package com.byteme.wearly.controller;

import com.byteme.wearly.model.Conversation;
import com.byteme.wearly.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 17, 2022 11:35 PM
 */

@RestController
@RequestMapping("/convo")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Conversation>> getAllConversation(@PathVariable("id") Long receiverId) {
        return new ResponseEntity<>(conversationService.getList(receiverId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConversation(@PathVariable("id") Long id) {
        conversationService.delete(id);
        return new ResponseEntity<>("Conversation deleted.", HttpStatus.NO_CONTENT);
    }
}
