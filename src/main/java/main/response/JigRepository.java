package main.response;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JigRepository extends CrudRepository<Jig, Integer> {
}
