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
 * @created Feb 14, 2022 5:45 PM
 */

@Entity
@Data
@Table(name = "sale")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "clotheId")
public class Sale extends Clothe {

    @Column(name = "soldCount", columnDefinition = "INT DEFAULT '0'")
    private int soldCount = 0;

}
