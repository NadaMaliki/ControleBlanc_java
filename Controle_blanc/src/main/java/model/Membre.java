package model;

import java.util.List;

public class Membre {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String phone;
	private List<Incident> indicidents;
	
	
	
	public Membre(String nom, String prenom, String email, String phone) {
		this.nom=nom;
		this.prenom = prenom;
		this.email = email;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
//	public Incident getIncidents() {
//		for(int i=0; i< indicidents.size() ; i++) {
//			return indicidents.get(i);
//		}
//		return null;
//	}
		
	@Override
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;  
        }
        if (obj == null) {
            return false; 
        }
        Membre membre = (Membre) obj;
        return id == membre.id; 
    }
	
	@Override 
	public int hashCode() {
		return nom.hashCode();
	}
	
}
