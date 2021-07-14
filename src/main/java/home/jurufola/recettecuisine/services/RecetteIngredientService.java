package home.jurufola.recettecuisine.services;

import home.jurufola.recettecuisine.entities.RecetteIngredient;
import home.jurufola.recettecuisine.repositories.RecetteIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe de service pour la table pivot entre la recette et l'ingredient
 * @author juruf_000
 */
@Service
public class RecetteIngredientService {
    @Autowired
    RecetteIngredientRepository recetteIngredientRepository;

    public void save(RecetteIngredient recetteIngredient) {
        recetteIngredientRepository.save(recetteIngredient);
    }
}
