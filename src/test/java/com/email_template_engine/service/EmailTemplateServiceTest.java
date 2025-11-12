package com.email_template_engine.service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.email_template_engine.exception.TemplateRenderException;
import com.email_template_engine.model.EmailTemplate;
import com.email_template_engine.model.TemplateContext;
import com.email_template_engine.model.TemplateType;

@SpringBootTest
@DisplayName("Email Template Service Tests")
class EmailTemplateServiceTest {

    @Autowired
    private EmailTemplateService emailTemplateService;

    // ========== THYMELEAF TESTS ==========
    
    @Nested
    @DisplayName("Thymeleaf Template Tests")
    class ThymeleafTests {

        @Test
        @DisplayName("Should render Thymeleaf template in English")
        void testRenderThymeleafTemplate() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "John Doe");
            variables.put("companyName", "Tech Corp");
            variables.put("hasDiscount", true);
            variables.put("discountCode", "WELCOME20");
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale(Locale.ENGLISH.toString())
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result).isNotEmpty();
            assertThat(result).contains("John Doe");
            assertThat(result).contains("Tech Corp");
            assertThat(result).contains("WELCOME20");
            assertThat(result).contains("https://example.com/activate");
        }

        @Test
        @DisplayName("Should render Thymeleaf template in Spanish")
        void testRenderSpanishTemplate() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "María García");
            variables.put("companyName", "Tech Corp");
            variables.put("hasDiscount", false);
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("es")
                    .variables(variables)
                    .build();

            // Act
            EmailTemplate result = emailTemplateService.renderEmailTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result.getHtmlContent()).contains("María García");
            assertThat(result.getLocale()).isEqualTo("es");
            assertThat(result.getTemplateName()).isEqualTo("welcome");
        }

        @Test
        @DisplayName("Should render Thymeleaf template in French")
        void testRenderFrenchTemplate() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Pierre Dubois");
            variables.put("companyName", "Solutions Tech");
            variables.put("hasDiscount", true);
            variables.put("discountCode", "BIENVENUE20");
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("fr")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result).contains("Pierre Dubois");
            assertThat(result).contains("BIENVENUE20");
        }

        @Test
        @DisplayName("Should handle conditional rendering - with discount")
        void testConditionalRenderingWithDiscount() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Test User");
            variables.put("companyName", "Test Corp");
            variables.put("hasDiscount", true);
            variables.put("discountCode", "SAVE50");
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).contains("SAVE50");
        }

        @Test
        @DisplayName("Should handle conditional rendering - without discount")
        void testConditionalRenderingWithoutDiscount() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Test User");
            variables.put("companyName", "Test Corp");
            variables.put("hasDiscount", false);
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result).doesNotContain("discountCode");
        }
    }

    // ========== FREEMARKER TESTS ==========
    
    @Nested
    @DisplayName("FreeMarker Template Tests")
    class FreeMarkerTests {

        @Test
        @DisplayName("Should render FreeMarker template in English")
        void testRenderFreeMarkerTemplate() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Sarah Johnson");
            variables.put("companyName", "MyApp Platform");
            variables.put("notificationTitle", "New Message Received");
            variables.put("notificationMessage", "You have a new message from your team.");
            variables.put("actionRequired", true);
            variables.put("actionMessage", "Please review and respond within 24 hours");
            variables.put("actionLink", "https://example.com/messages/123");

            TemplateContext context = TemplateContext.builder()
                    .templateName("notification")
                    .templateType(TemplateType.FREEMARKER)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result).contains("Sarah Johnson");
            assertThat(result).contains("New Message Received");
            assertThat(result).contains("Please review and respond within 24 hours");
        }

        @Test
        @DisplayName("Should render FreeMarker template in Spanish")
        void testRenderFreeMarkerSpanishTemplate() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Carlos Rodriguez");
            variables.put("companyName", "Plataforma MyApp");
            variables.put("notificationTitle", "Nuevo Mensaje");
            variables.put("notificationMessage", "Tienes un nuevo mensaje.");
            variables.put("actionRequired", false);

            TemplateContext context = TemplateContext.builder()
                    .templateName("notification")
                    .templateType(TemplateType.FREEMARKER)
                    .locale("es")
                    .variables(variables)
                    .build();

            // Act
            EmailTemplate result = emailTemplateService.renderEmailTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result.getHtmlContent()).contains("Carlos Rodriguez");
            assertThat(result.getTemplateName()).isEqualTo("notification");
        }

        @Test
        @DisplayName("Should render FreeMarker template without action required")
        void testRenderFreeMarkerWithoutAction() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Mike Wilson");
            variables.put("companyName", "TechCorp");
            variables.put("notificationTitle", "System Update");
            variables.put("notificationMessage", "Your system has been updated.");
            variables.put("actionRequired", false);

            TemplateContext context = TemplateContext.builder()
                    .templateName("notification")
                    .templateType(TemplateType.FREEMARKER)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result).contains("Mike Wilson");
            assertThat(result).contains("System Update");
        }
    }

    // ========== VELOCITY TESTS ==========
    
    @Nested
    @DisplayName("Velocity Template Tests")
    class VelocityTests {

        @Test
        @DisplayName("Should render Velocity template for password reset")
        void testRenderVelocityPasswordResetTemplate() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "David Chen");
            variables.put("companyName", "SecureApp");
            variables.put("resetLink", "https://example.com/reset/token123");
            variables.put("expiryTime", "24 hours");
            variables.put("supportEmail", "support@example.com");

            TemplateContext context = TemplateContext.builder()
                    .templateName("reset-password")
                    .templateType(TemplateType.VELOCITY)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result).contains("David Chen");
            assertThat(result).contains("SecureApp");
            assertThat(result).contains("https://example.com/reset/token123");
            assertThat(result).contains("24 hours");
        }

        @Test
        @DisplayName("Should render Velocity template for account activation")
        void testRenderVelocityAccountActivationTemplate() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Emily Brown");
            variables.put("companyName", "CloudServices");
            variables.put("activationCode", "ACT-2025-XYZ789");
            variables.put("activationLink", "https://example.com/activate/emily123");
            variables.put("expiryDays", "7");

            TemplateContext context = TemplateContext.builder()
                    .templateName("account-activation")
                    .templateType(TemplateType.VELOCITY)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            EmailTemplate result = emailTemplateService.renderEmailTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result.getHtmlContent()).contains("Emily Brown");
            assertThat(result.getHtmlContent()).contains("ACT-2025-XYZ789");
        }
    }

    // ========== ERROR HANDLING TESTS ==========
    
    @Nested
    @DisplayName("Error Handling Tests")
    class ErrorHandlingTests {

        @Test
        @DisplayName("Should throw exception for non-existent template")
        void testNonExistentTemplate() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Test User");

            TemplateContext context = TemplateContext.builder()
                    .templateName("non-existent-template")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act & Assert
            assertThatThrownBy(() -> emailTemplateService.renderTemplate(context))
                    .isInstanceOf(TemplateRenderException.class);
        }

        @Test
        @DisplayName("Should handle missing variables gracefully")
        void testMissingVariables() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            // Missing required variables

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert - Should not throw exception, but render with empty values
            assertThat(result).isNotNull();
        }

        @Test
        @DisplayName("Should handle null variables map")
        void testNullVariables() {
            // Arrange
            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(null)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
        }

        @Test
        @DisplayName("Should throw exception for unsupported locale")
        void testUnsupportedLocale() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Test User");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("zh_CN") // Unsupported locale
                    .variables(variables)
                    .build();

            // Act & Assert
            assertThatThrownBy(() -> emailTemplateService.renderTemplate(context))
                    .isInstanceOf(TemplateRenderException.class);
        }
    }

    // ========== EDGE CASE TESTS ==========
    
    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Should handle empty string variables")
        void testEmptyStringVariables() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "");
            variables.put("companyName", "");
            variables.put("hasDiscount", false);
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
        }

        @Test
        @DisplayName("Should handle special characters in variables")
        void testSpecialCharactersInVariables() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "John <script>alert('test')</script>");
            variables.put("companyName", "Tech & Co.");
            variables.put("hasDiscount", false);
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            // Thymeleaf should escape HTML by default
            assertThat(result).contains("&lt;script&gt;");
        }

        @Test
        @DisplayName("Should handle very long text in variables")
        void testLongTextInVariables() {
            // Arrange
            String longText = "A".repeat(1000);
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", longText);
            variables.put("companyName", "Test Corp");
            variables.put("hasDiscount", false);
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result).contains(longText);
        }

        @Test
        @DisplayName("Should handle Unicode characters")
        void testUnicodeCharacters() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "测试用户 🎉");
            variables.put("companyName", "テスト会社");
            variables.put("hasDiscount", false);
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            String result = emailTemplateService.renderTemplate(context);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result).contains("测试用户 🎉");
        }
    }

    // ========== PERFORMANCE TESTS ==========
    
    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Should render template within acceptable time")
        void testRenderPerformance() {
            // Arrange
            Map<String, Object> variables = new HashMap<>();
            variables.put("userName", "Performance Test");
            variables.put("companyName", "Test Corp");
            variables.put("hasDiscount", true);
            variables.put("discountCode", "PERF20");
            variables.put("activationLink", "https://example.com/activate");

            TemplateContext context = TemplateContext.builder()
                    .templateName("welcome")
                    .templateType(TemplateType.THYMELEAF)
                    .locale("en")
                    .variables(variables)
                    .build();

            // Act
            long startTime = System.currentTimeMillis();
            String result = emailTemplateService.renderTemplate(context);
            long endTime = System.currentTimeMillis();

            // Assert
            assertThat(result).isNotNull();
            assertThat(endTime - startTime).isLessThan(1000); // Should complete within 1 second
        }
    }
}
