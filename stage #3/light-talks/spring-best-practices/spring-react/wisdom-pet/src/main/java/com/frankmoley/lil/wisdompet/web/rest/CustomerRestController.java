package com.frankmoley.lil.wisdompet.web.rest;

import com.frankmoley.lil.wisdompet.services.CustomerService;
import com.frankmoley.lil.wisdompet.web.errors.BadRequestException;
import com.frankmoley.lil.wisdompet.web.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

  private final CustomerService customerService;

  public CustomerRestController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public List<Customer> getAll(@RequestParam(name="email", required = false)String email){
    return this.customerService.getAllCustomers(email);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Customer createCustomer(@RequestBody Customer customer){
    return this.customerService.createOrUpdate(customer);
  }

  @GetMapping("/{id}")
  public Customer getCustomer(@PathVariable("id")long id){
    return this.customerService.getCustomer(id);
  }

  @PutMapping("/{id}")
  public Customer updateCustomer(@PathVariable("id")long id, @RequestBody Customer customer){
    if(id != customer.getCustomerId()){
      throw new BadRequestException("ids do not match");
    }
    return this.customerService.createOrUpdate(customer);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.RESET_CONTENT)
  public void deleteCustomer(@PathVariable("id")long id){
    this.customerService.deleteCustomer(id);
  }
}
