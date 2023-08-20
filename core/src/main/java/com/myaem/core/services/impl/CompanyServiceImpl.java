package com.myaem.core.services.impl;

import com.myaem.core.services.Company;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = Company.class,immediate = true)
@Designate(ocd = CompanyServiceImpl.Config.class)

public class CompanyServiceImpl implements Company{
    String companyName = StringUtils.EMPTY;
    String companyType = StringUtils.EMPTY;
    String companyAdd = StringUtils.EMPTY;
    @ObjectClassDefinition(name = "Company",description = "Enter Company Detail")

    @interface Config {
        @AttributeDefinition(name = "Company Name", description = "Enter the Company Name", type = AttributeType.STRING)
        String getCompanyName();

        @AttributeDefinition(name = "Company Type", description = "Enter the Company Type", type = AttributeType.STRING)
        String getCompanyType();

        @AttributeDefinition(name = "Company Address", description = "Enter the Company Address", type = AttributeType.STRING)
        String getCompanyAddress();
    }

    @Modified
    @Activate
    protected void activate(CompanyServiceImpl.Config properties) {
        companyName = properties.getCompanyName();
        companyType = properties.getCompanyType();
        companyAdd = properties.getCompanyAddress();
    }

    @Override
    public String getCompanyAddress() {
        return companyAdd;
    }
    @Override
    public String getCompanyType() {
        return companyType;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }
}
