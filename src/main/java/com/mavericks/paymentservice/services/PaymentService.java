package com.mavericks.paymentservice.services;

import com.mavericks.paymentservice.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class PaymentService {
  @Autowired
  private OrderService orderService;

  public BigDecimal chargeForOrder(String orderId) throws IOException {
    Order order = orderService.getOrderById(orderId);
    return order.getTotal();
  }
}
