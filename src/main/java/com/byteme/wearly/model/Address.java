package com.byteme.wearly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 10:04 AM
 */

@Entity
@Data
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "addressId")
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private WearlyUser user;

    @Column(name = "streetNo", columnDefinition = "VARCHAR(50)")
    private String streetNo;

    @Column(name = "baranggay", columnDefinition = "VARCHAR(50)")
    private String baranggay;

    @Column(name = "city", columnDefinition = "VARCHAR(20)")
    private String city;

    @Column(name = "country", columnDefinition = "VARCHAR(20)")
    private String country;

    @Column(name = "zipCode", columnDefinition = "VARCHAR(15)")
    private String zipCode;

    @Column(name = "description", columnDefinition = "VARCHAR(255)")
    private String description;
}
