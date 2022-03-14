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
 * @created Feb 17, 2022 9:20 PM
 */

@Entity
@Data
@Table(name = "conversation")
@NoArgsConstructor
@AllArgsConstructor
public class Conversation {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "conversationId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receiverUserId")
    private WearlyUser receiverUser;

    @ManyToOne
    @JoinColumn(name = "senderUserId")
    private WearlyUser senderUser;

    @Column(name = "convoCode", columnDefinition = "VARCHAR(10)")
    private String convoCode;

    @Column(name = "isSeen", columnDefinition = "TINYINT DEFAULT '0'")
    private int isSeen = 0;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt = new Date();

}
