package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.BookAppointment;
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
 * @created Mar 16, 2022 5:20 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookAppointmentRepoTest {

    @Autowired
    private BookAppointmentRepo bookAppointmentRepoTest;

    // this should return one clothe for customize using its ID
    @Test
    void itShouldReturnClotheForCustomization() {

        // given
        Long id = 5L; // this id for customization exist
        // when
        BookAppointment expectedResult = bookAppointmentRepoTest.findByCustomizeId(id);
        // then
        assertThat(expectedResult).isNotNull();

    }

    // this should return nothing if customize ID does not exist
    @Test
    void itShouldReturnEmptyForNonExistingID() {

        // given
        Long id = 6L; // this id does not exist
        // when
        BookAppointment expectedResult = bookAppointmentRepoTest.findByCustomizeId(id);
        // then
        assertThat(expectedResult).isNull();

    }

    // this should return all clothes for customize by receiver ID for notification purpose
    @Test
    void itShouldReturnAllCustomizeByReceiverId() {

        // given
        Long id = 2L; // this id of receiver exist
        Sort sort = Sort.by("createdAt");
        // when
        List<BookAppointment> expectedList = bookAppointmentRepoTest.findAllByReceiverId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if receiver ID does not exist or no notification for receiver
    @Test
    void itShouldReturnEmptyForCustomizeByReceiverId() {

        // given
        Long id = 1L; // this id does not exist
        Sort sort = Sort.by("createdAt");
        // when
        List<BookAppointment> expectedList = bookAppointmentRepoTest.findAllByReceiverId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }
}