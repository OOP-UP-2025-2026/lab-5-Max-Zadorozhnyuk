package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[4];

        people[0] = new Person("Петренко", "Олег", 40);
        people[1] = new Student("Іваненко", "Марія", 19, "КН-23", "ST12345");
        people[2] = new Student("Сидоренко", "Андрій", 20, "ПЗ-22", "ST67890");
        people[3] = new Lecturer("Коваль", "Наталія", 45, "Інформатика", 25000);

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}