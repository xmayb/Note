
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NoteRepository repository = new InMemoryNoteRepository();
        NoteService service = new NoteService(repository);


        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Menu: 1 -> is create Note\n" +
                    "2 -> is get Note \n" +
                    "3 -> delete Note\n" +
                    "4 -> get all Notes\n " +
                    "5 -> update Note\n" +
                    "6 -> break \n" );


            System.out.println("Write your choice: ");
            int choice = scanner.nextInt();

            int id = scanner.nextInt();
            switch (choice){

                case 1:
                    scanner.nextLine();
                    String text = scanner.nextLine();
                    service.createNote(text);
                    break;
                case 2:
                    if(service.getNote(id) == null) {
                    System.out.println("Note not found");

                    }else {
                        System.out.println("Enter note id:  ");
                        service.getNote(id);
                        scanner.nextLine();
                    }
                    break;
                case 3:
                    service.deleteNote(id);
                    System.out.print("Enter id: \n");
                    break;
                case 4:
                    List<Note> list = service.getAllNotes();
                    list.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter id:");
                    scanner.nextLine();
                    String text1 = scanner.nextLine();
                    service.updateNote(id, text1);

                    break;
                case 6: break;

            }


        }



    }
}