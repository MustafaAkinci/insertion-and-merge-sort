import javax.print.DocFlavor.STRING;

public class student {

    String name;
    String surname;
    int id;

    student(String name, String surname, int id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}