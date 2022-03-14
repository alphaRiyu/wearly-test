package com.byteme.wearly.model.couturier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 28, 2022 5:30 PM
 */

@Entity
@Data
@Table(name = "clotheSize")
@NoArgsConstructor
@AllArgsConstructor
public class ClotheSize {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "sizeId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clotheId", referencedColumnName = "clotheId")
    private Clothe clothe;

    @Column(name = "size", columnDefinition = "VARCHAR(25)")
    private String size;

    @Column(name = "shoulder", columnDefinition = "VARCHAR(20)")
    private String shoulder;

    @Column(name = "bust", columnDefinition = "VARCHAR(20)")
    private String bust;

    @Column(name = "topLength", columnDefinition = "VARCHAR(20)")
    private String topLength;

    @Column(name = "sleeves", columnDefinition = "VARCHAR(20)")
    private String sleeves;

    @Column(name = "bottomWaist", columnDefinition = "VARCHAR(20)")
    private String bottomWaist;

    @Column(name = "hips", columnDefinition = "VARCHAR(20)")
    private String hips;

    @Column(name = "thigh", columnDefinition = "VARCHAR(20)")
    private String thigh;

    @Column(name = "bottomLength", columnDefinition = "VARCHAR(20)")
    private String bottomLength;

}
