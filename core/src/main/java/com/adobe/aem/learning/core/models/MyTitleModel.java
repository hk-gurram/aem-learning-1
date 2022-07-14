package com.adobe.aem.learning.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MyTitleModel {

    @ValueMapValue
    private String myTitle;

    @ValueMapValue
    private String linkPath;

    @ValueMapValue
    private String target;

    @ValueMapValue
    private boolean external;

    @ValueMapValue(name = "sling:resourceType")
    private String resourceType;

    public String getMyTitle() {
        return myTitle;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public String getTarget() {
        return target;
    }

    public boolean isExternal() {
        return external;
    }

    public String getResourceType() {
        return resourceType;
    }
}
