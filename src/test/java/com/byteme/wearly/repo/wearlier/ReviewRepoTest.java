package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.Review;
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
 * @created Mar 18, 2022 11:09 AM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReviewRepoTest {

    @Autowired
    private ReviewRepo reviewRepoTest;

    // this should find all reviews of selected clothe
    @Test
    void itShouldReturnAllReviewsOfClothe() {

        // given
        Long id = 1L; // this clothing id has 1 review
        Sort sort = Sort.by("dateReviewed");
        // when
        List<Review> expectedList = reviewRepoTest.findAllByClotheId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list of reviews for the clothing that does not have one.
    @Test
    void itShouldReturnEmpty() {

        // given
        Long id = 2L; // this clothing id has no review
        Sort sort = Sort.by("dateReviewed");
        // when
        List<Review> expectedList = reviewRepoTest.findAllByClotheId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }

}