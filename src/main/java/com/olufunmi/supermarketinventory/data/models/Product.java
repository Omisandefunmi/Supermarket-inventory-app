package com.olufunmi.supermarketinventory.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {

    private String id;
    @NonNull
    private String productName;
    @NonNull
    private String batchNumber;
    @NonNull
    private double price;
    @NonNull
    private String size;
    @NonNull
    private LocalDate dateAdded;
    @NonNull
    private int quantity;
}
