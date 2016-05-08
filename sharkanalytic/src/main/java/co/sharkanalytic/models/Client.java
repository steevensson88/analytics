package co.sharkanalytic.models;

import java.util.Date;

public class Client {
	private int id_client;
	private String num_compte_client;
	private String nom_client;
	private Double solde_compte;
	private Date datecreation;
	private Double montant_compte;
	
	public Client(){

	}
	
	public Client(String num_compte_client, String nom_client, Double solde_compte, Double montant_compte,Date datecreation) {
		super();
		this.num_compte_client = num_compte_client;
		this.nom_client = nom_client;
		this.solde_compte = solde_compte;
		this.datecreation = datecreation;
		this.montant_compte=montant_compte;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNum_compte_client() {
		return num_compte_client;
	}

	public void setNum_compte_client(String num_compte_client) {
		this.num_compte_client = num_compte_client;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public Double getSolde_compte() {
		return solde_compte;
	}

	public void setSolde_compte(Double solde_compte) {
		this.solde_compte = solde_compte;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	
	

	public Double getMontant_compte() {
		return montant_compte;
	}

	public void setMontant_compte(Double montant_compte) {
		this.montant_compte = montant_compte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datecreation == null) ? 0 : datecreation.hashCode());
		result = prime * result + id_client;
		result = prime * result
				+ ((nom_client == null) ? 0 : nom_client.hashCode());
		result = prime
				* result
				+ ((num_compte_client == null) ? 0 : num_compte_client
						.hashCode());
		result = prime * result
				+ ((solde_compte == null) ? 0 : solde_compte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (datecreation == null) {
			if (other.datecreation != null)
				return false;
		} else if (!datecreation.equals(other.datecreation))
			return false;
		if (id_client != other.id_client)
			return false;
		if (nom_client == null) {
			if (other.nom_client != null)
				return false;
		} else if (!nom_client.equals(other.nom_client))
			return false;
		if (num_compte_client == null) {
			if (other.num_compte_client != null)
				return false;
		} else if (!num_compte_client.equals(other.num_compte_client))
			return false;
		if (solde_compte == null) {
			if (other.solde_compte != null)
				return false;
		} else if (!solde_compte.equals(other.solde_compte))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", num_compte_client="
				+ num_compte_client + ", nom_client=" + nom_client
				+ ", solde_compte=" + solde_compte + ", datecreation="
				+ datecreation + ", montant_compte=" + montant_compte + "]";
	}

}
