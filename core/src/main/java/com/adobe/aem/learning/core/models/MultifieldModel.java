package com.adobe.aem.learning.core.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldModel {

    @ValueMapValue
    private String mainLabel;

    @ChildResource
    private List<LinkModel> links = new ArrayList<>();

    public String getMainLabel() {
        return mainLabel;
    }

    public List<LinkModel> getLinks() {
        return links;
    }
}
