/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author AlumMati
 */
public class Contactos implements Serializable, Comparable<Contactos> {

    private String nombre;
    private String direccion;
    private int telefono;
    private Date fnacimiento;
    private String notas;

    public Contactos() {
    }

    ;
    public Contactos(String n, String d, int t, String fn, String not) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        nombre = n;
        direccion = d;
        telefono = t;
        fnacimiento = formato.parse(fn);
        notas = not;
    }

    public int compareTo(Contactos c1, Contactos c2) {
       return c1.getNombre().compareTo(c2.getNombre());

    }

    @Override
    public String toString() {

        Calendar calen = new GregorianCalendar();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        return ("\n Nombre: " + nombre
                + "\n Dirección: " + direccion
                + "\n Teléfono: " + telefono
                + "\n F. Nacim.: " + formato.format(fnacimiento)
                + "\n Notas: " + notas);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the fnacimiento
     */
    public Date getFnacimiento() {
        return fnacimiento;
    }

    /**
     * @param fnacimiento the fnacimiento to set
     */
    /*public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }*/
    /**
     * @return the notas
     */
    public String getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public int compareTo(Contactos o) {


        
        int resultado = this.nombre.compareToIgnoreCase(o.getNombre());
        
            if(resultado == 0){
                resultado = this.fnacimiento.compareTo(o.getFnacimiento());
            }
                return resultado;
      
    }

}
