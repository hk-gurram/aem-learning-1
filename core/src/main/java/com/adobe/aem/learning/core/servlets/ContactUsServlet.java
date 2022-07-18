package com.adobe.aem.learning.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Servlet.class, immediate = true)
@SlingServletResourceTypes(resourceTypes = {
  "aem-learning/components/contactUs" }, methods = HttpConstants.METHOD_POST, selectors = "contact", extensions = "html")
public class ContactUsServlet extends SlingAllMethodsServlet {
    private static final Logger logger = LoggerFactory.getLogger(ContactUsServlet.class);

    private static final String CONTACT_SENDER_EMAIL = "contact-email";
    public static final String SELECTOR_SEPARTOR = ".";

    @Override
    protected void doPost(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws IOException {
        PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
        assert pageManager != null;
        Page page = pageManager.getContainingPage(request.getResource());
        String pagePath = page.getPath();
        String extension = request.getRequestPathInfo().getExtension();
        String success = StringUtils.join(pagePath, SELECTOR_SEPARTOR, "success", SELECTOR_SEPARTOR, extension);
        String error = StringUtils.join(pagePath, SELECTOR_SEPARTOR, "error", SELECTOR_SEPARTOR, extension);

        try {
            final String senderEmail = request.getParameter(CONTACT_SENDER_EMAIL);

            if (!senderEmail.contains("gmail")) {
                logger.error("Error occurred while sending e-mail");
                response.sendRedirect(error);
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (final RuntimeException | IOException e) {
            logger.error("Email sending failed", e);
            response.sendRedirect(error);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        response.sendRedirect(success);
    }
}
