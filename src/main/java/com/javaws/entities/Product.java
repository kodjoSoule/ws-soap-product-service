package com.javaws.entities;
import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	//reference
	private String reference;
	//nom
	private String nom;
	//prix
	private double prix;
	
	public Product() {
		
	}
	
	public Product(String reference, String nom, double prix) {
		this.reference = reference;
		this.nom = nom;
		this.prix = prix;
	}

	public Product(int productId, String reference2, String nom2, double prix2) {
		// TODO Auto-generated constructor stub
		this.id = productId;
		this.reference = reference2;
		this.nom = nom2;
		this.prix = prix2;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getReference() {
		return reference;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
