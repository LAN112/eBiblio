package pl.edu.zut.core.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AbstractEntity.class)
public class AbstractEntity_ {
    public static volatile SingularAttribute<AbstractEntity, Long> id;
}
