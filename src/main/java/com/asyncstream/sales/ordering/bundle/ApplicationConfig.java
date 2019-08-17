package com.asyncstream.sales.ordering.bundle;

import com.asyncstream.sales.ordering.bundle.delegate.BundleProcessStart;
import com.asyncstream.sales.ordering.bundle.delegate.ConfirmDeliveryAgent;
import com.asyncstream.sales.ordering.bundle.delegate.ProcessOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public BundleOrderingProcessApplication bundleOrderingProcessApplication(){
        return new BundleOrderingProcessApplication();
    }

    @Bean
    public BundleProcessStart bundleProcessStart(){
        return new BundleProcessStart();
    }

    @Bean
    public ConfirmDeliveryAgent confirmDeliveryAgent(){
        return new ConfirmDeliveryAgent();
    }

    @Bean
    public ProcessOrder processOrder(){
        return new ProcessOrder();
    }
}
