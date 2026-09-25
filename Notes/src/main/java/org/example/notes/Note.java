package org.example.notes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Note {
    private int id;
    private String note;

    @JsonCreator
    public Note(@JsonProperty("id") int id,@JsonProperty("note") String note) {
        this.id = id;
        this.note = note;

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "["+id +"]"  + " " + note;
    }


}
