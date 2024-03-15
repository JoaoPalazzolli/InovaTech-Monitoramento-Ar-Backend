package com.project.Controller;

import com.project.services.MonitoramentoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/monitoramento")
public class MonitoramentoController extends HttpServlet {

    private final MonitoramentoService monitoramentoService = new MonitoramentoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        monitoramentoService.findAll(req, resp);
    }
}
