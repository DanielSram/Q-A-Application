package cz.cd.bootcamp.qa.controller;

import cz.cd.bootcamp.qa.model.QA;
import cz.cd.bootcamp.qa.repository.QARepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link QA} controller.
 *
 * @author Daniel Sram
 */
@RestController
@AllArgsConstructor
public class QAController {

    private final QARepository repository;

    /**
     * Finds all categories.
     *
     * @return list of categories
     */
    @GetMapping("/categories")
    public List<String> getCategories() {
        return repository.getCategories();
    }

    /**
     * Finds QAs by category.
     *
     * @return list of QAs
     */
    @GetMapping("/findByCategory/{category}")
    public List<QA> findByCategory(@PathVariable final String category) {
        return repository.findByCategory(category);
    }

    /**
     * Fulltext search by question or answer.
     *
     * @return list of QAs
     */
    @GetMapping("/search/{text}")
    public List<QA> search(@PathVariable final String text) {
        return repository.findDistinctByQuestionIgnoreCaseContainingOrAnswerIgnoreCaseContaining(text, text);
    }
}
