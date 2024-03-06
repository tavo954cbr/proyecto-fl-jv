package screen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import db.repository.EmpleadoRepository;
import db.repository.GeneroRepository;
import models.Empleado;

public class VentanaEmpleados extends JFrame implements ActionListener {
    GeneroRepository generoRepository = new GeneroRepository();
    EmpleadoRepository empleadoRepository = new EmpleadoRepository();
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
    JComboBox<String> generoJComboBox;
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

    }

    private void crearComponentes() {
        JLabel textLabel = new JLabel("Empleados");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel numeroEmpleadoJLabel = new JLabel("# Empleado");
        JComboBox<Long> numeroEmpleadoJComboBox = new JComboBox<Long>();
        JButton buscarJButton = new JButton("Buscar");
        JLabel nombreJLabel = new JLabel("Nombre: ");
        JTextField nombreJTextField = new JTextField(100);
        JLabel domicilioJLabel = new JLabel("Domicilio: ");
        JTextField domicilioJTextField = new JTextField(100);
        JLabel telefonoJLabel = new JLabel("Telefono: ");
        JTextField telefonoJTextField = new JTextField(15);
        JLabel emailJLabel = new JLabel("Email: ");
        JTextField emailJTextField = new JTextField(100);
        JLabel fechaJLabel = new JLabel("Fecha: ");
        JDateChooser fehcaJDateChooser = new JDateChooser();
        JLabel generoJLabel = new JLabel("Género: ");
        JComboBox<String> generoJComboBox = new JComboBox<String>();
        JButton guardarJButton = new JButton("Guardar");
        JButton modificarJButton = new JButton("Modificar");
        JButton eliminarJButton = new JButton("Eliminar");
        JButton limpiarJButton = new JButton("Limpiar");

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
            int idEmpleado = numeroEmpleadoJComboBox.getSelectedIndex();

        }
        if (e.getSource() == guardarJButton) {
            System.out.println("Registrar...");
            Long id = (Long) (numeroEmpleadoJComboBox.getSelectedItem());
            String nombre = nombreJTextField.getText();
            String domicilio = domicilioJTextField.getText();
            String telefono = telefonoJTextField.getText();
            String email = emailJTextField.getText();
            Empleado empleado = new Empleado(
                    id,
                    nombre,
                    domicilio,
                    telefono,
                    email,
                    null,
                    null);

        }
        if (e.getSource() == modificarJButton) {
            System.out.println("modificar...");

        }
        if (e.getSource() == eliminarJButton) {
            System.out.println("Eliminar...");

        }
        if (e.getSource() == limpiarJButton) {
            System.out.println("Limpiar...");
        }
    }
}
