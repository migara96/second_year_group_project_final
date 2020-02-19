package lk.cmb.ucsc.drivingschool.repo;

import lk.cmb.ucsc.drivingschool.model.Shedules;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SheduleRepo extends MongoRepository<Shedules,String> {
}
