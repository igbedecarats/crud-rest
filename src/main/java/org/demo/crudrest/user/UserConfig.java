package org.demo.crudrest.user;

import org.demo.crudrest.user.domain.UserRepository;
import org.demo.crudrest.user.usecase.CreateUserService;
import org.demo.crudrest.user.usecase.CreateUserServiceImpl;
import org.demo.crudrest.user.usecase.FindUsersService;
import org.demo.crudrest.user.usecase.FindUsersServiceImpl;
import org.demo.crudrest.user.usecase.UpdateUserService;
import org.demo.crudrest.user.usecase.UpdateUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

  @Autowired private UserRepository userRepository;

  @Bean
  public CreateUserService createUserService() {
    return new CreateUserServiceImpl(userRepository);
  }

  @Bean
  public FindUsersService findUsersService() {
    return new FindUsersServiceImpl(userRepository);
  }

  @Bean
  public UpdateUserService updateUserService() {
    return new UpdateUserServiceImpl(userRepository, findUsersService());
  }
}
