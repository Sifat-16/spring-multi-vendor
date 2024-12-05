package com.wakil.spring_multi_vendor.services.file;

import com.wakil.spring_multi_vendor.exception.files.FileAlreadyExistsException;
import com.wakil.spring_multi_vendor.exception.files.FileNotFoundException;
import com.wakil.spring_multi_vendor.exception.files.FileSaveFailedException;
import com.wakil.spring_multi_vendor.model.CustomFile;
import com.wakil.spring_multi_vendor.respository.files.CustomFileRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomFileService implements CustomFileServiceI{

    final CustomFileRepository customFileRepository;

    @Value(value = "${folder.prefix}")
    String DIR;

    @PostConstruct
    void init(){
        Path storagePath = Path.of(DIR);
        if(!Files.exists(storagePath)){
            try {
                Files.createDirectory(storagePath);
            }catch (Exception e){
                System.out.println("Folder can not be created "+e.getMessage());
            }
        }
    }



    @Override
    public List<CustomFile> getAllFiles() {
        return customFileRepository.findAll();
    }

    @Override
    public Optional<CustomFile> saveFile(MultipartFile file){

        try {

            String savedFilePathString = DIR+File.separator+file.getOriginalFilename();

            Path savedPath = Path.of(savedFilePathString);


            long currentFile = Files.copy(file.getInputStream(), savedPath, StandardCopyOption.REPLACE_EXISTING);

            CustomFile customFile = CustomFile.builder()
                    .name(file.getName())
                    .originalName(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .size(file.getSize())
                    .filePath(savedPath.toString())
//                    .myFile(new SerialBlob(file.getBytes()))
                    .build();



            return Optional.of(customFileRepository.save(customFile));
        }catch (Exception e){
            throw new FileSaveFailedException("File can not be saved"+e.getMessage());
        }


    }

    @Override
    public CustomFile getFileById(UUID id) {
        return customFileRepository.findById(id).orElseThrow(()-> new FileNotFoundException("File not found for "+id));
    }
}
