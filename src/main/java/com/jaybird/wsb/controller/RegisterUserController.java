package com.jaybird.wsb.controller;

import com.jaybird.wsb.model.CreateRequestLogin;
import com.jaybird.wsb.model.User;
import com.jaybird.wsb.model.payload.CreateUserResponse;
import com.jaybird.wsb.service.CreateRequestService;

import java.net.CacheRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterUserController {
  final CreateRequestService createRequestService;

  public RegisterUserController(CreateRequestService createRequestService) {
    this.createRequestService = createRequestService;
  }

  @PutMapping("/createUser")
  public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateRequestLogin createRequestLogin){
    return ResponseEntity.ok(new CreateUserResponse(String.format("User %s is created",createRequestService.createUser(createRequestLogin).getLogin())));
  }
}
