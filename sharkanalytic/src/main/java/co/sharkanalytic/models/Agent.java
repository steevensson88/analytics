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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author GABI
 */
@Entity
@Table(name = "agents")
@JsonIgnoreProperties({ "clientsList"})
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_agent")
	private Integer idAgent;
	@Lob
	@Column(name = "nom_agent")
	private String nomAgent;
	@Column(name = "prenom_agent")
	private String prenomAgent;
	@OneToMany(mappedBy = "idAgent", fetch = FetchType.EAGER)
	private List<Client> clientsList;

	public Agent() {
	}

	public Agent(Integer idAgent) {
		this.idAgent = idAgent;
	}

	public Integer getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(Integer idAgent) {
		this.idAgent = idAgent;
	}

	public String getNomAgent() {
		return nomAgent;
	}

	public void setNomAgent(String nomAgent) {
		this.nomAgent = nomAgent;
	}

	public String getPrenomAgent() {
		return prenomAgent;
	}

	public void setPrenomAgent(String prenomAgent) {
		this.prenomAgent = prenomAgent;
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
		hash += (idAgent != null ? idAgent.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Agent)) {
			return false;
		}
		Agent other = (Agent) object;
		if ((this.idAgent == null && other.idAgent != null)
				|| (this.idAgent != null && !this.idAgent.equals(other.idAgent))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Agent [idAgent=" + idAgent + ", nomAgent=" + nomAgent + ", prenomAgent=" + prenomAgent
				+ ", clientsList=" + clientsList + "]";
	}

}