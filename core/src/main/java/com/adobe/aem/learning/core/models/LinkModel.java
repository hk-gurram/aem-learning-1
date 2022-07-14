package com.adobe.aem.learning.core.models;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkModel {

    @ValueMapValue
    private String label;

    @ValueMapValue
    private String linkPath;

    @ValueMapValue
    private String target;

    @ValueMapValue
    private boolean external;

    private String linkURL;

    @PostConstruct
    protected void init() {
        if(StringUtils.isNoneBlank(linkPath)) {
            linkURL = BooleanUtils.isTrue(external) ? StringUtils.join("https://", linkPath) : StringUtils.join(linkPath, ".html");
        }
    }

    public String getLabel() {
        return label;
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

    public String getLinkURL() {
        return linkURL;
    }
}
