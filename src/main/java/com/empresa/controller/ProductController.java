package com.empresa.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Product;
import com.empresa.service.AppService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping(path = "/empresa")
public class ProductController {
	@Autowired
	private AppService s; 
	
	@PostMapping(path = "/product")
	public ResponseEntity<?> postProduct(@RequestBody Product product) {
		ResponseEntity<?> res = null;
		
		s.getProducts().add(product);
		res = ResponseEntity.status(HttpStatus.OK).body(product);
		
		return res;
	}
	
	@GetMapping(path = "/product")
	public ResponseEntity<?> getAllProduct() {
		return ResponseEntity.status(HttpStatus.OK).body(s.getProducts().stream().sorted().collect(Collectors.toList()));
	}
	
	@GetMapping(path = "/product/{id}")
	public ResponseEntity<?> getProduct(@PathVariable int id) {
		ResponseEntity<?> res = null;
		Product p1 = s.getProducts().stream().filter(p -> p.getPrdId() == id).findFirst().orElse(null);
		
		if (s.getProducts() == null || s.getProducts().isEmpty()) {
			res = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay productos en la base");
		} else if (p1 == null && !s.getProducts().contains(p1)) {
			res = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el producto");
		} else if (s.getProducts().contains(p1)) {
			res = ResponseEntity.status(HttpStatus.OK).body(p1);
		}
		return res;
	}
	
	@PutMapping(path = "/product")
	public ResponseEntity<?> putProduct(@RequestBody Product product) {
		ResponseEntity<?> res = null;
		Product p1 = s.getProducts().stream().filter(p -> p.getPrdId() == product.getPrdId()).findFirst().orElse(null);
		
		if (p1 != null) {
			p1.setPrdName(product.getPrdName());
			p1.setPrdPrice(product.getPrdPrice());
			res = ResponseEntity.status(HttpStatus.OK).body(p1);
		} else {
			res = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el producto");
		}
		
		return res;
	}
	
	@DeleteMapping(path = "/product/{id}")
	public ResponseEntity<?> delProduct(@PathVariable int id) {
		ResponseEntity<?> res = null;
		Product p1 = s.getProducts().stream().filter(p -> p.getPrdId() == id).findFirst().orElse(null);
		
		if (p1 == null) {
			res = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el producto");
		} else {
			s.getProducts().remove(p1);
			res = ResponseEntity.status(HttpStatus.OK).body(p1);
		}
		
		return res;
	}
}
