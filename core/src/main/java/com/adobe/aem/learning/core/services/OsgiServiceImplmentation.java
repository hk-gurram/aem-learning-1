package com.adobe.aem.learning.core.services;

import org.osgi.service.component.annotations.Component;

@Component(service = OsgiServiceInterface.class, immediate = true)
public class OsgiServiceImplmentation implements OsgiServiceInterface{

    @Override
    public String getCourseName() {
        return "AEM Training";
    }

    @Override
    public String getCourseDetails() {
        return "AEM Frontend and Backend concepts";
    }

    @Override
    public String getCourseContent() {
        return "Component, Templates, ClientLibs, Sling Models, OSGI Services";
    }
}
