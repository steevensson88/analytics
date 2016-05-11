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
@Table(name = "mode_receptions")
@XmlRootElement

public class ModeReception implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_m_reception")
    private Integer idMReception;
    @Column(name = "lib_m_reception")
    private String libMReception;
    @OneToMany(mappedBy = "idMReception", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationsList;
    @OneToMany(mappedBy = "modIdMReception", fetch = FetchType.LAZY)
    private List<Reclamation> reclamationsList1;

    public ModeReception() {
    }

    public ModeReception(Integer idMReception) {
        this.idMReception = idMReception;
    }

    public Integer getIdMReception() {
        return idMReception;
    }

    public void setIdMReception(Integer idMReception) {
        this.idMReception = idMReception;
    }

    public String getLibMReception() {
        return libMReception;
    }

    public void setLibMReception(String libMReception) {
        this.libMReception = libMReception;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMReception != null ? idMReception.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeReception)) {
            return false;
        }
        ModeReception other = (ModeReception) object;
        if ((this.idMReception == null && other.idMReception != null) || (this.idMReception != null && !this.idMReception.equals(other.idMReception))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "ModeReception [idMReception=" + idMReception
				+ ", libMReception=" + libMReception + ", reclamationsList="
				+ reclamationsList + ", reclamationsList1=" + reclamationsList1
				+ "]";
	}

}
