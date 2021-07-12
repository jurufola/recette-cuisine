package home.jurufola.recettecuisine.repositories;

import home.jurufola.recettecuisine.entities.Categorie;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
