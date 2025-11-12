<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Subscription Expiration</title>
    <style>
        body { font-family: Arial, sans-serif; background: #fbfaf2; }
        .container { max-width: 600px; margin: 36px auto; background: #fff; border-radius: 8px; box-shadow: 0 2px 7px rgba(217,128,27,.10);}
        .header { background: #e67e22; color: #fff; padding: 26px 20px; border-radius: 8px 8px 0 0; text-align: center;}
        .content { padding: 36px 22px; color: #444;}
        .footer { background: #f3f2ea; color: #999; text-align: center; font-size: 13px; padding: 15px; border-radius: 0 0 8px 8px;}
        .btn { background: #e67e22; color: #fff; padding: 12px 36px; border-radius: 6px; text-decoration: none; font-weight: bold; display: inline-block; margin-top: 20px;}
        .details { background: #fde3cf; padding: 15px 18px; border-radius: 6px; margin: 19px 0;}
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Subscription Expiration Notice</h1>
        </div>
        <div class="content">
            <p>Dear <b>${userName}</b>,</p>
            <p>Your subscription for <b>${planName}</b> at <b>${companyName}</b> will expire on <span style="color:#e67e22;">${expiryDate}</span>.</p>
            <div class="details">
                <p><b>Current plan:</b> ${planName}</p>
                <p><b>Expiration date:</b> ${expiryDate}</p>
            </div>
            <a href="${renewalLink}" class="btn">Renew Now</a>
            <p style="margin-top: 28px;">To avoid interruption of service, please renew before the expiration date.</p>
        </div>
        <div class="footer">
            For questions or help, contact our team.<br>
            &copy; 2025 ${companyName}
        </div>
    </div>
</body>
</html>
