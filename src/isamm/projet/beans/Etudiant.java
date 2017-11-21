package isamm.projet.beans;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name ="id_etudiant")
public class Etudiant extends Personne {
	
	private String cne;
	private Filiere filiere;
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	
	@ManyToOne(targetEntity = isamm.projet.beans.Filiere.class)
	@JoinColumn(name = "id_filiere", nullable = false)
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public Etudiant(String nom, String prenom, String email, String telephone, String sexe, String cne) {
		super(nom, prenom, email, telephone, sexe);
		this.cne = cne;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudiant(String nom, String prenom, String email, String telephone, String sexe) {
		super(nom, prenom, email, telephone, sexe);
		// TODO Auto-generated constructor stub
	}
	
	

	

}
