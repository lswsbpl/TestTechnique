package com.jaybird.wsb.tdd.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class RequestHelper<T> {

  public ResponseEntity<Object> doPut(T t, String url,Class aClass) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(new ResponseErrorHandler() {
      @Override
      public boolean hasError(ClientHttpResponse response) throws IOException {
        return false;
      }

      @Override
      public void handleError(ClientHttpResponse response) throws IOException {
        return;
      }
    });
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/json");
    Map<String, String> param = new HashMap<>();

    HttpEntity<T> requestEntity = new HttpEntity<>(t, headers);

    ResponseEntity<Object> response = restTemplate.exchange("http://localhost:8080" + url, HttpMethod.PUT, requestEntity, aClass);

    return response;
  }
}

