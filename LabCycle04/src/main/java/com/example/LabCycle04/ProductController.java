package com.example.LabCycle04;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	List<Product> plist = new ArrayList<Product>();

	@GetMapping
	public List<Product> getProduct() {
		return plist;
	}

	@PostMapping
	public List<Product> postProduct(@RequestBody Product product) {
		plist.add(product);
		return plist;
	}

	@DeleteMapping("/{id}")
	public List<Product> deleProduct(@PathVariable int id) {
		for (Product p : plist) {
			if (id == p.getId()) {
				plist.remove(p);
			}
		}
		return plist;
	}

	@PutMapping
	public List<Product> putProduct(@RequestBody Product product) {
		for (Product p : plist) {
			if (product.getId() == p.getId()) {
				p.setName(product.getName());
				p.setPrice(product.getPrice());
				break;
			}
		}
		return plist;
	}

}
