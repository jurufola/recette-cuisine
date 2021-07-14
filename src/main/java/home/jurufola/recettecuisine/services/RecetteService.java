package home.jurufola.recettecuisine.services;

import home.jurufola.recettecuisine.entities.Recette;
import home.jurufola.recettecuisine.repositories.CategorieRepository;
import home.jurufola.recettecuisine.repositories.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de Service pour les récettes
 * @author juruf_000
 */
@Service
public class RecetteService {
    @Autowired
    RecetteRepository recetteRepository;

    /**
     * Méthode service pour récuperer toutes les recettes
     * @return La liste de toutes les recettes
     */
    public List<Recette> getRecettes() {
        return recetteRepository.findAll();
    }

    /**
     * Méthode de service pour récuprer une recette
     * @param id L'identifaint de la recette
     * @return La recette demandée
     */
    public Recette getRecette(Long id) {
        return recetteRepository.findById(id).get();
    }

    /**
     * Méthode de service pour ajouter une recette à la base
     * @param recette La recette à rajouter
     * @return Message de rajout OK
     */
    public String addRecette(Recette recette) {
        recetteRepository.save(recette);
        return "La recette " + " a été rajoutée à la base";
    }

    /**
     * Méthode de service pour supprimer une recette de la base
     * @param recette La recette à supprimer
     * @return Message de suppression OK
     */
    public String deleteRecette(Recette recette) {
        recetteRepository.delete(recette);
        return "La recette " + recette + " a été supprimée de la base";
    }

}
