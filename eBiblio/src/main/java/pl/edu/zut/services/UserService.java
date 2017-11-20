package pl.edu.zut.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import pl.edu.zut.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll(Specification<User> specification);

    Page<User> findAll(Specification<User> specification, Pageable pageable);

    Optional<User> findOne(Specification<User> specification);

    Optional<User> save(User user);

    Long count(Specification<User> specification);

    void delete(Long id);
}
