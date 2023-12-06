import dao.UsuarioDao;
import model.Usuario;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            UsuarioDao dao = new UsuarioDao();

//            if(dao.salvar(new Usuario("maria@gmail.com", "123456"))){
//                System.out.println("Salvo");
//            }else{
//                System.out.println("Falha");
//            }

//            System.out.println(dao.buscarPorEmail("joao@gmail.com"));

            System.out.println(dao.listarUsuarios());

        } catch (SQLException e) {
            System.out.println("Falha na operação do banco");
        } catch (IOException e) {
            System.out.println("Falha na leitura do arquivo de configurações");
        } catch (ClassNotFoundException e) {
            System.out.println("Falha no Driver");
        }

    }
}