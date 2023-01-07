package com.olufunmi.supermarketinventory.dtos;



import lombok.Getter;


@Getter
public class AddRequest {
    private String productName;
    private String batchNumber;
    private double price;
    private String size;
    private int quantity;
}
