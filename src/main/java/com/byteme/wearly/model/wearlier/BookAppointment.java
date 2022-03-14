package com.byteme.wearly.model.wearlier;

import com.byteme.wearly.model.Notification;
import com.byteme.wearly.model.couturier.servicetype.Customize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 25, 2022 12:12 PM
 */

@Entity
@Data
@Table(name = "bookAppointment")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "notificationId")
public class BookAppointment extends Notification {

    @ManyToOne
    @JoinColumn(name = "customizeId", referencedColumnName = "clotheId")
    private Customize customize;

    @Column(name = "firstName", columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column(name = "lastName", columnDefinition = "VARCHAR(50)")
    private String lastName;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "contactNo", columnDefinition = "VARCHAR(20)")
    private String contactNo;

    @Column(name = "address", columnDefinition = "VARCHAR(255)")
    private String address;

    @Column(name = "availableDate", columnDefinition = "DATE")
    private Date availableDate;

    @Column(name = "consultationType", columnDefinition = "VARCHAR(50)")
    private String consultationType;

    @Column(name = "ownDesign", columnDefinition = "VARCHAR(255)")
    private String ownDesign;

    @Column(name = "note", columnDefinition = "VARCHAR(255)")
    private String note;

}
