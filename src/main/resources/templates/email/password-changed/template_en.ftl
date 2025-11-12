<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Changed</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f7f7f7; margin: 0; }
        .container { background: #fff; max-width: 600px; margin: 30px auto; border-radius: 8px; box-shadow: 0 2px 6px rgba(0,0,0,.05); }
        .header { background: #673ab7; color: #fff; padding: 24px 20px; text-align: center; border-radius: 8px 8px 0 0; }
        .content { padding: 30px 24px; color: #444; }
        .footer { background: #f0f0f0; padding: 20px; text-align: center; font-size: 13px; color: #888; border-radius: 0 0 8px 8px;}
        .btn { background: #673ab7; color: #fff; text-decoration: none; padding: 12px 32px; border-radius: 6px; display: inline-block; margin-top: 18px; }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Password Changed</h1>
        </div>
        <div class="content">
            <p>Hello <strong>${userName}</strong>,</p>
            <p>This is a confirmation that your account password was successfully changed at <strong>${companyName}</strong>.</p>
            <p>If you did not request this change, please reset your password immediately or <a href="${supportLink}">contact support</a>.</p>
            <div>
                <a class="btn" href="${supportLink}">Contact Support</a>
            </div>
        </div>
        <div class="footer">
            &copy; 2025 ${companyName}. All rights reserved.
        </div>
    </div>
</body>
</html>
