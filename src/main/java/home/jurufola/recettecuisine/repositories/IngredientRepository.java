package home.jurufola.recettecuisine.repositories;

import home.jurufola.recettecuisine.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface repository pour les opérations De CRUD des ingrédients
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
