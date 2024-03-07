package screen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistroVentana extends JFrame{

    JLabel textJLabel;
    JLabel nombreJLabel;
    JLabel emailJLabel;
    JLabel usuarJLabel;
    JLabel contraseniaJLabel;
    JTextField nombreJTextField;
    JTextField emailJTextField;
    JTextField usuarioJTextField;
    JPasswordField contraseniaJPasswordField;
    JRadioButton mostrar;
    JButton registrarJButton;



    public RegistroVentana(){
        super("Registrarse");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        crearComponentes();
    }


    private void crearComponentes(){
        // mostrando = :
        textJLabel = new JLabel("Registrate");
        textJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreJLabel = new JLabel("Nombre: ");
        nombreJTextField = new JTextField(100);
        emailJLabel =  new JLabel("Email: ");
        emailJTextField = new JTextField(100);
        usuarJLabel = new JLabel("Usuario: ");
        usuarioJTextField = new JTextField(100);
        contraseniaJLabel = new JLabel("Contraseña: ");
        mostrar = new JRadioButton();
        contraseniaJPasswordField = new JPasswordField(100);
        registrarJButton = new JButton("Registrarte:");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(textJLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(nombreJLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        add(nombreJTextField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(emailJLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        add(emailJTextField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(usuarJLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        add(usuarioJTextField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(contraseniaJLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 1;
        add(mostrar, gbc);

        gbc.gridx = 3;
        gbc.gridwidth = 1;
        add(contraseniaJPasswordField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(registrarJButton, gbc);


    }
}
