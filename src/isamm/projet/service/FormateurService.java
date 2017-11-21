package isamm.projet.service;

import java.util.ArrayList;
import java.util.List;

import isamm.projet.beans.Formateur;
import isamm.projet.beans.Matiere;
import isamm.projet.inter.IDao;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import isamm.projet.util.HibernateUtil;


public class FormateurService implements IDao <Formateur> {

	@Override
	public boolean create(Formateur obj) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
		session.save(obj);
		tx.commit();
		return true;
	}

	@Override
	public List<Formateur> getAll() {
		Session session = HibernateUtil.openSession();
		Query q = session.createQuery("from Formateur");
		List l = q.list();
		return l;
	}

	@Override
	public boolean delete(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("delete from Formateur where id_formateur='"+id+"'");
        query.executeUpdate();
		tx.commit();
		return true;
	}

	@Override
	public boolean update(int id, Formateur obj) {
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
			 Query query = session.createQuery("from Formateur where id_formateur='"+id+"'");
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
	

}
