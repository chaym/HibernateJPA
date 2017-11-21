package isamm.projet.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name ="id_formateur")
public class Formateur extends Personne {
	
	private String matricule;
	private Set<Matiere> matieres = new HashSet<Matiere>();
	@OneToMany(mappedBy = "formateur")
	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Formateur(String nom, String prenom, String email, String telephone, String sexe, String matricule
			) {
		super(nom, prenom, email, telephone, sexe);
		this.matricule = matricule;
	}

	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formateur(String nom, String prenom, String email, String telephone, String sexe) {
		super(nom, prenom, email, telephone, sexe);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
