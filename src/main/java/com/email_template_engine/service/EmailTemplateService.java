package com.email_template_engine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.email_template_engine.exception.TemplateNotFoundException;
import com.email_template_engine.model.EmailTemplate;
import com.email_template_engine.model.TemplateContext;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor

public class EmailTemplateService {

    private final List<TemplateRenderer> renderers;

    public String renderTemplate(TemplateContext context) {
        log.info("Rendering template: {} with type: {} and locale: {}", context.getTemplateName(),
                context.getTemplateType(), context.getLocaleObject());

        TemplateRenderer renderer = findRenderer(context);
        return renderer.render(context);
    }

    public EmailTemplate renderEmailTemplate(TemplateContext context) {
        String content = renderTemplate(context);

        return EmailTemplate.builder().templateName(context.getTemplateName()).locale(context.getLocaleObject().toString())
                .htmlContent(content).build();
    }

    private TemplateRenderer findRenderer(TemplateContext context) {
        return renderers.stream().filter(renderer -> renderer.supports(context)).findFirst()
                .orElseThrow(() -> new TemplateNotFoundException(
                        "No renderer found for template type: " + context.getTemplateType()));
    }
}
