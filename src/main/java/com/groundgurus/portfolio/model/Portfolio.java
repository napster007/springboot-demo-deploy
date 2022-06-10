package com.groundgurus.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Portfolio {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String jobTitle;
  private int age;
  private String email;
  private String skype;
  private String phone;
  private String address;

  public String getFullName() {
    return firstName + " " + lastName;
  }
}
