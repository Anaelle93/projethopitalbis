package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOPatient;
import metier.Hopital;
import metier.Patient;

public class DAOPatient implements IDAOPatient {

	

		@Override
		public Patient findById(Integer id) {
			EntityManager em = Hopital.getInstance().getEmf().createEntityManager();
			Patient patient = em.find(Patient.class, id);
			em.close();
			return patient;
		}

		@Override
		public List<Patient> findAll() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public Patient save(Patient patient) {
			EntityManager em = Hopital.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			patient=em.merge(patient);
			
			em.getTransaction().commit();
			em.close();
			return patient;
		}

		@Override
		public void delete(Patient patient) {
			
			EntityManager em = Hopital.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			patient=em.merge(patient);
			em.remove(patient);
			
			em.getTransaction().commit();
			em.close();
			
		}

	

}
