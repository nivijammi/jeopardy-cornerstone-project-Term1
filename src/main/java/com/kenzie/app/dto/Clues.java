package com.kenzie.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Clues {

    public Clues(List<Clue> clues) {
        this.clues = clues;
    }

    public Clues() {
    }

    @JsonProperty("clues")
    List<Clue> clues;

    public List<Clue> getClues() {
        return clues;
    }

    public void setClues(List<Clue> clues) {
        this.clues = clues;
    }

    @Override
    public String toString() {
        return "Clues{" +
                "clues=" + clues +
                '}';
    }
}
