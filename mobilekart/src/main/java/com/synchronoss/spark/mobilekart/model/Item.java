package com.synchronoss.spark.mobilekart.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

  private long barcodeId;
  String name;
  double price;
  double discountedPrice;
  int quantity;

  public long getBarcodeId() {
    return barcodeId;
  }

  public void setBarcodeId(long barcodeId) {
    this.barcodeId = barcodeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getDiscountedPrice() {
    return discountedPrice;
  }

  public void setDiscountedPrice(double discountedPrice) {
    this.discountedPrice = discountedPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
