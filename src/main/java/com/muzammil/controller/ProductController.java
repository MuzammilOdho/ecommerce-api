package com.muzammil.controller;

import com.muzammil.dto.ApiResponse;
import com.muzammil.dto.request.ProductCreationRequest;
import com.muzammil.dto.response.ProductResponse;
import com.muzammil.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/products")
    public ResponseEntity<ApiResponse<?>> createProduct(@RequestBody ProductCreationRequest productCreationRequest) {
        productService.save(productCreationRequest);
        ApiResponse<?> response = new ApiResponse<>(
                "success",
                "Product created" ,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ApiResponse<?>> deleteProduct(@PathVariable("id") long productId) {
        productService.delete(productId);
        ApiResponse<?> response = new ApiResponse<>(
                "success",
                "Product deleted" ,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(@PathVariable("id") long productId) {
                ProductResponse product = productService.findById(productId);
                ApiResponse<ProductResponse> response = new ApiResponse<>(
                        "success",
                        "Product found" ,
                        product
                );
                return ResponseEntity.ok(response);
    }
    @GetMapping("/products")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts() {
        List<ProductResponse> products = productService.findAll();
        ApiResponse<List<ProductResponse>> response = new ApiResponse<>(
                "success",
                "All products found" ,
                products
        );
        return ResponseEntity.ok(response);
    }

}
