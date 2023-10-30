package com.aemsite.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = {Servlet.class})
@SlingServletResourceTypes(
        resourceTypes = "aemsite/components/firstcomponent",
        methods = HttpConstants.METHOD_GET,
        selectors = "message",
        extensions = "html")
@ServiceDescription("First Demo Servlet")
public class DemoServlet extends SlingSafeMethodsServlet {
    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {

        Resource resource = req.getResource();
        String propertyKey = "servletMessage";

        resp.setContentType("text/plain");
        if (resource.getValueMap().get(propertyKey) != null) {
            resp.getWriter().write(resource.getValueMap().get(propertyKey).toString());
        } else {
            resp.getWriter().write("Property with the key " + propertyKey + " doesn't exist!" );
        }



    }
}
