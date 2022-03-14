package com.byteme.wearly.repo.couturier;

import com.byteme.wearly.model.couturier.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 28, 2022 10:32 AM
 */

@Repository
public interface FollowRepo extends JpaRepository<Follow, Long> {

    List<Follow> findAllByFollowingId(Long id);
    List<Follow> findAllByFollowerId(Long id);
    @Modifying
    @Query(value = "DELETE FROM follow " +
            "WHERE follower_user_id = :followerId " +
            "AND following_user_id = :followingId", nativeQuery = true)
    void unfollowWearlyUser(@Param("followerId") Long followerId, @Param("followingId") Long followingId);

}
