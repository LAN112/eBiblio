package pl.edu.zut.models;

import pl.edu.zut.core.model.AbstractEntity_;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public class User_ extends AbstractEntity_ {

    public static volatile SingularAttribute<User, String> login;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> phoneNumber;

}
