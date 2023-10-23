package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;
    @GetMapping
    public List<Item> getAllItems(){
        return productRepository.findAll();
    }
    @PostMapping()
    public Item saveItem(@RequestBody Item item){
        return productRepository.save(item);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Item updateEntity(@PathVariable Long id, @RequestBody Item updatedItem) {
        Item existingEntity = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with ID: " + id));

        existingEntity.setTitle(updatedItem.getTitle());
        existingEntity.setQuantity(updatedItem.getQuantity());
        existingEntity.setPrice(updatedItem.getPrice());

        return productRepository.save(existingEntity);
    }
}
