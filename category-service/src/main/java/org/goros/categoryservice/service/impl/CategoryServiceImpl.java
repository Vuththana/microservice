package org.goros.categoryservice.service.impl;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.goros.categoryservice.entity.model.Category;
import org.goros.categoryservice.entity.request.CategoryRequest;
import org.goros.categoryservice.repository.CategoryRepository;
import org.goros.categoryservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    public CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(UUID categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Category not found."));
    }

    @Override
    public void updateCategoryById(UUID categoryId, CategoryRequest request) {
        categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Category not found"));
        if(categoryRepository.findById(categoryId).isPresent() && request != null) {
            Category createdCategory = new Category();

            createdCategory.setCategoryId(UUID.randomUUID());
            createdCategory.setCategoryName(request.getCategoryName());
            createdCategory.setCategoryDescription(request.getCategoryDescription());

            categoryRepository.save(createdCategory);
        }
    }

    @Override
    public void deleteCategoryById(UUID categoryId) {
        getCategoryById(categoryId);

        categoryRepository.deleteById(categoryId);
    }
}
