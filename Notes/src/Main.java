import java.util.HashMap;
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
            switch (choice){

                case 1:
                    scanner.nextLine();
                case 2:
                    service.getNote(choice);
                    int id = scanner.nextInt();
                    System.out.print("Введите id: " + id + "\n");

                    break;
                case 3:
                    int id = scanner.nextInt();
                    System.out.print("Введите id: " + id + "\n");

                    break;
                case 4:
                    service.getAllNotes();
                    list.forEach(System.out::println);
                    break;
                case 5:
                    service.updateNote(choice, "The Nore was updated");
                    System.out.print("Введите id: "); int id = scanner.nextInt();
                    break;
                case 6: break;

            }


        }



    }
}