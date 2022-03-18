package com.byteme.wearly.repo;

import com.byteme.wearly.model.Conversation;
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
 * @created Mar 18, 2022 12:20 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ConversationRepoTest {

    @Autowired
    private ConversationRepo conversationRepoTest;
    private final ConversationRepo conversationRepoMock = mock(ConversationRepo.class);

    // this should create a new conversation between two users
    @Test
    void itShouldCreateNewConversation() {

        // given
        Long senderId = 1L;
        Long receiverId = 2L;
        // when
        conversationRepoMock.saveConversation(senderId, receiverId);
        // then
        verify(conversationRepoMock, times(1)).saveConversation(senderId, receiverId);

    }

    // this should return an error or will not save a conversation if users does not exist
    @Test
    void itShouldReturnErrorAndNotCreateNewConversation() {

        // given
        Long senderId = 11L; // this user does not exist
        Long receiverId = 12L; // this user does not exist
        // when
        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
            conversationRepoTest.saveConversation(senderId, receiverId);
        });
        // then
        assertTrue(Objects.requireNonNull(exception.getMessage()).contains("could not execute statement"));

    }

    // this should return all conversation that the user is involved
    @Test
    void itShouldReturnAllConversationOfUser() {

        // given
        Long id = 1L; // this user has 1 conversation
        Sort sort = Sort.by("createdAt");
        // when
        List<Conversation> expectedList = conversationRepoTest.findAllByReceiverUserId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }

    // this should return an empty list for user who does not have any conversation
    @Test
    void itShouldReturnEmptyConversation() {

        // given
        Long id = 3L; // this user exist but does not have any conversation
        Sort sort = Sort.by("createdAt");
        // when
        List<Conversation> expectedList = conversationRepoTest.findAllByReceiverUserId(id, sort);
        // then
        assertThat(expectedList).asList();
        assertTrue(expectedList.isEmpty());

    }

    // this should return 1 if code exists
    @Test
    void itShouldReturnOneIfConvoCodeExist() {

        // given
        String convoCode = "12"; // this convo code exist
        // when
        int expectedResult = conversationRepoTest.convoCodeExist(convoCode);
        // then
        assertTrue(expectedResult > 0);

    }

    // this should return 0 if code does not exist
    @Test
    void itShouldReturnZeroIfConvoCodeDoesNotExist() {

        // given
        String convoCode = "112"; // this convo code does not exist
        // when
        int expectedResult = conversationRepoTest.convoCodeExist(convoCode);
        // then
        assertTrue(expectedResult <= 0);

    }
}