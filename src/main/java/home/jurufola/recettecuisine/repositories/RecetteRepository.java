package home.jurufola.recettecuisine.repositories;

import home.jurufola.recettecuisine.entities.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface repository pour les opérations De CRUD des recettes
 */
public interface RecetteRepository extends JpaRepository<Recette, Long> {
}
