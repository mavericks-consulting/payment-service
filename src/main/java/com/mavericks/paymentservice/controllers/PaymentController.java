package com.mavericks.paymentservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mavericks.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
@RequestMapping("/payments")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @RequestMapping(
      path = "/orders/{orderId}",
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE
  )
  public ResponseEntity<String> chargeForOrder(@PathVariable String orderId) throws IOException {
    BigDecimal amountCharged = paymentService.chargeForOrder(orderId);
    if(Integer.parseInt(orderId)%5 == 0) {
      return getResponseString("Could not process payment for order ", orderId, HttpStatus.BAD_REQUEST);
    }
    return getResponseString("Payment of " + amountCharged + " successful for order ", orderId, HttpStatus.ACCEPTED);
  }

  private ResponseEntity<String> getResponseString(String message, String orderId, HttpStatus statusCode) throws JsonProcessingException {
    return new ResponseEntity<String>(message + orderId, statusCode);
  }
}
