package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.CartItem;
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
 * @created Mar 16, 2022 6:14 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CartItemRepoTest {

    @Autowired
    private CartItemRepo cartItemRepoTest;

    // this should return all cart items owned by wearlier
    @Test
    void itShouldReturnAllCartItemsOfWearlier() {

        // given
        Long id = 1L; // this wearlier id exist
        // when
        List<CartItem> expectedList = cartItemRepoTest.findByWearlierId(id);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list for wearlier who does not have any cart items
    @Test
    void itShouldReturnEmptyListForNoItems() {

        // given
        Long id = 2L; // this wearlier does not have any cart items added
        // when
        List<CartItem> expectedList = cartItemRepoTest.findByWearlierId(id);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }
}