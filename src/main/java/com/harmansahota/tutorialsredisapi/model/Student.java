package com.harmansahota.tutorialsredisapi.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;
import java.util.UUID;

@Data
@RedisHash(value = "Student")
public class Student {

    @Generated
    private UUID id;

    @NotNull(message = "Student's 'name' can't be NULL")
    private String name;

    @NotNull(message = "Student's `grade` can't be NULL")
    private Integer grade;

    @Null(message = "Passing in a timestamp is forbidden")
    private Instant createdDateTime;
}
