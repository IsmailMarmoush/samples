package io.memoria.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookNotFoundException extends RuntimeException {
  BookNotFoundException() {}

  BookNotFoundException(String message) {
    super(message);
  }
}