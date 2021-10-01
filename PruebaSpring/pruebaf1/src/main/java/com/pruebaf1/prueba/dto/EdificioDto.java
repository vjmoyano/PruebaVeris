package com.pruebaf1.prueba.dto;

import java.sql.Date;

public class EdificioDto {
    private int codigoEdificio;

    private String nombreEdificio;

    private int codigoCiudad;

    private String usuarioRegistro;

    private Date fechaRegistro;

    public EdificioDto(int codigoEdificio, String nombreEdificio,
                       int codigoCiudad, String usuarioRegistro,
                       Date fechaRegistro) {
        this.codigoEdificio = codigoEdificio;
        this.nombreEdificio = nombreEdificio;
        this.codigoCiudad = codigoCiudad;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public int getCodigoEdificio() {
        return codigoEdificio;
    }

    public void setCodigoEdificio(int codigoEdificio) {
        this.codigoEdificio = codigoEdificio;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EdificioDto() {
    }
}
