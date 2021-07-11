package home.jurufola.recettecuisine.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant un ingrédient
 * @author juruf_000
 */
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "nom")
    private String nom;

    @ManyToMany
    @JoinTable(name = "recette_ingredient",
    joinColumns = {@JoinColumn(name = "ingredient_id")},
    inverseJoinColumns = {@JoinColumn(name = "recette_id")}
    )
    private Set<Recette> recettes = new HashSet<>();

    /**
     * Constructeur
     * @param type Le type d'ingrédient
     * @param nom Le nom de l'ingrédient
     * @param recettes Les recettes qui utilisent l'ingrédient
     */
    public Ingredient(String type, String nom, Set<Recette> recettes) {
        this.type = type;
        this.nom = nom;
        this.recettes = recettes;
    }

    /**
     * Constructeur vide
     */
    public Ingredient() {
    }

    /**
     * Getter identfiant
     * @return L'identifiant
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter identifiant
     * @param id L'identifiant
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter type
     * @return Le type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter type
     * @param type Le type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter nom
     * @return Le nom de l'ingrédient
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter nom
     * @param nom Le nom de l'ingrédient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter recettes
     * @return Les recettes utilisant l'ingrédient
     */
    public Set<Recette> getRecettes() {
        return recettes;
    }

    /**
     * Setter recettes
     * @param recettes Les recettes utilisant l'ingrédient
     */
    public void setRecettes(Set<Recette> recettes) {
        this.recettes = recettes;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                ", recettes=" + recettes +
                '}';
    }
}
