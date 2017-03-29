package it.polito.tdp.lab04.model;



import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.IscrittiDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	Map<String, Corso> corsi = new HashMap<String, Corso>();
	Map<Integer, Studente> studenti = new HashMap <Integer, Studente>();
	CorsoDAO cDAO = new CorsoDAO();
	StudenteDAO sDAO = new StudenteDAO();
	IscrittiDAO iDAO = new IscrittiDAO();
	
	public Model() {
		super();
		for(Corso temp : cDAO.getTuttiICorsi()){
			corsi.put(temp.getCodins(), temp);
		}
		for(Studente temp : sDAO.getTuttiGliStudenti()){
			studenti.put(temp.getMatricola(), temp);
		}
	
	}
	
	public List<Corso> getCorsi(){
		List<Corso> listaCorsi = new ArrayList<Corso>(corsi.values());
		return listaCorsi;
				
	}
	
	public Studente getStudentFromMatricola(int matricola){
		if(!studenti.containsKey(matricola)){	
			return null;
		}
		else{
			return studenti.get(matricola);
		}
	}

	
	public List<Studente> getIscritti(Corso c){
		
		List<Studente> stud = new LinkedList<Studente>();
		
		for(IscrittiPerCorso i : iDAO.getTuttiGliStudenti()){
			if(i.getCodiceCorso().compareTo(c.getCodins())==0){
				stud.add(studenti.get(i.getStudente()));
			}
		}
		
		return stud;
	}
	
}
