package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.RentRequest;
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
 * @created Mar 16, 2022 9:19 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RentRequestRepoTest {

    @Autowired
    private RentRequestRepo rentRequestRepoTest;

    // this should return rent request content using its ID
    @Test
    void itShouldReturnRentRequest() {

        // given
        Long id = 4L; // this rent request ID exist
        // when
        RentRequest expectedResult = rentRequestRepoTest.findByRentId(id);
        // then
        assertThat(expectedResult).isNotNull();

    }

    // this should not return a rent request content if ID does not exist
    @Test
    void itShouldReturnEmptyResultRentRequest() {

        // given
        Long id = 1L; // this rent request ID does exist
        // when
        RentRequest expectedResult = rentRequestRepoTest.findByRentId(id);
        // then
        assertThat(expectedResult).isNull();

    }

    // this should return all rent request of receiver for notification purposes
    @Test
    void itShouldReturnAllRentRequestByReceiverId() {

        // given
        Long id = 2L; // this user will receive the rent request
        Sort sort = Sort.by("createdAt");
        // when
        List<RentRequest> expectedList = rentRequestRepoTest.findAllByReceiverId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return all rent request of receiver for notification purposes
    @Test
    void itShouldReturnEmptyListOfRentRequestByReceiverId() {

        // given
        Long id = 1L; // this user does not have any rent request
        Sort sort = Sort.by("createdAt");
        // when
        List<RentRequest> expectedList = rentRequestRepoTest.findAllByReceiverId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }

}