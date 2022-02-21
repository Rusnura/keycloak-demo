package ru.tumasoff.keycloakdemo.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
  @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getEmployee(@AuthenticationPrincipal Jwt principal, @PathVariable String id) {
    System.out.println(principal.toString());
    System.out.println(principal.getClaimAsString("preferred_username"));
    return ResponseEntity.ok("Ruslan Tumasov");
  }
}