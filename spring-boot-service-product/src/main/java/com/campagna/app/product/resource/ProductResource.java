package com.campagna.app.product.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campagna.app.product.endpoint.ProductEndpoint;
import com.campagna.app.product.models.entity.Product;
import com.campagna.app.product.models.service.ProductService;

@RestController
@RequestMapping(value = ProductEndpoint.PRODUCT)
public class ProductResource implements ProductEndpoint {

//	@Autowired
//	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	private ProductService productService;
	
	@Autowired
	public ProductResource(ProductService productService) {
		this.productService = productService;
	}

	@Override
	@GetMapping(value = LIST)
	public List<Product> list() {
		return productService.findAll().stream().map(p ->{
//			p.setPort(Integer.parseInt(env.getProperty("server.port")));
			p.setPort(port);
			return p;	
		}).collect(Collectors.toList());
	}

	@Override
	@GetMapping(value = ID)
	public Product findById(@PathVariable("id") Long id) {
		Product product = productService.findById(id);
//		product.setPort(Integer.parseInt(env.getProperty("server.port")));
		product.setPort(port);
		return product;
	}

	
	
}
