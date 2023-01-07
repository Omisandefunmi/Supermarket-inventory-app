package com.olufunmi.supermarketinventory.services;

import com.olufunmi.supermarketinventory.data.models.Product;
import com.olufunmi.supermarketinventory.data.repositories.ProductRepository;
import com.olufunmi.supermarketinventory.dtos.AddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public String addProducts(AddRequest request) {
        Optional<Product> productExists = productRepository.findByBatchNumber(request.getBatchNumber());
        if(productExists.isPresent()){
            Product actualProduct = productExists.get();
            if(actualProduct.getSize().equals(request.getSize())){
                int newQuantity = actualProduct.getQuantity() + request.getQuantity();
                actualProduct.setQuantity(newQuantity);
            }
            else{
                Product product = createNewProduct(request);
                productRepository.save(product);
            }
        }

        else{
            Product product = createNewProduct(request);
            productRepository.save(product);

        }
        return "product added";
    }

    private static Product createNewProduct(AddRequest request) {
        Product product = new Product();
        product.setQuantity(request.getQuantity());
        product.setProductName(request.getProductName());
        product.setPrice(request.getPrice());
        product.setBatchNumber(request.getBatchNumber());
        product.setSize(request.getSize());
        product.setDateAdded(LocalDate.now());

        return product;
    }
}
