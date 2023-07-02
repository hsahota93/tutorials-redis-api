package com.harmansahota.tutorialsredisapi.controller;

import com.harmansahota.tutorialsredisapi.model.Student;
import com.harmansahota.tutorialsredisapi.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@Validated
@RestController
@AllArgsConstructor
public class RedisController {

    private final StudentService studentService;

    @GetMapping("/api/v1/student/{id}")
    public Student findStudentById(@PathVariable UUID id) {

        return studentService.findStudentById(id);
    }

    @GetMapping("/api/v1/student")
    public Collection<Student> findAllStudents() {

        return studentService.findAllStudents();
    }

    @PostMapping("/api/v1/student")
    public Student insertStudent(@RequestBody @Valid Student newStudent) {

        return studentService.insertStudent(newStudent);
    }

    @DeleteMapping("/api/v1/student/{id}")
    public void deleteStudent(@PathVariable UUID id) {

        studentService.deleteStudent(id);
    }
}
