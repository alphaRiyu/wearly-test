package com.byteme.wearly.controller;

import com.byteme.wearly.model.Message;
import com.byteme.wearly.service.ConversationService;
import com.byteme.wearly.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 18, 2022 12:26 AM
 */

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final ConversationService conversationService;

    @PostMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> createMessage(@PathVariable("id") Long receiverId, @RequestPart("message") String messageStr,
                                                 @RequestPart("file") MultipartFile file) throws IOException {
        Message message = messageService.getJsonData(messageStr);
        // validate if convo code already exist in conversation table, if so, no need to create a new code
        if (!conversationService.codeExist(message.getConvoCode())) {
            conversationService.create(message.getUser().getId(), receiverId);
        }
        messageService.create(message, file);
        return new ResponseEntity<>("Message sent!", HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<List<Message>> getMessageByConvoCode(@PathVariable("code") String convoCode) {
        return new ResponseEntity<>(messageService.getByConvoCode(convoCode), HttpStatus.OK);
    }

    @GetMapping(value = "/file/{convoCode}/{filename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getMessageFile(@PathVariable("convoCode") String convoCode, @PathVariable("filename") String file)
            throws IOException {
        FileSystemResource fileSystemResource = new FileSystemResource("src/main/resources/images/message/" + convoCode + "/" + file);
        InputStream inputStream = fileSystemResource.getInputStream();
        return new ResponseEntity<>(IOUtils.toByteArray(inputStream), HttpStatus.OK);
    }

}
