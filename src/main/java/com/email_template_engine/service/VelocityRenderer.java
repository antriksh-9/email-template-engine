package com.email_template_engine.service;

import java.io.StringWriter;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Component;

import com.email_template_engine.exception.TemplateRenderException;
import com.email_template_engine.model.TemplateContext;
import com.email_template_engine.model.TemplateType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@RequiredArgsConstructor
public class VelocityRenderer implements TemplateRenderer{
    
    private final VelocityEngine velocityEngine;

    @Override
    public String render(TemplateContext context) {
        try {
            String templatePath = buildTemplatePath(context);
            log.debug("Rendering Velocity template: {}", templatePath);

            VelocityContext velocityContext = new VelocityContext();
            if(context.getVariables() != null) {
                context.getVariables().forEach(velocityContext::put);
            }

            StringWriter writer = new StringWriter();
            velocityEngine.mergeTemplate(templatePath, "UTF-8", velocityContext, writer);

            return writer.toString();
        } catch(Exception e) {
            log.error("Error rendering Velocity template: {}", context.getTemplateName(), e);
            throw new TemplateRenderException("Failed to render Velocity template", e);
        }
    }

    @Override
    public boolean supports(TemplateContext context) {
        return context.getTemplateType() == TemplateType.VELOCITY;
    }

    private String buildTemplatePath(TemplateContext context) {
        return String.format("templates/email/%s/template_%s.vm", context.getTemplateName(), context.getLocaleObject().getLanguage());
    }
}
