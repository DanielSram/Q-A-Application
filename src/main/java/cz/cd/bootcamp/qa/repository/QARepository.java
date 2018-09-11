package cz.cd.bootcamp.qa.repository;

import cz.cd.bootcamp.qa.model.QA;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * {@link QA} repository.
 *
 * @author Daniel Sram
 */
@RepositoryRestResource
public interface QARepository extends PagingAndSortingRepository<QA, Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @Override
    @RestResource(exported = false)
    void delete(QA entity);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends QA> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
