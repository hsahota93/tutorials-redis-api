package com.harmansahota.tutorialsredisapi.service;

import com.harmansahota.tutorialsredisapi.exception.RecordNotFoundException;
import com.harmansahota.tutorialsredisapi.model.Student;
import com.harmansahota.tutorialsredisapi.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @Test
    @DisplayName("findStudentById - Happy Path")
    void testFindStudentById() {

        // Given an ID that relates to a record in the DB
        UUID id = UUID.randomUUID();
        Student student = new Student();
        Optional<Student> optionalStudent = Optional.of(student);

        // When we do the look-up and get a non-empty Optional back
        Mockito.when(studentRepository.findById(id)).thenReturn(optionalStudent);

        // Then we shouldn't throw any exceptions
        assertDoesNotThrow(() -> studentService.findStudentById(id),
                "We shouldn't throw anything if we found the record");
    }

    @Test
    void testFindStudentById_NotFound() {

        // Given an empty Optional
        UUID id = UUID.randomUUID();
        Optional<Student> optionalStudent = Optional.empty();

        // When
        Mockito.when(studentRepository.findById(id)).thenReturn(optionalStudent);

        // Then
        assertThrows(RecordNotFoundException.class,
                () -> studentService.findStudentById(id),
                "We should throw this exception so that it's caught by @ControllerAdvice");
    }

//    @Test
//    void testInsertStudent() {
//
//        // Given a Student with no ID or timestamp
//        Student student = new Student();
//        student.setName("test");
//        student.setGrade(100);
//
//        // When we save the object to the DB
//        Student savedStudent = studentService.insertStudent(student);
//
//        // Then the following fields should be set
//        assertNotNull(savedStudent.getId(), "An ID should've been created and set");
//        assertEquals(student.getName(), savedStudent.getName(), "The names should match");
//        assertEquals(student.getGrade(), savedStudent.getGrade(), "The grades should match");
//        assertNotNull(savedStudent.getCreatedDateTime(), "A timestamp should be set before saving");
//    }
}