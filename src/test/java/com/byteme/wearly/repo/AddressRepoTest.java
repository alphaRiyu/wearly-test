package com.byteme.wearly.repo;

import com.byteme.wearly.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 18, 2022 11:38 AM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AddressRepoTest {

    @Autowired
    private AddressRepo addressRepoTest;

    // this should return an address owned by specific user
    @Test
    void itShouldReturnAnAddressOfUser() {

        // given
        Long id = 1L; // this user added their address
        // when
        Address expectedResult = addressRepoTest.findByUserId(id).get();
        // then
        assertThat(expectedResult).isNotNull();

    }

    // this should return an empty object or address owned by user
    @Test
    void itShouldReturnEmptyForUserWithNoAddress() {

        // given
        Long id = 2L; // this user added their address
        // when
        Exception exception = assertThrows(Exception.class, () -> {
            addressRepoTest.findByUserId(id).get();
        });
        // then
        assertTrue(exception.getMessage().contains("No value present"));

    }
}