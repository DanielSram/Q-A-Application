package cz.cd.bootcamp.qa.boot;

import com.opencsv.CSVReader;
import cz.cd.bootcamp.qa.model.QA;
import cz.cd.bootcamp.qa.repository.QARepository;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;

/**
 * Maps CVS file into {@link QA} entities.
 *
 * @author Daniel Sram
 */
@Slf4j
@Component
@AllArgsConstructor
public class QAProducer {
    private static final String CSV_PATH = "classpath:db.csv";

    private final QARepository repository;
    private final ResourceLoader resourceLoader;

    /**
     * Loads CSV file and saves parsed entities.
     *
     * @throws IOException when error occurs
     */
    @PostConstruct
    public void loadQAs() throws IOException {
        log.info("Loading questions and answers.");

        @Cleanup CSVReader csvReader = new CSVReader(new FileReader(resourceLoader.getResource(CSV_PATH).getFile()));

        csvReader.forEach(this::saveRecord);
    }

    private void saveRecord(final String[] record) {
        if (record.length < 3) {
            log.warn("Excluding invalid record {}.", record);
            return;
        }

        final QA entity = QA.builder()
                .category(record[0])
                .question(record[1])
                .answer(record[2])
                .build();

        if (!entity.isValid()) {
            log.warn("Excluding invalid entity {}.", entity);
            return;
        }

        repository.save(entity);
    }
}
