package com.adobe.aem.learning.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class)
@SlingServletPaths("/bin/pathServlet")
@ServiceDescription("Register servlet using path")
public class PathServlet extends SlingSafeMethodsServlet {

    private static final Logger logger = LoggerFactory.getLogger(PathServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            response.getWriter().println("This is an example of path servlet");
        } catch (final Exception e) {
            logger.error("Exception in doGet method", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}