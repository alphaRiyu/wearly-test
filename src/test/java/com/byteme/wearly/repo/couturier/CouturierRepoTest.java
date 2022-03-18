package com.byteme.wearly.repo.couturier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 16, 2022 2:58 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CouturierRepoTest {

    @Autowired
    private CouturierRepo couturierRepoTest;
    private final CouturierRepo couturierRepoMock = mock(CouturierRepo.class);

    // this should add or register a new Couturier if ID exist
    @Test
    void itShouldRegisterNewCouturier() {

        // given
        Long id = 1L; // existing ID of Wearlier
        // when
        couturierRepoMock.addCouturierById(id);
        // then
        verify(couturierRepoMock, times(1)).addCouturierById(id);

    }

    // this should throw an error when adding a Couturier even though Wearlier does not exist
    @Test
    void itShouldNotRegisterNewCouturier() {

        // given
        Long id = 10L; // this ID does not exist
        // when
        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
           couturierRepoTest.addCouturierById(id);
        });
        // then
        assertTrue(Objects.requireNonNull(exception.getMessage()).contains("could not execute statement"));

    }

}