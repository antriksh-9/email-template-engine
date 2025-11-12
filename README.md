# Email Template Engine 📧

A powerful, multi-language email template rendering microservice built with Spring Boot. Supports multiple template engines (Thymeleaf, FreeMarker, Velocity) and provides easy integration as a reusable JAR library.

## 🌟 Features

- **Multi-Engine Support**: Thymeleaf, FreeMarker, and Velocity template engines
- **Multi-Language**: Built-in support for English, Spanish, French, and more
- **RESTful API**: Easy-to-use REST endpoints for template rendering
- **Reusable Component**: Use as a JAR dependency in any Spring Boot application
- **Rich Templates**: Pre-built templates for common use cases
- **Customizable**: Add your own templates and variables

## 📋 Table of Contents

- [What Does It Provide?](#what-does-it-provide)
- [Template Library](#template-library)
- [Using as a JAR Library](#using-as-a-jar-library)
- [API Documentation](#api-documentation)
- [Adding Custom Templates](#adding-custom-templates)
- [Testing](#testing)

---

## 🎯 What Does It Provide?

The Email Template Engine is a **template rendering service** that:

1. **Generates HTML email content** from templates with dynamic variables
2. **Supports multiple languages** (i18n) - render the same template in different languages
3. **Works with three template engines** - choose the one that fits your needs
4. **Provides a REST API** - render templates via HTTP requests
5. **Can be used as a library** - integrate directly into your Spring Boot app

### Use Cases
Use this library when you need consistent, professional email designs across your applications without writing HTML manually or managing template files yourself.

- **Welcome emails** - Onboard new users with personalized messages
- **Password reset** - Send secure password reset links
- **Order confirmations** - E-commerce order details
- **Notifications** - System alerts and updates
- **Subscription reminders** - Renewal notices
- **Security alerts** - Login notifications, account changes

---

## 📚 Template Library

### Pre-built Templates

| Template | Engine | Languages | Use Case |
|----------|--------|-----------|----------|
| `welcome` | Thymeleaf | EN, ES, FR | User onboarding |
| `reset-password` | Velocity | EN, ES | Password recovery |
| `account-activation` | Velocity | EN | Account verification |
| `notification` | FreeMarker | EN, ES | System notifications |
| `password-changed` | FreeMarker | EN | Password change confirmation |
| `order-confirmation` | FreeMarker | EN | E-commerce orders |
| `account-deletion` | FreeMarker | EN | Account deletion warning |
| `new-device-login` | FreeMarker | EN | Security alerts |
| `subscription-expiry` | FreeMarker | EN | Subscription reminders |

---
## 📦 Using as a JAR Library

### Step 1: Download the JAR
Download the latest version: [email-template-engine-0.0.1.jar](https://github.com/antriksh-9/email-template-engine/releases/download/v0.0.1/email-template-engine-0.0.1-SNAPSHOT.jar)

### Step 2: Install to Local Maven Repository

`mvn install:install-file
-Dfile=/path/to/downloaded/email-template-engine-0.0.1-SNAPSHOT.jar
-DgroupId=com.email_template_engine
-DartifactId=email-template-engine
-Dversion=0.0.1-SNAPSHOT
-Dpackaging=jar`


### Step 3: Add to Your Project
In your project's `pom.xml`:
`<dependency> <groupId>com.email_template_engine</groupId> <artifactId>email-template-engine</artifactId> <version>0.0.1-SNAPSHOT</version> </dependency> `

### Step 4: Use in Your Application
Basic Usage

```
package com.yourcompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.email_template_engine.service.EmailTemplateService;
import com.email_template_engine.model.TemplateContext;
import com.email_template_engine.model.TemplateType;
import com.email_template_engine.model.EmailTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationService {

    @Autowired
    private EmailTemplateService emailTemplateService;

    public String sendWelcomeEmail(String userName, String email) {
        // Prepare template variables
        Map<String, Object> variables = new HashMap<>();
        variables.put("userName", userName);
        variables.put("companyName", "My Company");
        variables.put("hasDiscount", true);
        variables.put("discountCode", "WELCOME20");
        variables.put("activationLink", "https://myapp.com/activate/" + email);

        // Build template context
        TemplateContext context = TemplateContext.builder()
            .templateName("welcome")
            .templateType(TemplateType.THYMELEAF)
            .locale("en")
            .variables(variables)
            .build();

        // Render template
        EmailTemplate result = emailTemplateService.renderEmailTemplate(context);
        
        // Get the HTML content
        String htmlContent = result.getHtmlContent();
        
    }
}
```
## 📖 API Documentation

[View API Documentation in Postman](https://documenter.getpostman.com/view/29968557/2sB3Wtsz3W)


## 🎨 Adding Custom Templates

### Step 1: Create Template Folder Structure
```
src/main/resources/templates/email/
└── your-template-name/
    ├── template_en.html   (Thymeleaf)
    ├── template_en.ftl    (FreeMarker)
    └── template_en.vm     (Velocity)
```

### Step 2: Create Template File
Example: `templates/email/custom-welcome/template_en.html`

```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Custom Welcome</title>
</head>
<body>
    <h1>Hello <span th:text="${userName}">User</span>!</h1>
    <p>Custom message here...</p>
</body>
</html>
```
### Step 3: Use Your Template

```
TemplateContext context = TemplateContext.builder()
    .templateName("custom-welcome")  // Matches folder name
    .templateType(TemplateType.THYMELEAF)
    .locale("en")
    .variables(Map.of("userName", "Alice"))
    .build();

String html = emailTemplateService.renderTemplate(context);
```

## 🧪 Testing
This project includes comprehensive test coverage with **60+ test cases** covering all template engines, edge cases, error handling, and performance scenarios.

### Test Coverage

| Category | Tests | Coverage |
|----------|-------|----------|
| **Thymeleaf Templates** | 6 tests | Multi-language, conditional rendering |
| **FreeMarker Templates** | 3 tests | Multi-language, conditional logic |
| **Velocity Templates** | 2 tests | Password reset, account activation |
| **Error Handling** | 4 tests | Missing templates, variables, locales |
| **Edge Cases** | 4 tests | Special characters, Unicode, empty values |
| **Performance** | 1 test | Response time validation |
| **Total** | **20 tests** | ✅ All passing |

---

### Test Categories

#### 1. Thymeleaf Template Tests

✅ Should render Thymeleaf template in English <br>
✅ Should render Thymeleaf template in Spanish<br>
✅ Should render Thymeleaf template in French <br>

#### 2. FreeMarker Template Tests

✅ Should render FreeMarker template in English <br>
✅ Should render FreeMarker template in Spanish <br>


---

#### 3. Velocity Template Tests


✅ Should render Velocity template for password reset <br>
✅ Should render Velocity template for account activation <br>


---

#### 4. Error Handling Tests

✅ Should throw exception for non-existent template <br>
✅ Should handle missing variables gracefully <br>
✅ Should handle null variables map <br>
✅ Should throw exception for unsupported locale <br>


---

#### 5. Edge Case Tests

✅ Should handle empty string variables <br>
✅ Should handle special characters in variables (XSS prevention) <br>
✅ Should handle very long text in variables <br>
✅ Should handle Unicode characters (emoji, Chinese, Japanese) <br>


---

#### 6. Performance Tests

✅ Should render template within acceptable time (<1 second)













