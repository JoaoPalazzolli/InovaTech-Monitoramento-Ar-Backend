package com.project.services;

import com.google.gson.Gson;
import com.project.dto.MonitoramentoDTO;
import com.project.mapper.Mapper;
import com.project.models.Monitoramento;
import com.project.repositories.MonitoramentoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
public class MonitoramentoService {

    private final Gson gson = new Gson();

    private final MonitoramentoRepository monitoramentoRepository = new MonitoramentoRepository();

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("application/json");

        var monitoramentos = Mapper.parseListObject(monitoramentoRepository.findAll(), MonitoramentoDTO.class);

        var toJson = gson.toJson(monitoramentos);

        resp.getWriter().append(toJson);
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var monitoramento = gson.fromJson(req.getReader(), Monitoramento.class);

        monitoramentoRepository.save(monitoramento);

        resp.setStatus(201);
        resp.setContentType("application/json");
    }

}
