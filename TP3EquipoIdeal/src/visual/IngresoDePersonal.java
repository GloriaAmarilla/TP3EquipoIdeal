package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class IngresoDePersonal {

	private JFrame frmIngresodepersonal;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField rol;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoDePersonal window = new IngresoDePersonal();
					window.frmIngresodepersonal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IngresoDePersonal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngresodepersonal = new JFrame();
		frmIngresodepersonal.setTitle("IngresoDePersonal");
		frmIngresodepersonal.getContentPane().setBackground(new Color(224, 255, 255));
		frmIngresodepersonal.setBounds(100, 100, 596, 741);
		frmIngresodepersonal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngresodepersonal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingreso de Personas");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 41));
		lblNewLabel.setBounds(55, 39, 446, 111);
		frmIngresodepersonal.getContentPane().add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(new Color(0, 0, 139));
		lblNombre.setFont(new Font("Arial", Font.BOLD, 25));
		lblNombre.setBounds(55, 172, 156, 44);
		frmIngresodepersonal.getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Calibri", Font.PLAIN, 20));
		nombre.setBounds(218, 178, 293, 38);
		frmIngresodepersonal.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellido.setForeground(new Color(0, 0, 139));
		lblApellido.setFont(new Font("Arial", Font.BOLD, 25));
		lblApellido.setBounds(55, 237, 158, 44);
		frmIngresodepersonal.getContentPane().add(lblApellido);
		
		apellido = new JTextField();
		apellido.setFont(new Font("Calibri", Font.PLAIN, 20));
		apellido.setColumns(10);
		apellido.setBounds(218, 246, 293, 38);
		frmIngresodepersonal.getContentPane().add(apellido);
		
		JLabel lblRolEnEl = new JLabel("Rol:");
		lblRolEnEl.setHorizontalAlignment(SwingConstants.LEFT);
		lblRolEnEl.setForeground(new Color(0, 0, 139));
		lblRolEnEl.setFont(new Font("Arial", Font.BOLD, 25));
		lblRolEnEl.setBounds(53, 307, 158, 44);
		frmIngresodepersonal.getContentPane().add(lblRolEnEl);
		
		rol = new JTextField();
		rol.setFont(new Font("Calibri", Font.PLAIN, 20));
		rol.setColumns(10);
		rol.setBounds(218, 316, 293, 38);
		frmIngresodepersonal.getContentPane().add(rol);
		
		JLabel lblCalificacin = new JLabel("Calificación:");
		lblCalificacin.setHorizontalAlignment(SwingConstants.LEFT);
		lblCalificacin.setForeground(new Color(0, 0, 139));
		lblCalificacin.setFont(new Font("Arial", Font.BOLD, 25));
		lblCalificacin.setBounds(53, 369, 158, 44);
		frmIngresodepersonal.getContentPane().add(lblCalificacin);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(218, 375, 293, 38);
		frmIngresodepersonal.getContentPane().add(textField);
		
		JButton btnIngresarPersona = new JButton("Ingresar Candidato");
		btnIngresarPersona.setFont(new Font("Arial", Font.PLAIN, 20));
		btnIngresarPersona.setBounds(155, 449, 219, 56);
		frmIngresodepersonal.getContentPane().add(btnIngresarPersona);
		
		JButton btnFormarEquipo = new JButton("Formar Equipo");
		btnFormarEquipo.setFont(new Font("Arial", Font.PLAIN, 20));
		btnFormarEquipo.setBounds(155, 612, 219, 56);
		frmIngresodepersonal.getContentPane().add(btnFormarEquipo);
		
		JLabel lblSiYaIngresaste = new JLabel("Si ya ingresaste a todas las personas disponibles:");
		lblSiYaIngresaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiYaIngresaste.setForeground(new Color(0, 0, 139));
		lblSiYaIngresaste.setFont(new Font("Arial", Font.BOLD, 23));
		lblSiYaIngresaste.setBounds(10, 546, 560, 44);
		frmIngresodepersonal.getContentPane().add(lblSiYaIngresaste);
	}

}
