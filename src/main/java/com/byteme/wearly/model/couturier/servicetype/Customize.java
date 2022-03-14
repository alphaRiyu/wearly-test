package com.byteme.wearly.model.couturier.servicetype;

import com.byteme.wearly.model.couturier.Clothe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 12:16 PM
 */

@Entity
@Data
@Table(name = "customize")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "clotheId")
public class Customize extends Clothe {

    @Column(name = "bookCount", columnDefinition = "INT DEFAULT '0'")
    private int bookCount = 0;

}
