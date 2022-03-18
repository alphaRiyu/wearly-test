package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.BidStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 16, 2022 4:47 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BidStatusRepoTest {

    @Autowired
    private BidStatusRepo bidStatusRepoTest;

    // this should return all bid status by clothe for auction ID
    @Test
    void itShouldReturnAllClothesForAuction() {

        // given
        Long id = 1L; // this id exist
        Sort sort = Sort.by("bidAmount");
        // when
        List<BidStatus> expectedList = bidStatusRepoTest.findAllByAuctionId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if clothe for auction ID does not exist
    @Test
    void itShouldReturnEmptyList() {

        // given
        Long id = 3L; // this id does not exist
        Sort sort = Sort.by("bidAmount");
        // when
        List<BidStatus> expectedList = bidStatusRepoTest.findAllByAuctionId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }

    // this should return all bid status by receiver ID for notification purposes
    @Test
    void itShouldReturnAllBidStatusByReceiverId() {

        // given
        Long id = 2L; // this id exist
        Sort sort = Sort.by("createdAt");
        // when
        List<BidStatus> expectedList = bidStatusRepoTest.findAllByReceiverId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if receiver ID does not exist or user does not have any notification for auction
    @Test
    void itShouldReturnEmptyListForNotFoundReceiverId(){

        // given
        Long id = 1L; // this id does not exist
        Sort sort = Sort.by("createdAt");
        // when
        List<BidStatus> expectedList = bidStatusRepoTest.findAllByReceiverId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }
}