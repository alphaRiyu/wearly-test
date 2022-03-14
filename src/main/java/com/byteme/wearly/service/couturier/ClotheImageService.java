package com.byteme.wearly.service.couturier;

import com.byteme.wearly.model.couturier.Clothe;
import com.byteme.wearly.model.couturier.ClotheImage;
import com.byteme.wearly.repo.couturier.ClotheImageRepo;
import com.byteme.wearly.repo.couturier.ClotheRepo;
import com.byteme.wearly.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 13, 2022 11:32 AM
 */

@Service
@RequiredArgsConstructor
public class ClotheImageService {

    private final ClotheRepo clotheRepo;
    private final ClotheImageRepo clotheImageRepo;

    public void createClotheImage(Long id, MultipartFile[] file) throws IOException {
        Clothe clothe = clotheRepo.findById(id).orElseThrow(() -> new IllegalStateException("Clothe not found"));
        if (clotheRepo.existsById(clothe.getId())) {
            String uploadDir = "src/main/resources/images/clothe/" + id;
            for (int i = 0; i < file.length; i++) {
                String filename = id + "_auction_" + i + "." +
                        FilenameUtils.getExtension(file[i].getOriginalFilename());
                clotheImageRepo.addClotheImage(id, filename);
                FileUploadUtil.uploadImage(uploadDir, filename, file[i]);
            }
        }
    }

    public List<String> getList(Long id) {
        List<String> imagePaths = new ArrayList<>();
        for (ClotheImage image : clotheImageRepo.findAllByClotheId(id)) {
            imagePaths.add(image.getClotheImagePath());
        }
        return imagePaths;
    }
}
