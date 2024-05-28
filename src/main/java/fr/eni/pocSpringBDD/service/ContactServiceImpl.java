package fr.eni.pocSpringBDD.service;

import java.util.List;

import fr.eni.pocSpringBDD.repository.ClientRepository;
import fr.eni.pocSpringBDD.repository.EtablissementRepository;
import fr.eni.pocSpringBDD.repository.MaisonMereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pocSpringBDD.entity.Contact;
import fr.eni.pocSpringBDD.repository.ContactRepository;
import jakarta.transaction.Transactional;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactRepository repoContact;

	@Autowired
	ClientRepository repoClient;

	@Autowired
	EtablissementRepository repoEtablissement;

	@Autowired
	MaisonMereRepository repoMaisonMere;


	@Override
	@Transactional
	public void addContact(Contact contact) throws ContactException {
		if ("Martin".equals(contact.getNom())) {
			throw new ContactException("Pas de Martin!!!");
		}

		repoMaisonMere.save(contact.getClient().getMaisonMere());
		// Boucle sur chaque pour le save
		// contact.getClient().getLstEtablissements().forEach(e -> repoEtablissement.save(e));
		// OU save toute la liste en une fois
        repoEtablissement.saveAll(contact.getClient().getLstEtablissements());

		repoClient.save(contact.getClient());
		repoContact.save(contact);
	}

	@Override
	public List<Contact> getAll() {
		return (List<Contact>) repoContact.findAll();
	}

	@Override
	public List<Contact> getFromNomAndPrenom(String nom, String prenom) {
		return repoContact.findAllByNomAndPrenom(nom, prenom);
	}
}
