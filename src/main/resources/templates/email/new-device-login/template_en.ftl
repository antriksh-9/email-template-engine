<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Login Alert</title>
    <style>
        body { font-family: Arial, sans-serif; background: #fafbfc; }
        .container { max-width: 600px; margin: 25px auto; background: #fff; border-radius: 8px; box-shadow: 0 2px 8px rgba(80,80,80,.07);}
        .header { background: #ff9800; color: #fff; padding: 26px 18px; text-align: center; border-radius: 8px 8px 0 0;}
        .content { padding: 36px 22px; color: #222;}
        .footer { background: #f6f7f7; color: #888; text-align: center; font-size: 13px; padding: 16px; border-radius: 0 0 8px 8px;}
        .detail-box { background: #fffbe7; border-left: 5px solid #ff9800; padding: 16px; margin: 18px 0; border-radius: 4px;}
        .btn { display: inline-block; margin-top: 18px; background: #ff9800; color: #fff; text-decoration: none; padding: 10px 32px; border-radius: 4px;}
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>New Device Login Alert</h1>
        </div>
        <div class="content">
            <p>Hello <strong>${userName}</strong>,</p>
            <p>A new login to your <b>${companyName}</b> account was detected:</p>
            <div class="detail-box">
                <p><b>Device:</b> ${deviceInfo}</p>
                <p><b>Location:</b> ${location}</p>
                <p><b>Time:</b> ${loginTime}</p>
            </div>
            <p>If this was <b>not you</b>, please reset your password immediately:</p>
            <a class="btn" href="${resetLink}">Reset Password</a>
        </div>
        <div class="footer">
            If you recognize this login, no further action is needed. <br>
            &copy; 2025 ${companyName}
        </div>
    </div>
</body>
</html>
