package org.demo.crudrest.user.usecase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.persistence.EntityNotFoundException;
import org.demo.crudrest.user.domain.User;
import org.demo.crudrest.user.domain.UserRepository;

public class FindUsersServiceImpl implements FindUsersService {

  private UserRepository userRepository;

  public FindUsersServiceImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> findAll() {
    return StreamSupport.stream(userRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public User find(final long userId) {
    return userRepository
        .findById(userId)
        .orElseThrow(() -> new EntityNotFoundException("User with " + userId + " not found."));
  }
}
