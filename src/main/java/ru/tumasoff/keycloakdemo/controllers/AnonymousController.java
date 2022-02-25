package ru.tumasoff.keycloakdemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anonymous")
public class AnonymousController {
  @GetMapping("/")
  public ResponseEntity<?> getPage() {
    return ResponseEntity.ok("Hello, anonymous!");
  }
}
