package org.demo.crudrest.user.usecase;

import org.demo.crudrest.user.domain.User;
import org.demo.crudrest.user.domain.UserRepository;

public class UpdateUserServiceImpl implements UpdateUserService {

  private UserRepository userRepository;

  private FindUsersService findUsersService;

  public UpdateUserServiceImpl(
      final UserRepository userRepository, final FindUsersService findUsersService) {
    this.userRepository = userRepository;
    this.findUsersService = findUsersService;
  }

  @Override
  public User update(final Request request) {
    User user = findUsersService.find(request.getId());
    if (request.getFirstName() != null) {
      user.setFirstName(request.getFirstName());
    }
    if (request.getLastName() != null) {
      user.setLastName(request.getLastName());
    }
    if (request.getEmail() != null) {
      user.setEmail(request.getEmail());
    }
    return userRepository.save(user);
  }
}
