package com.myaem.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class HeroComponentModel {

    @ValueMapValue
    @Optional
    private String title;

    @ValueMapValue
    @Optional
    private String description;

    @ValueMapValue
    @Optional
    private String imageUrl;

    @ValueMapValue
    @Optional
    private String buttonLink;

    @ValueMapValue
    @Optional
    private String buttonText;

    public String getTitle () {
        return title;
    }

    public String getDescription () {
        return description;
    }

    public String getImageUrl () {
        return imageUrl;
    }

    public String getButtonLink () {
        return buttonLink;
    }

    public String getButtonText () {
        return buttonText;
    }


}
