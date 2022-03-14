package com.byteme.wearly.model.couturier;

import com.byteme.wearly.model.WearlyUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 28, 2022 9:25 AM
 */

@Entity
@Data
@Table(name = "follow")
@NoArgsConstructor
@AllArgsConstructor
public class Follow {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "followId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "followerUserId", referencedColumnName = "userId")
    private WearlyUser follower;

    @ManyToOne
    @JoinColumn(name = "followingUserId", referencedColumnName = "userId")
    private WearlyUser following;

}
