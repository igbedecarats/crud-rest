package org.demo.crudrest.user.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateUserRequest {

  private String identification;

  private String firstName;

  private String lastName;

  private String email;
}
