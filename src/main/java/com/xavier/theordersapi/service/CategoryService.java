package com.xavier.theordersapi.service;

import com.xavier.theordersapi.repository.CategoryRepository;
import com.xavier.theordersapi.model.Category;
import com.xavier.theordersapi.service.exception.CategoryExistException;
import com.xavier.theordersapi.service.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(@Autowired CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(final Category category) {
        verifyIfExist(category);
        return categoryRepository.save(category);
    }


    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findById(Long id) {
        verifyIfNotExist(id);
        return categoryRepository.getOne(id);
    }

    public void delete(Long id) {
        verifyIfNotExist(id);
        categoryRepository.deleteById(id);
    }


    private boolean isUpdatingToADifferentCategory(Category category, Optional<Category> foundCategory) {
        return category.exist() && !category.equals(foundCategory);
    }

    private void verifyIfNotExist(Long id) {
        Optional<Category> foundCategory = categoryRepository.findById(id);
        if (!foundCategory.isPresent()) {
            throw new CategoryNotFoundException();
        }
    }

    private void verifyIfExist(Category category) {
        Optional<Category> foundCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (foundCategory.isPresent() && (category.isNew() || isUpdatingToADifferentCategory(category, foundCategory))) {
            throw new CategoryExistException();
        }
    }
}
