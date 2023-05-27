package com.harmansahota.tutorialsredisapi.service;

import com.harmansahota.tutorialsredisapi.model.Student;
import com.harmansahota.tutorialsredisapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student findStudentById(String id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {

            log.info("Found the following student: {}", optionalStudent.get());
            return optionalStudent.get();
        } else {

            throw new RuntimeException("No data found for id: " + id);
        }
    }

    // TODO: throw error if the ID already exists
    public Student insertStudent(Student newStudent) {

        newStudent.setCreatedDateTime(Instant.now());
        return studentRepository.save(newStudent);
    }

    public void deleteStudent(String id) {

        studentRepository.deleteById(id);
    }

    public Collection<Student> findAllStudents() {

        return IteratorUtils.toList(studentRepository.findAll().iterator());
    }
}
