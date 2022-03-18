package com.byteme.wearly.repo.couturier;

import com.byteme.wearly.model.couturier.ClotheImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 16, 2022 1:40 AM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClotheImageRepoTest {

    @Autowired
    private ClotheImageRepo clotheImageRepoTest;
    private final ClotheImageRepo clotheImageRepoMock = mock(ClotheImageRepo.class);

    // this should accept an existing image id and a string for image filename
    @Test
    void itShouldAddClotheImageIfClotheExist() {

        // given
        Long id = 1L; // this is an existing image ID
        String imageFilename = "1_auction_0.jpg";
        // when
        clotheImageRepoMock.addClotheImage(id, imageFilename);
        // then
        verify(clotheImageRepoMock, times(1)).addClotheImage(id, imageFilename);

    }

    // this should not add an image and return an error if clothe ID does not exist
    @Test
    void itShouldNotAddClotheImageIfClotheDoesNotExist() {

        // given
        Long id = 6L; // this id does not exist
        String imageFilename = "1_auction_0.jpg";
        // when
        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
           clotheImageRepoTest.addClotheImage(id, imageFilename);
        });
        // then
        assertTrue(Objects.requireNonNull(exception.getMessage()).contains("could not execute statement"));

    }

    // this should return a list of all images by clothe ID
    @Test
    void itShouldReturnAllImages() {

        // given
        Long id = 1L; // this is an existing clothe ID;
        // when
        List<ClotheImage> expectedList = clotheImageRepoTest.findAllByClotheId(id);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if image ID does not exist or no image was added
    @Test
    void itShouldReturnEmpty() {

        // given
        Long id = 6L; // this ID does not exist
        // when
        List<ClotheImage> expectedList = clotheImageRepoTest.findAllByClotheId(id);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }
}