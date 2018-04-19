package com.mavericks.paymentservice.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {
  private Long id;

  private String productIds;

  private BigDecimal total;

  public Order() {

  }

  public Long getId() {
    return id;
  }

  public String getProductIds() {
    return productIds;
  }

  public BigDecimal getTotal() { return total; }

  public void setId(Long id) {
    this.id = id;
  }

  public void setProductIds(String productIds) {
    this.productIds = productIds;
  }

  public void setTotal(BigDecimal total) { this.total = total; }
}
