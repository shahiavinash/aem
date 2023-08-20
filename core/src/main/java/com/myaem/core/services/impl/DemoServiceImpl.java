package com.myaem.core.services.impl;

import com.myaem.core.services.DemoService;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = DemoService.class,immediate = true)
@Designate(ocd = DemoServiceImpl.Config.class)
public class DemoServiceImpl implements DemoService{

    String demoUrl = StringUtils.EMPTY;
    @ObjectClassDefinition(name = "demoUrl Testing",description = "Testing of Demo Url")
    @interface Config {
        @AttributeDefinition(name = "demoUrl",description = "This is demo Url",type = AttributeType.STRING)
        String getUrl();
    }

    @Modified
    @Activate
    protected void activate(DemoServiceImpl.Config props) {

        demoUrl = props.getUrl();
    }

    @Override
    public String getUrl (){
        return demoUrl;
    }
}
