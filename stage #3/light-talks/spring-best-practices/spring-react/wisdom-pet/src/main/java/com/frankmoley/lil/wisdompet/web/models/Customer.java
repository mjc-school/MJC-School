package com.frankmoley.lil.wisdompet.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

  public Long customerId;
  public String firstName;
  public String lastName;
  public String emailAddress;
  public String phoneNumber;
  public String address;

}
