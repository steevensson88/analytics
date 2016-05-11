package co.sharkanalytic.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GABI
 */
@Entity
@Table(name = "departements")
@XmlRootElement

public class Departement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_departement")
    private Integer idDepartement;
    @Column(name = "nom_departement")
    private String nomDepartement;
    @OneToMany(mappedBy = "depIdDepartement2", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationsList;
    @OneToMany(mappedBy = "idDepartement", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationsList1;
    @OneToMany(mappedBy = "depIdDepartement", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationsList2;

    public Departement() {
    }

    public Departement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }

    public Integer getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    @XmlTransient
    public List<Reclamation> getReclamationsList() {
        return reclamationsList;
    }

    public void setReclamationsList(List<Reclamation> reclamationsList) {
        this.reclamationsList = reclamationsList;
    }

    @XmlTransient
    public List<Reclamation> getReclamationsList1() {
        return reclamationsList1;
    }

    public void setReclamationsList1(List<Reclamation> reclamationsList1) {
        this.reclamationsList1 = reclamationsList1;
    }

    @XmlTransient
    public List<Reclamation> getReclamationsList2() {
        return reclamationsList2;
    }

    public void setReclamationsList2(List<Reclamation> reclamationsList2) {
        this.reclamationsList2 = reclamationsList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartement != null ? idDepartement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.idDepartement == null && other.idDepartement != null) || (this.idDepartement != null && !this.idDepartement.equals(other.idDepartement))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Departement [idDepartement=" + idDepartement
				+ ", nomDepartement=" + nomDepartement + ", reclamationsList="
				+ reclamationsList + ", reclamationsList1=" + reclamationsList1
				+ ", reclamationsList2=" + reclamationsList2 + "]";
	}

    
    
}
