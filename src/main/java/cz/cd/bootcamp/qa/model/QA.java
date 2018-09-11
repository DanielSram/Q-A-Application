package cz.cd.bootcamp.qa.model;

import lombok.Getter;
import lombok.Setter;

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
public class QA {

    @Id
    @GeneratedValue
    private Long id;

    private String category;
    private String question;
    private String answer;
}
