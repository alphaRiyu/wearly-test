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
 * @created Feb 18, 2022 3:18 PM
 */

@Entity
@Data
@Table(name = "favorite")
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "favoriteId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ownerUserId")
    private WearlyUser user;

    @ManyToOne
    @JoinColumn(name = "addedClotheId")
    private Clothe clothe;

    @Column(name = "isFavorite", columnDefinition = "TINYINT DEFAULT '1'")
    private int isFavorite = 1;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt = new Date();
}
