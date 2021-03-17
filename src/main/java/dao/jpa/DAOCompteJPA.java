package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOCompte;
import metier.Hopital;
import metier.Compte;

public class DAOCompteJPA implements IDAOCompte {

	

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Hopital.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.close();
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Compte save(Compte compte) {
		EntityManager em = Hopital.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		
		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void delete(Compte compte) {
		
		EntityManager em = Hopital.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		em.remove(compte);
		
		em.getTransaction().commit();
		em.close();
		
	}


}


