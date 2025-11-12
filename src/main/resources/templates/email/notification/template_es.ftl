<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notificación</title>
    <style>
        body {
            font-family: Arial, sans-serif;
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
        }
        .header {
            background-color: #2196F3;
            color: white;
            padding: 20px;
            text-align: center;
        }
        .content {
            padding: 30px 20px;
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
        }
        .action-box {
            background-color: #fff3e0;
            border-left: 5px solid #ff9800;
            padding: 15px;
            margin: 20px 0;
            border-radius: 4px;
        }
        .button {
            display: inline-block;
            background-color: #2196F3;
            color: white;
            padding: 12px 30px;
            text-decoration: none;
            border-radius: 5px;
            margin: 15px 0;
        }
        .footer {
            background-color: #f5f5f5;
            padding: 20px;
            text-align: center;
            font-size: 12px;
            color: #666;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>📬 Nueva Notificación</h2>
        </div>
        <div class="content">
            <p>Hola <strong>${userName}</strong>,</p>
            
            <p>Tienes una nueva notificación de <strong>${companyName}</strong>:</p>
            
            <div class="notification-box">
                <h3>${notificationTitle}</h3>
                <p>${notificationMessage}</p>
            </div>
            
            <#if actionRequired>
                <div class="action-box">
                    <p><strong>⚠️ Acción Requerida:</strong></p>
                    <p>${actionMessage}</p>
                    <a href="${actionLink}" class="button">Realizar Acción</a>
                </div>
            </#if>
            
            <p>Gracias por tu atención.</p>
        </div>
        <div class="footer">
            <p>Saludos cordiales,<br/><strong>${companyName}</strong></p>
            <p>© 2025 Todos los derechos reservados</p>
        </div>
    </div>
</body>
</html>
