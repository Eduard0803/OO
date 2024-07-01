import javax.swing.*;

public class Person{
    private String name, email;
    private int age;

    private Person(){}
    public Person(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getEmail(){return email;}
}
