package cz.cd.bootcamp.qa.repository;

import cz.cd.bootcamp.qa.model.QA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * {@link QA} repository.
 *
 * @author Daniel Sram
 */
public interface QARepository extends JpaRepository<QA, Long> {

    /**
     * Finds all categories.
     *
     * @return list of categories
     */
    @Query("select distinct qa.category from QA qa")
    List<String> getCategories();

    /**
     * Fulltext search by question or answer.
     *
     * @return list of QAs
     */
    List<QA> findDistinctByQuestionIgnoreCaseContainingOrAnswerIgnoreCaseContaining(String question, String answer);

    /**
     * Finds QAs by category.
     *
     * @return list of QAs
     */
    List<QA> findByCategory(String category);
}
