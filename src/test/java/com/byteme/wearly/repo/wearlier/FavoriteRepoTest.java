package com.byteme.wearly.repo.wearlier;

import com.byteme.wearly.model.wearlier.Favorite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 16, 2022 7:08 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FavoriteRepoTest {

    @Autowired
    private FavoriteRepo favoriteRepoTest;
    private final FavoriteRepo favoriteRepoMock = mock(FavoriteRepo.class);

    // this should add the selected clothe to favorite by specific user
    @Test
    void itShouldAddClotheToFavorite() {

        // given
        Long userId = 1L; // this user exist
        Long clotheId = 1L; // this id exist
        // when
        favoriteRepoMock.addClotheToFavorite(userId, clotheId);
        // then
        verify(favoriteRepoMock, times(1)).addClotheToFavorite(userId, clotheId);

    }

    // this should throw an error when either clothe or user does not exist
    @Test
    void itShouldThrowErrorWhenUserOrClotheNotExist() {

        // given
        Long userId = 3L; // this user does not exist
        Long clotheId = 6L; // this clothing does not exist
        // when
        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
           favoriteRepoTest.addClotheToFavorite(userId, clotheId);
        });
        // then
        assertTrue(Objects.requireNonNull(exception.getMessage()).contains("could not execute statement"));

    }

    // this should return all clothes added to favorite by user using their ID
    @Test
    void itShouldReturnAllAddedClothesToFavoriteByUser() {

        // given
        Long userId = 1L; // this user exist and has 1 added clothe to favorite
        Sort sort = Sort.by("createdAt");
        // when
        List<Favorite> expectedList = favoriteRepoTest.findAllByUserId(userId, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list if user does not have any added clothes to favorite
    @Test
    void itShouldReturnEmptyListForNoAddedClothesToFavorite() {

        // given
        Long userId = 2L; // this user exist but does not have any added clothes to favorite
        Sort sort = Sort.by("createdAt");
        // when
        List<Favorite> expectedList = favoriteRepoTest.findAllByUserId(userId, sort);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }

    // this should delete or remove a specific clothe from favorite list of user
    @Test
    void itShouldRemoveClotheFromFavorites() {

        // given
        Long userId = 1L;
        Long clotheId = 1L;
        // when
        favoriteRepoMock.deleteFavoriteClothe(userId, clotheId);
        // then
        verify(favoriteRepoMock, times(1)).deleteFavoriteClothe(userId, clotheId);

    }
}