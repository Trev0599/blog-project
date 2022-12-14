package com.blog.api.payloads;

public class ResourceNotFoundExceptiuon extends RuntimeException {
    String resourceName; String fieldName; Integer fieldValue;
    public ResourceNotFoundExceptiuon(String resourceName, String fieldName, Integer fieldValue) {

        super(String.format("%s not found with %s: %s",resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;

    }
}
