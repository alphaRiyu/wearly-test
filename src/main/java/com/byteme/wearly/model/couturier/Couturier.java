package com.byteme.wearly.model.couturier;

import com.byteme.wearly.model.WearlyUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 14, 2022 12:54 PM
 */

@Entity
@Table(name = "couturier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@OnDelete(action = OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name = "userId")
public class Couturier extends WearlyUser {

    @Column(name = "title", columnDefinition = "VARCHAR(25) DEFAULT 'Couturier'")
    private String title = "Couturier";

    @Column(name = "approvedDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date approvedDate = new Date();
}
