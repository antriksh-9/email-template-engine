package com.email_template_engine.controller;

import com.email_template_engine.model.EmailTemplate;
import com.email_template_engine.model.TemplateContext;
import com.email_template_engine.service.EmailTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/templates")
@RequiredArgsConstructor
@ConditionalOnProperty(name = "email.template.microservice.enabled", havingValue = "true")
public class EmailTemplateController {
    
    private final EmailTemplateService emailTemplateService;

    /**
     * Generic endpoint that returns JSON by default or HTML based on format parameter
     * 
     * Examples:
     * - JSON: POST /api/v1/templates/render
     * - HTML: POST /api/v1/templates/render?format=html
     */
    @PostMapping(value = "/render")
    public ResponseEntity<?> renderTemplate(
            @Valid @RequestBody TemplateContext context,
            @RequestParam(defaultValue = "json") String format) {
        
        log.info("Received render request for template: {}, format: {}", 
            context.getTemplateName(), format);
        
        if ("html".equalsIgnoreCase(format)) {
            // Return raw HTML for browser preview
            String htmlContent = emailTemplateService.renderTemplate(context);
            return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(htmlContent);
        } else {
            // Return JSON with metadata
            EmailTemplate result = emailTemplateService.renderEmailTemplate(context);
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
        }
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Email Template Engine is running");
    }
}
