package com.adobe.aem.learning.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "OSGI Service Configurations for AEM Learning", description = "This is an example learning")
public @interface OsgiServiceConfigurations {

    @AttributeDefinition(name = "Course Name") String courseName() default "";

    @AttributeDefinition(name = "Course Content") String courseContent() default "AEM Frontend and Backend concepts";

    @AttributeDefinition(name = "Course Duration") String courseDetails() default "Component, Templates, ClientLibs, Sling Models, OSGI Services";

}
