package com.wakil.spring_multi_vendor.controller.file;


import com.wakil.spring_multi_vendor.model.CustomFile;
import com.wakil.spring_multi_vendor.response.ApiResponse;
import com.wakil.spring_multi_vendor.services.file.CustomFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping("${api.prefix}/files")
@RequiredArgsConstructor
public class FileController {

    final CustomFileService customFileService;


    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> uploadFile(@RequestParam List<MultipartFile> files){
        List<Optional<CustomFile>> savedFiles = files.stream().map(customFileService::saveFile).toList();
        return ResponseEntity.ok().body(new ApiResponse("Saved Files", savedFiles));
    }

    @GetMapping("/all-files")
    public ResponseEntity<ApiResponse> allFiles(){
        List<CustomFile> allFiles = customFileService.getAllFiles();
        return ResponseEntity.ok().body(new ApiResponse("Saved Files", allFiles));
    }


    @GetMapping("/get-file/{id}")
    public ResponseEntity<ApiResponse> getFile(@PathVariable UUID id){
        CustomFile file = customFileService.getFileById(id);
        return ResponseEntity.ok().body(new ApiResponse("File", file));
    }

    @GetMapping("/get-file/{id}/download")
    public ResponseEntity<Resource> getDownloadableFile(@PathVariable UUID id) throws SQLException, IOException {
        CustomFile file = customFileService.getFileById(id);
        System.out.println(file.getOriginalName());

        Path path = Path.of(file.getFilePath());
        byte[] fileContent = Files.readAllBytes(path);

        System.out.println(fileContent.length);

        ByteArrayResource resource = new ByteArrayResource(fileContent);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getContentType())).body(resource);
    }



}
