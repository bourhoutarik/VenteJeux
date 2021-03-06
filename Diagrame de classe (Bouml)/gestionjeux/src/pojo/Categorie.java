package pojo;

// Generated 11 juin 2014 17:16:45 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Categorie generated by hbm2java
 */
@Entity
@Table(name = "categorie", catalog = "mldcorection")
public class Categorie implements java.io.Serializable {

	private char idCategorie;
	private String nom;
	private String genre;
	private int pegi;
	private Set<Produit> produits = new HashSet<Produit>(0);

	public Categorie() {
	}

	public Categorie(char idCategorie, String nom, String genre, int pegi) {
		this.idCategorie = idCategorie;
		this.nom = nom;
		this.genre = genre;
		this.pegi = pegi;
	}

	public Categorie(char idCategorie, String nom, String genre, int pegi,
			Set<Produit> produits) {
		this.idCategorie = idCategorie;
		this.nom = nom;
		this.genre = genre;
		this.pegi = pegi;
		this.produits = produits;
	}

	@Id
	@Column(name = "IdCategorie", unique = true, nullable = false, length = 1)
	public char getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(char idCategorie) {
		this.idCategorie = idCategorie;
	}

	@Column(name = "nom", nullable = false, length = 100)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "genre", nullable = false, length = 100)
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Column(name = "pegi", nullable = false)
	public int getPegi() {
		return this.pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "type_de_categorie", catalog = "mldcorection", joinColumns = { @JoinColumn(name = "IdCategorie", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "IdProduit", nullable = false, updatable = false) })
	public Set<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

}
