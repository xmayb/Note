



import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NoteRepository repository = new JsonNoteRepository();
        NoteService service = new NoteService(repository);


        Scanner scanner = new Scanner(System.in);
  while(true){
            System.out.print("Menu: \n" +
                    "1 -> is create Note\n" +
                    "2 -> is get Note \n" +
                    "3 -> delete Note\n" +
                    "4 -> get all Notes\n" +
                    "5 -> update Note\n" +
                    "6 -> break \n" );


            System.out.println("Write your choice: ");
            int choice = scanner.nextInt();

            switch (choice){

                case 1:
                    scanner.nextLine();
                    String text = scanner.nextLine();
                    Note created = service.createNote(text);
                    System.out.println("Note created: " + created);
                    break;
                case 2:
                    System.out.println("Enter ID: ");
                    int getId = scanner.nextInt();
                    Note found = service.getNote(getId);
                    if(found == null) {
                    System.out.println("Note not found");
                    }else {
                        System.out.println(found);
                    }
                    break;
                case 3:
                    System.out.println("Enter ID: ");
                    int delId = scanner.nextInt();
                    boolean deleted = service.deleteNote(delId);
                    System.out.println(deleted ? "Note delated " : "Note not found");
                    break;
                case 4:
                    List<Note> list = service.getAllNotes();
                    list.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter id:");
                    int updId = scanner.nextInt();
                    scanner.nextLine();
                    String newText = scanner.nextLine();
                    boolean update = service.updateNote(updId, newText);
                    System.out.println(update ? "Note updated" : "Note not found");
                    break;
                case 6:
                    return;

            }


        }



    }
}