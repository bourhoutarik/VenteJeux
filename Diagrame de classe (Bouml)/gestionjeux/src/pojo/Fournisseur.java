package pojo;

// Generated 11 juin 2014 17:16:45 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Fournisseur generated by hbm2java
 */
@Entity
@Table(name = "fournisseur", catalog = "mldcorection")
public class Fournisseur implements java.io.Serializable {

	private char idFournis;
	private Adresse adresse;
	private String nomEntreprise;
	private String numTva;
	private Set<Commande> commandes = new HashSet<Commande>(0);

	public Fournisseur() {
	}

	public Fournisseur(char idFournis, Adresse adresse, String nomEntreprise,
			String numTva) {
		this.idFournis = idFournis;
		this.adresse = adresse;
		this.nomEntreprise = nomEntreprise;
		this.numTva = numTva;
	}

	public Fournisseur(char idFournis, Adresse adresse, String nomEntreprise,
			String numTva, Set<Commande> commandes) {
		this.idFournis = idFournis;
		this.adresse = adresse;
		this.nomEntreprise = nomEntreprise;
		this.numTva = numTva;
		this.commandes = commandes;
	}

	@Id
	@Column(name = "idFournis", unique = true, nullable = false, length = 1)
	public char getIdFournis() {
		return this.idFournis;
	}

	public void setIdFournis(char idFournis) {
		this.idFournis = idFournis;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdAdresse", nullable = false)
	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Column(name = "NomEntreprise", nullable = false, length = 100)
	public String getNomEntreprise() {
		return this.nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	@Column(name = "NumTVA", nullable = false, length = 100)
	public String getNumTva() {
		return this.numTva;
	}

	public void setNumTva(String numTva) {
		this.numTva = numTva;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fournisseur")
	public Set<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

}