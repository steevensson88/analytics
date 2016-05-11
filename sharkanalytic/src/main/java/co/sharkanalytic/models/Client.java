package co.sharkanalytic.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "clients")
@JsonIgnoreProperties({ "reclamationsList" })
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Integer idClient;

	@Column(name = "numcompte_client")
	private String numcompteClient;

	@Column(name = "nom_client")
	private String nomClient;

	@Column(name = "email_client")
	private String emailClient;

	@Column(name = "adresse_client")
	private String adresseClient;

	@Column(name = "solde_compte")
	private Double soldeCompte;
	@Column(name = "montant_compte")
	private Double montantCompte;
	@Column(name = "datecreation")
	@Temporal(TemporalType.DATE)
	private Date datecreation;
	@JoinColumn(name = "id_agent", referencedColumnName = "id_agent")
	@ManyToOne(fetch = FetchType.EAGER)
	private Agent idAgent;
	@JoinColumn(name = "id_agence", referencedColumnName = "id_agence")
	@ManyToOne(fetch = FetchType.EAGER)
	private Agence idAgence;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient", fetch = FetchType.LAZY)
	private List<Reclamation> reclamationsList;

	public Client() {
	}

	public Client(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getNumcompteClient() {
		return numcompteClient;
	}

	public void setNumcompteClient(String numcompteClient) {
		this.numcompteClient = numcompteClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public Double getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(Double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public Double getMontantCompte() {
		return montantCompte;
	}

	public void setMontantCompte(Double montantCompte) {
		this.montantCompte = montantCompte;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Agent getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(Agent idAgent) {
		this.idAgent = idAgent;
	}

	public Agence getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(Agence idAgence) {
		this.idAgence = idAgence;
	}

	@XmlTransient
	public List<Reclamation> getReclamationList() {
		return reclamationsList;
	}

	public void setReclamationsList(List<Reclamation> reclamationsList) {
		this.reclamationsList = reclamationsList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idClient != null ? idClient.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Client)) {
			return false;
		}
		Client other = (Client) object;
		if ((this.idClient == null && other.idClient != null)
				|| (this.idClient != null && !this.idClient.equals(other.idClient))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", numcompteClient=" + numcompteClient + ", nomClient=" + nomClient
				+ ", emailClient=" + emailClient + ", adresseClient=" + adresseClient + ", soldeCompte=" + soldeCompte
				+ ", montantCompte=" + montantCompte + ", datecreation=" + datecreation + ", idAgent=" + idAgent
				+ ", idAgence=" + idAgence + ", reclamationsList=" + reclamationsList + "]";
	}

}
