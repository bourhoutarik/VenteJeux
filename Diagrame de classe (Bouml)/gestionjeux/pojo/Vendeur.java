package pojo;

// Generated 11 juin 2014 17:16:45 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vendeur generated by hbm2java
 */
@Entity
@Table(name = "vendeur", catalog = "mldcorection")
public class Vendeur implements java.io.Serializable {

	private char idVendeur;
	private String nom;
	private String prenom;
	private String telephone;
	private Set<Commande> commandes = new HashSet<Commande>(0);

	public Vendeur() {
	}

	public Vendeur(char idVendeur, String nom, String prenom, String telephone) {
		this.idVendeur = idVendeur;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}

	public Vendeur(char idVendeur, String nom, String prenom, String telephone,
			Set<Commande> commandes) {
		this.idVendeur = idVendeur;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.commandes = commandes;
	}

	@Id
	@Column(name = "idVendeur", unique = true, nullable = false, length = 1)
	public char getIdVendeur() {
		return this.idVendeur;
	}

	public void setIdVendeur(char idVendeur) {
		this.idVendeur = idVendeur;
	}

	@Column(name = "Nom", nullable = false, length = 100)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false, length = 100)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "telephone", nullable = false, length = 100)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendeur")
	public Set<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

}