package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import logica.EquipoIdeal;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IngresoDePersonal {

	private JFrame frmIngresoDePersonal;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private EquipoIdeal estructuraDeEquipo;

	public IngresoDePersonal(EquipoIdeal estructuraEquipo) {
		estructuraDeEquipo = estructuraEquipo;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngresoDePersonal = new JFrame();
		frmIngresoDePersonal.setTitle("IngresoDePersonal");
		frmIngresoDePersonal.getContentPane().setBackground(new Color(224, 255, 255));
		frmIngresoDePersonal.setBounds(100, 100, 596, 490);
		frmIngresoDePersonal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngresoDePersonal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingreso de Personas");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 36));
		lblNewLabel.setBounds(55, 11, 446, 66);
		frmIngresoDePersonal.getContentPane().add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(new Color(0, 0, 139));
		lblNombre.setFont(new Font("Arial", Font.BOLD, 25));
		lblNombre.setBounds(53, 88, 156, 44);
		frmIngresoDePersonal.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtNombre.setBounds(218, 88, 293, 38);
		frmIngresoDePersonal.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellido.setForeground(new Color(0, 0, 139));
		lblApellido.setFont(new Font("Arial", Font.BOLD, 25));
		lblApellido.setBounds(51, 131, 158, 44);
		frmIngresoDePersonal.getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtApellido.setColumns(10);
		txtApellido.setBounds(218, 137, 293, 38);
		frmIngresoDePersonal.getContentPane().add(txtApellido);
		
		JLabel lblRolEnEl = new JLabel("Rol:");
		lblRolEnEl.setHorizontalAlignment(SwingConstants.LEFT);
		lblRolEnEl.setForeground(new Color(0, 0, 139));
		lblRolEnEl.setFont(new Font("Arial", Font.BOLD, 25));
		lblRolEnEl.setBounds(51, 186, 158, 38);
		frmIngresoDePersonal.getContentPane().add(lblRolEnEl);
		
		JLabel lblCalificacion = new JLabel("Calificación:");
		lblCalificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblCalificacion.setForeground(new Color(0, 0, 139));
		lblCalificacion.setFont(new Font("Arial", Font.BOLD, 25));
		lblCalificacion.setBounds(51, 228, 158, 44);
		frmIngresoDePersonal.getContentPane().add(lblCalificacion);
		
		JComboBox cmbxRoles = new JComboBox();
		cmbxRoles.setFont(new Font("Calibri", Font.PLAIN, 16));
		cmbxRoles.setBounds(218, 186, 293, 35);
		frmIngresoDePersonal.getContentPane().add(cmbxRoles);
		
		cmbxRoles.setModel(new DefaultComboBoxModel(new String [] {"Seleccione un rol", "LIDER", "ARQUITECTO","PROGRAMADOR","TESTER"}));
		
		JComboBox cmbxCalificaciones = new JComboBox();
		cmbxCalificaciones.setFont(new Font("Calibri", Font.PLAIN, 16));
		cmbxCalificaciones.setBounds(218, 228, 293, 35);
		frmIngresoDePersonal.getContentPane().add(cmbxCalificaciones);
		
		cmbxCalificaciones.setModel(new DefaultComboBoxModel(new String [] {"Seleccione la calificacion","5","4","3","2","1"}));
		
		JButton btnIngresarPersona = new JButton("Ingresar Candidato");
		btnIngresarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				aca se deben ir cargando las personas en la clase PersonalLaboral
			}
		});
		btnIngresarPersona.setFont(new Font("Arial", Font.PLAIN, 20));
		btnIngresarPersona.setBounds(155, 283, 219, 44);
		frmIngresoDePersonal.getContentPane().add(btnIngresarPersona);
		
		JLabel lblSiYaIngresaste = new JLabel("Si ya ingresaste a todas las personas disponibles:");
		lblSiYaIngresaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiYaIngresaste.setForeground(new Color(0, 0, 139));
		lblSiYaIngresaste.setFont(new Font("Arial", Font.BOLD, 23));
		lblSiYaIngresaste.setBounds(10, 341, 560, 44);
		frmIngresoDePersonal.getContentPane().add(lblSiYaIngresaste);
		
		JButton btnFormarEquipo = new JButton("Formar Equipo");
		btnFormarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aca se forma el equipo y se muestra el frame EquipoFormado
			}
		});
		btnFormarEquipo.setFont(new Font("Arial", Font.PLAIN, 20));
		btnFormarEquipo.setBounds(155, 384, 219, 44);
		frmIngresoDePersonal.getContentPane().add(btnFormarEquipo);
		
	}

	public void mostrarVentana() {
		frmIngresoDePersonal.setVisible(true);
	}
}
