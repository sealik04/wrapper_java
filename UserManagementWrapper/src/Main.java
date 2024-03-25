import java.sql.*;
import java.util.Scanner;
import Db.Query;
import Db.Database;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database;

        try {
            database = new Database("uzivatele", "root", "");

            while (true) {
                System.out.println("vyber akci:");
                System.out.println("1 - vložit uživatele");
                System.out.println("2 - upravit uživatele");
                System.out.println("3 - pdstranit uživatele");
                System.out.println("4 - zobrazit uživatele");
                System.out.println("5 - konec");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("---VLOŽIT NOVÉHO UŽIVATELE---");
                        System.out.println("zadej jméno:");
                        String name = scanner.nextLine();
                        System.out.println("zadej příjmení:");
                        String surname = scanner.nextLine();
                        System.out.println("zadej bydliště:");
                        String housing = scanner.nextLine();
                        int id = 0;

                        try {
                            int result = database.insert("swag", new Object[]{name, surname, housing, id});
                            System.out.println("uživatel vložen");
                        } catch (SQLException e) {
                            System.out.println("error: " + e.getMessage());
                        }
                    case 2:
                        System.out.println("---ÚPRAVA UŽIVATELE---");
                        System.out.println("zadej id uživatele:");
                        int editId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("co chceš upravit?");
                        System.out.println("1 - jméno");
                        System.out.println("2 - příjmení");
                        System.out.println("3 - bydliště");

                        int editChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (editChoice) {
                            case 1:
                                System.out.println("zadej nové jméno:");
                                String newName = scanner.nextLine();
                                database.update("swag", new String[]{"jmeno"}, "id=?", new Object[]{newName, editId});
                                break;
                            case 2:
                                System.out.println("zadej nové příjmení:");
                                String newSurname = scanner.nextLine();
                                database.update("swag", new String[]{"prijmeni"}, "id=?", new Object[]{newSurname, editId});
                                break;
                            case 3:
                                System.out.println("zadej nové bydliště:");
                                String newHousing = scanner.nextLine();
                                database.update("swag", new String[]{"bydliste"}, "id=?", new Object[]{newHousing, editId});
                                break;
                            default:
                                System.out.println("invalid choice");
                        }
                        break;

                    case 3:
                        System.out.println("---ODSTRANĚNÍ UŽIVATELE---");
                        System.out.println("zadej id uživatele, kterého chcete odstranit:");
                        int deleteId = scanner.nextInt();
                        database.delete("swag", "id=?", new Object[]{deleteId});
                        System.out.println("uživatel byl odstraněn");
                        break;

                    case 4:
                        System.out.println("---ZOBRAZENÍ UŽIVATELŮ---");
                        try {
                            ResultSet resultSet = database.select("seznam", new Object[]{ "jmeno", "prijmeni", "bydliste", "id"}, null, null);
                            while (resultSet.next()) {
                                int ids = resultSet.getInt("id");
                                String names = resultSet.getString("jmeno");
                                String surnames = resultSet.getString("prijmeni");
                                String housings = resultSet.getString("bydliste");

                                System.out.println("id: " + ids + ", jmeno: " + names + ", prijmeni: " + surnames + ", bydliste: " + housings);
                            }
                        } catch (SQLException e) {
                            System.out.println("error: " + e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("konec");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("invalid choice");
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println("db error: " + e.getMessage());
        }
    }
