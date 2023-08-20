package com.myaem.core.models;

import com.day.cq.wcm.api.Page;
import com.myaem.core.services.Company;
import com.myaem.core.services.EmployeeService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;


@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MyTestingModel {

    @Inject
    EmployeeService emp;

    @ScriptVariable
    private Page currentPage;

    @OSGiService
    Company cmp;
    @ValueMapValue
    @Required
    @Default(values = "Hello")
    private String firstname;

    @ValueMapValue
    @Named("lastname")
    private String last;

    @ValueMapValue
    private String lastname;
    @ValueMapValue
    @Optional
    private String add;

    private String message;

    private String message2;

    private String[] tags;

    @PostConstruct
    protected void init() {
        message = "Employee Id : "+emp.getEmployeeID()+"\n" +
                "Employee Name : "+emp.getEmployeeName()+"\n"+
                "Employee Post : "+emp.getEmployeePost()+"\n"+
                "Employee Mobile : "+emp.getEmployeeMob();
        message2 = "Company Name : "+cmp.getCompanyName()+"\n"+
                "Company Type : "+cmp.getCompanyType()+"\n"+
                "Company Address : "+cmp.getCompanyAddress();
        tags = currentPage.getProperties().get("cq:tags",String[].class);
    }

    public String getLastname() {
        return lastname;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage2() {
        return message2;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLast() {
        return last;
    }

    public String getAdd() {
        return add;
    }

    public String[] getTags() {
        return currentPage.getProperties().get("cq:tags",String[].class);
    }
}
