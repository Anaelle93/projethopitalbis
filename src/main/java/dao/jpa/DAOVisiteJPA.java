package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOVisite;
import metier.Hopital;
import metier.Visite;

public class DAOVisiteJPA  implements IDAOVisite {

	

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class, id);
		em.close();
		return visite;
	}

	
	@Override
	public Visite save(Visite visite) {
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		visite=em.merge(visite);
		
		em.getTransaction().commit();
		em.close();
		return visite;
	}

	@Override
	public void delete(Visite visite) {
		
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		visite=em.merge(visite);
		em.remove(visite);
		
		em.getTransaction().commit();
		em.close();
		
	}


	@Override
	public List<Visite> findAll() {
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		Query myQuery=em.createQuery("SELECT v from visite v",Visite.class);
		
		return null;
	}


	@Override
	public void insert(Visite d) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Visite d) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Visite> selectAllByPatient(int secu) {
		EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
		Query myQuery=em.createQuery("from visite v WHERE v.id=:id_patient",Visite.class);
		myQuery.setParameter("id_patient",secu);
		return (List<Visite>) myQuery.getResultStream();
	}


	


}
