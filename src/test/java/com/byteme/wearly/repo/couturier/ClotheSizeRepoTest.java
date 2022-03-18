package com.byteme.wearly.repo.couturier;

import com.byteme.wearly.model.couturier.ClotheSize;
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
 * @created Mar 16, 2022 2:44 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClotheSizeRepoTest {

    @Autowired
    private ClotheSizeRepo clotheSizeRepoTest;

    // this should return all sizes of clothe using its ID
    @Test
    void itShouldReturnAllClotheSize() {

        // given
        Long id = 1L; // this id exist
        // when
        List<ClotheSize> expectedList = clotheSizeRepoTest.findAllByClotheId(id);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if clothe does not exist
    @Test
    void itShouldReturnEmpty() {

        // given
        Long id = 2L; // this id does not exist
        // when
        List<ClotheSize> expectedList = clotheSizeRepoTest.findAllByClotheId(id);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }
}