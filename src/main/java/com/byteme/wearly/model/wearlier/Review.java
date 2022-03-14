package com.byteme.wearly.model.wearlier;

import com.byteme.wearly.model.WearlyUser;
import com.byteme.wearly.model.couturier.Clothe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 24, 2022 4:48 PM
 */

@Entity
@Data
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "reviewId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private WearlyUser user;

    @ManyToOne
    @JoinColumn(name = "clotheId", referencedColumnName = "clotheId")
    private Clothe clothe;

    @Column(name = "review", columnDefinition = "INT(10)")
    private int review = 0;

    @Column(name = "comment", columnDefinition = "VARCHAR(255)")
    private String comment;

    @Column(name = "dateReviewed", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date dateReviewed = new Date();
}
