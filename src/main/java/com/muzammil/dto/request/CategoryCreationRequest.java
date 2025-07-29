package com.muzammil.dto.request;

public class CategoryCreationRequest {
    private String categoryName;
    private String categoryDescription;

    public CategoryCreationRequest() {
    }

    public CategoryCreationRequest(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }
}
