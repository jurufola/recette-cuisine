package home.jurufola.recettecuisine.entities;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recette")
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @Column(name = "type_cuisson")
    private String typeCuisson;

    private LocalTime tempsCuisson;

    @ManyToMany
    @JoinTable(name = "recette_ingredient",
            joinColumns = {@JoinColumn(name = "recette_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private Set<Ingredient> ingredients = new HashSet<>();

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "nb_likes", columnDefinition = "integer default 0")
    private int nbLikes;

    @OneToMany(mappedBy = "recette")
    private Set<RecetteIngredient> recetteIngredients = new HashSet<>();

    /**
     * Constructeur
     * @param categorie La catégorie à laquelle appartient la recette
     * @param typeCuisson Le type de cuisson de la recette
     * @param tempsCuisson Le temps de cuisson de la recette
     * @param ingredients Les ingrédients composant la recette
     * @param description La description de la recette avec les différentes étapes
     * @param nbLikes Le nombre de like de la recette
     */
    public Recette(Categorie categorie, String typeCuisson, LocalTime tempsCuisson, Set<Ingredient> ingredients,
                   String description, int nbLikes) {
        this.categorie = categorie;
        this.typeCuisson = typeCuisson;
        this.tempsCuisson = tempsCuisson;
        this.ingredients = ingredients;
        this.description = description;
        this.nbLikes = nbLikes;
    }

    /**
     * Constructeur vide
     */
    public Recette() {
    }

    /**
     * Getter id
     * @return L'id de la recette
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter id
     * @param id L'id de la recette
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter categorie
     * @return La catégorie de la recette
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Setter categorie
     * @param categorie La catégorie de la recette
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * Getter typeCuisson
     * @return Le type de la cuisson
     */
    public String getTypeCuisson() {
        return typeCuisson;
    }

    /**
     * Setter typeCuisson
     * @param typeCuisson Le type de la cuisson
     */
    public void setTypeCuisson(String typeCuisson) {
        this.typeCuisson = typeCuisson;
    }

    /**
     * Getter tempsCuisson
     * @return Le temps de la cuisson
     */
    public LocalTime getTempsCuisson() {
        return tempsCuisson;
    }

    /**
     * Setter tempsCuisson
     * @param tempsCuisson Le temps de la cuisson
     */
    public void setTempsCuisson(LocalTime tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }

    /**
     * Getter ingredients
     * @return Les ingrédients de la recette
     */
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Setter ingredients
     * @param ingredients Les ingrédients de la recette
     */
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Getter description
     * @return La description de la recette
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter description
     * @param description La description de la recette
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter nbLikes
     * @return Le nombre de likes de la recette
     */
    public int getNbLikes() {
        return nbLikes;
    }

    /**
     * Setter nbLikes
     * @param nbLikes Le nombre de likes de la recette
     */
    public void setNbLikes(int nbLikes) {
        this.nbLikes = nbLikes;
    }

    /**
     * Getter nom
     * @return Le nom de la recette
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter nom
     * @param nom Le nom de la recette
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter recetteIngredients
     * @return La liste de recetteIngredients
     */
    public Set<RecetteIngredient> getRecetteIngredients() {
        return recetteIngredients;
    }

    /**
     * Setter recetteIngredient
     * @param recetteIngredients La liste de recetteIngredients
     */
    public void setRecetteIngredients(Set<RecetteIngredient> recetteIngredients) {
        this.recetteIngredients = recetteIngredients;
    }

    /**
     * Ajout nouvel ingrédient dans la recette
     * @param ingredient L'ingredient
     */
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    /**
     * Rajout nouvel enregistrement table pivot
     * @param recetteIngredient enregistrement à rajouter
     */
    public void setRecetteIngredient(RecetteIngredient recetteIngredient) {
        this.recetteIngredients.add(recetteIngredient);
    }
    /**
     * Redéfinition de toString()
     * @return Répeérentation en chaîne de caractères de la recette
     */

    /*@Override
    public String toString() {
        return "Recette{" +
                "id=" + id +
                ", categorie=" + categorie +
                ", typeCuisson='" + typeCuisson + '\'' +
                ", tempsCuisson=" + tempsCuisson +
                ", ingredients=" + ingredients +
                ", description='" + description + '\'' +
                ", nbLikes=" + nbLikes +
                '}';
    }*/

}
