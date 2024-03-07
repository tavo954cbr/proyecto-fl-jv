package screen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import db.repository.EmpleadoRepository;
import db.repository.GeneroRepository;
import models.Empleado;
import models.Genero;

public class VentanaEmpleados extends JFrame implements ActionListener {
    GeneroRepository generoRepository = new GeneroRepository();
    EmpleadoRepository empleadoRepository = new EmpleadoRepository();
    Empleado empleado; 
    JLabel textLabel;
    JLabel numeroEmpleadoJLabel;
    JLabel nombreJLabel;
    JLabel domicilioJLabel;
    JLabel telefonoJLabel;
    JLabel emailJLabel;
    JLabel fechaJLabel;
    JLabel generoJLabel;
    JComboBox<Long> numeroEmpleadoJComboBox;
    JTextField nombreJTextField;
    JTextField domicilioJTextField;
    JTextField telefonoJTextField;
    JTextField emailJTextField;
    JDateChooser fehcaJDateChooser;
    JComboBox<Genero> generoJComboBox;
    JButton buscarJButton;
    JButton guardarJButton;
    JButton modificarJButton;
    JButton eliminarJButton;
    JButton limpiarJButton;

    public VentanaEmpleados() {
        super("Control de Empleados");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        crearComponentes();
        llenarComboBox();

    }

    private void crearComponentes() {
        textLabel = new JLabel("Empleados");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numeroEmpleadoJLabel = new JLabel("# Empleado");
        numeroEmpleadoJComboBox = new JComboBox<Long>();
        buscarJButton = new JButton("Buscar");
        nombreJLabel = new JLabel("Nombre: ");
        nombreJTextField = new JTextField(100);
        domicilioJLabel = new JLabel("Domicilio: ");
        domicilioJTextField = new JTextField(100);
        telefonoJLabel = new JLabel("Telefono: ");
        telefonoJTextField = new JTextField(15);
        emailJLabel = new JLabel("Email: ");
        emailJTextField = new JTextField(100);
        fechaJLabel = new JLabel("Fecha: ");
        fehcaJDateChooser = new JDateChooser();
        generoJLabel = new JLabel("Género: ");
        generoJComboBox = new JComboBox<Genero>();
        guardarJButton = new JButton("Guardar");
        modificarJButton = new JButton("Modificar");
        eliminarJButton = new JButton("Eliminar");
        limpiarJButton = new JButton("Limpiar");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; // ? columna donde inicia
        gbc.gridy = 0; // ? fila donde inicia
        gbc.gridwidth = 4; // ? numero de columnas que ocupa
        gbc.gridheight = 1; // ? numero de filas que ocupa
        gbc.fill = GridBagConstraints.BOTH;
        add(textLabel, gbc);
        

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(numeroEmpleadoJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(numeroEmpleadoJComboBox, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 1;
        buscarJButton.addActionListener(this);
        add(buscarJButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(nombreJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(nombreJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(domicilioJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(domicilioJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(telefonoJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(telefonoJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(emailJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(emailJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        add(fechaJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(fehcaJDateChooser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        add(generoJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(generoJComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        guardarJButton.addActionListener(this);
        add(guardarJButton, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        modificarJButton.addActionListener(this);
        add(modificarJButton, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 1;
        eliminarJButton.addActionListener(this);
        add(eliminarJButton, gbc);

        gbc.gridx = 3;
        gbc.gridwidth = 1;
        limpiarJButton.addActionListener(this);
        add(limpiarJButton, gbc);

    }

    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buscarJButton) {
            System.out.println("Buscar...");
            recuperarEmpleado();
        }
        if (e.getSource() == guardarJButton) {
            System.out.println("Guardar...");
            guardarEmpleado();

        }
        if (e.getSource() == modificarJButton) {
            System.out.println("modificar...");
            modificarEmpleado();

        }
        if (e.getSource() == eliminarJButton) {
            System.out.println("Eliminar...");
            eliminarEmpleado();
        }
        if (e.getSource() == limpiarJButton) {
            System.out.println("Limpiar...");
            limpiarCampos();
            actualizarCombobox();
        }
    }


    private void recuperarEmpleado(){
        empleado = empleadoRepository.recuperarId((long)(numeroEmpleadoJComboBox.getSelectedItem()));
        nombreJTextField.setText(empleado.getNombre());
        domicilioJTextField.setText(empleado.getDomicilio());
        telefonoJTextField.setText(empleado.getTelefono());
        emailJTextField.setText(empleado.getEmail());
        fehcaJDateChooser.setDate(empleado.getFechaNacimiento());
        generoJComboBox.setSelectedIndex(compararGenero(empleado.getGenero()));
        }
    

        private int compararGenero(Genero genero) {
       
            for (int i = 0; i < generoJComboBox.getItemCount(); i++) {
                if(genero.getNombre().equals( generoJComboBox.getItemAt(i).getNombre())){
                    return i;
                }
            }
            return -1;
        }

    private void guardarEmpleado(){
        java.util.Date utilDate = fehcaJDateChooser.getDate();
        java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
        empleado = new Empleado(
            null,
            nombreJTextField.getText(),
            domicilioJTextField.getText(),
            telefonoJTextField.getText(),
            emailJTextField.getText(),
            fecha,
            generoJComboBox.getItemAt(generoJComboBox.getSelectedIndex())
            );
        empleadoRepository.agregar(empleado);
    }

    private void modificarEmpleado(){
        java.util.Date utilDate = fehcaJDateChooser.getDate();
        java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
        empleado.setNombre(nombreJTextField.getText());
        empleado.setDomicilio(domicilioJTextField.getText());
        empleado.setTelefono(telefonoJTextField.getText());
        empleado.setEmail(emailJTextField.getText());
        empleado.setFechaNacimiento(fecha);
        empleado.setGenero(generoJComboBox.getItemAt(generoJComboBox.getSelectedIndex()));
        empleadoRepository.modificar(empleado);
       
    }


    private void eliminarEmpleado(){
        empleadoRepository.eliminar(empleado);
    }

    private void limpiarCampos(){
        empleado = null;
        nombreJTextField.setText("");
        domicilioJTextField.setText("");
        telefonoJTextField.setText("");
        emailJTextField.setText("");
        fehcaJDateChooser.setDate(null);
        numeroEmpleadoJComboBox.removeAllItems();
        generoJComboBox.removeAllItems();
    }

    
    private Empleado dameEmpleado(){
        long l = (Long)(generoJComboBox.getSelectedItem());
        Genero genero = generoRepository.recuperarId(l);
        java.util.Date utilDate = fehcaJDateChooser.getDate();
        java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
        Empleado empleado = new Empleado(
            null, 
            nombreJTextField.getText(), 
            domicilioJTextField.getText(), 
            telefonoJTextField.getText(), 
            emailJTextField.getText(), 
            fecha, 
            genero);
        return empleado;
    }

    private void actualizarCombobox(){
        limpiarCampos();
        llenarComboBox();
        revalidate();
        repaint();
    }

   

    private void llenarComboBox(){
        List<Genero> generos = generoRepository.recuperarTodos();
        for (Genero genero : generos){
            generoJComboBox.addItem(genero);
        }

        List<Empleado> empleados = empleadoRepository.recuperarTodos();
        for(Empleado empleado : empleados){
            numeroEmpleadoJComboBox.addItem(empleado.getId());
        }

    }

   

    
    
}
