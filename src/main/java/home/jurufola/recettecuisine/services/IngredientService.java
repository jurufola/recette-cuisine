package home.jurufola.recettecuisine.services;

import home.jurufola.recettecuisine.entities.Ingredient;
import home.jurufola.recettecuisine.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de Service pour les ingrédients
 */
@Service
public class IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;// Injection de dependance IngredientRepository

    /**
     * Méthode de service pour sauvgarder un ingrédient dans la base
     * @param ingredient L'ingrédient
     * @return Message d'ajout Ok
     */
    public String addIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return "L'ingrédient " + ingredient + " a été bien rajouté à la base";
    }

    /**
     * Méthode de service pour retourner tous les ingrédients
     * @return Liste de tous les ingrédients
     */
    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    /**
     * Méthode de service pour  retourne un ingrédient
     * @param id id de l'ingredient
     * @return Ingrédient demandé
     */
    public Ingredient getIngredient(Long id) {
        return ingredientRepository.findById(id).get();
    }

    /**
     * Méthode de service pour supprimer un ingrédient
     * @param ingredient L'ingrédient à supprimer
     */
    public void delete(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }
}
