package com.byteme.wearly.model.couturier;

import com.byteme.wearly.model.couturier.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 3:09 PM
 */

@Entity
@Data
@Table(name = "clothe")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Clothe {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "clotheId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "couturierId", referencedColumnName = "userId")
    private Couturier couturier;

    @OneToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(255)")
    private String description;

    @Column(name = "price", columnDefinition = "DECIMAL(10, 2) DEFAULT '0.00'")
    private double price;

    @Column(name = "inSocks", columnDefinition = "INT DEFAULT '0'")
    private int inStocks;

    @Column(name = "serviceType", columnDefinition = "VARCHAR(20)")
    private String serviceType;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt = new Date();

}
