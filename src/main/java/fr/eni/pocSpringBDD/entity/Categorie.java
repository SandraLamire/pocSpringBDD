package fr.eni.pocSpringBDD.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue
    private Integer idCategorie;
    private String libelle;
    private String description;

    public Categorie(String libelle, String description) {
        super();
        this.libelle = libelle;
        this.description = description;
    }

}
