package org.mysimplelibrary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private String name;
    @Id
    private Long id;
    private String email;
}
