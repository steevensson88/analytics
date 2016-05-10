package co.sharkanalytic.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agences")

public class Agence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "id_agence")
    private Integer idAgence;
    
    @Column(name = "nom_agence")
    private String nomAgence;
    
    @Column(name = "adresse_agence")
    private String adresseAgence;
    
    @Column(name = "contact_agence")
    private String contactAgence;
    
    @OneToMany(mappedBy = "idAgence", fetch = FetchType.LAZY)
    private List<Client> clientsList;

    public Agence() {
    }

    public Agence(Integer idAgence) {
        this.idAgence = idAgence;
    }

    public Integer getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(Integer idAgence) {
        this.idAgence = idAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getAdresseAgence() {
        return adresseAgence;
    }

    public void setAdresseAgence(String adresseAgence) {
        this.adresseAgence = adresseAgence;
    }

    public String getContactAgence() {
        return contactAgence;
    }

    public void setContactAgence(String contactAgence) {
        this.contactAgence = contactAgence;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgence != null ? idAgence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agence)) {
            return false;
        }
        Agence other = (Agence) object;
        if ((this.idAgence == null && other.idAgence != null) || (this.idAgence != null && !this.idAgence.equals(other.idAgence))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", nomAgence=" + nomAgence
				+ ", adresseAgence=" + adresseAgence + ", contactAgence="
				+ contactAgence + ", clientsList=" + clientsList + "]";
	}

    
}
