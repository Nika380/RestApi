package project.rest.restapi.services.collateral;

import org.springframework.stereotype.Service;
import project.rest.restapi.entity.Collateral;
import project.rest.restapi.repository.CollateralRepository;

@Service
public class CollateralService implements  CollateralInterface{
    private final CollateralRepository collateralRepository;

    public CollateralService(CollateralRepository collateralRepository) {
        this.collateralRepository = collateralRepository;
    }

    @Override
    public Collateral addCollateral(Collateral collateral) {
        return collateralRepository.save(collateral);
    }
}
