package com.harmansahota.tutorialsredisapi.service;

import com.harmansahota.tutorialsredisapi.model.Student;
import com.harmansahota.tutorialsredisapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student findById(String id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {

            return optionalStudent.get();
        } else {

            throw new RuntimeException("No data found for id: " + id);
        }
    }

    // TODO: throw error if the ID already exists
    public Student insert(String id, Student newStudent) {

        newStudent.setId(id);
        newStudent.setCreatedDateTime(Instant.now());
        return studentRepository.save(newStudent);
    }

    // TODO: implement more methods
}
