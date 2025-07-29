package com.muzammil.dto.request;

public class ProductCreationRequest {

    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    private long productCategoryId;

    public ProductCreationRequest() {
    }

    public ProductCreationRequest(String productName, String productDescription,
                                  double productPrice, int productQuantity,
                                  long productCategoryId) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productCategoryId = productCategoryId;
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
