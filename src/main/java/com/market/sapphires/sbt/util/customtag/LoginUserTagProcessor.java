package com.market.sapphires.sbt.util.customtag;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

public class LoginUserTagProcessor extends AbstractElementTagProcessor {

    public LoginUserTagProcessor(String dialectPrefix) {
        super(
                TemplateMode.HTML,
                dialectPrefix,
                null, false,
                "login-user", true,
                StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
            IElementTagStructureHandler structureHandler) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        IModelFactory modelFactory = context.getModelFactory();
        IModel iModel = modelFactory.createModel();
        iModel.add(modelFactory.createOpenElementTag("span"));
        iModel.add(modelFactory.createText(HtmlEscape.escapeHtml4Xml(auth.getName())));
        iModel.add(modelFactory.createCloseElementTag("span"));

        structureHandler.replaceWith(iModel, false);
    }

}
