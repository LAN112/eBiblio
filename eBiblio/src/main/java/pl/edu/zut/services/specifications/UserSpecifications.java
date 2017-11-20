package pl.edu.zut.services.specifications;

import org.springframework.data.jpa.domain.Specification;
import pl.edu.zut.models.User;
import pl.edu.zut.models.User_;

public final class UserSpecifications {
    public static Specification<User> withId(final Long id) {
        return (userRoot, query, builder) -> builder.equal(userRoot.get(User_.id), id);
    }

    public static Specification<User> withLogin(final String login) {
        return (userRoot, query, builder) -> builder.equal(userRoot.get(User_.login), login);
    }

    public static Specification<User> withPassword(final String password) {
        return (userRoot, query, builder) -> builder.equal(userRoot.get(User_.password), password);
    }

    public static Specification<User> withName(final String name) {
        return (userRoot, query, builder) -> builder.equal(userRoot.get(User_.name), name);
    }

    public static Specification<User> withSurname(final String surname) {
        return (userRoot, query, builder) -> builder.equal(userRoot.get(User_.surname), surname);
    }

    public static Specification<User> withEmail(final String email) {
        return (userRoot, query, builder) -> builder.equal(userRoot.get(User_.email), email);
    }
}
