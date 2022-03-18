package com.byteme.wearly.repo.couturier;

import com.byteme.wearly.model.couturier.Follow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 16, 2022 3:49 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FollowRepoTest {

    @Autowired
    private FollowRepo followRepoTest;
    private final FollowRepo followRepoTestMock = mock(FollowRepo.class);

    // this should return all users following another user using the ID
    @Test
    void itShouldReturnAllFollowedByUser() {

        // given
        Long id = 2L; // this user exist following 1 user
        // when
        List<Follow> expectedList = followRepoTest.findAllByFollowingId(id);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if user is not following anyone
    @Test
    void itShouldReturnEmptyForFollowedByUser() {

        // given
        Long id = 1L; // this user does not follow any user
        // when
        List<Follow> expectedList = followRepoTest.findAllByFollowingId(id);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }

    // this should return all followers of one user using their ID
    @Test
    void itShouldReturnAllFollowersOfUser() {

        // given
        Long id = 1L; // this user has 1 follower
        // when
        List<Follow> expectedList = followRepoTest.findAllByFollowerId(id);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if users don't have any followers
    @Test
    void itShouldReturnEmptyForFollowersOfUser() {

        // given
        Long id = 2L; // this user does not have followers
        // when
        List<Follow> expectedList = followRepoTest.findAllByFollowerId(id);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }

    // this should unfollow a user
    @Test
    void itShouldUnfollowUser() {

        // given
        Long followerId = 1L;
        Long followingId = 2L;
        // when
        followRepoTestMock.unfollowWearlyUser(followerId, followingId);
        // then
        verify(followRepoTestMock, times(1)).unfollowWearlyUser(followerId, followingId);

    }
}