package com.example.bullhornchallenge;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Messages, Long> {
}
