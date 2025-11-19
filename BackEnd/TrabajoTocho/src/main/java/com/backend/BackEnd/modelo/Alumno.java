package com.backend.BackEnd.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private double desarrolloInterfaces;

    @Column
    private double programacionMultimedia;

    @Column
    private double programacionServicios;

    @Column
    private double accesoDatos;

    @Column
    private double SistemaGestion;

    @Column
    private double empresaIniciativa;

    @Column
    private double ingles;


    public Alumno(){

    }

    public Alumno(String nombre, String apellido, double desarrolloInterfaces, double programacionMultimedia, double programacionServicios, double accesoDatos, double sistemaGestion, double empresaIniciativa, double ingles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.desarrolloInterfaces = desarrolloInterfaces;
        this.programacionMultimedia = programacionMultimedia;
        this.programacionServicios = programacionServicios;
        this.accesoDatos = accesoDatos;
        SistemaGestion = sistemaGestion;
        this.empresaIniciativa = empresaIniciativa;
        this.ingles = ingles;
    }


    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getDesarrolloInterfaces() {
        return desarrolloInterfaces;
    }

    public void setDesarrolloInterfaces(double desarrolloInterfaces) {
        this.desarrolloInterfaces = desarrolloInterfaces;
    }

    public double getProgramacionMultimedia() {
        return programacionMultimedia;
    }

    public void setProgramacionMultimedia(double programacionMultimedia) {
        this.programacionMultimedia = programacionMultimedia;
    }

    public double getProgramacionServicios() {
        return programacionServicios;
    }

    public void setProgramacionServicios(double programacionServicios) {
        this.programacionServicios = programacionServicios;
    }

    public double getAccesoDatos() {
        return accesoDatos;
    }

    public void setAccesoDatos(double accesoDatos) {
        this.accesoDatos = accesoDatos;
    }

    public double getSistemaGestion() {
        return SistemaGestion;
    }

    public void setSistemaGestion(double sistemaGestion) {
        SistemaGestion = sistemaGestion;
    }

    public double getEmpresaIniciativa() {
        return empresaIniciativa;
    }

    public void setEmpresaIniciativa(double empresaIniciativa) {
        this.empresaIniciativa = empresaIniciativa;
    }

    public double getIngles() {
        return ingles;
    }

    public void setIngles(double ingles) {
        this.ingles = ingles;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "uuid=" + uuid +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", desarrolloInterfaces=" + desarrolloInterfaces +
                ", programacionMultimedia=" + programacionMultimedia +
                ", programacionServicios=" + programacionServicios +
                ", accesoDatos=" + accesoDatos +
                ", SistemaGestion=" + SistemaGestion +
                ", empresaIniciativa=" + empresaIniciativa +
                ", ingles=" + ingles +
                '}';
    }
}
