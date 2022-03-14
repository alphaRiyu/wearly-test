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
 * @created Feb 14, 2022 5:49 PM
 */

@Entity
@Data
@Table(name = "rent")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "clotheId")
public class Rent extends Clothe {

    @Column(name = "availableStartDate", columnDefinition = "DATE")
    private String availableStartDate;

    @Column(name = "availableEndDate", columnDefinition = "DATE")
    private String availableEndDate;
}
