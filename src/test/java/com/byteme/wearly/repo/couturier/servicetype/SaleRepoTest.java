package com.byteme.wearly.repo.couturier.servicetype;

import com.byteme.wearly.model.couturier.servicetype.Sale;
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
 * @created Mar 16, 2022 1:32 AM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SaleRepoTest {

    @Autowired
    private SaleRepo saleRepoTest;

    // this should return all clothes owned by Couturier using their ID
    @Test
    void itShouldReturnAllClothes() {

        // given
        Long id = 2L;
        Sort sort = Sort.by("createdAt");
        // when
        List<Sale> expectedList = saleRepoTest.findAllByCouturierId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if Couturier ID does not exist or no clothe added
    @Test
    void itShouldReturnEmpty() {

        // given
        Long id = 1L;
        Sort sort = Sort.by("createdAt");
        // when
        List<Sale> expectedList = saleRepoTest.findAllByCouturierId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }

}