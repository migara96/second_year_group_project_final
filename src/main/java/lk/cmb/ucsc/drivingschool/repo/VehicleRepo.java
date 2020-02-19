package lk.cmb.ucsc.drivingschool.repo;

import lk.cmb.ucsc.drivingschool.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends MongoRepository<Vehicle,String> {

}
