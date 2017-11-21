package isamm.projet.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity  
@Table(name = "matiere")
public class Matiere {
	 private int id_matiere;
	 private String code;
	 private String libelle;
	 private Set<Filiere> filieres = new HashSet<Filiere>();
	 private Formateur formateur;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
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
	@ManyToMany
	@JoinTable(name = "LigneMatiereFiliere", joinColumns = { @JoinColumn(name = "id_matiere") },inverseJoinColumns = {@JoinColumn(name = "id_filiere") })
	public Set<Filiere> getFilieres() {
		return filieres;
	}
	public void setFilieres(Set<Filiere> filieres) {
		this.filieres = filieres;
	}
	
	@ManyToOne(targetEntity = isamm.projet.beans.Formateur.class)
	@JoinColumn(name = "id_formateur", nullable = false)
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Matiere(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
    
	 
	 

}
