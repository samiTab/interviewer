package com.sample.interview.repositories;

import com.sample.interview.entities.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Defines custom repository functions on top of the standards ones defined in CrudRepository
 */
public interface QuestionRepository extends CrudRepository<Question,
        Long> {

    List<Question> findByCandidateExperienceAndCodingLanguageAndInterviewDurationLessThanEqual(String candidateExperience,
                                                                                   String codingLanguage,
                                                                                   int interviewDuration);

    List<Question> findAllByCandidateExperience(String candidateExperience);

    List<Question> findAllByCodingLanguage(String codingLanguage);

}
