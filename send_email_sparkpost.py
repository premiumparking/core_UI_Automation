import smtplib
import os
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders


# Get the date from the environment variable
date_str = os.getenv('DATE_STR')

# SparkPost SMTP configuration
smtp_host = os.getenv('SPARKPOST_SMTP_HOST')
smtp_port = os.getenv('SPARKPOST_SMTP_PORT')
smtp_username = os.getenv('SPARKPOST_SMTP_USERNAME')
smtp_password = os.getenv('SPARKPOST_SMTP_PASSWORD')


# Email settings
from_email = os.getenv('FROM_EMAIL')
to_emails = [os.getenv('TO_EMAIL_1'), os.getenv('TO_EMAIL_2')]
subject = f"Textpay Automation Test Report for {date_str}"
body = f"The textpay automation test report for {date_str} is attached."

# Create a multipart message
msg = MIMEMultipart()
msg['From'] = from_email
msg['To'] = to_emails
msg['Subject'] = subject

# Attach the email body
msg.attach(MIMEText(body, 'plain'))

# Specify the attachment file
filename = f"test-report-{date_str}.zip"
attachment_path = f"./test-report-{date_str}.zip"

print("SMTP Host:", smtp_host)  # should not be None
print("SMTP Port:", smtp_port)  # should not be None
print("SMTP Username:", smtp_username)  # should not be None
print("SMTP Password:", smtp_password)  # should not be None


try:
    # Attempt to establish an SMTP connection
    server = smtplib.SMTP(smtp_host, int(smtp_port))
    server.set_debuglevel(1)  # Enable debug output to see the connection details
    server.starttls()  # Upgrade the connection to secure
    server.login(smtp_username, smtp_password)  # Try to log in to the server
    print("SMTP connection and authentication successful.")
except smtplib.SMTPException as e:
    print(f"SMTP error occurred: {e}")
    exit(1)
except Exception as e:
    print(f"An error occurred: {e}")
    exit(1)


server.quit()

print('Email sent successfully.')