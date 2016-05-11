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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GABI
 */
@Entity
@Table(name = "menus")
@XmlRootElement

public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu")
    private Integer idMenu;
    @Column(name = "nom_menu")
    private String nomMenu;
    @Column(name = "lien_menu")
    private String lienMenu;
    @ManyToMany(mappedBy = "menusList", fetch = FetchType.LAZY)
    private List<Profile> profilesList;

    public Menu() {
    }

    public Menu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNomMenu() {
        return nomMenu;
    }

    public void setNomMenu(String nomMenu) {
        this.nomMenu = nomMenu;
    }

    public String getLienMenu() {
        return lienMenu;
    }

    public void setLienMenu(String lienMenu) {
        this.lienMenu = lienMenu;
    }

    @XmlTransient
    public List<Profile> getProfilesList() {
        return profilesList;
    }

    public void setProfilesList(List<Profile> profilesList) {
        this.profilesList = profilesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + ", nomMenu=" + nomMenu
				+ ", lienMenu=" + lienMenu + ", profilesList=" + profilesList
				+ "]";
	}

    
    
}