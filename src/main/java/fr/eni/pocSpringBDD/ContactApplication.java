package fr.eni.pocSpringBDD;

import fr.eni.pocSpringBDD.entity.Client;
import fr.eni.pocSpringBDD.entity.Contact;
import fr.eni.pocSpringBDD.entity.Etablissement;
import fr.eni.pocSpringBDD.repository.ContactRepository;
import fr.eni.pocSpringBDD.service.ContactException;
import fr.eni.pocSpringBDD.service.ContactService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ContactApplication implements CommandLineRunner {
	@Autowired
	ContactService service;

	/// Pour la démo
	@Autowired
	ContactRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Etablissement e1 = new Etablissement("Maison Mère","ici",100);
		Etablissement e2 = new Etablissement("Maison père","idc",50);
		Client maBoite = new Client("Maboite","ici pas là","LaVille");

		maBoite.addEtablissement(e1);
		maBoite.addEtablissement(e2);


		Contact jean = new Contact("Cerien","Jean","02145577");
		jean.setClient(maBoite);
		System.out.println(jean);
		service.addContact(jean);
		System.out.println(jean);

		System.out.println("------------------");
		service.getAll().forEach(System.out::println);


		System.out.println("--------------------");
		service.getFromNomAndPrenom("Cerien","Jean").forEach(System.out::println);


		Contact martin = new Contact("Martin","Martin","545454");
		try {
			service.addContact(martin);
		} catch (ContactException e) {
			System.err.println(e.getMessage());
		}

		System.out.println("----------------");
		System.out.println(repo.getTelContactOfClientInVille("LaVille"));
		System.out.println(repo.getVilleClientOfContactTel("02145577"));
	}

}
