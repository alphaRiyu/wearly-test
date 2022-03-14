package com.byteme.wearly.model;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 13, 2022 7:10 PM
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "wearlyUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class WearlyUser {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "userId")
    private Long id;

    @Column(name = "firstName", columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column(name = "lastName", columnDefinition = "VARCHAR(50)")
    private String lastName;

    @Column(name = "dateOfBirth", columnDefinition = "DATE")
    private String dateOfBirth;

    @Column(name = "contactNo", columnDefinition = "VARCHAR(15)")
    private String contactNo;

    @Column(name = "email", columnDefinition = "VARCHAR(50) UNIQUE")
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR(100)")
    private String password;

    @Column(name = "status", columnDefinition = "VARCHAR(10) DEFAULT 'Online'")
    private String status = "Online";

    @Column(name = "isWearlier", columnDefinition = "TINYINT(2) DEFAULT '0'")
    private int isWearlier = 0;

    @Column(name = "isCouturier", columnDefinition = "TINYINT(2) DEFAULT '0'")
    private int isCouturier = 0;

    @Column(name = "isAdmin", columnDefinition = "TINYINT(2) DEFAULT '0'")
    private int isAdmin = 0;

    @Column(name = "profileImage", columnDefinition = "VARCHAR(255)")
    private String profileImage;

    @Transient
    private String profileImagePath;

    @Transient
    public String getProfileImagePath() {
        if (profileImage == null || id == null) {
            return null;
        }
        return "/image/" + id + "/" + profileImage;
    }

}
