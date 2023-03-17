package school.mjc.application.repository;

import org.springframework.data.repository.CrudRepository;
import school.mjc.application.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
