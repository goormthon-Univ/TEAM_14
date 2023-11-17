package com.mungge.orumi.domain.Image.application;

import com.mungge.orumi.domain.Image.dao.ImageRepository;
import com.mungge.orumi.domain.Image.domain.Image;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("${image.path}")
    private String fileUrl;
    private final ImageRepository imageRepository;

    public Long save(MultipartFile file) throws IOException {
        String sourceFileName = file.getOriginalFilename();
        String sourceFileExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
        String destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileExtension;
        file.transferTo(new File(fileUrl + destinationFileName));

        Image image = new Image(destinationFileName, sourceFileName, fileUrl);
        image.setFileName(destinationFileName);
        image.setFileOriName(sourceFileName);
        image.setFileUrl(fileUrl);
        Long imageId = imageRepository.save(image).getId();
        return imageId;
    }

    public Image getImage(Long Id) {
        Image image = imageRepository.findById(Id)
                .orElseThrow(null);
        return image;
    }
}
