package pl.marcin.creditservice.reposotories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.marcin.creditservice.models.Credit;

@Repository
public interface CreditRepository extends CrudRepository<Credit, String> {
}
