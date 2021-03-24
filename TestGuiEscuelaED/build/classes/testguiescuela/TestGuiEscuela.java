/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testguiescuela;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * En este proyecto creamos una interfaz gráfica donde podemos matricular, insertar y borrar alumnos de un Instituto
 *@version 18/03/2021/A
 * @author Alba María Megías Guerrero
 */
public class TestGuiEscuela {
      
    /**
    * {@value #subjects} Matríz de dos dimensiones que contiene el listado de asignaturas.
    */ 
    static final String[][] subjects = new String[][]{{"Matemáticas","Lengua","Informática"}
                                                            ,{"Historia","Química","Geografía","Física"}
                                                            ,{"Latín","Griego","Literatura"}
                                                            };
    
    private static Alumno student;
    
    
    /**
     * Constructor de la clase TestGuiEscuela pasamos por parámetro un ArrayList de estudiantes.
     * @param students ArrayList que contiene una lista de estudiantes
     */
    public TestGuiEscuela(ArrayList<Alumno> students){
        Alumnos.insertStudents(students);
        
        new Ventana();
    }
    
    /**
     * Main de la aplicación donde instanciamos alumnos y los añadimos al ArrayList de estudiantes.
     * @param args ejecuta el programa instanciando alumnos 
     */
    public static void main(String[] args) {
        
        ArrayList<Alumno> students = new ArrayList<>(); 
        students.add(new Alumno("Alba", 1, "18542148W", LocalDate.of(1992, 05, 11)));
        
        students.add(new Alumno("Darío", 2, "78235412L", LocalDate.of(1997, 8, 10)));
        
        students.add(new Alumno("Teresa", 1, "77812364Ñ", LocalDate.of(1950, 03, 20)));
        
        students.add(new Alumno("Lolita", 2, "12654789P", LocalDate.of(1950, 03, 20)));

        
        new TestGuiEscuela(students);
  
    }
   
  
}
