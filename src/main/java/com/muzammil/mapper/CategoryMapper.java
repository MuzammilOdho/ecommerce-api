package com.muzammil.mapper;

import com.muzammil.dto.request.CategoryCreationRequest;
import com.muzammil.dto.response.CategoryResponse;
import com.muzammil.model.Category;

public class CategoryMapper {
    public static Category toCategory(CategoryCreationRequest categoryCreationRequest) {
       return new Category(
                categoryCreationRequest.getCategoryName(),
                categoryCreationRequest.getCategoryDescription()
        );
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}
