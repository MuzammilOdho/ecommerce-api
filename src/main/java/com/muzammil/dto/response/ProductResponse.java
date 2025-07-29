package com.muzammil.dto.response;

import java.time.LocalDateTime;

public class ProductResponse {
    private long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    private long productCategoryId;

    private LocalDateTime createdAt;

    public ProductResponse(long productId, String productName, String productDescription,
                           double productPrice, int productQuantity, long productCategoryId,
                           LocalDateTime createdAt) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productCategoryId = productCategoryId;
        this.createdAt = createdAt;
    }

    public ProductResponse() {
    }

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public long getProductCategoryId() {
        return productCategoryId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
