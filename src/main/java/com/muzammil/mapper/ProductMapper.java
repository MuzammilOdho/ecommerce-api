package com.muzammil.mapper;

import com.muzammil.dto.request.ProductCreationRequest;
import com.muzammil.dto.response.ProductResponse;
import com.muzammil.model.Product;

public class ProductMapper {

    public static Product toProduct(ProductCreationRequest productCreationRequest){
        return new Product(productCreationRequest.getProductName(),
                productCreationRequest.getProductDescription(),
                productCreationRequest.getProductPrice(),
                productCreationRequest.getProductQuantity()
        );
    }
    public static ProductResponse toProductResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getId(),
                product.getCreatedAt()
        );
    }

}
