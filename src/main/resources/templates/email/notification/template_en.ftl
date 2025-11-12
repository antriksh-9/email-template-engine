<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notification</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            background-color: #ffffff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        .header {
            background-color: #2196F3;
            color: white;
            padding: 30px 20px;
            text-align: center;
        }
        .header h2 {
            margin: 0;
            font-size: 24px;
        }
        .content {
            padding: 30px 20px;
            color: #333333;
            line-height: 1.6;
        }
        .notification-box {
            padding: 20px;
            background-color: #e3f2fd;
            border-left: 5px solid #2196F3;
            margin: 20px 0;
            border-radius: 4px;
        }
        .notification-box h3 {
            margin-top: 0;
            color: #1976D2;
            font-size: 18px;
        }
        .notification-box p {
            margin-bottom: 0;
            color: #424242;
        }
        .action-box {
            background-color: #fff3e0;
            border-left: 5px solid #ff9800;
            padding: 20px;
            margin: 20px 0;
            border-radius: 4px;
        }
        .action-box strong {
            color: #e65100;
            font-size: 16px;
        }
        .button {
            display: inline-block;
            background-color: #2196F3;
            color: white;
            padding: 14px 35px;
            text-decoration: none;
            border-radius: 5px;
            margin: 15px 0;
            font-weight: bold;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #1976D2;
        }
        .footer {
            background-color: #f5f5f5;
            padding: 20px;
            text-align: center;
            font-size: 12px;
            color: #666666;
            border-top: 1px solid #e0e0e0;
        }
        .icon {
            font-size: 30px;
            margin-bottom: 10px;
        }
        /* Responsive */
        @media only screen and (max-width: 600px) {
            .container {
                margin: 10px;
                border-radius: 0;
            }
            .content {
                padding: 20px 15px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="icon">📬</div>
            <h2>New Notification</h2>
        </div>
        <div class="content">
            <p>Hello <strong>${userName}</strong>,</p>
            
            <p>You have a new notification from <strong>${companyName}</strong>:</p>
            
            <div class="notification-box">
                <h3>${notificationTitle}</h3>
                <p>${notificationMessage}</p>
            </div>
            
            <#if actionRequired>
                <div class="action-box">
                    <p><strong>⚠️ Action Required</strong></p>
                    <p>${actionMessage}</p>
                    <center>
                        <a href="${actionLink}" class="button">Take Action Now</a>
                    </center>
                </div>
            </#if>
            
            <p>Thank you for your prompt attention to this matter.</p>
            
            <p style="margin-top: 30px; font-size: 14px; color: #666;">
                If you have any questions, please don't hesitate to contact our support team.
            </p>
        </div>
        <div class="footer">
            <p>Best regards,<br/><strong>${companyName}</strong></p>
            <p style="margin-top: 10px;">© 2025 All rights reserved</p>
            <p style="margin-top: 10px; font-size: 11px;">
                This is an automated notification. Please do not reply to this email.
            </p>
        </div>
    </div>
</body>
</html>
