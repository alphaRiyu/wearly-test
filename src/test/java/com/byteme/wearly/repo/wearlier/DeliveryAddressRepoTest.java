package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.DeliveryAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 16, 2022 6:56 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DeliveryAddressRepoTest {

    @Autowired
    private DeliveryAddressRepo deliveryAddressRepoTest;

    // this should return all delivery address owned by user using their ID
    @Test
    void itShouldReturnAllDeliveryAddressOwnedByUser() {

        // given
        Long id = 1L; // this user id exist and has 1 delivery address
        // when
        List<DeliveryAddress> expectedList = deliveryAddressRepoTest.findByUserId(id);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if no delivery address was added by user
    @Test
    void itShouldReturnEmptyListIfNoDeliveryAddress() {

        // given
        Long id = 2L; // although this user exist, but has not added any delivery address
        // when
        List<DeliveryAddress> expectedList = deliveryAddressRepoTest.findByUserId(id);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }
}