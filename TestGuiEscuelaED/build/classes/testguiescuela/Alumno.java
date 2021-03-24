/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testguiescuela;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


//Comparable alumno porque comparo un Alumno con otro
/**
 * Trabajamos con los datos de un alumno, implementamos la interfaz Comparable y serializamos el alumno
 * @serial   serializamos la clase alumno y su contenido.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html"></a>
 * @author Alba María Megías Guerrero
 * @see java.io.Serializable
 */



public class Alumno implements Comparable<Alumno>, Serializable  {
    private String dni;
    private int course;
    private String name;
    private LocalDate birthday;
   
    private ArrayList<String> enrolledSubjects = new ArrayList<String>();
    
    /**
     * Constructor de la clase Alumno
     * @param name Nombre del alumno.
     * @param course Curso actual del alumno.
     * @param dni Dni actual del alumno.
     * @param birthday Fecha de nacimiento del alumno.
     */
    public Alumno(String name, int course, String dni, LocalDate birthday){
        this.name = name;
        this.dni = dni;
        this.setCourse(course);
        this.birthday = birthday;
        
    }

    
    /**
     * Devuelve el dni del alumno
     * @return Nos devuelve el dni del alumno. 
     */
    public String getDni() {
        return dni;
    }

    /**
     * Asignamos un dni al alumno
     * @param dni Asignamos un dni al alumno.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtenemos el curso alctual del alumno
     * @return Devuelve el curso actual del alumno.
     */
    public int getCourse() {
        return course;
    }

    /**
     * Asignamos un curso al alumno
     * @param course Asignamos un curso al alumno.
     */
    public void setCourse(int course) {
        this.course = course;
    }
    
    /**
     * Obtenemos el nombre del alumno
     * @return  Devuelve el nombre del alumno.
     */
    public String getName() {
        return name;
    }

    /**
     * Asignamos un nombre al alumno
     * @param name Asignamos un nombre al alumno.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtenemos la fecha de nacimiento del alumno
     * @return Devuelve la fecha de nacimiento del alumno.
     */
    public LocalDate getBirthdate() {
        return birthday;
    }

    /**
     * Asignamos una fecha de nacimiento al alumno
     * @param birthday Asignamos una fecha de nacimiento al alumno.
     */
    public void setBirthdate(LocalDate birthday) {
        this.birthday = birthday;
    }

    
    //Comparable permite comparar una instanciaa con otra
    //estos métodos que comparan me decuelven enteros
    /**
     * Implementamos el método compareTo
     * @param o Compara un alumno con otro y lo ordena alfabéticamente.
     * @return Devuelve el alumno ordenado de forma alfabéticamente.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html"></a> 
     */
    @Override
    public int compareTo(Alumno o){
        return this.getName().compareToIgnoreCase(o.getName());
        //return this.name.compareToIgnoreCase(o.getName());

    }
   
    /**
     * Devolvemos las asignaturas matriculadas del alumno
     * @return Devuelve las asignaturas en las que está matriculado el alumno.
     */
    //método de instancia
    public ArrayList<String> getEnrolledSubjects(){
        return enrolledSubjects;
    }
    
    /**
     * Añadimos una asignatura a la lista de matriculaciones
     * @param subject Añade la asignatura nueva a la lista de asignaturas matriculadas.
     */
    //añadir las asignaturas en las que se encuentra matriculado
    public void setEnrolledSubject(String subject){
        this.enrolledSubjects.add(subject);
    }
    
}
