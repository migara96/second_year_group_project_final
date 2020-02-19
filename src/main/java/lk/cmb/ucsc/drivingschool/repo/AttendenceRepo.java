package lk.cmb.ucsc.drivingschool.repo;

import lk.cmb.ucsc.drivingschool.model.Attendence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttendenceRepo extends MongoRepository<Attendence,String> {
}
