package com.adobe.aem.learning.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.learning.core.services.OsgiServiceInterface;
import com.adobe.aem.learning.core.services.OsgiServiceUserInterface;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OsgiServiceModel {

    @OSGiService
    private OsgiServiceInterface osgiServiceInterface;

    @OSGiService
    private OsgiServiceUserInterface osgiServiceUser;

    @ValueMapValue
    private String linkPath;

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

    public String getLinkPath() {
        return linkPath;
    }

    public List<String> getChildPages() {
        return osgiServiceUser.getChildPages(linkPath);
    }
}
