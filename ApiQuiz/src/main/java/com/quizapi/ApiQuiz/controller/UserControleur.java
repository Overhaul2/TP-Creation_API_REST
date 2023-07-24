package com.quizapi.ApiQuiz.controller;

import com.quizapi.ApiQuiz.ApiResponse;
import com.quizapi.ApiQuiz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserControleur {
  private final UserService userService;

  @PostMapping("/login")
  public ApiResponse login(@RequestParam String email, String password){
      return userService.login(email, password);
  }

}
