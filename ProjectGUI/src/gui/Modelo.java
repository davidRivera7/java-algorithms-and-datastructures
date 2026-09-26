
package gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Modelo {
    
    private ArrayList<Person> persons;
    
    public void createPersons() {                        
        persons = new ArrayList<>();
        
        persons.add(new Person("David", "Rivera", 20));
        persons.add(new Person("Alison", "Ponce", 15));
        persons.add(new Person("Selene", "Castro", 48));
        persons.add(new Person("David", "Moreno", 47));                        
        
    }
    
    public Person searchPerson(Person[] persons, String name, String lastName) {
        
        for (Person p : persons) {
            if (p.getName().equals(name) && p.getLastName().equals(lastName))
                return p;
        }
        
        return null;
    }
    
    public String[][] createDataTable() {        
        String[][] personData = new String[persons.size()][3];
        
        int iteratorPersons = 0;
        int c = 0;
        
        for (int r = 0; r < personData.length; r++) {
            
            personData[r][c++] = persons.get(iteratorPersons).getName();
            personData[r][c++] = persons.get(iteratorPersons).getLastName();
            personData[r][c++] = persons.get(iteratorPersons).getAge() + "";
            
            c = 0;
            iteratorPersons++;
        }
        
        return personData;
    }
    
    public ArrayList<Person> getPersons() {
        return persons;
    }
    
    public Person[] getArrayPerson() {
        Person[] arrayPerson = new Person[persons.size()];
        
        int i = 0;
        for (Person p : persons) {
            arrayPerson[i] = p;
            i++;
        }
        
        return arrayPerson;
    }
    
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        
        modelo.createPersons();
        for (Person i : modelo.getArrayPerson()) {
            System.out.println(i);
        }
    }
    
    public void registrarPersona() {
        String name = JOptionPane.showInputDialog("Digite nombre:");
        String lastName = JOptionPane.showInputDialog("Digite apellido:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Digite edad"));
        
        persons.add(new Person(name, lastName, age));
    }
    
}
