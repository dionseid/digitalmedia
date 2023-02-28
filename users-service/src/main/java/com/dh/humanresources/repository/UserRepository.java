package com.dh.humanresources.repository;

import com.dh.humanresources.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@AllArgsConstructor
public class UserRepository {
  private IUserRepository userRepository;

  public User validateAndGetUser(String username) {
    return  userRepository.validateAndGetUser(username);
  }

  public Optional<User> getUserExtra(String username) {
    return userRepository.getUserExtra(username);
  }

  public User saveUserExtra(User user) {
    return userRepository.saveUserExtra(user);
  }
}
