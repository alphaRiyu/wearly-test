package com.byteme.wearly.repo.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Customize;
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
 * @created Mar 16, 2022 1:17 AM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomizeRepoTest {

    @Autowired
    private CustomizeRepo customizeRepoTest;

    // this should return a list of all clothes owned by Couturier using their ID
    @Test
    void itShouldReturnAllClothes() {

        // given
        Long id = 2L; // existing id of Couturier
        Sort sort = Sort.by("createdAt");
        // when
        List<Customize> expectedList = customizeRepoTest.findAllByCouturierId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if id of Couturier does not exist or there are no clothes listed
    @Test
    void itShouldReturnEmpty() {

        // given
        Long id = 1L; // not existing id of Couturier
        Sort sort = Sort.by("createdAt");
        // when
        List<Customize> expectedList = customizeRepoTest.findAllByCouturierId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }
}