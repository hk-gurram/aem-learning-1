package com.adobe.aem.learning.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = OsgiServiceInterface.class, immediate = true)
@Designate(ocd = OsgiServiceConfigurations.class)
public class OsgiServiceImplmentation implements OsgiServiceInterface{

    private OsgiServiceConfigurations configurations;

    @Activate
    private void activate(OsgiServiceConfigurations config) {
        configurations = config;
    }

    @Override
    public String getCourseName() {
        return configurations.courseName();
    }

    @Override
    public String getCourseDetails() {
        return configurations.courseDetails();
    }

    @Override
    public String getCourseContent() {
        return configurations.courseContent();
    }
}
