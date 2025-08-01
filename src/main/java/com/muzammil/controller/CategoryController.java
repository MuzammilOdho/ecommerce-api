package com.muzammil.controller;

import com.muzammil.dto.ApiResponse;
import com.muzammil.dto.request.CategoryCreationRequest;
import com.muzammil.dto.response.CategoryResponse;
import com.muzammil.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<ApiResponse<?>> createCategory(@RequestBody CategoryCreationRequest category) {
        categoryService.save(category);
        ApiResponse<?> response = new ApiResponse<>(
                "Success",
                "Category Created",
                null
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategoryById(@PathVariable("id") long id) {
        CategoryResponse category = categoryService.findById(id);
        ApiResponse<CategoryResponse> response = new ApiResponse<>(
                "Success",
                "Category Found",
                category
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<ApiResponse<?>> updateCategory(@PathVariable("id") long categoryId, @RequestBody CategoryCreationRequest category) {
        categoryService.update(category,categoryId);
        ApiResponse<?> response = new ApiResponse<>(
                "success",
                "Category Updated!",
                null
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCategory(@PathVariable("id") long categoryId) {
        categoryService.delete(categoryId);
        ApiResponse<?> response = new ApiResponse<>(
                "success",
                "Category deleted!",
                null
        );
        return ResponseEntity.ok(response);
    }

}
