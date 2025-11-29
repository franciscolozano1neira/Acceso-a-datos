package reto2.parte2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import static java.lang.Integer.parseInt;

public class PruebaStleary {

    public static void main(String[] args) {
        //Declaramos un bloque try para lanzar los escritores, lectores y demas variables que sueltan errores
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("libro3.json")));
             BufferedReader br = new BufferedReader(new FileReader(new File("libro3.json")));) {

            Libro elquijote = new Libro("El Quijote","Miguel de Cervantes","Nisu",233,1605);
            Libro elproblemadelostrescuerpos = new Libro("El problema de los tres cuerpos","Cixin Liu","Nova",350,2021);
            // Declaramos la variable jsonArr de la clase JSONArray que usaremos para serializar los objetos a json
            JSONArray jsonArr = new JSONArray();
            // Creamos las listas de Libros
            List<Libro> misLibros = new ArrayList<Libro>();
            List<Libro> misLibros2 = new ArrayList<Libro>();
            // Añadimos los Libros a la lista
            misLibros.add(elquijote);
            misLibros.add(elproblemadelostrescuerpos);
            // Hacemos un forEach para recorrer la lista
            for(Libro l: misLibros){
                // Al recorrerla vamos metiendo en la variable jsonObj de la clase
                // JSONObject y los parametros con sus respectivos getters
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("titulo",l.getTitulo());
                jsonObj.put("autor",l.getAutor());
                jsonObj.put("editorial",l.getEditorial());
                jsonObj.put("pagina",l.getPagina());
                jsonObj.put("añoPublicacion",l.getAñoPublicacion());
                jsonArr.put(jsonObj);
            }
            // Creamos la variable json y en ella metemos el resultado de posar a json la lista de libros
            String json = jsonArr.toString();
            System.out.println("JSON generado:\n"+json);
            //Escribimos en el archivo
            bw.write(json);
            bw.close();
            // Leemos el archivo
            String linea = br.readLine();
            System.out.println("\nLinea leida:"+linea);
            // Creamos un nuevo JSONArray donde almacenaremos el contenido que lea el BufferedReader
            JSONArray jsonLeido = new JSONArray(linea);
            // Hacemos que el for recorra la linea entera que le estamos pasando
            for (int i = 0; i < jsonLeido.length(); i++){
                // Declaramos un obj por cada iteracion y mediante los setters le asignamos los valores que necesitemos
                // obteniendolos desde la clave que le pasamos con el optString (buca valores en la linea por la clave que le pases)
                JSONObject obj = jsonLeido.getJSONObject(i);
                Libro l = new Libro();
                l.setTitulo(obj.optString("titulo"));
                l.setAutor(obj.optString("autor"));
                l.setEditorial(obj.optString("editorial"));
                l.setPagina(parseInt(obj.optString("pagina")));
                l.setAñoPublicacion(parseInt(obj.optString("añoPublicacion")));
                misLibros2.add(l);

            }
            // Mostramos la lista leida
            System.out.println("\nLibros como objetos leidos:\n"+misLibros2.toString().replaceAll("\\]\\[","\n"));

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
