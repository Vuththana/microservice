package org.goros.categoryservice.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID categoryId;
    @Column(name = "category_name", nullable = true)
    public String categoryName;
    @Column(name = "category_description", nullable = true)
    public String categoryDescription;
}
