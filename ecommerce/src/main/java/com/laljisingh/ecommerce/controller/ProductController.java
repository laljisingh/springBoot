package com.laljisingh.ecommerce.controller;

import com.laljisingh.ecommerce.model.Product;
import com.laljisingh.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("add-product")
    public String addProduct(@RequestBody Product newProduct){
        return productService.addProduct(newProduct);
    }
    @GetMapping("find-all-product/{category}")
    public List<Product> getAllProductBasedCategory(@PathVariable String category){
        return productService.getAllProductBasedCategory(category);
    }

    @DeleteMapping("delete-product/{id}")
    public String deleteProduct(@PathVariable int id){
       return productService.deleteById(id);
    }

}
