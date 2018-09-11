package cz.cd.bootcamp.qa.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Question and answer entity.
 *
 * @author Daniel Sram
 */
@Entity
@Getter
@Setter
@Builder
@ToString(exclude = "id")
public class QA {

    @Id
    @GeneratedValue
    private Long id;

    private String category;
    private String question;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String answer;

    /**
     * Resolves whether all mandatory attributes are filled correctly.
     *
     * @return true if so, otherwise false
     */
    public boolean isValid() {
        return StringUtils.isNotBlank(category)
                && StringUtils.isNotBlank(question)
                && StringUtils.isNotBlank(answer);
    }
}
