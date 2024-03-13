package com.javaws.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaws.dao.IDaoProduct;
import com.javaws.entities.Product;

import com.javaws.database.DBManager;
public class ProductDao implements IDaoProduct {
	public ProductDao() {
	}

	@Override
	public boolean create(Product product) throws Exception {
		//reference, nom, prix
	    String query = "INSERT INTO T_Product (reference, nom, prix) VALUES (?, ?, ?)";

	    try (Connection connection = DBManager.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {

	        ps.setString(1, product.getReference());
	        ps.setString(2, product.getNom());
	        ps.setDouble(3, product.getPrix());
	        
	        int rowCount = ps.executeUpdate();

	        return rowCount > 0;

	    } catch (SQLException e) {
	        // Log or handle the SQL exception
	        throw new Exception("Erreur lors de la création de produit : " + e.getMessage());
	    }
	}

	@Override
	public Product read(int id) {
	    String query = "SELECT * FROM T_Product WHERE id = ?";

	    try (Connection connection = DBManager.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {
	        ps.setInt(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                int productId = rs.getInt("id");
	                String reference = rs.getString("reference");
	                String nom = rs.getString("nom");
	                double prix = rs.getDouble("prix");
	                return new Product(productId, reference, nom, prix);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // Gérer l'exception SQL
	    } catch (Exception e) {
	        e.printStackTrace(); // Gérer d'autres exceptions
	    }

	    return null;
	}

	@Override
    public boolean update(Product product) throws Exception {
        String query = "UPDATE T_Product SET reference = ?, nom = ?, prix = ? WHERE id = ?";

        try (Connection connection = DBManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, product.getReference());
            ps.setString(2, product.getNom());
            ps.setDouble(3, product.getPrix());
            ps.setInt(4, product.getId());
            
            int rowCount = ps.executeUpdate();

            return rowCount > 0;

        } catch (SQLException e) {
            // Gérer l'exception SQL
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public boolean delete(int id) throws Exception {
	    String query = "DELETE FROM T_Product WHERE id = ?";
	    
	    try (Connection connection = DBManager.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {
	        
	        ps.setInt(1, id);
	        int rowCount = ps.executeUpdate();  // Utilisez executeUpdate au lieu de execute pour les opérations DML
	        
	        return rowCount > 0;  // Vérifiez si des lignes ont été affectées

	    } catch (SQLException e) {
	        // Log or handle the SQL exception
	        throw new Exception("Erreur lors de la suppression du produit : " + e.getMessage(), e);
	    }
	}

	@Override
	public List<Product> getAllProducts() throws Exception {
		List<Product> products = new ArrayList<>();
		// TODO Auto-generated method stub
		try (Connection connection = DBManager.getConnection()) {
			String query = "select * from  T_Product";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int identifiant = rs.getInt("id");
				String reference = rs.getString("reference");
				String nom = rs.getString("nom");
				double prix = rs.getDouble("prix");
				Product product = new Product(identifiant, reference, nom, prix);
				products.add(product);
				
			
				
            }
		} catch (Exception e) {
				throw new Exception("Erreur lors de la lecture  des étudiants : " + e.getMessage());
			}
		return products;
	}
}
