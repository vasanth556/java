import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class studentinfo{
         private static final String url="jdbc:mysql://localhost:3306/student";
         private static final String user="root";
         private static final String password="mysql123";


         public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
           try{
            Connection con=DriverManager.getConnection(url, user, password);
            System.out.println("connected to database");
            while(true){
                System.out.println("enter the choice to perform :");
                System.out.println("1.create \n 2.select \n 3.update\n4.delete");
                int choice=sc.nextInt();
                switch(choice){
                    case 1:
                         addstudent(con , sc);
                        break;
                    case 2:
                        selectstudent(con ,sc );
                        break;
                    case 3:
                        updatestudent(con,sc);
                        break;
                    case 4:
                       deletestudent(con,sc);
                       break;
                    default:
                       System.out.println("enter the valid number");

                }
            }
            
           }
           catch(Exception e){
            e.printStackTrace();
        }
          
         }
         private static void addstudent(Connection con,Scanner sc)throws SQLException{
            System.out.println("enter the student id:");
            int id =sc.nextInt();
            sc.nextLine();
            System.out.println("enter the student name:");
            String name=sc.nextLine();
            System.out.println("enter the student age:");
            int age=sc.nextInt();

            String str="insert into studentinfo values(?,?,?)";
            PreparedStatement pst=con.prepareStatement(str);
            pst.setInt(1,id);
            pst.setString(2, name);
            pst.setInt(3,age);
            pst.executeUpdate();
            System.out.println("values inserted succesfully!");
         }
         private static void selectstudent(Connection con,Scanner sc)throws SQLException{
          
            String str="select * from studentinfo";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(str);
           while (rs.next()){
             System.out.println(rs.getInt("id") + rs.getString("name")+rs.getInt("age"));
           }
           System.out.println("values are viewed successfully!");
         }
         private static void updatestudent(Connection con,Scanner sc)throws SQLException{
            System.out.println("enter the student id:");
            int id =sc.nextInt();
            sc.nextLine();
            System.out.println("enter the student name:");
            String name=sc.nextLine();
            System.out.println("enter the student age:");
            int age=sc.nextInt();

            String str="update studentinfo set name=?,age=? where id=? ";
            PreparedStatement pst=con.prepareStatement(str);
            pst.setInt(1,id);
            pst.setString(2, name);
            pst.setInt(3,age);
            pst.executeUpdate();
            System.out.println("values are updated successfully!");
         }
         private static void deletestudent(Connection con,Scanner sc)throws SQLException{
            System.out.println("enter the student id:");
            int id =sc.nextInt();
            String str="delete from studentinfo where id=? ";
            PreparedStatement pst=con.prepareStatement(str);
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("values are deleted succesfully!");
         }


}