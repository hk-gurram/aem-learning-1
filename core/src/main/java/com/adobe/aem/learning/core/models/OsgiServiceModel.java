package com.adobe.aem.learning.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.learning.core.services.OsgiServiceInterface;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OsgiServiceModel {

    @OSGiService
    private OsgiServiceInterface osgiServiceInterface;

    private String courseName;

    private String courseContent;

    private String courseDetails;

    public String getCourseName() {
        return osgiServiceInterface.getCourseName();
    }

    public String getCourseContent() {
        return osgiServiceInterface.getCourseContent();
    }

    public String getCourseDetails() {
        return osgiServiceInterface.getCourseDetails();
    }
}
