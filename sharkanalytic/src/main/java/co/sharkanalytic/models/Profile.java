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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GABI
 */
@Entity
@Table(name = "profiles")
@XmlRootElement

public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profil")
    private Integer idProfil;
    @Column(name = "lib_profil")
    private String libProfil;
    @JoinTable(name = "contenir", joinColumns = {
        @JoinColumn(name = "id_profil", referencedColumnName = "id_profil")}, inverseJoinColumns = {
        @JoinColumn(name = "id_menu", referencedColumnName = "id_menu")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Menu> menusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfil", fetch = FetchType.LAZY)
    private List<User> usersList;

    public Profile() {
    }

    public Profile(Integer idProfil) {
        this.idProfil = idProfil;
    }

    public Integer getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(Integer idProfil) {
        this.idProfil = idProfil;
    }

    public String getLibProfil() {
        return libProfil;
    }

    public void setLibProfil(String libProfil) {
        this.libProfil = libProfil;
    }

    @XmlTransient
    public List<Menu> getMenusList() {
        return menusList;
    }

    public void setMenusList(List<Menu> menusList) {
        this.menusList = menusList;
    }

    @XmlTransient
    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfil != null ? idProfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.idProfil == null && other.idProfil != null) || (this.idProfil != null && !this.idProfil.equals(other.idProfil))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Profile [idProfil=" + idProfil + ", libProfil=" + libProfil
				+ ", menusList=" + menusList + ", usersList=" + usersList + "]";
	}

    
}
