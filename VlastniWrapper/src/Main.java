import Db.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        /*try {
            Database database = new Database("lidi", "root", "");
            String [] columns = {"jmeno"};
            Object [] params = {"Novotný"};
            ResultSet rs = database.select("lidicky", columns, "prijmeni=?", params);

            while(rs.next()){
                System.out.println(rs.getString("jmeno"));
            }

        } catch (SQLException ex){
            System.out.println("error: " + ex.getMessage());
        }

      try {
          Database database = new Database("lidi", "root", "");
          String [] columns = {"jmeno", "prijmeni"};
          Object [] params = {"Pepa", "Nový", 1};
          int uspech3 = database.update("lidicky", columns, "id=?", params);
          System.out.println(uspech3);
      } catch (SQLException ex){
          System.out.println("error: " + ex.getMessage());
      }

        try {
            Database database = new Database("lidi", "root", "");
            Object[] data = {"Sona"};
            int uspech2 = database.delete("lidicky", "jmeno=?", data);
            System.out.println(uspech2);
        } catch (SQLException ex){
            System.out.println("error: " + ex.getMessage());
        }

        /*try{
            Database database = new Database("lidi", "root", "");
            Object[] data = {"František", "Novotný", 27};
            int uspech1 = database.insert("lidicky", data);
            System.out.println(uspech1);
        } catch (SQLException ex){

        }*/

        /*Query query = new Query();

        query.delete("zaci").where("jmeno=?");
        System.out.println(query.getQuery());

        String [] columns1 = {"jmeno", "mesto"};
        query.update("zaci").set(columns1).where("id = ?");
        System.out.println(query.getQuery());

        Object[] param1 = { null, "Degeš", 8, "Přerov"};
        query.insert("zaci").values(param1);
        System.out.println(query.getQuery());

        query.select(null).from("zaci").where("mesto=?");
        System.out.println(query.getQuery());*/
    }
}