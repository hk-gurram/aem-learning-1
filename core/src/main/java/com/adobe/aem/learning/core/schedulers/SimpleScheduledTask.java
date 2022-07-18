/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.learning.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple demo for cron-job like tasks that get executed regularly.
 * It also demonstrates how property values can be set. Users can
 * set the property values in /system/console/configMgr
 */
@Designate(ocd = SimpleScheduledTask.Config.class)
@Component(service = Runnable.class)
public class SimpleScheduledTask implements Runnable {

    @ObjectClassDefinition(name = "A scheduled task", description = "Simple demo for cron-job like task with properties")
    public @interface Config {

        @AttributeDefinition(name = "Cron-job expression") String scheduler_expression() default "*/01 * * * * ?";

        @AttributeDefinition(name = "Concurrent task", description = "Whether or not to schedule this task concurrently") boolean scheduler_concurrent() default false;

        @AttributeDefinition(name = "A parameter", description = "Can be configured in /system/console/configMgr") String myParameter() default "This is Sling Scheduler Example";
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String myParameter;

    private Config configuration;

    private static final String JOB_TOPIC = "Scheduler Training";

    @Reference
    private Scheduler scheduler;

    @Override
    public void run() {
        logger.debug("SimpleScheduledTask is now running, myParameter='{}'", myParameter);
    }

    @Activate
    protected void activate(final Config config) {
        configuration = config;
        myParameter = config.myParameter();
        this.scheduleJob();
    }

    @Modified
    public void modified(final Config config) {
        this.configuration = config;
        this.unScheduleJob();
        this.scheduleJob();
    }

    @Deactivate
    private void deactivate() {
        this.unScheduleJob();
    }

    private void scheduleJob() {
        try {
            logger.info("Scheduling expression: {}", configuration.scheduler_expression());
            final ScheduleOptions options = this.scheduler
                                              .EXPR(this.configuration.scheduler_expression())
                                              .name(JOB_TOPIC)
                                              .canRunConcurrently(configuration.scheduler_concurrent());
            this.scheduler.schedule(this, options);
        } catch (final Exception e) {
            logger.error("Unable to schedule a job", e);
        }
    }

    private void unScheduleJob() {
        try {
            if (this.scheduler != null) {
                logger.info("Removing scheduled job: {}", JOB_TOPIC);
                this.scheduler.unschedule(JOB_TOPIC);
            }
        } catch (final Exception e) {
            logger.error("Unable to un schedule a job", e);
        }
    }

}
