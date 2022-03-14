package com.byteme.wearly.model.couturier.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 4:34 PM
 */

@Entity
@Data
@Table(name = "subcategory")
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "subcategoryId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @Column(name = "subType", columnDefinition = "VARCHAR(50)")
    private String subType;
}
