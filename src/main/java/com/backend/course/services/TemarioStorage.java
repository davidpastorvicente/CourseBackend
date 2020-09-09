package com.backend.course.services;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class TemarioStorage {
    private final Path root = Paths.get("archivos");

    public void init() throws IOException {
        Files.createDirectory(root);
    }

    public void save(MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(), this.root.resolve(Objects.requireNonNull(file.getOriginalFilename())));
    }

    public Resource load(String fileName) throws MalformedURLException {
        Path file = root.resolve(fileName);
        return new UrlResource(file.toUri());
    }

    public Stream<Path> loadAll() throws IOException {
        return Files.walk(root, 1).filter(path -> !path.equals(root)).map(root::relativize);
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }
}
