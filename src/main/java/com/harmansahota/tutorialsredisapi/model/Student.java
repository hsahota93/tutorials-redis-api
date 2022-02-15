package com.harmansahota.tutorialsredisapi.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@RedisHash(value = "Student")
public class Student {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private int grade;

    private Instant createdDateTime;
}
