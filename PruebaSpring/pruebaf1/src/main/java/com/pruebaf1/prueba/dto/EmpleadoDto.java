package com.pruebaf1.prueba.dto;


import java.sql.Date;


public class EmpleadoDto {

    private String codigoEmpleado;

    private String tipoIdentificacion;

    private String numeroIdentificacion;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String nombreCompleto;

    private String mail;

    private String sexo;

    private Date fechaNacimiento;

    private String codigoEdificio;

    private String estado;

    private String usuarioRegistro;

    private Date fechaRegistro;

    public EmpleadoDto() {
        this.fechaRegistro = new Date(System.currentTimeMillis());
    }

    public EmpleadoDto(String codigoEmpleado, String tipoIdentificacion,
                       String numeroIdentificacion, String primerNombre,
                       String segundoNombre, String primerApellido,
                       String segundoApellido, String nombreCompleto, String mail,
                       String sexo, Date fechaNacimiento,
                       String codigoEdificio, String estado, String usuarioRegistro,
                       Date fechaRegistro) {
        this.codigoEmpleado = codigoEmpleado;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreCompleto = nombreCompleto;
        this.mail = mail;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.codigoEdificio = codigoEdificio;
        this.estado = estado;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = this.nombreCompleto();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCodigoEdificio() {
        return codigoEdificio;
    }

    public void setCodigoEdificio(String codigoEdificio) {
        this.codigoEdificio = codigoEdificio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String nombreCompleto() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.primerNombre+" ");

        if (this.segundoNombre != null) {
            sb.append(this.segundoNombre+" ");
        }
        sb.append(this.primerApellido);
        if (this.segundoApellido != null) {
            sb.append(this.segundoApellido+" ");
        }
        return sb.toString();
    }
}
