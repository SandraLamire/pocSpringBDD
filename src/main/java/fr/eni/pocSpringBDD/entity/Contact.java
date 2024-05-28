package fr.eni.pocSpringBDD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Permet de faire une entité au lieu de juste un POJO
@Entity
public class Contact {
    @Id
    @GeneratedValue
    // Type objet Integer permet de mettre null si pas de valeur au lieu de 0 pour int
    private Integer idContact;
    private String nom;
    private String prenom;
    private String tel;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@ManyToOne(fetch = FetchType.EAGER) => charge contact + client
    //@ManyToOne(fetch = FetchType.LAZY) => par défaut / charge contact mais client que quand besoin
    @ManyToOne
    private Client client;

    public Contact(String nom, String prenom, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }
}
