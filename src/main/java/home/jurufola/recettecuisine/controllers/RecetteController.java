package home.jurufola.recettecuisine.controllers;

import home.jurufola.recettecuisine.entities.Ingredient;
import home.jurufola.recettecuisine.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlleur Recette
 * @author juruf_000
 */
@Controller
public class RecetteController {

    @Autowired
    IngredientService ingredientService; // Injection dépendance IngredientService
    @GetMapping("layout")
    public String getLayout(){
        return "common/layout";
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("recettes")
    public String getRecettes(){
        return "recettes";
    }

    @GetMapping("recette/{id}")
    public String getRecette(@PathVariable Long id){
        return "recette";
    }

    @GetMapping("ajout-recette")
    public String getAddRecetteForm() {
        return "ajout-recette";
    }

    @GetMapping("categories")
    public String getCategories() {
        return "categories";
    }

    @GetMapping("ajout-categorie")
    public String getAddCategorieForm() {
        return "ajout-categorie";
    }

    /**
     * Retourne la page qui affiche la liste des ingredients
     * @param model Le modèle pour la vue
     * @return page ingredients
     */
    @GetMapping("ingredients")
    public String getIngredients(Model model) {
        List<Ingredient> ingredients = ingredientService.getIngredients();
        model.addAttribute("ingredients", ingredients);
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient);
        }
        return "ingredients";
    }

    /**
     * Permet d'afficher le formulaire pour ajouter un ingrédient
     * @param model Le modèle pour la vue
     * @return page ajout-ingredient
     */
    @GetMapping("ajout-ingredient")
    public String getAddIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ajout-ingredient";
    }

    /**
     * Permet d'ajouter un ingrédient dans la base
     * @param ingredient L'ingredient à ajouter
     * @param model Le modèle pour la vue
     * @return La page 'liste de tous les ingrédients'
     */
    @PostMapping("ajout-ingredient")
    public String addIngredient(@ModelAttribute Ingredient ingredient, Model model) {
        System.out.println(ingredientService.addIngredient(ingredient));
        List<Ingredient> ingredients = ingredientService.getIngredients();
        model.addAttribute("ingredients", ingredients);
        return "ingredients";
    }

    /**
     * Supprimer un ingrédient
     * @param model Le modèle de la vue
     * @param id
     * @return La page 'liste de tous les ingrédients'
     */
    @GetMapping("delete-ingredient/{id}")
    public String deleteIngredient(Model model,@PathVariable("id") Long id) {
        Ingredient ingredient = ingredientService.getIngredient(id);
        ingredientService.delete(ingredient);
        List<Ingredient> ingredients = ingredientService.getIngredients();
        model.addAttribute("ingredients", ingredients);
        return "ingredients";
    }
}
