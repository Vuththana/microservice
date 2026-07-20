package org.goros.categoryservice.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    public UUID categoryId;
    public String categoryName;
    public String categoryDescription;
}
