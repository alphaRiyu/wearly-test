package com.byteme.wearly.service.wearlier;

import com.byteme.wearly.model.EmailVerification;
import com.byteme.wearly.model.WearlyUser;
import com.byteme.wearly.model.wearlier.Wearlier;
import com.byteme.wearly.repo.EmailVerificationRepo;
import com.byteme.wearly.repo.WearlyUserRepo;
import com.byteme.wearly.repo.wearlier.WearlierRepo;
import com.byteme.wearly.util.EmailVerificationUtil;
import com.byteme.wearly.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Feb 13, 2022 7:15 PM
 */

@Service
@RequiredArgsConstructor
public class WearlierService {
    private final WearlierRepo wearlierRepo;
    private final WearlyUserRepo wearlyUserRepo;
    private final EmailVerificationRepo emailVerificationRepo;
    private final EmailVerificationUtil emailVerificationUtil;

    // TODO: 2/15/2022 validate entry 
    public Wearlier create(Wearlier wearlier) {
        if (wearlierRepo.findWearlierByEmail(wearlier.getEmail()).isPresent()) {
            Wearlier currentWearlier = wearlierRepo
                    .findWearlierByEmail(wearlier.getEmail())
                    .orElseThrow(() -> new IllegalStateException("User not found"));
            if (currentWearlier.getIsWearlier() == 0) {
                sendEmail(currentWearlier);
                return currentWearlier;
            }
            throw new IllegalStateException("Email is already taken.");
        }
        Wearlier savedWearlier = wearlierRepo.save(wearlier);
        sendEmail(wearlier);
        return savedWearlier;
    }

    public void sendEmail(Wearlier wearlier) {
        emailVerificationUtil.setTo(wearlier.getEmail());
        emailVerificationUtil.send();
        EmailVerification emailVerification = new EmailVerification();
        emailVerification.setCode(emailVerificationUtil.getCode());
        emailVerification.setUser(wearlier);
        emailVerificationRepo.save(emailVerification);
    }

    public boolean isVerified(Long id, int code) {
        if (emailVerificationRepo.existsById(emailVerificationRepo.findByUserIdAndCode(id, code).getId())) {
            WearlyUser currentUser = wearlyUserRepo
                    .findById(id)
                    .orElseThrow(() -> new IllegalStateException("User not found"));
            currentUser.setIsWearlier(1);
            wearlyUserRepo.save(currentUser);
            emailVerificationRepo.deleteByUserId(id);
            return true;
        }
        return false;
    }

    public void createProfileImage(Long id, MultipartFile file) throws IOException {
        WearlyUser user = wearlyUserRepo.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
        String filename = user.getId() + "_" + user.getFirstName() + "." +
                FilenameUtils.getExtension(file.getOriginalFilename());
        user.setProfileImage(filename);
        WearlyUser savedUser = wearlyUserRepo.save(user);
        String uploadDir = "src/main/resources/images/profile/" + savedUser.getId();
        FileUploadUtil.uploadImage(uploadDir, filename, file);
    }

    // TODO: 2/24/2022 improve
    public Wearlier getById(Long id) {
        if (wearlierRepo.findById(id).isPresent()) {
            return wearlierRepo.findById(id).get();
        }
        throw new IllegalStateException("Id does not exist");
    }

    // TODO: 2/15/2022 optimize if possible 
    // on login method
    public Wearlier loginUser(String email, String password) {
        Wearlier loggingInUser = wearlierRepo
                .findWearlierByEmail(email)
                .orElseThrow(() -> new IllegalStateException("Email does not exist"));
        if (wearlierRepo.findWearlierByEmail(email).isPresent()) {
            if (loggingInUser.getPassword().equals(password)) {
                if (wearlierRepo.findById(loggingInUser.getId()).isPresent()) {
                    return wearlierRepo.findById(loggingInUser.getId()).get();
                }
            }
        }
        throw new IllegalStateException("Incorrect password");
    }

    // TODO: 2/15/2022 add to admin service 
    // only an authorized personnel (admin) can access this method.
//    public List<WearlyUser> getWearlyUserList() {
//        log.info("Getting all wearly users");
//        return wearlyUserRepo.findAll();
//    }

    // TODO: 2/15/2022 add to admin service 
    // only an authorized personnel (admin) can access this method.
    public List<Wearlier> getList() {
        return wearlierRepo.findAll();
    }

    // TODO: 2/15/2022 need more validation and optimization 
    @Transactional
    public Wearlier update(Long id, Wearlier wearlier) {
        Wearlier currentUser = wearlierRepo
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("User id: " + id + " not found"));
        if (wearlier.getFirstName() != null
                && wearlier.getFirstName().length() > 0
                && !Objects.equals(wearlier.getFirstName(), currentUser.getFirstName())) {
            currentUser.setFirstName(wearlier.getFirstName());
        }
        if (wearlier.getLastName() != null
                && wearlier.getLastName().length() > 0
                && !Objects.equals(wearlier.getLastName(), currentUser.getLastName())) {
            currentUser.setLastName(wearlier.getLastName());
        }
        if (wearlier.getContactNo() != null
                && wearlier.getContactNo().length() > 0
                && !Objects.equals(wearlier.getContactNo(), currentUser.getContactNo())) {
            currentUser.setContactNo(wearlier.getContactNo());
        }
        return wearlierRepo.save(currentUser);
    }

    // TODO: 2/15/2022 remove if deleting user account feature is not applicable
    public void delete(Long id) {
        wearlierRepo.deleteById(id);
    }

}
