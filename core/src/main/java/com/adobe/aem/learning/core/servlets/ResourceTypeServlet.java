package com.adobe.aem.learning.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class)
@SlingServletResourceTypes(resourceTypes = { ResourceTypeServlet.RESOURCE_TYPE }, selectors = { ResourceTypeServlet.SELECTOR }, extensions = {
  ResourceTypeServlet.EXTENSION }, methods = HttpConstants.METHOD_GET)
public class ResourceTypeServlet extends SlingSafeMethodsServlet {

    private static final Logger logger = LoggerFactory.getLogger(ResourceTypeServlet.class);

    protected static final String SELECTOR = "robots";
    protected static final String EXTENSION = "txt";
    protected static final String RESOURCE_TYPE = "aem-learning/components/page";

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("This is an example for Resource Type servlet");
        } catch (final Exception e) {
            logger.error("Exception in doGet method", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
