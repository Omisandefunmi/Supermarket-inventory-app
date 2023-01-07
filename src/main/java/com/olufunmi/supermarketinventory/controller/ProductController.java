package com.olufunmi.supermarketinventory.controller;

import com.olufunmi.supermarketinventory.dtos.AddRequest;
import com.olufunmi.supermarketinventory.services.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("product/")
public class ProductController {
    private final ProductService productService;

    @PostMapping("add/")
    public String addProduct(AddRequest request){
        return productService.addProducts(request);
    }

}
