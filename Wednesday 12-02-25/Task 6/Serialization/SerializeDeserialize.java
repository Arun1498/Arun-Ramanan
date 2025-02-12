package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDeserialize {
        public static void main(String[] args) {
            Employee emp = new Employee(101, "Arun", "Arun@gmail.com");
            try {
                FileOutputStream fileOut = new FileOutputStream("employee.txt");
                ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
                objOut.writeObject(emp);
                objOut.close();
                FileInputStream fis = new FileInputStream("employee.txt");
                ObjectInputStream objIn = new ObjectInputStream(fis);
                Employee deserializedEmp = (Employee) objIn.readObject();
                objIn.close();
                System.out.println("Eno: " + deserializedEmp.eno);
                System.out.println("Ename: " + deserializedEmp.name);
                System.out.println("Email: " + deserializedEmp.email);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



