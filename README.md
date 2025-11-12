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
- [Quick Start](#quick-start)
- [Using as a JAR Library](#using-as-a-jar-library)
- [API Documentation](#api-documentation)
- [Configuration](#configuration)
- [Adding Custom Templates](#adding-custom-templates)
- [Examples](#examples)

---

## 🎯 What Does It Provide?

The Email Template Engine is a **template rendering service** that:

1. **Generates HTML email content** from templates with dynamic variables
2. **Supports multiple languages** (i18n) - render the same template in different languages
3. **Works with three template engines** - choose the one that fits your needs
4. **Provides a REST API** - render templates via HTTP requests
5. **Can be used as a library** - integrate directly into your Spring Boot app

### Use Cases

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



