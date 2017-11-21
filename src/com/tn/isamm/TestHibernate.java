package com.tn.isamm;


//import java.util.List;


import org.hibernate.Session;


import java.util.Iterator;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import isamm.projet.util.HibernateUtil;
import isamm.projet.beans.*;

import isamm.projet.service.*;
public class TestHibernate {

	public static void main(String[] args) {
		
		Session sess = HibernateUtil.openSession();

		
		EtudiantService etudiant = new EtudiantService();
		FiliereService filiere = new FiliereService();
		FormateurService formateur = new FormateurService();
		MatiereService matiere = new MatiereService();
		
		
		Filiere f = new Filiere("IAII","Ingénierie des automatismes et informatique industrielle");
		Filiere f1 = new Filiere("IRT","Ingénierie des réseaux et télécommunications");
		Filiere f2 = new Filiere("IIR","Ingénierie informatique et réseaux");
		filiere.create(f1);
		filiere.create(f2);
		filiere.create(f);
		
		
		Formateur fr = new Formateur("SELIMANI","Yahya","","","Homme","vide");
		Formateur fr1 = new Formateur("SAFI","Ilham","","","Homme","vide");
		formateur.create(fr);
		formateur.create(fr1);
		
		Matiere m = new Matiere("TPC","Techniques de programmation structurée");
		Matiere m1 = new Matiere("JB","Java de Base");
		Matiere m2 = new Matiere("AU","Administration Unix");
		Matiere m3 = new Matiere("Hibernate","Framework de persistance");
		Matiere m4 = new Matiere("POO","Programmation orientée objet");
		
		
		m.setFormateur(fr);
		m2.setFormateur(fr1);
		m4.setFormateur(fr1);
		
		matiere.create(m);
		matiere.create(m1);
		matiere.create(m2);
		matiere.create(m3);
		matiere.create(m4);
		
		Etudiant e = new Etudiant("SAFI","Amal","","","Femme","22845676");
		Etudiant e1 = new Etudiant("ALAMI","Samir","","","Homme","23845976");
		Etudiant e2 = new Etudiant("ALAOUI","Safa","","","Femme","22345476");
		
		e.setFiliere(f2);
		e1.setFiliere(f2);
		e2.setFiliere(f);
		
		etudiant.create(e);
		etudiant.create(e1);
		etudiant.create(e2);
		
		
		//Aff  liste  matieres
		List <Matiere> L =  matiere.getAll();
		Iterator i = L.iterator();
		while (i.hasNext()) {
		System.out.println(((Matiere) i.next()).getCode());
		}
		
		//Aff  liste  filiere
		
				List <Filiere> F =  filiere.getAll();
				Iterator i1 = F.iterator();
				while (i1.hasNext()) {
				System.out.println(((Filiere) i1.next()).getCode());
				}
		
		
		
		
		
		
		
		
	}

}
