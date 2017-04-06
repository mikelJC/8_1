/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author AlumMati
 */
public class Agenda {

    ArrayList<Contactos> aContactos = new ArrayList<Contactos>();
    BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));

    public void añadircontacto() throws ParseException {
        try {
            String n;
            String d;
            int t;
            String f;
            String nt;
            System.out.println("Introduce nombre");
            n = tec.readLine();
            System.out.println("Introduce dirección");
            d = tec.readLine();
            System.out.println("Introduce teléfono");
            t = Integer.parseInt(tec.readLine());
            System.out.println("Introduce Fecha nacimiento");
            f = tec.readLine();
            System.out.println("Introduce notas");
            nt = tec.readLine();

            Contactos contacto = new Contactos(n, d, t, f, nt);

            aContactos.add(contacto);

        } catch (IOException ex) {
            System.err.println("error de entrada" + ex.getMessage());
        }
    }

    ;
    public void eliminarcontacto() {

        try {
            int posicion = 1;
            String nombre;
            System.out.println("Introduce nombre del contacto a eliminar");
            nombre = tec.readLine();

            ArrayList<Integer> aIndexBorrados = new ArrayList<Integer>();

            for (int i = 0; i < aContactos.size(); i++) {

                if (aContactos.get(i).getNombre().equalsIgnoreCase(nombre)) {

                    System.out.println(posicion + ".");
                    System.out.println(aContactos.get(i));

                    aIndexBorrados.add(i);
                    posicion++;
                }
            }

            System.out.println("HEMOS LLEGADO");

            System.out.println("\nSeleccione el numero a borrar");
            int borrar;
            borrar = Integer.parseInt(tec.readLine());

            System.out.println("borrar vale " + borrar);

            borrar = borrar - 1;
            int var2 = aIndexBorrados.get(borrar);

            aContactos.remove(var2);

        } catch (IOException ex) {
            System.err.println("error de entrada" + ex.getMessage());
        }

    }

    ;
    public void busqueda() throws IOException {
        int posicion = 1;
        String nombre;
        System.out.println("Introduce nombre del contacto");
        nombre = tec.readLine();

        for (int i = 0; i < aContactos.size(); i++) {

            if (aContactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(posicion + ".");
                System.out.println(aContactos.get(i));
                posicion++;
            }
        }

    }

    ;
    public void consulta() throws IOException {

    }

    ;
    public void mostraragenda() {

        Collections.sort(aContactos);


        for (int i = 0; i < aContactos.size(); i++) {
            System.out.println(aContactos.get(i));
        }

    }

    public void añadir(Contactos e) {
        aContactos.add(e);
    }

    public void leerfichero() throws IOException, ClassNotFoundException, FileNotFoundException {

        File f = new File("contactos.txt");

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        aContactos = (ArrayList<Contactos>) ois.readObject();

        fis.close();

    }

    public void guardarfichero() throws IOException, ClassNotFoundException {

        File f = new File("contactos.txt");

        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(aContactos);

        fos.close();
    }

    public void mostrarcumpleaños() throws ParseException {

        Calendar calendario = new GregorianCalendar();

        Date fechaactual = new Date();
        Date fechanacimiento = new Date();
        //fechaactual = calendario.getTime();

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");

        int contador = 0;

        for (int i = 0; i < aContactos.size(); i++) {
            fechanacimiento = aContactos.get(i).getFnacimiento();

            int resultado = añosEntreFechas(fechanacimiento, fechaactual);

            if (resultado == -1) {
                contador++;
            } else {
                System.out.println(aContactos.get(i).getNombre() + " es su " + resultado + "º" + "Cuempleaños");
            }
        }

        if (contador == aContactos.size()) {
            System.out.println("No cumple nadie");
        }

    }

    static int añosEntreFechas(Date fechaInicial, Date fechaFinal) {
        Calendar cIni = new GregorianCalendar();
        cIni.setTime(fechaInicial);
        Calendar cFin = new GregorianCalendar();
        cFin.setTime(fechaFinal);

        int nocumple = -1;

        if ((cFin.get(Calendar.MONTH) == cIni.get(Calendar.MONTH)) && (cFin.get(Calendar.DAY_OF_MONTH) == cIni.get(Calendar.DAY_OF_MONTH))) {
            return cFin.get(Calendar.YEAR) - cIni.get(Calendar.YEAR); //devuelve años de diferencia
        } else {
            return nocumple; //
        }
    }

}
