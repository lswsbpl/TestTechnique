package com.jaybird.wsb.model.payload;

import java.time.Instant;

public class CreateUserResponse {
  public CreateUserResponse() {
  }

  public CreateUserResponse(String message) {
    this.message = message;
  }

  String message;
  Instant timestamp= Instant.now();

  public Instant getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "CreateUserResponse{" +
        "message='" + message + '\'' +
        ", timestamp=" + timestamp +
        '}';
  }
}
