public class Note {
    private int id;
    private String note;

    public Note(int id, String note) {
        this.id = id;
        this.note = note;

    }

    public int getId() {
        return id;
    }
    public String getText() {
        return note;
    }

    @Override
    public String toString() {
        return "["+id +"]"  + " " + note;
    }


}
