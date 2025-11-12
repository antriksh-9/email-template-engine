<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f5f5f5; margin: 0; }
        .container { max-width: 600px; margin: 36px auto; background: #fff; border-radius: 6px; box-shadow: 0 2px 6px rgba(0,0,0,.07);}
        .header { background: #2196F3; color: #fff; padding: 22px 20px; text-align: center; }
        .content { padding: 26px 22px; color: #222;}
        .footer { background: #f1f1f1; padding: 18px; text-align: center; color: #888; border-radius: 0 0 6px 6px;}
        .order-box { background: #e3f2fd; padding: 16px; border-radius: 6px; margin-bottom: 26px;}
        .btn { background: #2196F3; color: #fff; text-decoration: none; padding: 10px 28px; border-radius: 5px;}
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Order Confirmed!</h1>
        </div>
        <div class="content">
            <p>Hello <strong>${userName}</strong>,</p>
            <p>Your order <b>#${orderNumber}</b> was placed successfully.</p>
            <div class="order-box">
                <p><b>Order Date:</b> ${orderDate}</p>
                <p><b>Order Total:</b> ${orderTotal}</p>
            </div>
            <a class="btn" href="${orderDetailsLink}">View Order Details</a>
            <p style="margin-top:22px;">Thank you for shopping at <b>${companyName}</b>!</p>
        </div>
        <div class="footer">
            Questions? <a href="${supportLink}">Contact Support</a><br>
            &copy; 2025 ${companyName}
        </div>
    </div>
</body>
</html>
