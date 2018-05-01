package org.demo.crudrest.user.usecase;

import java.util.List;
import org.demo.crudrest.user.domain.User;

public interface FindUsersService {
  List<User> findAll();

  User find(final long userId);
}
