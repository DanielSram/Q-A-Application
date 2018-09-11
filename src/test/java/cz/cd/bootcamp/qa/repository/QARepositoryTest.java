package cz.cd.bootcamp.qa.repository;

import cz.cd.bootcamp.qa.model.QA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

/**
 * Tests the {@link QARepository}.
 *
 * @author Daniel Sram
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class QARepositoryTest {

    @Autowired
    private QARepository repository;

    @Test
    public void testGetCategories() {
        final List<String> categories = repository.getCategories();
        assertThat(categories.size(), greaterThan(2));
    }

    @Test
    public void testFindByCategory() {
        final List<QA> result = repository.findByCategory("Test category 1");
        assertThat(result, hasSize(1));
        assertThat(result.get(0).getQuestion(), equalTo("Test question 1"));
        assertThat(result.get(0).getAnswer(), equalTo("Test answer 1"));
    }

    @Test
    public void testFulltextSearch() {
        final String text = "Test answer";
        final List<QA> result = repository.findDistinctByQuestionIgnoreCaseContainingOrAnswerIgnoreCaseContaining(text, text);
        assertThat(result.size(), equalTo(3));
    }
}