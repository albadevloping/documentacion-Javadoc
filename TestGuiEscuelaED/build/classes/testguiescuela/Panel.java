/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testguiescuela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


/**
 * En esta clase creamos el panel de nuestra aplicación
 * e incorporamos todas sus funcionalidades
 * @author Alba María Megías Guerrero
 * @see javax.swing.JPanel
 * @see java.awt.event.ActionListener
 */
public class Panel extends JPanel implements ActionListener {

    private JLabel nameLabel;
    private JTextField nameTextBox;
    
    private JLabel courseLabel;
    private JTextField courseTextBox;
    
    private JLabel dniLabel;
    private JTextField dniTextBox;
    
    private JLabel birthdayLabel;
    private JTextField birthdayTextBox;
    
    private JButton previousBtn;
    private JButton nextBtn;
    
    private JRadioButton orderRadioName;
    private JRadioButton orderRadioDni;
    
    private ButtonGroup buttonsGroup;
    
    private JButton updateStudentBtn;
    private JButton deleteStudentBtn;
    private JButton insertStudentBtn;
    
     
    private int currentStudentIndex = 0;
  
    
    private JButton enrollStudentBtn;
    private ArrayList<JCheckBox> subjectsCheckBox = new ArrayList<>();
    private ArrayList<JLabel> enrolledLabels = new ArrayList();
    private JLabel message;
    private JButton saveChangesBtn;
    private JPanel enrolledPanel;
    
    
    /**
     * Constructor de la clase Panen donde instanciamos los componentes del panel.
     */
    public Panel(){
        
        // Crear Componentes
        nameLabel = new JLabel("Nombre: ");
        nameTextBox = new JTextField(20);
        courseLabel = new JLabel("Curso: ");
        courseTextBox = new JTextField(15);
        dniLabel =  new JLabel("Dni:");
        dniTextBox = new JTextField();
        birthdayLabel = new JLabel("Nacimiento:");
        birthdayTextBox = new JTextField(10);
        previousBtn = new JButton(" << ");
        nextBtn = new JButton(" >> ");
        
        orderRadioName = new JRadioButton("Ordenar por Nombre", false);
        orderRadioDni = new JRadioButton("Ordenar por Dni", true);
        
        
        buttonsGroup = new ButtonGroup();
        buttonsGroup.add(orderRadioName);
        buttonsGroup.add(orderRadioDni);
        
        
        updateStudentBtn = new JButton("Actualizar") ;
        deleteStudentBtn = new JButton("Borrar");
        insertStudentBtn = new JButton("Insertar");
        
        
        
        enrollStudentBtn = new JButton("Matricular Alumno");
        saveChangesBtn = new JButton("Guardar Cambios");
        message = new JLabel();
        message.setVisible(false);
        

        //LAYOUT OF COMPONENTS
        nameLabel.setBounds(50, 40, 200, 20);
        nameTextBox.setBounds(140, 40, 150, 20);
        
        courseLabel.setBounds(50, 70, 200, 20);
        courseTextBox.setBounds(140, 70, 150, 20);
        
        dniLabel.setBounds(50, 100, 200, 20);
        dniTextBox.setBounds(140, 100, 150, 20);
        
        birthdayLabel.setBounds(50, 130, 200, 20);
        birthdayTextBox.setBounds(140, 130, 150, 20);
        
        
        previousBtn.setBounds(70, 190, 80, 40);
        nextBtn.setBounds(245, 190, 80, 40);
        
        orderRadioName.setBounds(35, 240, 150, 20);
        orderRadioDni.setBounds(210, 240, 150, 20);
        
        updateStudentBtn.setBounds(35, 275, 95, 30);
        deleteStudentBtn.setBounds(160, 275, 80, 30);
        insertStudentBtn.setBounds(280, 275, 80, 30);

        
        enrollStudentBtn.setBounds(135, 320, 140, 30);
        message.setBounds(450, 350, 400, 30);

        
        // Nuevo Panel para matricular alumnos
        enrolledPanel = new JPanel();
        enrolledPanel.setBounds(490, 30, 300, 300);
        enrolledPanel.setBackground(Color.PINK);
        //enrolledPanel.setLayout(null);
        // PONGO UN BORDE AL PANEL DE ALUMNO
        enrolledPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        //enrolledPanel.setBorder(BorderFactory.createBevelBorder(0));
        enrolledPanel.setLayout(null);
        saveChangesBtn.setBounds(80, 190, 140, 30);

        enrolledPanel.add(saveChangesBtn);
        enrolledPanel.setVisible(false);
      
        
        /**
         * asociamos los componentes del panel al contenedor.
         */
        //Asociar los componentes al contenedor
        this.add(nameLabel);
        this.add(nameTextBox);
        this.add(courseLabel);
        this.add(courseTextBox);
        this.add(dniLabel);
        this.add(dniTextBox);        
        this.add(birthdayLabel);
        this.add(birthdayTextBox);
        this.add(nextBtn);
        this.add(previousBtn);
        this.add(enrolledPanel);
        
        this.add(orderRadioName);
        this.add(orderRadioDni);
        
        this.add(updateStudentBtn);
        this.add(deleteStudentBtn);
        this.add(insertStudentBtn);
        
        
        this.add(enrollStudentBtn);
        this.add(message);


        /**
         * Añadimos eventos a los componentes.
         */
        // Añadir los eventos
        nextBtn.addActionListener(this);
        previousBtn.addActionListener(this);
        orderRadioName.addActionListener(this);
        orderRadioDni.addActionListener(this);
        updateStudentBtn.addActionListener(this);
        deleteStudentBtn.addActionListener(this);
        insertStudentBtn.addActionListener(this);
        enrollStudentBtn.addActionListener(this);
        saveChangesBtn.addActionListener(this);
     
     
        /**
         * Aplicamos estilos a los componentes del panel.
         */
        // Estilos
        this.setBackground(Color.LIGHT_GRAY);
        previousBtn.setBackground(Color.PINK);
        nextBtn.setBackground(Color.PINK);
        previousBtn.setBorderPainted(false);        
        nextBtn.setBorderPainted(false);
        
        orderRadioName.setVisible(true);
        orderRadioName.setEnabled(true);
        
        orderRadioDni.setVisible(true);
        orderRadioDni.setEnabled(true);
        
        updateStudentBtn.setBackground(Color.DARK_GRAY);
        deleteStudentBtn.setBackground(Color.DARK_GRAY);
        insertStudentBtn.setBackground(Color.DARK_GRAY);
        
        updateStudentBtn.setForeground(Color.WHITE);
        deleteStudentBtn.setForeground(Color.WHITE);
        insertStudentBtn.setForeground(Color.WHITE);
        
        
        updateStudentBtn.setBorderPainted(false);
        deleteStudentBtn.setBorderPainted(false);
        insertStudentBtn.setBorderPainted(false);
        
        
        enrollStudentBtn.setBackground(Color.DARK_GRAY);
        enrollStudentBtn.setForeground(Color.WHITE);
        enrollStudentBtn.setBorderPainted(false);
        message.setForeground(Color.BLACK);
        saveChangesBtn.setBackground(Color.DARK_GRAY);
        saveChangesBtn.setForeground(Color.WHITE);
        saveChangesBtn.setBorderPainted(false);
        
        
        // PONGO UN BORDE AL PANEL DE ALUMNO
        Border borderJpanel = new TitledBorder(new EtchedBorder(), "   FORMULARIO ALUMNOS      ");        
        this.setBorder(borderJpanel);
        
        // Por defecto los TextField están vacios, con esto consigo que aparezcan 
        //rellenos y que no sean editables nada más arrancar la aplicación
        
 
        if(Alumnos.isStudentsListEmpty()){
            setStudent(Alumnos.getStudent(0));
            
            nameTextBox.setEditable(false);
            courseTextBox.setEditable(false);
            dniTextBox.setEditable(false);
            birthdayTextBox.setEditable(false);
            
        }
        
        //en cuanto se ejecute el panel hago lo siguiente 
        /**
         * Al ejecutar el panel ordeno a los estudiantes por dni.
         */
        Alumnos.OrderStudentByDni();
        setStudent(Alumnos.getStudent(0));
        
        
        // *** ActionListener de los Radio Buttoms
        /**
         * Clase interna donde manejo el funcionamiento 
         * del RadioButton que ordena por dni.
         * @see java.awt.event.ItemListener
         */
        orderRadioDni.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(ie.getStateChange()==1){// 1 MARCADO 0 SIN MARCAR
                    Alumnos.OrderStudentByDni();
                    setStudent(Alumnos.getStudent(0));
                  
                }
            }
        });
        
        /**
         * Clase interna donde manejo el funcionamiento 
         * del RadioButton que ordena por dni.
         * @see java.awt.event.ItemListener
         */
        orderRadioName.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie){
                if(ie.getStateChange()==1){
                    Alumnos.orderStudentByName();
                    setStudent(Alumnos.getStudent(0));
                }
            }
        });
   
    }
    /**
     * Método para colocar un estudiante en los JTextField del panel.
     * @param student introduzco un estudiante y lo muestroe n los TextArea del panel
     */
    public void setStudent(Alumno student){
        this.nameTextBox.setText(student.getName());
        this.courseTextBox.setText(Integer.toString(student.getCourse()));
        this.dniTextBox.setText(student.getDni());
        this.birthdayTextBox.setText(student.getBirthdate().toString());
        
    }
    
    /**
     * Método para activar la edición de los TextArea.
     */
    public void setEditableButtons(){
        nameTextBox.setEditable(true);
        courseTextBox.setEditable(true);
        dniTextBox.setEditable(true);
        birthdayTextBox.setEditable(true);
    }
    
    /**
     * Método para desactivar la edición de los TextArea y deshabilitar la
     * funcionalidad de los componentes del panel.
     */
    public void setNoEditableComponents(){
        nameTextBox.setEditable(false);
        courseTextBox.setEditable(false);
        dniTextBox.setEditable(false);
        birthdayTextBox.setEditable(false);
        updateStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        insertStudentBtn.setEnabled(false);
        enrollStudentBtn.setEnabled(false);
        nextBtn.setEnabled(false);
        previousBtn.setEnabled(false);
        orderRadioName.setEnabled(false);
        orderRadioDni.setEnabled(false);
    }
    
    /**
     * Método para activar la edición de los TextArea y habilitar la
     * funcionalidad de los componentes del panel.
     */
    public void setEditableComponents(){
        nameTextBox.setEditable(true);
        courseTextBox.setEditable(true);
        dniTextBox.setEditable(true);
        birthdayTextBox.setEditable(true);
        updateStudentBtn.setEnabled(true);
        deleteStudentBtn.setEnabled(true);
        insertStudentBtn.setEnabled(true);
        enrollStudentBtn.setEnabled(true);
        nextBtn.setEnabled(true);
        previousBtn.setEnabled(true);
        orderRadioName.setEnabled(true);
        orderRadioDni.setEnabled(true);
    }
    
    
    /**
     * Método que elimina los checkBox del panel si el usuario
     * ya los a pulsado.
     *  
     */
    public void removeCheckBox(){
        if(subjectsCheckBox != null){
            for (JCheckBox jCheckBox : subjectsCheckBox) {
                enrolledPanel.remove(jCheckBox);
            }
        }
    } 
    
    
    /**
     * Método que elimina los JLabels correspondientes al método removeCheckBox().
     *  
     */
    public void removeLabels(){
        if(subjectsCheckBox != null){
            for (JLabel jLabel : enrolledLabels) {
                enrolledPanel.remove(jLabel);
            }
        }
    }
 
    /**
     * Método en el que trabajamos los eventos de los componemtes del panel y le damos funcionalidad.
     * @param e pasamos por parámetro un ActionEvent llamado e 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // ****** Recorres alumnos con los botones izquierda y derecha ******
      
        /**
         * Si lo que clicamos es btn ">>" buscamos el siguiente alumno
         * en la lista de alumnos
         * if <code>e.getSource()</code> == <code>nextBtn</code>
         * @see java.awt.event.ActionEvent
         */
        if(e.getSource() == nextBtn){
            //currentStudentIndex++;
            //currentStudentIndex %= Alumnos.getSize();
            //setStudent(Alumnos.getStudent(currentStudentIndex));
            if(currentStudentIndex < Alumnos.getSize()-1){
              currentStudentIndex++;
              setStudent(Alumnos.getStudent(currentStudentIndex));            
            }
            removeCheckBox();
            removeLabels();
            this.repaint();
        }
        
        /**
         * Si lo que clicamos es btn "anterior" buscamos el anteriro alumno.
         * en la lista de alumnos
         * if <code>e.getSource()</code> == <code>previousBtn</code>
         * @see java.awt.event.ActionEvent
         */
        if(e.getSource() == previousBtn){
            // -1 módulo 4 = 3
            //currentStudentIndex--;
            //currentStudentIndex %= Alumnos.getSize();
            //setStudent(Alumnos.getStudent(currentStudentIndex));
            if(currentStudentIndex > 0){
                currentStudentIndex--;
                setStudent(Alumnos.getStudent(currentStudentIndex));
            }
            removeCheckBox();
            removeLabels();
            this.repaint();
        }
        
        // ***** Editar alumnos con el botón updateStudentBtn
        /**
         * Actualizamos los estudiantes con el bt updateStrudentBtn
         * Deshabilitamos los componentes del panel
         * if <code>e.getSource()</code> == <code>updateStudentBtn</code>
         * @see java.awt.event.ActionEvent
         */
        if(e.getSource() == updateStudentBtn){
            //llamo al método que hace editables todos los textFields
            setEditableButtons();
            
            previousBtn.setEnabled(false);
            nextBtn.setEnabled(false);
            deleteStudentBtn.setEnabled(false);
            orderRadioName.setEnabled(false);
            orderRadioDni.setEnabled(false);
        }
        // ***** Guardar los cambios dentro del array de alumnos
        
        /**
         * Guardamos los cambios introducidosen el panel en 
         * nuestro ArrayList de alumnos
         */
        if(e.getSource()==insertStudentBtn){
            //guardar esos datos dentro del array
            setEditableButtons();
            Alumnos.getStudent(currentStudentIndex).setName(nameTextBox.getText());
            Alumnos.getStudent(currentStudentIndex).setCourse(Integer.parseInt(courseTextBox.getText()));
                                 Alumnos.getStudent(currentStudentIndex).setDni(dniTextBox.getText());
            Alumnos.getStudent(currentStudentIndex).setBirthdate(LocalDate.parse(birthdayTextBox.getText()));
            
            previousBtn.setEnabled(true);
            nextBtn.setEnabled(true);
            deleteStudentBtn.setEnabled(true);
            orderRadioName.setEnabled(true);
            orderRadioDni.setEnabled(true);
            
            Alumnos.OrderStudentByDni();
            
        }
        // ***** Borrar campos de texto al pulsar el botón de borrar
        /**
         * Borramos los alumnos del panel al pulsar <code>deleteStudentBtn</code>
         */
        if(e.getSource()== deleteStudentBtn){
            
            Alumnos.deleteStudent(Alumnos.getStudent(currentStudentIndex));
            
            nameTextBox.setText(null);
            courseTextBox.setText(null);
            dniTextBox.setText(null);
            birthdayTextBox.setText(null);
        }
      
        
        /**
         * Matricular alumnos en asignaturas, creamos los Checkbox y labels
         * donde aparecerán la sasignaturas matriculadas
         * if <code>e.getSource()</code> == <code>enrollStudentBtn</code>
         * 
         */
        if(e.getSource() == enrollStudentBtn){
            
            enrolledPanel.setVisible(true);
            setNoEditableComponents();
            //limpiar la caché cuando pasas al siguiente alumno
            removeCheckBox();
            removeLabels();
            
            // ******** Matricular a los alumnos al pulsar el Botón Matricular Alumnos *****
            // **** Manejo de los CheckBoxs y la Matriculación de alumnos
            
            //elimina el array
            subjectsCheckBox.clear();
            
            int course = Alumnos.getStudent(currentStudentIndex).getCourse()-1;
            for (int i = 0; i < TestGuiEscuela.subjects[course].length; i++) {
                
                String currentSubject = TestGuiEscuela.subjects[course][i];
                
                //Instancio los checkBox
                //Si el alumno NO está matriculado en esa asignatura
                if (!Alumnos.getStudent(currentStudentIndex).getEnrolledSubjects().contains(currentSubject)){
                    JCheckBox myCheckBox = new JCheckBox(TestGuiEscuela.subjects[course][i]);
                    myCheckBox.setBounds(75, 30 +(30 * i), 150, 15);
                    subjectsCheckBox.add(myCheckBox);
                    enrolledPanel.add(myCheckBox);
                }else {
                    JCheckBox myCheckBox = new JCheckBox(currentSubject);
                    myCheckBox.setBounds(75, 30 +(30 * i), 150, 15);
                    myCheckBox.setSelected(true);
                    subjectsCheckBox.add(myCheckBox);    
                    enrolledPanel.add(myCheckBox);

                }
            }
            this.repaint();
        }
        
        
        /**
         * Guardar las asignaturas matriculadas en <code>EnrolledSubjects</code>
         * 
         * if <code>e.getSource()</code> == <code>saveChangesBtn</code>
         * 
         */
        if(e.getSource() == saveChangesBtn){
            String text = "Asignaturas matriculadas: ";

            //si el array de CheckBox no es nulo y no está vacío
            if (subjectsCheckBox != null && !subjectsCheckBox.isEmpty()) {
                // *** MATRICULAR AL ALUMNO ***
                // *** Comprobar asignaturas en las que se MATRICULA AL ALUMNO y guardarlas en enrollSubjects                
                for (JCheckBox jCheckBox : subjectsCheckBox) {
                    if(jCheckBox.isSelected()){
                        //Si el checkBox está seleccionado añade el contenido del mismo a la etiqueta donde aparecen
                        //las asignaturas en las que está matriculado el alumno
                        //ya no existe tal etiqueta, ahora si está matriculado sale el checkBox de la asignatura
                        //señalado
                        if(!Alumnos.getStudent(currentStudentIndex).getEnrolledSubjects().contains(jCheckBox.getText())){
                            Alumnos.getStudent(currentStudentIndex).setEnrolledSubject(jCheckBox.getText());
                            text += jCheckBox.getText();
                            text += " | ";
                        }
                        
                    }
                }
            }
            message.setText(text);
            
            removeCheckBox();
            
            // ******** Matricular a los alumnos al pulsar el Botón Matricular Alumnos *****
            // **** Manejo de los CheckBoxs y la Matriculación de alumnos
            
            subjectsCheckBox.clear();
            
            
  
            int course = Alumnos.getStudent(currentStudentIndex).getCourse()-1;
            for (int i = 0; i < TestGuiEscuela.subjects[course].length; i++) {
                //Instancio los checkBox
                String currentSubject = TestGuiEscuela.subjects[course][i];
                //Si el alumno NO está matriculado en esa asignatura
                if (!Alumnos.getStudent(currentStudentIndex).getEnrolledSubjects().contains(currentSubject)){
                    JCheckBox myCheckBox = new JCheckBox(currentSubject);
                    myCheckBox.setBounds(75, 30 +(30 * i), 150, 15);
                    subjectsCheckBox.add(myCheckBox);
                    enrolledPanel.add(myCheckBox);
                }else {
                    //en las asignaturas en las que está ya el alumno matriculado salen los checkBox activados
                    JCheckBox myCheckBox = new JCheckBox(currentSubject);
                    myCheckBox.setBounds(75, 30 +(30 * i), 150, 15);
                    myCheckBox.setSelected(true);
                    subjectsCheckBox.add(myCheckBox);
                    enrolledPanel.add(myCheckBox);
 
                      
                    //si ya está las asignatura matriculada hacer un else añadiendo un label que diga --> Historia: Matriculada
                    //JLabel enrolled = new JLabel(TestGuiEscuela.subjects[course][i] + ": ¡Matriculada!");
                    //enrolled.setBounds(550, 50 +(30 * i), 150, 15);
                    //enrolledLabels.add(enrolled);
                    //this.add(enrolled);
                }   
            }
            setEditableComponents();
            enrolledPanel.setVisible(false);
            this.repaint();
        }
      
    }
}
