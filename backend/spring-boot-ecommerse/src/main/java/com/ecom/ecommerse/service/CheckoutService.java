package com.ecom.ecommerse.service;


import com.ecom.ecommerse.dto.Purchase;
import com.ecom.ecommerse.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
