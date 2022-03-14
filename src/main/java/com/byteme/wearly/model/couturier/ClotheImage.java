package com.byteme.wearly.model.couturier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 13, 2022 11:08 AM
 */

@Entity
@Data
@Table(name = "clotheImage")
@NoArgsConstructor
@AllArgsConstructor
public class ClotheImage {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "clotheImageId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clotheId", referencedColumnName = "clotheId")
    private Clothe clothe;

    @Column(name = "clotheImage", columnDefinition = "VARCHAR(255)")
    private String clotheImage;

    @Transient
    private String clotheImagePath;

    @Transient
    public String getClotheImagePath() {
        if (clotheImage == null || id == null) {
            return null;
        }
        return "/image/" + clothe.getId() + "/" + clotheImage;
    }
}
