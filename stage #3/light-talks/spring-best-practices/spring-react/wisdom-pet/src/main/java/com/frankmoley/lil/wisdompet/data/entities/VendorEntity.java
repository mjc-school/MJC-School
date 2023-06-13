package com.frankmoley.lil.wisdompet.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="VENDORS")
@Data
@ToString
public class VendorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="VENDOR_ID")
  private long id;

  @Column(name="NAME")
  private String name;

  @Column(name="contact")
  private String contact;

  @Column(name="EMAIL")
  private String email;

  @Column(name="PHONE")
  private String phone;

  @Column(name="ADDRESS")
  private String address;
}
