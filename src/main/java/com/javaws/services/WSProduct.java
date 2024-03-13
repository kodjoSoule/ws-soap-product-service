package com.javaws.services;
import java.util.ArrayList;

import java.util.List;

import com.javaws.dao.IDaoProduct;
import com.javaws.dao.impl.ProductDao ;
import com.javaws.entities.Product;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
@WebService
public class WSProduct {
	IDaoProduct productDao = new ProductDao();
	List<Product> myTests = new ArrayList<>();
	
	//getAllEtudiant
	@WebMethod
	public List<Product> getProducts () {
			System.out.println("getProducts");
			try {
				System.out.println("getProducts"+productDao.getAllProducts());
				return productDao.getAllProducts();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	//createProduct
	@WebMethod
	public boolean createProduct(@WebParam(name = "reference") String reference, @WebParam(name = "nom") String nom,
			@WebParam(name = "prix") double prix) {
		Product product = new Product(reference, nom, prix);
		try {
			return productDao.create(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	//deleteProduct
	@WebMethod
	public boolean deleteProduct(@WebParam(name = "id") int id) {
		try {
			return productDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	//updateProduct
	@WebMethod
	public boolean updateProduct(
			@WebParam(name = "id") int id,
			@WebParam(name = "reference") String reference,
			@WebParam(name = "nom") String nom,
			@WebParam(name = "prix") double prix) {
		
		
		Product product = new Product(id, reference, nom, prix);
		try {
			return productDao.update(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	//	chercher etudiant
	@WebMethod
	public Product getProduct(@WebParam(name = "id") int id) {
		try {
			return productDao.read(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
}
