package com.blog.api.services;

import com.blog.api.entities.Category;
import com.blog.api.payloads.CategoryDto;
import com.blog.api.payloads.ResourceNotFoundExceptiuon;
import com.blog.api.repo.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.categoryDtoToCat(categoryDto);
        Category newCategory = this.categoryRepo.save(category);

            return this.catToCatDto(newCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer catId) {

        Category cat = this.categoryRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundExceptiuon("Category","CategoryId",catId));

        cat.setCatDesc(categoryDto.getCatDesc());
        cat.setCatTitle(categoryDto.getCatTitle());
       Category updateCat =  this.categoryRepo.save(cat);
       return this.catToCatDto(updateCat);
    }

    @Override
    public void deleteCategory(Integer catId) {
        this.categoryRepo.deleteById(catId);
    }

    @Override
    public CategoryDto getCategory(Integer catId) {

        Category cat = this.categoryRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundExceptiuon("Category","CategoryId",catId));

        return this.catToCatDto(cat);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> cat = this.categoryRepo.findAll();
       List<CategoryDto> categoryDto1= cat.stream().map(allCat->this.catToCatDto(allCat)).collect(Collectors.toList());
       return  categoryDto1;
    }

    public Category categoryDtoToCat(CategoryDto categoryDto){
        Category category = this.modelMapper.map(categoryDto,Category.class);
        return category;
    }
    public CategoryDto catToCatDto(Category category){
        CategoryDto categoryDto = this.modelMapper.map(category,CategoryDto.class);
        return categoryDto;
    }

}
