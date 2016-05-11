package co.sharkanalytic.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GABI
 */
@Entity
@Table(name = "reclamations")
@XmlRootElement

public class Reclamation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reclamation")
    private Integer idReclamation;
    @Column(name = "date_client")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateClient;
    @Column(name = "date_banque")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBanque;
    @Column(name = "date_env_csq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvCsq;
    
    @Column(name = "objet_reclamation")
    private String objetReclamation;
    @Lob
    @Column(name = "detail_reclamation")
    private String detailReclamation;
    @Column(name = "ref_transaction")
    private String refTransaction;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant_transaction")
    private Double montantTransaction;
    @Column(name = "date_env_departement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvDepartement;
    @Column(name = "date_ret_csq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRetCsq;
    @Column(name = "impact_fcfa")
    private Double impactFcfa;
    @Column(name = "impact_dollar")
    private Double impactDollar;
    @Lob
    @Column(name = "cause_pbleme")
    private String causePbleme;
    @Lob
    @Column(name = "origine_pbleme")
    private String originePbleme;
    @Lob
    @Column(name = "action_entreprise")
    private String actionEntreprise;
    @Column(name = "etat_reclamation")
    private String etatReclamation;
    @Column(name = "date_cloture")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCloture;
    @Column(name = "date_env_client")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvClient;
    @Column(name = "nbre_jrs")
    private BigInteger nbreJrs;
    @JoinColumn(name = "dep_id_departement2", referencedColumnName = "id_departement")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departement depIdDepartement2;
    @JoinColumn(name = "id_unite", referencedColumnName = "id_unite")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Unite idUnite;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit")
    @ManyToOne(fetch = FetchType.LAZY)
    private Produit idProduit;
    @JoinColumn(name = "id_c_reception", referencedColumnName = "id_c_reception")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategorieReception idCReception;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client idClient;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User idUser;
    @JoinColumn(name = "id_departement", referencedColumnName = "id_departement")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departement idDepartement;
    @JoinColumn(name = "id_m_reception", referencedColumnName = "id_m_reception")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModeReception idMReception;
    @JoinColumn(name = "id_devise", referencedColumnName = "id_devise")
    @ManyToOne(fetch = FetchType.LAZY)
    private Devise idDevise;
    @JoinColumn(name = "dep_id_departement", referencedColumnName = "id_departement")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departement depIdDepartement;
    @JoinColumn(name = "mod_id_m_reception", referencedColumnName = "id_m_reception")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModeReception modIdMReception;

    public Reclamation() {
    }

    public Reclamation(Integer idReclamation) {
        this.idReclamation = idReclamation;
    }

    public Integer getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Integer idReclamation) {
        this.idReclamation = idReclamation;
    }

    public Date getDateClient() {
        return dateClient;
    }

    public void setDateClient(Date dateClient) {
        this.dateClient = dateClient;
    }

    public Date getDateBanque() {
        return dateBanque;
    }

    public void setDateBanque(Date dateBanque) {
        this.dateBanque = dateBanque;
    }

    public Date getDateEnvCsq() {
        return dateEnvCsq;
    }

    public void setDateEnvCsq(Date dateEnvCsq) {
        this.dateEnvCsq = dateEnvCsq;
    }

    public String getObjetReclamation() {
        return objetReclamation;
    }

    public void setObjetReclamation(String objetReclamation) {
        this.objetReclamation = objetReclamation;
    }

    public String getDetailReclamation() {
        return detailReclamation;
    }

    public void setDetailReclamation(String detailReclamation) {
        this.detailReclamation = detailReclamation;
    }

    public String getRefTransaction() {
        return refTransaction;
    }

    public void setRefTransaction(String refTransaction) {
        this.refTransaction = refTransaction;
    }

    public Double getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(Double montantTransaction) {
        this.montantTransaction = montantTransaction;
    }

    public Date getDateEnvDepartement() {
        return dateEnvDepartement;
    }

    public void setDateEnvDepartement(Date dateEnvDepartement) {
        this.dateEnvDepartement = dateEnvDepartement;
    }

    public Date getDateRetCsq() {
        return dateRetCsq;
    }

    public void setDateRetCsq(Date dateRetCsq) {
        this.dateRetCsq = dateRetCsq;
    }

    public Double getImpactFcfa() {
        return impactFcfa;
    }

    public void setImpactFcfa(Double impactFcfa) {
        this.impactFcfa = impactFcfa;
    }

    public Double getImpactDollar() {
        return impactDollar;
    }

    public void setImpactDollar(Double impactDollar) {
        this.impactDollar = impactDollar;
    }

    public String getCausePbleme() {
        return causePbleme;
    }

    public void setCausePbleme(String causePbleme) {
        this.causePbleme = causePbleme;
    }

    public String getOriginePbleme() {
        return originePbleme;
    }

    public void setOriginePbleme(String originePbleme) {
        this.originePbleme = originePbleme;
    }

    public String getActionEntreprise() {
        return actionEntreprise;
    }

    public void setActionEntreprise(String actionEntreprise) {
        this.actionEntreprise = actionEntreprise;
    }

    public String getEtatReclamation() {
        return etatReclamation;
    }

    public void setEtatReclamation(String etatReclamation) {
        this.etatReclamation = etatReclamation;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }

    public Date getDateEnvClient() {
        return dateEnvClient;
    }

    public void setDateEnvClient(Date dateEnvClient) {
        this.dateEnvClient = dateEnvClient;
    }

    public BigInteger getNbreJrs() {
        return nbreJrs;
    }

    public void setNbreJrs(BigInteger nbreJrs) {
        this.nbreJrs = nbreJrs;
    }

    public Departement getDepIdDepartement2() {
        return depIdDepartement2;
    }

    public void setDepIdDepartement2(Departement depIdDepartement2) {
        this.depIdDepartement2 = depIdDepartement2;
    }

    public Unite getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(Unite idUnite) {
        this.idUnite = idUnite;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    public CategorieReception getIdCReception() {
        return idCReception;
    }

    public void setIdCReception(CategorieReception idCReception) {
        this.idCReception = idCReception;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Departement getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Departement idDepartement) {
        this.idDepartement = idDepartement;
    }

    public ModeReception getIdMReception() {
        return idMReception;
    }

    public void setIdMReception(ModeReception idMReception) {
        this.idMReception = idMReception;
    }

    public Devise getIdDevise() {
        return idDevise;
    }

    public void setIdDevise(Devise idDevise) {
        this.idDevise = idDevise;
    }

    public Departement getDepIdDepartement() {
        return depIdDepartement;
    }

    public void setDepIdDepartement(Departement depIdDepartement) {
        this.depIdDepartement = depIdDepartement;
    }

    public ModeReception getModIdMReception() {
        return modIdMReception;
    }

    public void setModIdMReception(ModeReception modIdMReception) {
        this.modIdMReception = modIdMReception;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReclamation != null ? idReclamation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamation)) {
            return false;
        }
        Reclamation other = (Reclamation) object;
        if ((this.idReclamation == null && other.idReclamation != null) || (this.idReclamation != null && !this.idReclamation.equals(other.idReclamation))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Reclamation [idReclamation=" + idReclamation + ", dateClient="
				+ dateClient + ", dateBanque=" + dateBanque + ", dateEnvCsq="
				+ dateEnvCsq + ", objetReclamation=" + objetReclamation
				+ ", detailReclamation=" + detailReclamation
				+ ", refTransaction=" + refTransaction
				+ ", montantTransaction=" + montantTransaction
				+ ", dateEnvDepartement=" + dateEnvDepartement
				+ ", dateRetCsq=" + dateRetCsq + ", impactFcfa=" + impactFcfa
				+ ", impactDollar=" + impactDollar + ", causePbleme="
				+ causePbleme + ", originePbleme=" + originePbleme
				+ ", actionEntreprise=" + actionEntreprise
				+ ", etatReclamation=" + etatReclamation + ", dateCloture="
				+ dateCloture + ", dateEnvClient=" + dateEnvClient
				+ ", nbreJrs=" + nbreJrs + ", depIdDepartement2="
				+ depIdDepartement2 + ", idUnite=" + idUnite + ", idProduit="
				+ idProduit + ", idCReception=" + idCReception + ", idClient="
				+ idClient + ", idUser=" + idUser + ", idDepartement="
				+ idDepartement + ", idMReception=" + idMReception
				+ ", idDevise=" + idDevise + ", depIdDepartement="
				+ depIdDepartement + ", modIdMReception=" + modIdMReception
				+ "]";
	}

    
}