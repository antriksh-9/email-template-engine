package com.email_template_engine.service;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.email_template_engine.exception.TemplateRenderException;
import com.email_template_engine.model.TemplateContext;
import com.email_template_engine.model.TemplateType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ThymeleafRenderer implements TemplateRenderer {
    private final TemplateEngine thymeleafTemplateEngine;

    @Override
    public String render(TemplateContext context) {
        try {
            Context thymeleafContext = new Context(context.getLocaleObject());
            if(context.getVariables() != null) {
                thymeleafContext.setVariables(context.getVariables());   
            }
            String templatePath = buildTemplatePath(context);
            log.debug("Rendering Thymeleaf template: {}", templatePath);

            return thymeleafTemplateEngine.process(templatePath, thymeleafContext);
        } catch(Exception e) {
            log.error("Error rendering Thymeleaf template: {}", context.getTemplateName(), e);
            throw new TemplateRenderException("Failed to render Thymeleaf template", e);
        }
    }

    @Override 
    public boolean supports(TemplateContext context) {
        return context.getTemplateType() == TemplateType.THYMELEAF;
    }

    private String buildTemplatePath(TemplateContext context) {
        return String.format("email/%s/template_%s", context.getTemplateName(), context.getLocaleObject().getLanguage());
    }
}