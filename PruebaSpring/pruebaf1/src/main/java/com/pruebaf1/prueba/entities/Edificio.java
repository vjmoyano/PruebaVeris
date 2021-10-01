package com.pruebaf1.prueba.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "edificio")
public class Edificio {
    public Edificio() {
    }

    @Id
    @Column(name = "codigo_edificio")
    private int codigoEdificio;

    @Column(name = "nombre_edificio")
    private String nombreEdificio;

    @Column(name = "codigo_ciudad")
    private int codigoCiudad;

    @Column(name = "usuario_registro")
    private String usuarioRegistro;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_ciudad", referencedColumnName = "codigo_ciudad",
            insertable = false, updatable = false)
    private Ciudad ciudad;

    public Edificio(int codigoEdificio, String nombreEdificio,
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
}
