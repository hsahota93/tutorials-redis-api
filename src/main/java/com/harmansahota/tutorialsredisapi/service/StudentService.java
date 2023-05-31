package com.harmansahota.tutorialsredisapi.service;

import com.harmansahota.tutorialsredisapi.exception.RecordNotFoundException;
import com.harmansahota.tutorialsredisapi.model.Student;
import com.harmansahota.tutorialsredisapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
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

            log.error("Couldn't find any data for id: {}", id);
            throw new RecordNotFoundException("No data found for id: " + id);
        }
    }

    public Student insertStudent(Student newStudent) {

        newStudent.setCreatedDateTime(Instant.now());
        return studentRepository.save(newStudent);
    }

    public void deleteStudent(String id) {

        try {

            studentRepository.deleteById(id);
        } catch (Exception e) {

            log.warn("No record found to delete. Ignoring request");
        }
    }

    // TODO: figure out a better way to handle iterators/large returns (paging)
    public Collection<Student> findAllStudents() {

        List<Student> allStudents = IteratorUtils.toList(studentRepository.findAll().iterator());
        if (CollectionUtils.isEmpty(allStudents)) {

            throw new RecordNotFoundException("No Student data was found");
        }

        return allStudents;
    }
}
