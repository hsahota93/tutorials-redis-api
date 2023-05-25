package com.harmansahota.tutorialsredisapi.controller;

import com.harmansahota.tutorialsredisapi.model.Student;
import com.harmansahota.tutorialsredisapi.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class RedisController {

    private final StudentService studentService;

    @GetMapping("/api/v1/id/{id}")
    public Student findById(@PathVariable String id) {

        return studentService.findById(id);
    }

    @PostMapping("/api/v1/id/{id}")
    public Student insert(
            @PathVariable String id,
            @RequestBody @Valid Student newStudent) {

        return studentService.insert(id, newStudent);
    }

    // TODO: add controller advice
}
