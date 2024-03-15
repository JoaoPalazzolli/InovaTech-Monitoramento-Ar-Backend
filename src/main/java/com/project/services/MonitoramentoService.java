package com.project.services;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
public class MonitoramentoService {

    private final Gson gson = new Gson();

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(202);
        resp.setContentType("application/json");

        resp.getWriter().append("Teste");
    }
}
