package com.frankmoley.lil.wisdompet.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Vendor {
  private Long vendorId;
  private String name;
  private String contact;
  private String emailAddress;
  private String phoneNumber;
  private String address;
}
