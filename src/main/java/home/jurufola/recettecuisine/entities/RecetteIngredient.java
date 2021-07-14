package home.jurufola.recettecuisine.entities;

import javax.persistence.*;

/**
 * Classe representant la table bpivot entre la recette et l'ingrédient
 * @author juruf_000
 */
@Entity
@Table(name = "recette_ingredient")
public class RecetteIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    private Recette recette;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private String quantite;

    /**
     * Getter id
     * @return L'identifiant de la table pivot
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter id
     * @param id L'identifiant de la table pivot
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter recette
     * @return La recette
     */
    public Recette getRecette() {
        return recette;
    }

    /**
     * Setter recette
     * @param recette La recette
     */
    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    /**
     * Getter ingredient
     * @return L'ingrédient
     */
    public Ingredient getIngredient() {
        return ingredient;
    }

    /**
     * Setter ingredient
     * @param ingredient L'ingrédient
     */
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * Getter quantité
     * @return La quantité d'ingrédient
     */
    public String getQuantite() {
        return quantite;
    }

    /**
     * Setter quantite
     * @param quantite La quantité d'ingrédient
     */
    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
}
