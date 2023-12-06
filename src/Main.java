import database.ConFactory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConFactory conFactory = new ConFactory();
        try {
            if(conFactory.getConnection()!=null){
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}