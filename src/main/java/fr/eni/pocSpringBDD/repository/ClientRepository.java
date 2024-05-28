package fr.eni.pocSpringBDD.repository;

import org.springframework.data.repository.CrudRepository;

import fr.eni.pocSpringBDD.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

}
