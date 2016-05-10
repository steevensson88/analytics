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
@Table(name = "unites", catalog = "SharkAnalytic", schema = "")
@XmlRootElement

public class Unite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unite")
    private Integer idUnite;
    @Column(name = "nom_unite")
    private String nomUnite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnite", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationsList;

    public Unite() {
    }

    public Unite(Integer idUnite) {
        this.idUnite = idUnite;
    }

    public Integer getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(Integer idUnite) {
        this.idUnite = idUnite;
    }

    public String getNomUnite() {
        return nomUnite;
    }

    public void setNomUnite(String nomUnite) {
        this.nomUnite = nomUnite;
    }

    @XmlTransient
    public List<Reclamation> getReclamationsList() {
        return reclamationsList;
    }

    public void setReclamationsList(List<Reclamation> reclamationsList) {
        this.reclamationsList = reclamationsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnite != null ? idUnite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unite)) {
            return false;
        }
        Unite other = (Unite) object;
        if ((this.idUnite == null && other.idUnite != null) || (this.idUnite != null && !this.idUnite.equals(other.idUnite))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Unite [idUnite=" + idUnite + ", nomUnite=" + nomUnite
				+ ", reclamationsList=" + reclamationsList + "]";
	}

}

