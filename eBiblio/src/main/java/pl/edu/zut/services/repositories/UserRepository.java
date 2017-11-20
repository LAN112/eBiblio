package pl.edu.zut.services.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.edu.zut.core.LibRepository;
import pl.edu.zut.models.User;

public interface UserRepository extends LibRepository <User, Long>, JpaSpecificationExecutor<User> {

    User save(User user);

    void delete(Long id);
}
