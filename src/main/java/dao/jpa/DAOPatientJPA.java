package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOPatient;
import metier.Hopital;
import metier.Patient;
import metier.Visite;

public class DAOPatientJPA implements IDAOPatient {

	

		@Override
		public Patient findById(Integer id) {
			EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
			Patient patient = em.find(Patient.class, id);
			em.close();
			return patient;
		}

		@Override
		public List<Patient> findAll() {
			EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
			Query myQuery=em.createQuery("SELECT p from patient v",Patient.class);
			
			return null;
		}


		@Override
		public Patient save(Patient patient) {
			EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			patient=em.merge(patient);
			
			em.getTransaction().commit();
			em.close();
			return patient;
		}

		@Override
		public void delete(Patient patient) {
			
			EntityManager em = Hopital.get_instance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			patient=em.merge(patient);
			em.remove(patient);
			
			em.getTransaction().commit();
			em.close();
			
		}

		@Override
		public void insert(Patient d) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void update(Patient d) {
			// TODO Auto-generated method stub
			
		}

		

	

}
