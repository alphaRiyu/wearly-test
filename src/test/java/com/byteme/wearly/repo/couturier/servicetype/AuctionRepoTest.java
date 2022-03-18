package com.byteme.wearly.repo.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Auction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 15, 2022 10:51 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuctionRepoTest {

    @Autowired
    private AuctionRepo auctionRepoTest;

    // this should return all clothes for auction owned by couturier using their ID
    @Test
    void itShouldReturnAllClothes() {

        // given
        Long id = 2L; // this is an existing id of Couturier
        Sort sort = Sort.by("createdAt");
        // when
        List<Auction> expectedAuctionList = auctionRepoTest.findAllByCouturierId(id, sort);
        // then
        assertThat(expectedAuctionList).asList();
        assertFalse(expectedAuctionList.isEmpty());
    }

    // this should return an empty list if the Couturier does not exist or doesn't have any added clothes
    @Test
    void itShouldReturnEmpty() {

        // given
        Long id = 1L; // this id does not exist as Couturier
        Sort sort = Sort.by("createdAt");
        // when
        List<Auction> expectedAuctionList = auctionRepoTest.findAllByCouturierId(id, sort);
        // then
        assertThat(expectedAuctionList).asList();
        assertTrue(expectedAuctionList.isEmpty());

    }


}