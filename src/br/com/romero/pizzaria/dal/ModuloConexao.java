/**
 * @author Felipe Galvão
 * Pizzaria Romero - Sistema Desktop
 * Data de criação: 11/10/2020
 * Versão: v1
 */

/*  Esse arquivo é responsável pela comunicação com o banco de dados Mysql */

package br.com.romero.pizzaria.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModuloConexao {

    public static Connection conector() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbpizzaria";
        String user = "root";
        String password = "";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            // System.out.println(e);
            return null;
        }
    }
}
