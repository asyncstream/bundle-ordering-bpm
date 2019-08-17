package com.asyncstream.sales.ordering.bundle;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.ProcessApplicationInfo;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ProcessApplication("Bundle Ordering Process Application")
public class BundleOrderingProcessApplication extends ServletProcessApplication {
    private  static final Logger LOG = LoggerFactory.getLogger(BundleOrderingProcessApplication.class);

    @PostDeploy
    public void initProcessApplication(ProcessApplicationInfo info){
        LOG.info("Application started");
    }
}
