package home.jurufola.recettecuisine.repositories;

import home.jurufola.recettecuisine.entities.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface repository pour les opérations De CRUD des recettes
 */
public interface RecetteRepository extends JpaRepository<Recette, Long> {
    List<Recette> findAllByNomLike(String pattern);

    List<Recette> findAllByNomOrDescriptionLike(String s, String s1);
}
