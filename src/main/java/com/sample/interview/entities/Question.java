package com.sample.interview.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

/**
 * Defines the question entity model
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String candidateExperience;

    private String codingLanguage;

    private int interviewDuration;

    private String tittle;

    private String description;

    private int maximumTime;

    private String possibleAnswer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCandidateExperience() {
        return candidateExperience;
    }

    public void setCandidateExperience(String candidateExperience) {
        this.candidateExperience = candidateExperience;
    }

    public String getCodingLanguage() {
        return codingLanguage;
    }

    public void setCodingLanguage(String codingLanguage) {
        this.codingLanguage = codingLanguage;
    }

    public int getInterviewDuration() {
        return interviewDuration;
    }

    public void setInterviewDuration(int interviewDuration) {
        this.interviewDuration = interviewDuration;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaximumTime() {
        return maximumTime;
    }

    public void setMaximumTime(int maximumTime) {
        this.maximumTime = maximumTime;
    }

    public String getPossibleAnswer() {
        return possibleAnswer;
    }

    public void setPossibleAnswer(String possibleAnswer) {
        this.possibleAnswer = possibleAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id &&
                candidateExperience == question.candidateExperience &&
                codingLanguage == question.codingLanguage &&
                interviewDuration == question.interviewDuration &&
                tittle.equals(question.tittle) &&
                description.equals(question.description) &&
                Objects.equals(maximumTime, question.maximumTime) &&
                Objects.equals(possibleAnswer, question.possibleAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, candidateExperience, codingLanguage, interviewDuration, tittle, description, maximumTime, possibleAnswer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", candidateExperience=" + candidateExperience +
                ", codingLanguage=" + codingLanguage +
                ", interviewDuration=" + interviewDuration +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", maximumTime='" + maximumTime + '\'' +
                ", possibleAnswer=" + possibleAnswer +
                '}';
    }
}
