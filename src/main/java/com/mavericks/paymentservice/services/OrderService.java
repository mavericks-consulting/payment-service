package com.mavericks.paymentservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mavericks.paymentservice.http.RestClient;
import com.mavericks.paymentservice.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
class OrderService {
  @Value("${order-service.host}")
  private String server;

  @Value("${order-service.port}")
  private String port;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private RestClient restClient;

  Order getOrderById(String orderId) throws IOException {
    ResponseEntity<String> stringResponseEntity = restClient.get(server, port, "/orders/" + orderId);
    return objectMapper.readValue(stringResponseEntity.getBody(), Order.class);
  }
}
