package com.harmansahota.tutorialsredisapi.controller;

import com.harmansahota.tutorialsredisapi.exception.RecordNotFoundException;
import com.harmansahota.tutorialsredisapi.model.Student;
import com.harmansahota.tutorialsredisapi.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Collection;

@Validated
@RestController
@AllArgsConstructor
public class RedisController {

    private final StudentService studentService;

    @GetMapping("/api/v1/student/{id}")
    public Student findStudentById(@PathVariable String id) {

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
    public void deleteStudent(@PathVariable String id) {

        studentService.deleteStudent(id);
    }

    // TODO: add controller advice
//    @ExceptionHandler({RecordNotFoundException.class})
//    public ResponseEntity<Object> handleAccessDeniedException(Exception ex) {
//        return new ResponseEntity<>(ex.getMessage());
//    }
}
