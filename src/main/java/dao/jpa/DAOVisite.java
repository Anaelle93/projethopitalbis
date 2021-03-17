package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOVisite;
import metier.Hopital;
import metier.Visite;

public class DAOVisite  implements IDAOVisite {

	

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Hopital.getInstance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class, id);
		em.close();
		return visite;
	}

	@Override
	public List<Visite> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Visite save(Visite visite) {
		EntityManager em = Hopital.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		visite=em.merge(visite);
		
		em.getTransaction().commit();
		em.close();
		return visite;
	}

	@Override
	public void delete(Visite visite) {
		
		EntityManager em = Hopital.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		visite=em.merge(visite);
		em.remove(visite);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
