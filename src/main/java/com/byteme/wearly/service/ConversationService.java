package com.byteme.wearly.service;

import com.byteme.wearly.model.Conversation;
import com.byteme.wearly.repo.ConversationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 11:03 PM
 */

@Service
@RequiredArgsConstructor
public class ConversationService {

    private final ConversationRepo conversationRepo;

    // TODO: 2/17/2022 handle errors
    @Transactional
    public void create(Long senderId, Long receiverId) {
        conversationRepo.saveConversation(senderId, receiverId);
    }

    public Boolean codeExist(String convoCode) {
        return conversationRepo.convoCodeExist(convoCode) >= 1;
    }

    public List<Conversation> getList(Long receiverId) {
        return conversationRepo.findAllByReceiverUserId(receiverId, Sort.by("createdAt"));
    }

    public void delete(Long id) {
        conversationRepo.deleteById(id);
    }
}
