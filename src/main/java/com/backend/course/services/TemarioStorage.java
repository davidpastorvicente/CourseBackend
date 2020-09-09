package com.backend.course.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TemarioStorage {
    private final Path root = Paths.get("files");

    public void save(MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
    }

    public Resource load(String fileName) throws MalformedURLException {
        return new UrlResource(root.resolve(fileName).toUri());
    }
}
