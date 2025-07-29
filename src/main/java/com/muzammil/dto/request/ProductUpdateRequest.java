package com.muzammil.dto.request;

public class ProductUpdateRequest {
    private long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    private long productCategoryId;

    public ProductUpdateRequest() {
    }

    public ProductUpdateRequest(long productId, String productName,
                                String productDescription, double productPrice,
                                int productQuantity, long productCategoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productCategoryId = productCategoryId;
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
}
