package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ProductController {

    private final AtomicLong idGenerator = new AtomicLong(4);
    private final List<Product> products = new CopyOnWriteArrayList<>(List.of(
            new Product(1L, "Laptop", new BigDecimal("65000.00")),
            new Product(2L, "Keyboard", new BigDecimal("1500.00")),
            new Product(3L, "Mouse", new BigDecimal("750.00"))
    ));

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/api/products")
    @ResponseBody
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping("/api/products")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        product.setId(idGenerator.getAndIncrement());
        products.add(product);
        return product;
    }
}
