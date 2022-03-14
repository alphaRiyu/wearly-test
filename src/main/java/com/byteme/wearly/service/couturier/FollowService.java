package com.byteme.wearly.service.couturier;

import com.byteme.wearly.model.couturier.Follow;
import com.byteme.wearly.repo.couturier.FollowRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 28, 2022 10:33 AM
 */

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepo followRepo;

    public Follow create(Follow follow) {
        return followRepo.save(follow);
    }

    public List<Follow> getFollowerList(Long followedId) {
        return followRepo.findAllByFollowingId(followedId);
    }

    public List<Follow> getFollowingList(Long followerId) {
        return followRepo.findAllByFollowerId(followerId);
    }

    public void delete(Long followerId, Long followingId) {
        followRepo.unfollowWearlyUser(followerId, followingId);
    }
}
