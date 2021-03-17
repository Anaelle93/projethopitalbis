package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOCompte;
import metier.Hopital;
import metier.Patient;
import metier.Visite;
import metier.Compte;

public class DAOCompteJPA implements IDAOCompte {

	

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.close();
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		Query myQuery=em.createQuery("SELECT c from compte c",Compte.class);
		
		return null;
	
	}


	@Override
	public Compte save(Compte compte) {
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		
		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void delete(Compte compte) {
		
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		em.remove(compte);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void insert(Compte d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Compte d) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Compte checkConnect(String log, String pass) {
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		Query myQuery=em.createQuery("Select c from Compte c WHERE c.login=:login AND c.password=:pass",Compte.class);
		myQuery.setParameter("login",log);
		myQuery.setParameter("pass",pass);
		return (Compte) myQuery.getSingleResult();
		
	}


	
}


