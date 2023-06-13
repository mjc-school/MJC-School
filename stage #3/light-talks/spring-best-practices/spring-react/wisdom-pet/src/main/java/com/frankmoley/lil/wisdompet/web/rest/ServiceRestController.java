package com.frankmoley.lil.wisdompet.web.rest;

import com.frankmoley.lil.wisdompet.services.ServiceService;
import com.frankmoley.lil.wisdompet.web.errors.BadRequestException;
import com.frankmoley.lil.wisdompet.web.models.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceRestController {

 private final ServiceService serviceService;

  public ServiceRestController(ServiceService serviceService) {
    this.serviceService = serviceService;
  }

  @GetMapping
  public List<Service> getServices(){
    return this.serviceService.getAllServices();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Service addService(@RequestBody Service model){
    return this.serviceService.createOrUpdateService(model);
  }

  @GetMapping("/{id}")
  public Service getService(@PathVariable("id")long id){
    return this.serviceService.getService(id);
  }

  @PutMapping("/{id}")
  public Service updateService(@PathVariable("id") Long id, @RequestBody Service model){
    if (id != model.getServiceId()){
      throw new BadRequestException("incoming id doesn't match path");
    }
    return this.serviceService.createOrUpdateService(model);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.RESET_CONTENT)
  public void deleteService(@PathVariable("id")long id){
    this.serviceService.deleteService(id);
  }
}
