package com.byteme.wearly.model.wearlier;

import com.byteme.wearly.model.Notification;
import com.byteme.wearly.model.couturier.servicetype.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 11:00 AM
 */

@Entity
@Data
@Table(name = "rentRequest")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "notificationId")
public class RentRequest extends Notification {

    @ManyToOne
    @JoinColumn(name = "rentId", referencedColumnName = "clotheId")
    private Rent rent;

    @Column(name = "startDate", columnDefinition = "DATE")
    private Date startDate;

    @Column(name = "endDate", columnDefinition = "DATE")
    private Date endDate;

    @Column(name = "size", columnDefinition = "VARCHAR(50)")
    private String size;

    @Column(name = "quantity", columnDefinition = "INT DEFAULT '0'")
    private int quantity = 0;

}
