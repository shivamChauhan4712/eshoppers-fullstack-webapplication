package com.Eshoppers.springEcomm.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.Eshoppers.springEcomm.model.Product;
import com.Eshoppers.springEcomm.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Product product = productService.getProductById(id);
		if(product!=null)
			return new ResponseEntity<>(product, HttpStatus.OK);
		else return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("products/{productId}/image")
	public ResponseEntity<byte[]>getImageByProductId(@PathVariable int productId){
		Product product = productService.getProductById(productId);
		if(product!=null)
			return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
		else return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/products")
	public ResponseEntity<?>addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
		Product savedProduct=null;
		try {
			savedProduct = productService.addOrUpdateProduct(product,imageFile);
			return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String>updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) {
		Product updatedProduct=null;
		
		try {
			updatedProduct = productService.addOrUpdateProduct(product,imageFile) ;
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}catch(IOException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String>deleteProduct(@PathVariable int id){
		Product product = productService.getProductById(id);
		if(product!=null) {
			productService.deleteProduct(id);
			return new ResponseEntity<>("DELETED", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
		List<Product> products = productService.searchProducts(keyword);
		System.out.println("Searching with: "+keyword);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
}
