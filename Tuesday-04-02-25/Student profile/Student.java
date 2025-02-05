



public class Student {
    private int id;
    private String name;
    private String email;
    private String phno;
    Student(int id,String name,String email,String phno)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phno=phno;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhno() {
        return phno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public boolean checkemail(String email) {
        return email.equals(this.email);
    }
    public boolean checkid(int id)
    {
        if (id==this.id)
            return true;
        return false;
    }
    public void display()
    {
        System.out.println("Student Id:"+id);
        System.out.println("Student Name:"+ name);
        System.out.println("Student email:"+ email);
        System.out.println("Student phno:"+phno);
    }

}