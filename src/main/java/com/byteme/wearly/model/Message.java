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
 * @created Feb 18, 2022 12:15 AM
 */

@Entity
@Data
@Table(name = "message")
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "messageId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "senderUserId")
    private WearlyUser user;

    @Column(name = "convoCode", columnDefinition = "VARCHAR(255)")
    private String convoCode;

    @Column(name = "message", columnDefinition = "VARCHAR(255)")
    private String message;

    @Column(name = "file", columnDefinition = "VARCHAR(255)")
    private String file;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt = new Date();

    @Transient
    private String filePath;

    @Transient
    public String getFilePath() {
        if (file == null || id == null) {
            return null;
        }
        return "/file/" + convoCode + "/" + file;
    }
}
