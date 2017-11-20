package pl.edu.zut.core;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface LibRepository <T extends LibEntity, ID extends Serializable> extends Repository<T, ID> {
}
