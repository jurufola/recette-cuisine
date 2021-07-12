package home.jurufola.recettecuisine.controllers;

import home.jurufola.recettecuisine.entities.Categorie;
import home.jurufola.recettecuisine.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Classe Controller pour la gestion des catégories
 * @author juruf_000
 */
@Controller
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    /**
     * Permet d'afficher la liste de toutes les catégories
     * @return Page 'categories.html'
     */
    @GetMapping("categories")
    public String getCategories(Model model) {
        List<Categorie> categories = categorieService.getCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    /**
     * Permet d'afficher le formulaire pour l'ajout d'une catégorie
     * @param model Le modèle à passer à la vue
     * @return page 'ajout-categorie.html'
     */
    @GetMapping("ajout-categorie")
    public String getAddCategorieForm(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "ajout-categorie";
    }

    /**
     * Permet d'ajouter une catégorie en base
     * @param categorie La catégorie à ajouter
     * @param model Le modèle à passer à la vue
     * @return Page 'categories.html'
     */
    @PostMapping("ajout-categorie")
    public String addCategorie(@ModelAttribute Categorie categorie, Model model) {
        System.out.println(categorieService.addCategorie(categorie));
        List<Categorie> categories = categorieService.getCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

}
