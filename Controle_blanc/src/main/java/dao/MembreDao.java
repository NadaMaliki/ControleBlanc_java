package dao;

import java.util.Set;

import model.Membre;

public interface MembreDao {
	public boolean Insere(Membre m);
	public boolean ChargerListIncidents();
//	public Set<Membre> chargerListeMembre(String nomFichier);
}
