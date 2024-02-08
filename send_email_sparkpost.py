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
smtp_port = int(os.getenv('SPARKPOST_SMTP_PORT'))
smtp_username = os.getenv('SPARKPOST_SMTP_USERNAME')
smtp_password = os.getenv('SPARKPOST_API_KEY')


# Email settings
from_email = os.getenv('FROM_EMAIL')
to_emails = [os.getenv('TO_EMAIL_1'), os.getenv('TO_EMAIL_2')]
subject = f"Textpay Automation Test Report for {date_str}"
body = f"The textpay automation test report for {date_str} is attached."

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


# Open the file in binary mode
with open(attachment_path, 'rb') as attachment:
    part = MIMEBase('application', 'octet-stream')
    part.set_payload(attachment.read())
    encoders.encode_base64(part)
    part.add_header(
        'Content-Disposition',
        f'attachment; filename= {filename}',
    )
    msg.attach(part)

print("SMTP Host:", smtp_host)  # should not be None
print("SMTP Port:", smtp_port)  # should not be None
print("SMTP Username:", smtp_username)  # should not be None
print("SMTP Password:", smtp_password)  # should not be None


# Send the email over SMTP
server = smtplib.SMTP(smtp_host, smtp_port)
server.starttls()
server.login(smtp_username, smtp_password)
server.sendmail(from_email, to_emails, msg.as_string())
server.quit()

print('Email sent successfully.')