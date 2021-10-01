package com.pruebaf1.prueba.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @Column(name = "codigo_ciudad")
    private int codigoCiudad;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    @Column(name = "usuario_registro")
    private String usuarioRegistro;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;



    public Ciudad() {
    }

    public Ciudad(int codigoCiudad, String nombreCiudad,
                  String usuarioRegistro, Date fechaRegistro) {
        this.codigoCiudad = codigoCiudad;
        this.nombreCiudad = nombreCiudad;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
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
