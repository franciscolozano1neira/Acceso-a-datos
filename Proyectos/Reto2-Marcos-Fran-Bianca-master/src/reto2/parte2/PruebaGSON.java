package reto2.parte2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class PruebaGSON {

    public static void main(String[] args) {
        //Declaramos un bloque try para lanzar los escritores, lectores y demas variables que sueltan errores
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("libro2.json")));
             BufferedReader br = new BufferedReader(new FileReader(new File("libro2.json")));) {

            Libro elquijote = new Libro("El Quijote","Miguel de Cervantes","Nisu",233,1605);
            Libro elproblemadelostrescuerpos = new Libro("El problema de los tres cuerpos","Cixin Liu","Nova",350,2021);
            // Declaramos la variable gson de la clase Gson que usaremos para serializar los objetos a json
            // y para deserializarlos
            Gson gson = new Gson();
            // Creamos las listas de Libros
            List misLibros = new ArrayList<Libro>();
            List misLibros2;
            // Añadimos los Libros a la lista
            misLibros.add(elquijote);
            misLibros.add(elproblemadelostrescuerpos);
            // Creamos la variable json y en ella metemos el resultado de posar a json la lista de libros
            String json = gson.toJson(misLibros);
            System.out.println("JSON generado:\n"+json);
            //Escribimos en el archivo
            bw.write(json);
            bw.close();
            // Leemos el archivo
            String linea = br.readLine();
            System.out.println("\nLinea leida:"+linea);
            // Usamos el TypeToken para saber que tipo de lista estamos usando y se lo pasamos al metodo
            // fromJson, ademas de pasarle tambien la linea y lo parseamos a una lista
            Type tipoLista = new TypeToken<List<Libro>>(){}.getType();
            misLibros2 = (List<Libro>) gson.fromJson(linea,tipoLista);
            // Mostramos la lista leida
            System.out.println("\nLibros como objetos leidos:\n"+misLibros2.toString().replaceAll("\\]\\[","\n"));

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
