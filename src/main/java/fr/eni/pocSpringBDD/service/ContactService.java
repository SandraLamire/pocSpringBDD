package fr.eni.pocSpringBDD.service;
import fr.eni.pocSpringBDD.entity.Contact;

import java.util.List;


public interface ContactService {
	public void addContact(Contact contact) throws ContactException;
	public List<Contact> getAll();
	public List<Contact> getFromNomAndPrenom(String nom, String prenom);
}
