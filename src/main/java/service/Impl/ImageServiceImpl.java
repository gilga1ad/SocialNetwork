package service.Impl;


import exceptions.ImageUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.ImageService;

import java.io.File;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private static final String PATH = "/home/kollaps/JavaTutorials/D_Galimov_HW/SocialNetwork/src/main/webapp/resources/img/";

    @Override
    public String saveProfilePhoto(MultipartFile file) {
        try {
            file.transferTo(new File(PATH + file.getOriginalFilename()));
        } catch (IOException e) {
            throw new ImageUploadException("Unable to save image", e);
        }
        return file.getOriginalFilename();
    }

}
