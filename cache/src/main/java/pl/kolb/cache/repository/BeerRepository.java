package pl.kolb.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kolb.cache.data.Beer;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}
