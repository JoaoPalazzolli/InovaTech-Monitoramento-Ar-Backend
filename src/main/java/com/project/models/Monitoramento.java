package com.project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "monitoramento")
public class Monitoramento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String temperatura;
    @Column(nullable = false)
    private String umidade;
    @Column(nullable = false)
    private boolean fumaca;
    @Column(name = "data_monitoramento")
    @Builder.Default private final Date dataMonitoramento = new Date();
}
