import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Note {
    private int id;
    private String note;

    @JsonCreator
    public Note(@JsonProperty("id") int id,@JsonProperty("text") String note) {
        this.id = id;
        this.note = note;

    }

    public int getId() {
        return id;
    }
    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "["+id +"]"  + " " + note;
    }


}
