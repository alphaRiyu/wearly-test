package com.byteme.wearly.repo;

import com.byteme.wearly.model.Conversation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 11:03 PM
 */

@Repository
public interface ConversationRepo extends JpaRepository<Conversation, Long> {

    @Modifying
    @Query(value = "INSERT INTO conversation(receiver_user_id, sender_user_id, convo_code) " +
            "VALUES(:receiverId, :senderId, CONCAT(:receiverId, '', :senderId)), " +
            "(:senderId, :receiverId, CONCAT(:receiverId, '', :senderId))", nativeQuery = true)
    void saveConversation(@Param("senderId") Long senderId, @Param("receiverId") Long receiverId);
    List<Conversation> findAllByReceiverUserId(Long id, Sort sort);
    @Query(value = "SELECT count(convo_code) " +
            "FROM conversation " +
            "WHERE convo_code = :code", nativeQuery = true)
    int convoCodeExist(@Param("code") String code);

}
