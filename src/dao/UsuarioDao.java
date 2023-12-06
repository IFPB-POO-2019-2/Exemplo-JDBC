package dao;

import database.ConFactory;
import model.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Usuario buscarPorEmail(String email) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM usuario WHERE email=?");
        statement.setString(1, email);

        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            String senha = resultSet.getString("senha");
            return new Usuario(email, senha);
        }
        return null;
    }

}
