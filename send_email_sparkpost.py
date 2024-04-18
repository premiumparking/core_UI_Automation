import smtplib
import os
import re
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders



def parse_test_summary(maven_output):
    # Define the pattern to search for
    pattern = r"Tests run: (\d+), Failures: (\d+), Errors: (\d+), Skipped: (\d+)"
    # Search for the pattern in the Maven output
    match = re.search(pattern, maven_output)
    # If a match is found, format and return the summary
    if match:
        return f"Tests run: {match.group(1)}, Failures: {match.group(2)}, Errors: {match.group(3)}, Skipped: {match.group(4)}"
    else:
        return "Test summary not found in Maven output."



# Get the date from the environment variable
date_str = os.getenv('DATE_STR')

# SparkPost SMTP configuration
smtp_host = os.getenv('SPARKPOST_SMTP_HOST')
smtp_port = os.getenv('SPARKPOST_SMTP_PORT')
smtp_username = os.getenv('SPARKPOST_SMTP_USERNAME')
smtp_password = os.getenv('SPARKPOST_SMTP_PASSWORD')

try:
    with open('mvn_output.txt', 'r') as file:
        maven_output = file.read()
    # Parse the test summary from Maven output
    test_summary = parse_test_summary(maven_output)
except FileNotFoundError:
    test_summary = "Maven output file not found."


# Email settings
from_email = os.getenv('FROM_EMAIL')
to_emails = [os.getenv('TO_EMAIL_1'), os.getenv('TO_EMAIL_2')]
subject = f"Textpay Automation Test Report for {date_str}"
body = f"The textpay automation test report for {date_str} is attached.\n\nTest Summary:\n{test_summary}"

# Create a multipart message
msg = MIMEMultipart()
msg['From'] = from_email
msg['To'] = ", ".join(to_emails)
msg['Subject'] = subject

# Attach the email body
msg.attach(MIMEText(body, 'plain'))

# Specify the attachment file
filename = f"test-report-{date_str}.zip"
attachment_path = f"./test-report-{date_str}.zip"

try:
    with open(attachment_path, 'rb') as attachment:
        part = MIMEBase('application', 'octet-stream')
        part.set_payload(attachment.read())
        encoders.encode_base64(part)
        part.add_header('Content-Disposition', f'attachment; filename={filename}')
        msg.attach(part)
except FileNotFoundError:
    print(f"The file {attachment_path} was not found.")
    exit(1)

print(f"SMTP Host:", smtp_host)
print(f"SMTP Port:", smtp_port)
print(f"SMTP Username:", smtp_username)
print(f"SMTP Password:", smtp_password) #"[HIDDEN]")  # Never print passwords

server = None
try:
    # Attempt to establish an SMTP connection
    server = smtplib.SMTP(smtp_host, smtp_port)
    server.set_debuglevel(1)
    server.starttls()
    server.login(smtp_username, smtp_password)
    server.sendmail(from_email, to_emails, msg.as_string())
    print("Email sent successfully.")
except smtplib.SMTPAuthenticationError as e:
    print("SMTP authentication failed:", e)
    exit(1)
except smtplib.SMTPException as e:
    print("SMTP error occurred:", e)
    exit(1)
except Exception as e:
    print("An error occurred:", e)
    exit(1)
finally:
    if server is not None:
        server.quit()