package com.myaem.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Component(service = { Servlet.class })
@SlingServletResourceTypes(
        resourceTypes="driveAem/components/myRegistration",
        methods = HttpConstants.METHOD_POST,
        selectors = "posting",
        extensions="html")
@ServiceDescription("Simple Demo Servlet")
public class SecondTestServlet extends SlingAllMethodsServlet {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(SecondTestServlet.class);
    @Override
    protected void doPost(SlingHttpServletRequest req,
                         SlingHttpServletResponse resp) throws ServletException, IOException {

        try{
            LOG.info("\n-------------------------STARTED POST------------------------");
            List<RequestParameter> requestParameterList = req.getRequestParameterList();
            for(RequestParameter requestParameter:requestParameterList) {
                LOG.info("\n==PARAMETER=== {}   :   {} ");
            }
        } catch (Exception e) {
            LOG.info("\n ERROR IN REQUEST {}  ");
        }
        resp.getWriter().write("===========FORM SUBMITTED");
    }
}
