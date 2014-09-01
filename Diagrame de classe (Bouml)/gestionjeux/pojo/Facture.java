package pojo;

// Generated 11 juin 2014 17:16:45 by Hibernate Tools 4.0.0

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Facture generated by hbm2java
 */
@Entity
@Table(name = "facture", catalog = "mldcorection")
public class Facture implements java.io.Serializable {

	private char idFacture;
	private Client client;
	private Adresse adresse;
	private long nrFacture;
	private Date dateFacturation;
	private String modePaiement;
	private String typeAchat;
	private long quantite;
	private String nomClient;
	private Set<Produit> produits = new HashSet<Produit>(0);

	public Facture() {
	}

	public Facture(char idFacture, Client client, long nrFacture,
			Date dateFacturation, String modePaiement, String typeAchat,
			long quantite, String nomClient) {
		this.idFacture = idFacture;
		this.client = client;
		this.nrFacture = nrFacture;
		this.dateFacturation = dateFacturation;
		this.modePaiement = modePaiement;
		this.typeAchat = typeAchat;
		this.quantite = quantite;
		this.nomClient = nomClient;
	}

	public Facture(char idFacture, Client client, Adresse adresse,
			long nrFacture, Date dateFacturation, String modePaiement,
			String typeAchat, long quantite, String nomClient,
			Set<Produit> produits) {
		this.idFacture = idFacture;
		this.client = client;
		this.adresse = adresse;
		this.nrFacture = nrFacture;
		this.dateFacturation = dateFacturation;
		this.modePaiement = modePaiement;
		this.typeAchat = typeAchat;
		this.quantite = quantite;
		this.nomClient = nomClient;
		this.produits = produits;
	}

	@Id
	@Column(name = "IdFacture", unique = true, nullable = false, length = 1)
	public char getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(char idFacture) {
		this.idFacture = idFacture;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdClient", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdAdresse")
	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Column(name = "nrFacture", nullable = false)
	public long getNrFacture() {
		return this.nrFacture;
	}

	public void setNrFacture(long nrFacture) {
		this.nrFacture = nrFacture;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateFacturation", nullable = false, length = 10)
	public Date getDateFacturation() {
		return this.dateFacturation;
	}

	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	@Column(name = "modePaiement", nullable = false, length = 100)
	public String getModePaiement() {
		return this.modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	@Column(name = "typeAchat", nullable = false, length = 100)
	public String getTypeAchat() {
		return this.typeAchat;
	}

	public void setTypeAchat(String typeAchat) {
		this.typeAchat = typeAchat;
	}

	@Column(name = "quantite", nullable = false)
	public long getQuantite() {
		return this.quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	@Column(name = "nomClient", nullable = false, length = 100)
	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ajout_du_produit_en_facture", catalog = "mldcorection", joinColumns = { @JoinColumn(name = "IdFacture", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "IdProduit", nullable = false, updatable = false) })
	public Set<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

}
