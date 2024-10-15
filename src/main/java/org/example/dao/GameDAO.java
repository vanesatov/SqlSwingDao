package org.example.dao;

import org.example.JdbcUtil;
import org.example.models.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements DAO<Game> {


    @Override
    public List<Game> findAll() {

        var salida = new ArrayList<Game>();

        //Consulta a la base de datos
        try {
            var st = JdbcUtil.getConnection().createStatement();
            // Ejecución de una consulta
            ResultSet rs = st.executeQuery("SELECT * FROM games");



            while (rs.next()) {
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setTitle(rs.getString("title"));
                game.setPlatform(rs.getString("platform"));
                game.setYear(rs.getInt("year"));
                game.setDescription(rs.getString("description"));
                salida.add(game);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }
}
