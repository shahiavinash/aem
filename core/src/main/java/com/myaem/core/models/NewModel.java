package com.myaem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)

public class NewModel {
    @ValueMapValue
    private String text1;

    public String getText1() {
        return text1;
    }


}
