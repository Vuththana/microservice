package org.goros.categoryservice.entity.response;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryResponse {
    public UUID categoryId;
    public String categoryName;
    public String categoryDescription;
}
