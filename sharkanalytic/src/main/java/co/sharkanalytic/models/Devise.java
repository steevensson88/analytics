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
@Table(name = "devises")
@XmlRootElement

public class Devise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_devise")
    private Integer idDevise;
    @Column(name = "nom_devise")
    private String nomDevise;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taux_fcfa")
    private Double tauxFcfa;
    @Column(name = "taux_dollar")
    private Double tauxDollar;
    @OneToMany(mappedBy = "idDevise", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationsList;

    public Devise() {
    }

    public Devise(Integer idDevise) {
        this.idDevise = idDevise;
    }

    public Integer getIdDevise() {
        return idDevise;
    }

    public void setIdDevise(Integer idDevise) {
        this.idDevise = idDevise;
    }

    public String getNomDevise() {
        return nomDevise;
    }

    public void setNomDevise(String nomDevise) {
        this.nomDevise = nomDevise;
    }

    public Double getTauxFcfa() {
        return tauxFcfa;
    }

    public void setTauxFcfa(Double tauxFcfa) {
        this.tauxFcfa = tauxFcfa;
    }

    public Double getTauxDollar() {
        return tauxDollar;
    }

    public void setTauxDollar(Double tauxDollar) {
        this.tauxDollar = tauxDollar;
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
        hash += (idDevise != null ? idDevise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devise)) {
            return false;
        }
        Devise other = (Devise) object;
        if ((this.idDevise == null && other.idDevise != null) || (this.idDevise != null && !this.idDevise.equals(other.idDevise))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Devise [idDevise=" + idDevise + ", nomDevise=" + nomDevise
				+ ", tauxFcfa=" + tauxFcfa + ", tauxDollar=" + tauxDollar
				+ ", reclamationsList=" + reclamationsList + "]";
	}

    
    
}
