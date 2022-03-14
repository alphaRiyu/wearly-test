package com.byteme.wearly.model;

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
 * @created Mar 14, 2022 11:38 AM
 */

@Entity
@Data
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
@OnDelete(action = OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name = "userId")
public class Admin extends WearlyUser {

    @Column(name = "title", columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(name = "createdAt", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt = new Date();

}
