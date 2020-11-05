package com.example.productsAndCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productsAndCategories.models.Category;
import com.example.productsAndCategories.models.Product;
import com.example.productsAndCategories.repositories.CategoryRepository;
import com.example.productsAndCategories.repositories.ProductRepository;

@Service
public class MainService 
{
	@Autowired
	private ProductRepository pRepo;
	@Autowired
	private CategoryRepository cRepo;
	
	public Product findProduct(Long id)
	{
		return this.pRepo.findById(id).orElse(null);
	}
	
	public List<Product> findAllProducts()
	{
		return this.pRepo.findAll();
	}
	
	public Product createProduct(Product p)
	{
		return this.pRepo.save(p);
	}
	
	public Product saveProduct(Product p)
	{
		return this.pRepo.save(p);
	}
	
	
	//Category
	public Category createCategory(Category c)
	{
		return this.cRepo.save(c);
	}
	
	public Category findCategory(Long id)
	{
		return this.cRepo.findById(id).orElse(null);
	}
	
	public List<Category> findAllCategories()
	{
		return this.cRepo.findAll();
	}
	

	
}
