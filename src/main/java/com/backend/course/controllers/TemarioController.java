package com.backend.course.controllers;

import com.backend.course.models.Temario;
import com.backend.course.services.TemarioStorage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/temarios")
public class TemarioController {
    public final TemarioStorage temarioStorage;

    public TemarioController(TemarioStorage temarioStorage) {
        this.temarioStorage = temarioStorage;
    }

    @GetMapping
    public List<Temario> getTemarios() throws IOException {
        return temarioStorage.loadAll().map(path -> {
            String fileName = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(TemarioController.class,
                    "getTemario", path.getFileName().toString()).build().toString();

            return new Temario(fileName, url);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{fileName:.+}")
    public Resource getTemario(@PathVariable String fileName) throws MalformedURLException {
        return temarioStorage.load(fileName);
    }

    @PostMapping
    public void postTemario(@RequestParam("temario") MultipartFile temario) throws IOException {
        temarioStorage.save(temario);
    }
}
