package com.byteme.wearly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 08, 2022 12:08 PM
 */

@Entity
@Data
@Table(name = "emailVerification")
@NoArgsConstructor
@AllArgsConstructor
public class EmailVerification {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "emailVerificationId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private WearlyUser user;

    @Column(name = "code", columnDefinition = "INT(10)")
    private int code;

}
