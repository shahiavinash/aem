package com.myaem.core.services.impl;

import com.myaem.core.services.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = EmployeeService.class,immediate = true)
@Designate(ocd = EmployeeServiceImpl.Config.class)
public class EmployeeServiceImpl implements EmployeeService{
    String ename = StringUtils.EMPTY;
    String post = StringUtils.EMPTY;
    String id = StringUtils.EMPTY;
    String mob = StringUtils.EMPTY;

    @ObjectClassDefinition(name = "Employee Details", description = "Enter the Details")
    @interface Config {
        @AttributeDefinition(name = "Employee name", description = "Enter the name of the Employee",type = AttributeType.STRING)
        String getEmployeeName();

        @AttributeDefinition(name = "Employee Post", description = "Enter the post of the Employee",type = AttributeType.STRING)
        String getEmployeePost();

        @AttributeDefinition(name = "Employee Id", description = "Enter the ID of the Employee",type = AttributeType.STRING)
        String getEmployeeID();

        @AttributeDefinition(name = "Employee Mobile Number", description = "Enter the Mobile number of the Employee",type = AttributeType.STRING)
        String getEmployeeMob();
    }


    @Modified
    @Activate
    protected void activate(EmployeeServiceImpl.Config prop) {
        ename = prop.getEmployeeName();
        post = prop.getEmployeePost();
        id = prop.getEmployeeID();
        mob = prop.getEmployeeMob();
    }

    @Override
    public String getEmployeeName() {
        return ename;
    }
    @Override
    public String getEmployeePost() {
        return post;
    }
    @Override
    public String getEmployeeID() {
        return id;
    }
    @Override
    public String getEmployeeMob () {
        return mob;
    }
}
