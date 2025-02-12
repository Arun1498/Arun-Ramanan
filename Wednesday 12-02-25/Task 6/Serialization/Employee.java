package Serialization;
import java.io.Serializable;

public class Employee implements Serializable {
    int eno;
    String name;
    transient String email;
    Employee(int eno,String name,String email){
        this.eno=eno;
        this.name=name;
        this.email=email;
    }
}

