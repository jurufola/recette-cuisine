package home.jurufola.recettecuisine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecetteController {
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
    @GetMapping("ingredients")
    public String getIngredients() {
        return "ingredients";
    }

    @GetMapping("ajout-ingredient")
    public String getAddIngredientForm() {
        return "ajout-ingredient";
    }
}
