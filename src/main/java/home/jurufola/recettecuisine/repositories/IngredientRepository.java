package home.jurufola.recettecuisine.repositories;

import home.jurufola.recettecuisine.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
