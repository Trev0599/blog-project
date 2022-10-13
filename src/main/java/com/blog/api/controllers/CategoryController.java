package com.blog.api.controllers;

import com.blog.api.payloads.CategoryDto;
import com.blog.api.payloads.UserDto;
import com.blog.api.services.CategoryService;
import com.blog.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cat")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //POST MAPPING
    @PostMapping("/")
        public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto1 = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }

    //PUT MAPPING
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
        CategoryDto categoryDto1 = this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<CategoryDto> deleteCategory( @PathVariable Integer catId){
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity(Map.of("message","user successfully deleted"), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCatId(){

        return ResponseEntity.ok( this.categoryService.getAllCategory());
    }
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer catId){
        return ResponseEntity.ok(this.categoryService.getCategory(catId));
    }

}
