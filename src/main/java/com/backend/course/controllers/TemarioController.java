package com.backend.course.controllers;

import com.backend.course.services.TemarioStorage;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/temarios")
public class TemarioController {
    public final TemarioStorage temarioStorage;
    public final CursoController cursoController;

    public TemarioController(TemarioStorage temarioStorage, CursoController cursoController) {
        this.temarioStorage = temarioStorage;
        this.cursoController = cursoController;
    }

    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> getTemario(@PathVariable String fileName) throws MalformedURLException {
        Resource file = temarioStorage.load(fileName.replace("%20", " "));
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileName + "\"").body(file);
    }

    @PostMapping
    public void postTemario(@RequestParam("id") Long id, @RequestParam("temario") MultipartFile temario) throws IOException {
        temarioStorage.save(temario);
        cursoController.addTemario(id, temario.getOriginalFilename());
    }
}
