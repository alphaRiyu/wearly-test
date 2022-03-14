package com.byteme.wearly.model.wearlier;

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
 * @created Feb 14, 2022 10:22 AM
 */

@Entity
@Table(name = "wearlier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@OnDelete(action = OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name = "userId")
public class Wearlier extends WearlyUser {

    @Column(name = "title", columnDefinition = "VARCHAR(25) DEFAULT 'Wearlier'")
    private String title = "Wearlier";

    @Column(name = "joinedDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date joinedDate = new Date();
}
