package org.goros.categoryservice.service;

import org.goros.categoryservice.entity.model.Category;
import org.goros.categoryservice.entity.request.CategoryRequest;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(UUID categoryId);
    void updateCategoryById(UUID categoryId, CategoryRequest request);
    void deleteCategoryById(UUID categoryId);
}