package com.byteme.wearly.repo;

import com.byteme.wearly.model.Message;
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
 * @created Mar 18, 2022 4:18 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MessageRepoTest {

    @Autowired
    private MessageRepo messageRepoTest;

    // this should return all messages between two users using their convo code
    @Test
    void itShouldReturnAllMessagesOfUsers() {

        // given
        String code = "12"; // this code exist between user 1 and user 2
        Sort sort = Sort.by("createdAt");
        // when
        List<Message> expectedList = messageRepoTest.findAllByConvoCode(code, sort);
        // then
        assertThat(expectedList).asList();
        assertFalse(expectedList.isEmpty());

    }
}