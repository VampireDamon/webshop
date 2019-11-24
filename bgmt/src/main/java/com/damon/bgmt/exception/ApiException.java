package com.damon.bgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public class ApiException extends RuntimeException {

  private final HttpStatus status;
  private final ErrorCode error;

  public ApiException(String message, HttpStatus status) {
    super(message);
    this.status = status;
    error = ErrorCode.with(message);
  }

  public ApiException(String message, String description, HttpStatus status) {
    super(message);
    this.status = status;
    error = ErrorCode.with(message, description);
  }

  public ApiException(ErrorCode error, HttpStatus status) {
    super(error.error);
    this.status = status;
    this.error = error;
  }

  public ApiException(String message, Throwable cause, HttpStatus status) {
    super(message, cause);
    this.status = status;
    error = ErrorCode.with(message);
  }

  public ResponseEntity<ErrorCode> response() {
    return new ResponseEntity<>(error, status);
  }

  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }

  public final HttpStatus getStatus() {
    return status;
  }

  public static class ErrorCode implements Serializable {

    private String error;
    private String description;

    public ErrorCode(String error, String description) {
      this.error = error;
      this.description = description;
    }

    public static ErrorCode with(String message) {
      return new ErrorCode(message, null);
    }

    public static ErrorCode with(String message, String description) {
      return new ErrorCode(message, description);
    }

    public String getError() {
      return error;
    }

    public void setError(String error) {
      this.error = error;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }
  }
}
