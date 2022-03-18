package com.byteme.wearly.repo;

import com.byteme.wearly.model.EmailVerification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 18, 2022 4:06 PM
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmailVerificationRepoTest {

    @Autowired
    private EmailVerificationRepo emailVerificationRepoTest;
    private EmailVerificationRepo emailVerificationRepoMock = mock(EmailVerificationRepo.class);

    // this should return an email verification data if user and code is found
    @Test
    void itShouldReturnEmailVerificationDetail() {

        // given
        Long id = 3L; // this is a user who has a pending email verification
        int code = 430551; // this is the code that was generated for the user
        // when
        EmailVerification expectedResult = emailVerificationRepoTest.findByUserIdAndCode(id, code);
        // then
        assertThat(expectedResult).isNotNull();

    }

    // this should return an empty or null result if user and code is not found
    @Test
    void itShouldReturnNull() {

        // given
        Long id = 4L; // this user does not exist and does not have a code
        int code = 541662; // this code does not exist
        // when
        EmailVerification expectedResult = emailVerificationRepoTest.findByUserIdAndCode(id, code);
        // then
        assertThat(expectedResult).isNull();

    }

    // this should delete the email verification data after the user verified it
    @Test
    void itShouldDeleteEmailVerificationData() {

        // given
        Long id = 3L; // assuming this user verified their email and its email verification data is about to be removed
        // when
        emailVerificationRepoMock.deleteByUserId(id);
        // then
        verify(emailVerificationRepoMock, times(1)).deleteByUserId(id);

    }
}