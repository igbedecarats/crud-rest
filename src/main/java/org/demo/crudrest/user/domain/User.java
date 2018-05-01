package org.demo.crudrest.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@ToString(of = {"id", "identification"})
@EqualsAndHashCode(of = {"id", "identification"})
@Getter
@NoArgsConstructor
public class User {

  @Id private long id;

  @Column(name = "identification", nullable = false)
  private String identification;

  @Column(name = "first_name", nullable = false)
  @Setter
  private String firstName;

  @Column(name = "last_name", nullable = false)
  @Setter
  private String lastName;

  @Column(name = "email", nullable = false)
  @Setter
  private String email;

  public User(
      final String identification,
      final String firstName,
      final String lastName,
      final String email) {
    this.identification = identification;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
