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

        var monitoramentosDTO = Mapper.parseListObject(monitoramentoRepository.findAll(), MonitoramentoDTO.class);

        var toJson = gson.toJson(monitoramentosDTO);

        resp.getWriter().append(toJson);
    }

    public void findLastMonitoramento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("application/json");

        var monitoramentoDTO = Mapper.parseObject(monitoramentoRepository.findLastMonitoramento().orElseThrow(), MonitoramentoDTO.class);

        var toJson = gson.toJson(monitoramentoDTO);

        resp.getWriter().append(toJson);
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var monitoramento = gson.fromJson(req.getReader(), Monitoramento.class);

        monitoramentoRepository.save(monitoramento);

        var toJson = gson.toJson(Mapper.parseObject(monitoramento, MonitoramentoDTO.class));

        resp.getWriter().append(toJson);
        resp.setStatus(201);
        resp.setContentType("application/json");
    }

}
