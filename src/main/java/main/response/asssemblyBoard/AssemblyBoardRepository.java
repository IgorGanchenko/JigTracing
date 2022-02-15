package main.response.asssemblyBoard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssemblyBoardRepository extends CrudRepository<AssemblyBoard, Integer> {
}
