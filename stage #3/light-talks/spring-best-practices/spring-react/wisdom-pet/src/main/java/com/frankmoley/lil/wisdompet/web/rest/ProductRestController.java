package com.frankmoley.lil.wisdompet.web.rest;

import com.frankmoley.lil.wisdompet.services.ProductService;
import com.frankmoley.lil.wisdompet.web.errors.BadRequestException;
import com.frankmoley.lil.wisdompet.web.models.Product;
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
@RequestMapping("/api/products")
public class ProductRestController {
  
  private final ProductService productService;

  public ProductRestController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> getProducts(){
    return this.productService.getAllProducts();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product addProduct(@RequestBody Product model){
    return this.productService.createOrUpdateProduct(model);
  }

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable("id")long id){
    return this.productService.getProduct(id);
  }

  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product model){
    if (id != model.getProductId()){
      throw new BadRequestException("incoming id doesn't match path");
    }
    return this.productService.createOrUpdateProduct(model);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.RESET_CONTENT)
  public void deleteProduct(@PathVariable("id")long id){
    this.productService.deleteProduct(id);
  }
}
