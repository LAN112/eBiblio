package pl.edu.zut.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.zut.models.User;
import pl.edu.zut.services.UserService;
import pl.edu.zut.services.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(Specification<User> specification) {
        return userRepository.findAll(specification);
    }

    @Override
    public Page<User> findAll(Specification<User> specification, Pageable pageable) {
        return userRepository.findAll(specification, pageable);
    }

    @Override
    public Optional<User> findOne(Specification<User> specification) {
        return Optional.ofNullable(userRepository.findOne(specification));
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.ofNullable(userRepository.save(user));
    }

    @Override
    public Long count(Specification<User> specification) {
        return userRepository.count(specification);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
