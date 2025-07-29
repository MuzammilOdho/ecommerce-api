package com.muzammil.dto.response;

public class CategoryResponse {
    private long categoryId;
    private String categoryName;
    private String categoryDescription;

    public CategoryResponse() {
    }

    public CategoryResponse(long categoryId, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }
}
