package home.jurufola.recettecuisine.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant la catégorie
 * @author juruf_000
 */
@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "categorie")
    private Set<Recette> recettes = new HashSet<>();

    /**
     * Constructeur
     * @param nom Le nm de la catégorie
     * @param recettes Les recettes de la catégorie
     */
    public Categorie(String nom, Set<Recette> recettes) {
        this.nom = nom;
        this.recettes = recettes;
    }

    /**
     * Constructeur vide
     */
    public Categorie() {
    }

    /**
     * Gette id
     * @return L'id de la catégorie
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter id
     * @param id L'id de la catégorie
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter nom
     * @return LE nom de la catégorie
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter nom
     * @param nom Le nom de la catégorie
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter recettes
     * @return Les recettes de la catégorie
     */
    public Set<Recette> getRecettes() {
        return recettes;
    }

    /**
     * Setter recettes
     * @param recettes Les recettes de la catégorie
     */
    public void setRecettes(Set<Recette> recettes) {
        this.recettes = recettes;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                //", recettes=" + recettes +
                '}';
    }
}
