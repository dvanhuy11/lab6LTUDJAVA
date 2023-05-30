package com.example.lab6.services;

import com.example.lab6.models.Product;
import com.example.lab6.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> GetAll(){
        return (List<Product>) productRepository.findAll();
    }

    public void Add(Product newProduct){
        productRepository.save(newProduct);
    }

    public Product get(int id) {
        return productRepository.findById(id).get();
    }

    public void save(Product product) {
        productRepository.save(product);
    }
    
    public void saveWithoutImage(int id, String name, int price){
        Product product = productRepository.getById(id);
        product.setName(name);
        product.setPrice(price);
        productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> search(String key){
        return productRepository.findAll().stream().filter(p -> p.getName().toLowerCase().contains(key)).toList();
    }
}
