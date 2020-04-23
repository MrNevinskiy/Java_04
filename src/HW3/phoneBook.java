package HW3;

import java.util.HashMap;
import java.util.HashSet;

public class phoneBook {

    HashMap<String, HashSet<Integer>> pb;

    public phoneBook() {
        this.pb = new HashMap<>();
    }

    @Override
    public String toString() {
        return "phoneBook{" +
                "pb=" + pb +
                '}';
    }

    public void addContact(String name, Integer phone){
        HashSet<Integer> book = pb.getOrDefault(name, new HashSet<>());
        book.add(phone);
        pb.put(name, book);
    }

    public void info(String name){
        System.out.println("Contact " + name + " Number " + pb.getOrDefault(name, new HashSet<>()));
    }

    public static void main(String[] args) {
        phoneBook book = new phoneBook();
        book.addContact("Roman", 332352);
        book.addContact("Makar", 3252525);
        book.addContact("Oleg", 356776);
        book.addContact("Makar",456789);
        System.out.println(book);
        book.info("Makar");

    }
}
