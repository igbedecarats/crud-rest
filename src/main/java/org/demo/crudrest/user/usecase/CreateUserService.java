package org.demo.crudrest.user.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.crudrest.user.domain.User;

public interface CreateUserService {

  User create(final Request request);

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  class Request {

    private String identification;

    private String firstName;

    private String lastName;

    private String email;
  }

}
