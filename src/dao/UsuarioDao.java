package dao;

import database.ConFactory;
import model.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao() throws SQLException, IOException, ClassNotFoundException {
        connection = new ConFactory().getConnection();
    }
    public boolean salvar(Usuario usuario) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("INSERT INTO usuario (email, senha) VALUES (?,?)");
        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getSenha());
        return statement.executeUpdate()>0;
    }

}
