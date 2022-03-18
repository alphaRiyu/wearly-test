package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.Wearlier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 18, 2022 11:15 AM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class WearlierRepoTest {

    @Autowired
    private WearlierRepo wearlierRepoTest;

    // this should return a user by finding them using their email
    @Test
    void itShouldReturnUserUsingIfEmailExist() {

        // given
        String email = "generieu17@gmail.com";
        // when
        Wearlier expectedResult = wearlierRepoTest.findWearlierByEmail(email).get();
        // then
        assertThat(expectedResult).isNotNull();
        assertEquals(expectedResult.getEmail(), email);

    }

    // this should return an empty result if user does not exist
    @Test
    void itShouldReturnEmptyResult() {

        // given
        String email = "example@gmail.com";
        // when
        Exception exception = assertThrows(Exception.class, () -> {
           wearlierRepoTest.findWearlierByEmail(email).get();
        });
        // then
        assertTrue(exception.getMessage().contains("No value present"));

    }
}