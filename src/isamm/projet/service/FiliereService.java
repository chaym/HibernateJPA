package isamm.projet.service;


import java.util.List;



import isamm.projet.inter.IDao;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import isamm.projet.util.HibernateUtil;
import isamm.projet.beans.Filiere;
import isamm.projet.beans.Matiere;


public class FiliereService implements IDao <Filiere>{

	@Override
	public boolean create(Filiere obj) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
		session.save(obj);
		tx.commit();
		return true;
	}

	@Override
	public List<Filiere> getAll() {
		Session session = HibernateUtil.openSession();
		Query q = session.createQuery("from Filiere");
		List l = q.list();
		return l;
	}

	@Override
	public boolean delete(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
        Query query = session.createQuery("delete from Filiere where id_filiere='"+id+"'");
        query.executeUpdate();
		tx.commit();
		return true;
	}

	@Override
	public boolean update(int id, Filiere obj) {
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
			 Query query = session.createQuery("from Filiere where id_filiere='"+id+"'");
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
