package com.project.Controller;

import com.project.services.MonitoramentoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "monitoramento", value = {"/monitoramento", "/monitoramento/last", "/monitoramento/currentday"})
public class MonitoramentoController extends HttpServlet {

    private final MonitoramentoService monitoramentoService = new MonitoramentoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().contains("last")){
            monitoramentoService.findLastMonitoramento(req, resp);
        } else if (req.getRequestURI().contains("currentday")) {
            monitoramentoService.findMonitoramentoCurrentDay(req, resp);
        } else {
            monitoramentoService.findAll(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        monitoramentoService.create(req, resp);
    }
}
