package com.dh.humanresources.repository;

import com.dh.humanresources.model.User;

import java.util.Optional;

public interface IUserRepository {

  User validateAndGetUser(String username);

  Optional<User> getUserExtra(String username);

  User saveUserExtra(User userExtra);
}
