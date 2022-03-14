package com.byteme.wearly.model.couturier.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 4:23 PM
 */

@Entity
@Data
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "categoryId")
    private Long id;

    @Column(name = "clothingFor", columnDefinition = "VARCHAR(20)")
    private String clothingFor;

    @Column(name = "type", columnDefinition = "VARCHAR(50)")
    private String type;
}
