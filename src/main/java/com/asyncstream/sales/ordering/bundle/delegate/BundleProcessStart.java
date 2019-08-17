package com.asyncstream.sales.ordering.bundle.delegate;

import com.asyncstream.sales.ordering.bundle.model.Address;
import com.asyncstream.sales.ordering.bundle.model.Order;
import com.asyncstream.sales.ordering.bundle.model.OrderItem;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.ArrayList;
import java.util.List;

public class BundleProcessStart implements JavaDelegate {

    public static final String BUNDLE_ORDER_ID_VAR_NAME = "orderId";
    public static final String ORDER_VAR_NAME = "order";

    public void execute(DelegateExecution delegateExecution) throws Exception {
        String orderId=(String)delegateExecution.getVariable(BUNDLE_ORDER_ID_VAR_NAME);
        Order order= new Order();
        order.setOrderNumber(orderId);
        order.setOrderItems(orderItems());
        order.setShippingAddress(shippingAddress());
        delegateExecution.setVariable(ORDER_VAR_NAME,order);
    }

    List<OrderItem> orderItems(){
        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        OrderItem item1 = new OrderItem();
        item1.setItemNumber("9904849");
        item1.setCategory("books");
        item1.setQuantity(2);

        OrderItem item2 = new OrderItem();
        item2.setItemNumber("9904859");
        item2.setCategory("clothes");
        item2.setQuantity(2);

        OrderItem item3 = new OrderItem();
        item3.setItemNumber("9904850");
        item3.setCategory("clothes");
        item3.setQuantity(2);

        orderItems.add(item1);
        orderItems.add(item2);
        orderItems.add(item3);

        return orderItems;
    }

    Address shippingAddress(){
        Address address =new Address();
        address.setAddressLine("Regensburgerstr 50");
        address.setCity("Munich");
        address.setCountry("DEU");
        address.setZipCode("90402");
        return address;
    }
}
