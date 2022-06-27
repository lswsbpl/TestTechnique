package com.jaybird.wsb.tdd.livecoding.wsb2606;

import java.time.Instant;

public class ResponseCreateUser {
  Instant timestamp=Instant.now();
  String message="User Created";

  public String getMessage() {
    return message;
  }

  public Instant getTimestamp() {
    return timestamp;
  }
}
