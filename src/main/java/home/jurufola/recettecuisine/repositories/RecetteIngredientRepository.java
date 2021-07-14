package home.jurufola.recettecuisine.repositories;

import home.jurufola.recettecuisine.entities.RecetteIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteIngredientRepository extends JpaRepository<RecetteIngredient, Long> {
}
