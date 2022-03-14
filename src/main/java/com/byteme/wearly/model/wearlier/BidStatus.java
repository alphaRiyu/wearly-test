package com.byteme.wearly.model.wearlier;

import com.byteme.wearly.model.Notification;
import com.byteme.wearly.model.couturier.servicetype.Auction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 9:30 AM
 */

@Entity
@Data
@Table(name = "bidStatus")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "notificationId")
public class BidStatus extends Notification {

    @ManyToOne
    @JoinColumn(name = "auctionId", referencedColumnName = "clotheId")
    private Auction auction;

    @Column(name = "bidAmount", columnDefinition = "DECIMAL (10, 2) DEFAULT '0.00'")
    private double bidAmount;

}
