package home.jurufola.recettecuisine.controllers;

import home.jurufola.recettecuisine.entities.Categorie;
import home.jurufola.recettecuisine.entities.Ingredient;
import home.jurufola.recettecuisine.entities.Recette;
import home.jurufola.recettecuisine.services.CategorieService;
import home.jurufola.recettecuisine.services.IngredientService;
import home.jurufola.recettecuisine.services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe Controller pour la gestion des Recettes
 * @author juruf_000
 */
@Controller
public class RecetteController {

    @Autowired
    RecetteService recetteService; // Injection dépendance RecetteService
    @Autowired
    CategorieService categorieService; // Injection dépendance CategorieService
    @Autowired
    IngredientService ingredientService; // Injection dépendance ingredientService
    @GetMapping("layout")
    public String getLayout(){
        return "common/layout";
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    /**
     * Permet d'afficher la liste de toutes les recettes
     * @param model Le modèle à passer à la vue
     * @return La page 'recettes.html'
     */
    @GetMapping("recettes")
    public String getRecettes(Model model){
        List<Recette> recettes = recetteService.getRecettes();
        model.addAttribute("recettes", recettes);
        return "recettes";
    }

    /**
     * Permert d'afficher une recette
     * @param id L'identifiant de la recette
     * @param model Le modèle à passer à la vue
     * @return La page 'recette.html'
     */
    @GetMapping("recette/{id}")
    public String getRecette(@PathVariable("id") Long id, Model model){
        Recette recette = recetteService.getRecette(id);
        List<Ingredient> ingredients = ingredientService.getIngredients();
        model.addAttribute("recette", recette);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("ingredient", new Ingredient());
       // model.addAttribute("quantite", "");
        return "recette";
    }

    /**
     * Permet d'afficher le formulaire pour ajouter une recette
     * @param model Le modèle à passer à la vue
     * @return page 'ajout-recette.html'
     */
    @GetMapping("ajout-recette")
    public String getAddRecetteForm(Model model) {
        model.addAttribute("recette", new Recette());
        model.addAttribute("listCategorie", categorieService.getCategories());
        return "ajout-recette";
    }

    /**
     * Permet d'ajouter une recette en base
     * @param recette La recette à ajouter
     * @param model Le modèle à passer à la vue
     * @return La page 'recettes.html'
     */
    @PostMapping("ajout-recette")
    public String addRecette(@ModelAttribute Recette recette, Model model) {
        System.out.println(recette.getCategorie());
        recetteService.addRecette(recette);
        List<Recette> recettes = recetteService.getRecettes();
        model.addAttribute("recettes", recettes);
        return "recettes";
    }

    @PostMapping("ajout-ingredient-recette/{id}/{quantite}")
    public String AddIngredientToRecette(@PathVariable("id") Long id,
                                         @ModelAttribute("ingredient") Ingredient ingredient,
                                         @PathVariable("quantite") String quantite, Model model) {
        System.out.println(ingredient);
        System.out.println("contenu quantite" + quantite);
        List<Recette> recettes = recetteService.getRecettes();
        model.addAttribute("recettes", recettes);
        return "recettes";
    }


}
