package home.jurufola.recettecuisine.services;

import home.jurufola.recettecuisine.entities.Categorie;
import home.jurufola.recettecuisine.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe Service pour les catégories
 * @author juruf_000
 */
@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    /**
     * Méthode de service pour recuperer toutes les catégories
     * @return La liste des catégories
     */
    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }

    /**
     * Méthode de service pour récuprer une catégorie
     * @param id L'identifant de la catégorie
     * @return La catégorie demandée
     */
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).get();
    }

    /**
     * Méthode de service pour rajouter une catégorie
     * @param categorie La catégorie à rajouter
     * @return Message de rajout OK
     */
    public String addCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
        return " La catégorie " + categorie + " a été ajoutée à la base";
    }

    /**
     * Méthode de service pour supprimer une catégorie
     * @param id L'identifiant de la catégorie
     * @return Message de suppression OK
     */
    public String deleteCategorie(Long id) {
        Categorie categorie = categorieRepository.findById(id).get();
        categorieRepository.delete(categorie);
        return " La catégorie " + categorie + " a bien été supprimée de la base";
    }
}
