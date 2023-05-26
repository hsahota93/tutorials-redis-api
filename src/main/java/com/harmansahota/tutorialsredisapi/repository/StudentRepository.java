package com.harmansahota.tutorialsredisapi.repository;

import com.harmansahota.tutorialsredisapi.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    // Empty for now as we're just using the methods from CrudRepository
}
