package isamm.projet.service;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import isamm.projet.util.HibernateUtil;
import isamm.projet.beans.Etudiant;
import isamm.projet.beans.Matiere;

import isamm.projet.inter.IDao;




public class EtudiantService implements IDao <Etudiant> {

	@Override
	public boolean create(Etudiant obj) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
		session.save(obj);
		tx.commit();
		return true;
	}

	@Override
	public List<Etudiant> getAll() {
		Session session = HibernateUtil.openSession();
		Query q = session.createQuery("from Etudiant");
		List l = q.list();
		return l;
	}

	@Override
	public boolean delete(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("delete from Etudiant where id_etudiant='"+id+"'");
        query.executeUpdate();
		tx.commit();
		return true;
	}

	@Override
	public boolean update(int id, Etudiant obj) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
		session.update(obj);
		tx.commit();
		return true;
	}

	@Override
	public boolean getById(int id) {
		Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from Etudiant where id_etudiant='"+id+"'");
			 Matiere u = (Matiere)query.uniqueResult();
			 tx.commit();
			 if(u!=null) result = true;
		 }catch(Exception ex){
			 if(tx!=null){
				 tx.rollback();
			 }
		 }finally{
			 session.close();
		 }
		 return result;
	}
	
    public List<Etudiant> listeMatiere(int id_filiere){
		
		Session session = HibernateUtil.openSession();
		/*Query q = session.createQuery("from Entreprise where nom_ent ='telnet'");
		List l = q.list();*/
		Query q = session.createQuery("from Etudiant where id_filiere='"+id_filiere+"' ");
		List l = q.list();
		return l;
	}

}
