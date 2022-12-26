package project.rest.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rest.restapi.entity.Collateral;

@Repository
public interface CollateralRepository extends JpaRepository<Collateral, Integer> {
}
