package service;


import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String saveProfilePhoto(MultipartFile file);

}
