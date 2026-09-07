package org.goros.categoryservice.controller;

import org.goros.categoryservice.entity.model.Category;
import org.goros.categoryservice.entity.request.CategoryRequest;
import org.goros.categoryservice.entity.response.ApiResponse;
import org.goros.categoryservice.entity.response.ApiResponseVoid;
import org.goros.categoryservice.entity.response.CategoryResponse;
import org.goros.categoryservice.service.CategoryService;
import org.goros.categoryservice.utils.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getAllCategories() {
        List<CategoryResponse> categoryResponse = categoryService.getAllCategories().stream().map(category -> modelMapper.map(category, CategoryResponse.class)).toList();
        ApiResponse<List<CategoryResponse>> response = ResponseUtil.success("Categories fetched successfully", categoryResponse);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/category/{category-id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategoryById(@PathVariable("category-id") UUID categoryId) {
        CategoryResponse categoryResponse = modelMapper.map(categoryService.getCategoryById(categoryId), CategoryResponse.class);
        ApiResponse<CategoryResponse> response = ResponseUtil.success("Categories fetched successfully", categoryResponse);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/category/{category-id}")
    public ResponseEntity<ApiResponseVoid> deleteCategoryById(@PathVariable("category-id") UUID categoryId) {
        categoryService.deleteCategoryById(categoryId);
        ApiResponseVoid response = ResponseUtil.successVoid("Categories deleted successfully");
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/category/{category-id}")
    public ResponseEntity<ApiResponseVoid> updateCategoryById(@PathVariable("category-id") UUID categoryId, @RequestBody CategoryRequest request) {
        categoryService.updateCategoryById(categoryId, request);
        ApiResponseVoid response = ResponseUtil.successVoid("Categories deleted successfully");
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
