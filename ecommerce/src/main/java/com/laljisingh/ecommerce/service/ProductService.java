package com.laljisingh.ecommerce.service;

import com.laljisingh.ecommerce.dao.ProductRepository;
import com.laljisingh.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public String addProduct(Product newProduct) {
        productRepository.save(newProduct);
        return "Product Saved";
    }

    public List<Product> getAllProductBasedCategory(String category) {
        List<Product> productList = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            if(product.getCategory().equals(category)){
                productList.add(product);
            }
        }
        return productList;
    }

    public String deleteById(int id) {
         productRepository.deleteById(id);
         return "Product Delete";
    }
}
