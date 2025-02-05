import java.util.ArrayList;
import java.util.Scanner;

public class menu {
    static Scanner in=new Scanner(System.in);
    static ArrayList<Student> list=new ArrayList<>();
    public static void main(String[] args) {
        int id=4;
        list.add(new Student(0,"Arun","arun@gmail.com","0912873465"));
        list.add(new Student(1,"Hariharan","Hariharan21404@gmail.com","978645312"));
        list.add(new Student(2,"Gowtham","Gowtham@gmail.com","978645311"));
        list.add(new Student(3,"Amudesh","Amudesh@gmail.com","978645313"));

        boolean exit=true;
        while (exit)
        {
            menu();
            System.out.println("Enter the choice");
            int ch=in.nextInt();
            switch (ch)
            {
                case 1:
                    Student s=null;
                    boolean exit2=true;
                    while (s==null && exit2)
                    {
                        s =checkprofile();
                        if (s == null)
                            exit2 = retrymenu();
                    }
                    if (s!=null)
                        checkprofile(s);
                    break;

                case 2:
                    addprofile(id);
                    id++;
                    break;
                case 3:
                    exit=false;
            }

        }
    }
    public static void menu()
    {
        System.out.println("Menu");
        System.out.println("1.Change Profile");
        System.out.println("2.Add Profile");
        System.out.println("3.Exit");
    }
    public static Student checkprofile()
    {
        System.out.println("Enter email:");
        String email=in.next();
        System.out.println("Enter Id");
        int id=in.nextInt();
        for (Student s:list)
        {
            if(s.checkemail(email) && s.checkid(id))
            {
                return s;
            }
        }
        System.out.println("Invalid login");
        return null;
    }
    public static boolean retrymenu() {
        while (true) {
            System.out.println("Do you want to retry(Yes/No)");
            String yon=in.next();
            if (yon.equals("Yes"))
                return true;
            else if (yon.equals("No"))
                return false;
            else
                System.out.println("Invalid command");
        }
    }
    public static void checkprofile(Student s)
    {
        s.display();
        System.out.println("what would you like to change");
        boolean exit=true;
        while (exit)
        {
            System.out.println("1.Name");
            System.out.println("2.Email");
            System.out.println("3.phone no");
            System.out.println("4.Finish changes");
            Byte ch=in.nextByte();
            switch(ch)
            {
                case 1:
                    System.out.println("Enter new name:");
                    in.nextLine();
                    s.setName(in.nextLine());
                    break;
                case 2:
                    System.out.println("Enter email:");
                    in.nextLine();
                    s.setEmail(in.nextLine());
                    break;
                case 3:
                    System.out.println("Enter Phone no");
                    in.nextLine();
                    s.setPhno(in.nextLine());
                    break;
                case 4:
                    exit=false;
                    System.out.println("Saved succesfully");
                    s.display();
                    break;
                default:
                    System.out.println("Invaild input");
            }
        }
    }
    public static void addprofile(int id){
        System.out.println(("Name:"));
        String name=in.nextLine();
        System.out.println("Email:");
        String mail=in.nextLine();
        System.out.println("phno:");
        String phno=in.next();
        list.add(new Student(id,name,mail,phno));
        System.out.println("Id alloted is:"+id);
    }

}
