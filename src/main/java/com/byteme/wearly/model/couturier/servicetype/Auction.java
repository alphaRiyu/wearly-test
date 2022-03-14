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
 * @created Feb 14, 2022 5:50 PM
 */

@Entity
@Data
@Table(name = "auction")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "clotheId")
public class Auction extends Clothe {

    @Column(name = "bidIncrement", columnDefinition = "DECIMAL(10, 2)")
    private double bidIncrement = 0;

    @Column(name = "postDuration", columnDefinition = "TIME")
    private String postDuration;

    @Column(name = "dateTime", columnDefinition = "DATETIME")
    private String dateTime;
}
