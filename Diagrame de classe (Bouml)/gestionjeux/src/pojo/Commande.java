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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Commande generated by hbm2java
 */
@Entity
@Table(name = "commande", catalog = "mldcorection")
public class Commande implements java.io.Serializable {

	private char idCommande;
	private Vendeur vendeur;
	private Fournisseur fournisseur;
	private int numdecommande;
	private String nomduproduit;
	private String constructeur;
	private char nbredecommande;
	private char datedecommande;
	private Set<Produit> produits = new HashSet<Produit>(0);

	public Commande() {
	}

	public Commande(char idCommande, Vendeur vendeur, Fournisseur fournisseur,
			int numdecommande, String nomduproduit, String constructeur,
			char nbredecommande, char datedecommande) {
		this.idCommande = idCommande;
		this.vendeur = vendeur;
		this.fournisseur = fournisseur;
		this.numdecommande = numdecommande;
		this.nomduproduit = nomduproduit;
		this.constructeur = constructeur;
		this.nbredecommande = nbredecommande;
		this.datedecommande = datedecommande;
	}

	public Commande(char idCommande, Vendeur vendeur, Fournisseur fournisseur,
			int numdecommande, String nomduproduit, String constructeur,
			char nbredecommande, char datedecommande, Set<Produit> produits) {
		this.idCommande = idCommande;
		this.vendeur = vendeur;
		this.fournisseur = fournisseur;
		this.numdecommande = numdecommande;
		this.nomduproduit = nomduproduit;
		this.constructeur = constructeur;
		this.nbredecommande = nbredecommande;
		this.datedecommande = datedecommande;
		this.produits = produits;
	}

	@Id
	@Column(name = "IdCommande", unique = true, nullable = false, length = 1)
	public char getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(char idCommande) {
		this.idCommande = idCommande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVendeur", nullable = false)
	public Vendeur getVendeur() {
		return this.vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFournis", nullable = false)
	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Column(name = "numdecommande", nullable = false)
	public int getNumdecommande() {
		return this.numdecommande;
	}

	public void setNumdecommande(int numdecommande) {
		this.numdecommande = numdecommande;
	}

	@Column(name = "nomduproduit", nullable = false, length = 100)
	public String getNomduproduit() {
		return this.nomduproduit;
	}

	public void setNomduproduit(String nomduproduit) {
		this.nomduproduit = nomduproduit;
	}

	@Column(name = "constructeur", nullable = false, length = 100)
	public String getConstructeur() {
		return this.constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	@Column(name = "nbredecommande", nullable = false, length = 1)
	public char getNbredecommande() {
		return this.nbredecommande;
	}

	public void setNbredecommande(char nbredecommande) {
		this.nbredecommande = nbredecommande;
	}

	@Column(name = "datedecommande", nullable = false, length = 1)
	public char getDatedecommande() {
		return this.datedecommande;
	}

	public void setDatedecommande(char datedecommande) {
		this.datedecommande = datedecommande;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "quantite1", catalog = "mldcorection", joinColumns = { @JoinColumn(name = "IdCommande", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "IdProduit", nullable = false, updatable = false) })
	public Set<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

}