package com.email_template_engine.service;
import java.io.StringWriter;
import org.springframework.stereotype.Component;

import com.email_template_engine.exception.TemplateRenderException;
import com.email_template_engine.model.TemplateContext;
import com.email_template_engine.model.TemplateType;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FreeMarkerRenderer implements TemplateRenderer{
    private final Configuration freemarkerConfiguration;

    @Override
    public String render(TemplateContext context) {
        try {
            String templatePath = buildTemplatePath(context);
            log.debug("Rendering FreeMarker template: {}", templatePath);

            Template template = freemarkerConfiguration.getTemplate(templatePath);
            StringWriter writer = new StringWriter();
            template.process(context.getVariables(), writer);

            return writer.toString();

        } catch(Exception e){
            log.error("Error rendering FreeMarker template: {}", context.getTemplateName(), e);
            throw new TemplateRenderException("Failed to render FreeMarker template", e);
        }
    }

    @Override
    public boolean supports(TemplateContext context) {
        return context.getTemplateType() == TemplateType.FREEMARKER;
    }

    private String buildTemplatePath(TemplateContext context) {
        return String.format("email/%s/template_%s.ftl", context.getTemplateName(), context.getLocaleObject().getLanguage());
    }
}
