package com.ecom.ecommerse.dto;


import com.ecom.ecommerse.entity.Address;
import com.ecom.ecommerse.entity.Customer;
import com.ecom.ecommerse.entity.Order;
import com.ecom.ecommerse.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
