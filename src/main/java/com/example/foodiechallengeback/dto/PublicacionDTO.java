package com.example.foodiechallengeback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PublicacionDTO {

    private Long id;

    private String contenido;

    private Long idSeccionForo;

    private String nombreSeccionForo;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date fecha;

    private String adjunto;

    private String adjuntoBlob;
}
