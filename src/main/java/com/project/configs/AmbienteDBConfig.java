package com.project.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class AmbienteDBConfig {

    private static final Logger logger = Logger.getLogger(AmbienteDBConfig.class.getName());

    private static Connection connection;

    public static Connection openConnection(){
        logger.info("Se conectando ao Banco de Dados");
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/monitoramentoar", "root", "admin");

            logger.info("Banco de Dados Conectado com Sucesso");
        } catch (SQLException e){
            logger.info("Erro ao se conectar ao Banco - Exception: " + e.getMessage());
        }

        return connection;
    }

    public static void gerarTabelasDB() throws SQLException {
        logger.info("Criando Tabelas no Banco de Dados");

        connection.createStatement().execute("CREATE TABLE if NOT EXISTS teste (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(255))");

        logger.info("Tabelas criadas com sucesso");
    }
}
