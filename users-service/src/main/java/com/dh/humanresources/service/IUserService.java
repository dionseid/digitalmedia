package com.dh.humanresources.service;

import com.dh.humanresources.model.User;

import java.util.Optional;

public interface IUserService {
  User validateAndGetUserExtra(String username);

  Optional<User> getUserExtra(String username);

  User saveUserExtra(User userExtra);
}
