package com.Ebooks.Ebooks_api.UseCases;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadUseCase {
    public String execute(String storagerDir, String filename, MultipartFile file) throws IOException{
        Path filepath = Paths.get("/storage/".concat(storagerDir), filename);
        Files.copy(file.getInputStream(), filepath);
        return filepath.toString();
    }

    public String execute(String filename, MultipartFile file) throws IOException{
        return this.execute("upload/", filename, file);
    }

    public String execute(MultipartFile file) throws IOException{
        return this.execute(UUID.randomUUID().toString(), file);
    }
}
