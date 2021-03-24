/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testguiescuela;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Comparable --> orden natural y MEtodo compareTo, un solo parámetro
// Comparator --> orden especial MEtodo compare, este método necesita dos parámetros
/**
 * En esta clase trabajamos con los alumnos
 * @author Alba María Megías Guerrero
 * @see java.io.Serializable
 * @serial Indicamos que la clase alumno implemente de Serializable
 */
public class Alumnos implements Serializable {
    
    /**
     * Creamos una lista de alumnos
     */
    private static ArrayList<Alumno> studentsList = new ArrayList();
    
    /**
     * Creamos una clase interna donde implementamos los métodos de la Interface Serializable.
     */
    static class OrderByDni implements Comparator<Alumno>{

        /**
         * Método que duvuelve los alumnos ordenados por dni
         * @param a1 Primer alumno introducido por parámetro.
         * @param a2 Segundo alumno intriducido por parámetro.
         * @return Devuelve los dni de los alumnos ordenados de menor a mayor.
         */
        @Override
        public int compare(Alumno a1, Alumno a2){
            return a1.getDni().compareToIgnoreCase(a2.getDni());
        }
    }
 
    /**
     * Método para insertar un alumno
     * @param student insertamos un estudiante en la lista de alumnos.
     */
    public static void insertStudent(Alumno student){
       studentsList.add(student);    
    } 
    
    /**
     * Método para borrar un estudiante de la lista de alumnos
     * @param student Estudiante que queremos eliminar.
     * @return Devuelve la lista de estudiantes con el alumno pasado por parámetro eliminado.
     */
    public static boolean deleteStudent(Alumno student){
        return studentsList.remove(student);
    }
    
    /**
     * Método que recibe un ArrayList de estudiantes
     * @param students Recibe un ArrayList con todos los estudiantes
     * y los inserta uno a uno en la lista de estudiantes.
     */
    public static void insertStudents(ArrayList<Alumno> students){
        for (Alumno student : students) {
            insertStudent(student);
        }
    }
    
    /**
     * Método que devuelve el alumno que se encuentra en el índice pasado por parámetro
     * @param index pasamos por parámetro una posición o índice.
     * @return nos devuelve el alumno que se encuentra en esa posición en la lista de estudiantes.
     */
    public static Alumno getStudent(int index){
        return studentsList.get(index);
    }
    
    /**
     * Método que devuelve el tamaño de la lista de estudiantes
     * @return nos devuelve el tamaño de la lista de estudiantes.
     */
    public static int getSize(){
        return studentsList.size();
    }
    /**
     * Comprobamos que la lista de estudiantes está vacía
     * @return devuelve : <ul>
     *                        <li>True si la lista de estudiantes está vacía</li>
     *                    </ul>
     */
    public static boolean isStudentsListEmpty(){
        if(studentsList.isEmpty()){
        }
        return true;
    }
    
    /**
     * Ordena al estudiante por dni.
     */
    public static void OrderStudentByDni(){
        studentsList.sort(new OrderByDni());
    }
    /**
     * Ordena al estudiante por nombre.
     */
    public static void orderStudentByName(){
        studentsList.sort(null);
    }
    
    
    
}
