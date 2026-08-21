public class Note {
    private int id;
    private String text;

    public Note(int id, String text) {
        this.id = id;
        this.text = text;

    }

    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "["+id +"]"  + " " + text;
    }


}
