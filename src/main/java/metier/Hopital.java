package metier;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import dao.jdbc.DAOCompteJDBC;
import dao.jdbc.DAOPatientJDBC;
import dao.jdbc.DAOVisiteJDBC;
import dao.jpa.DAOCompteJPA;
import dao.jpa.DAOPatientJPA;
import dao.jpa.DAOVisiteJPA;


public class Hopital {
	
	private LinkedList<Patient> fileAttente=new LinkedList<Patient>();
	private Patient lastPatient=null;
	private Compte connected=null;
	private IDAOCompte daoC = new DAOCompteJPA();
	private IDAOPatient daoP = new DAOPatientJPA();
	private IDAOVisite daoV = new DAOVisiteJPA();
	boolean pause=false;
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
	private static Hopital _instance=null; 
	
	private Hopital() {}

	
	
	public static Hopital get_instance() {
		if(_instance==null) {_instance=new Hopital();}
		
		return _instance;

	}

	public EntityManagerFactory getEmf() {
        return emf;
    }


    public void closeEmf() 
    {
        emf.close();
    }
	
	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}

	public void setFileAttente(LinkedList<Patient> fileAttente) {
		this.fileAttente = fileAttente;
	}

	public Patient getLastPatient() {
		return lastPatient;
	}

	public void setLastPatient(Patient lastPatient) {
		this.lastPatient = lastPatient;
	}

	public Compte getConnected() {
		return connected;
	}

	public void setConnected(Compte connected) {
		this.connected = connected;
	}

	public IDAOCompte getDaoC() {
		return daoC;
	}

	public void setDaoC(IDAOCompte daoC) {
		this.daoC = daoC;
	}

	public IDAOPatient getDaoP() {
		return daoP;
	}

	public void setDaoP(IDAOPatient daoP) {
		this.daoP = daoP;
	}

	public IDAOVisite getDaoV() {
		return daoV;
	}

	public void setDaoV(IDAOVisite daoV) {
		this.daoV = daoV;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
