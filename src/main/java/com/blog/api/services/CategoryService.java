package com.blog.api.services;

import com.blog.api.payloads.CategoryDto;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface CategoryService {

    //create
    public CategoryDto createCategory(CategoryDto categoryDto);

    //update
    public CategoryDto updateCategory(CategoryDto categoryDto,Integer catId);

    //delete
    void deleteCategory(Integer catId);

    //get
    public CategoryDto getCategory(Integer catId);

    //getAll

    List<CategoryDto> getAllCategory();


}
