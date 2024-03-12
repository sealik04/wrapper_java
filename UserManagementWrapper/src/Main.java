import Db.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int action;
        boolean running = true;
        while (running){
        try{
            Database database = new Database("lidi", "root", "");
            Scanner sc = new Scanner(System.in);

            System.out.println("vyber akci, co chceš provést \n" +
                    "1 - vypsat uživatele \n" +
                    "2 - vložit uživatele \n" +
                    "3 - upravit uživatele \n" +
                    "4 - odebrat uživatele \n" +
                    "5 - ukončit apliakci");
            action = sc.nextInt();
            switch (action){
                case 1:
                    String column = sc.nextLine();
                    sc.nextLine();
                    String parameter = sc.nextLine();

                    String [] columns = {column};
                    Object [] params = {parameter};

                    System.out.println(columns);
                    System.out.println(params);

                    /*ResultSet rs = database.select("lidicky", columns, "prijmeni=?", params);

                    while(rs.next()){
                        System.out.println(rs.getString("jmeno"));
                    }*/
                    break;
            }
        }catch (SQLException ex){
            System.out.println("error: " + ex.getMessage());
            }
        }
    }
}