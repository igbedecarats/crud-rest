package org.demo.crudrest.user.usecase;

import org.demo.crudrest.user.domain.User;
import org.demo.crudrest.user.domain.UserRepository;

public class CreateUserServiceImpl implements CreateUserService {

  private UserRepository userRepository;

  public CreateUserServiceImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User create(final Request request) {
    return userRepository.save(
        new User(
            request.getIdentification(),
            request.getFirstName(),
            request.getLastName(),
            request.getEmail()));
  }
}
