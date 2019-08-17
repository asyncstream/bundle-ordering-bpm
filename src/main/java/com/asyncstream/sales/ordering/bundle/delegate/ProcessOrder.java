package com.asyncstream.sales.ordering.bundle.delegate;

import com.asyncstream.sales.ordering.bundle.model.OrderItem;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessOrder implements JavaDelegate {
    private  static final Logger LOG = LoggerFactory.getLogger(ProcessOrder.class);
    public void execute(DelegateExecution delegateExecution) throws Exception {
        OrderItem item = (OrderItem)delegateExecution.getVariable("orderItem");
        //LOG.info("Item number::"+item.getItemNumber());
    }
}
