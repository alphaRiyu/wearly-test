package com.byteme.wearly.service;

import com.byteme.wearly.model.Message;
import com.byteme.wearly.repo.MessageRepo;
import com.byteme.wearly.util.FileUploadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 18, 2022 12:20 AM
 */

@Service
@RequiredArgsConstructor
public class MessageService {
    
    private final MessageRepo messageRepo;

    // TODO: 2/18/2022 optimize
    @Transactional
    public void create(Message message, MultipartFile file) throws IOException {
        Message savedMessage = messageRepo.save(message);
        if (!file.isEmpty()) {
            String uploadDir = "src/main/resources/images/message/" + savedMessage.getConvoCode();
            String filename = savedMessage.getConvoCode() + "_" + savedMessage.getId() + "."
                    + FilenameUtils.getExtension(file.getOriginalFilename());
            message.setFile(filename);
            FileUploadUtil.uploadImage(uploadDir, filename, file);
        }
    }

    public Message getJsonData(String messageStr) {
        Message message = new Message();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            message = objectMapper.readValue(messageStr, Message.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    // TODO: 2/18/2022 optimize
    public List<Message> getByConvoCode(String convoCode) {
        return messageRepo.findAllByConvoCode(convoCode, Sort.by("createdAt"));
    }
}
