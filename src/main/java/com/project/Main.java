package com.project;

import com.project.configs.AmbienteDBConfig;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AmbienteDBConfig.openConnection();
        AmbienteDBConfig.gerarTabelasDB();
    }
}