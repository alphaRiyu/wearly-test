package com.byteme.wearly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 01, 2022 5:33 PM
 */

@Entity
@Data
@Table(name = "notification")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Notification {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "notificationId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "senderUserId", referencedColumnName = "userId")
    private WearlyUser sender;

    @ManyToOne
    @JoinColumn(name = "receiverUserId", referencedColumnName = "userId")
    private WearlyUser receiver;

    @Column(name = "isRead", columnDefinition = "TINYINT DEFAULT '0'")
    private int isRead = 0;

    @Column(name = "status", columnDefinition = "VARCHAR(25)")
    private String status;

    @Column(name = "serviceType", columnDefinition = "VARCHAR(50)")
    private String serviceType;

    @Column(name = "createdAt", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt = new Date();
}
