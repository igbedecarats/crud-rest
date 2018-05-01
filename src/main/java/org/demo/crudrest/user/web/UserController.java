package org.demo.crudrest.user.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.demo.crudrest.user.domain.User;
import org.demo.crudrest.user.usecase.CreateUserService;
import org.demo.crudrest.user.usecase.FindUsersService;
import org.demo.crudrest.user.usecase.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(
  value = "users",
  tags = {"users"}
)
@RequestMapping("/api/users")
public class UserController {

  @Autowired private CreateUserService createUserService;

  @Autowired private FindUsersService findUsersService;

  @Autowired private UpdateUserService updateUserService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(value = "Creates a new User", produces = "application/json")
  @ResponseStatus(value = HttpStatus.CREATED)
  public User saveUserSuggestions(@RequestBody final CreateUserRequest request) {
    return createUserService.create(
        new CreateUserService.Request(
            request.getIdentification(),
            request.getFirstName(),
            request.getLastName(),
            request.getEmail()));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(value = "Lists all Users", produces = "application/json")
  @ResponseStatus(value = HttpStatus.CREATED)
  public List<User> findUsers() {
    return findUsersService.findAll();
  }

  @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(value = "Lists all Users", produces = "application/json")
  @ResponseStatus(value = HttpStatus.CREATED)
  public User findUserById(
      @ApiParam(value = "The user id", required = true) @PathVariable final long userId) {
    return findUsersService.find(userId);
  }

  @PutMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(value = "Lists all Users", produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public User findUserById(
      @ApiParam(value = "The user id", required = true) @PathVariable final long userId,
      @RequestBody final UpdateUserRequest request) {
    return updateUserService.update(
        new UpdateUserService.Request(
            userId, request.getFirstName(), request.getLastName(), request.getEmail()));
  }
}
