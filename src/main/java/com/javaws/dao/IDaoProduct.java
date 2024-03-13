package com.javaws.dao;

import java.util.List;

import com.javaws.entities.Product;

public interface IDaoProduct {
//	crud : create, read, update, delete
	public boolean create(Product product) throws Exception;

	public Product read(int id) throws Exception;

	public boolean update(Product product) throws Exception;

	public boolean delete(int id) throws Exception;
//	getAllEtudiant
	public List<Product> getAllProducts() throws Exception;

	
}
