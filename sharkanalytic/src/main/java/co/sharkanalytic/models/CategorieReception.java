package co.sharkanalytic.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "categorie_receptions", catalog = "SharkAnalytic", schema = "")
@XmlRootElement

public class CategorieReception implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_c_reception")
    private Integer idCReception;
    @Column(name = "lib_c_reception")
    private String libCReception;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCReception", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationsList;

    public CategorieReception() {
    }

    public CategorieReception(Integer idCReception) {
        this.idCReception = idCReception;
    }

    public Integer getIdCReception() {
        return idCReception;
    }

    public void setIdCReception(Integer idCReception) {
        this.idCReception = idCReception;
    }

    public String getLibCReception() {
        return libCReception;
    }

    public void setLibCReception(String libCReception) {
        this.libCReception = libCReception;
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
        hash += (idCReception != null ? idCReception.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieReception)) {
            return false;
        }
        CategorieReception other = (CategorieReception) object;
        if ((this.idCReception == null && other.idCReception != null) || (this.idCReception != null && !this.idCReception.equals(other.idCReception))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "CategorieReception [idCReception=" + idCReception
				+ ", libCReception=" + libCReception + ", reclamationsList="
				+ reclamationsList + "]";
	}
    
}
