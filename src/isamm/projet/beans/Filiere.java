package isamm.projet.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Filiere {
	
	private int id_filiere;
	private String code;
	private String libelle;
	private Set<Etudiant> etudiants = new HashSet<Etudiant>();
	private Set<Matiere> matieres = new HashSet<Matiere>();
	
	
	@ManyToMany(mappedBy = "filieres")
	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_filiere() {
		return id_filiere;
	}

	public void setId_filiere(int id_filiere) {
		this.id_filiere = id_filiere;
	}
	
	public String getCode() {
		return code;
	}
	

	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
    
	@OneToMany(mappedBy = "filiere")
	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Filiere(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
		
	}

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
