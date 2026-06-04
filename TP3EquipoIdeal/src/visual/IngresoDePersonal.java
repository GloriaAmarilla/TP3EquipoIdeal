package visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.EquipoIdeal;
import logica.Persona;
import logica.PersonalLaboral;

public class IngresoDePersonal {

	private JFrame frmIngresoDePersonal;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private PersonalLaboral _personal;
	private int _cantLideres, _cantArquitectos, _cantProgramadores, _cantTesters;
	private DefaultTableModel modeloTabla;

	public IngresoDePersonal(PersonalLaboral personal, int cantLideres, int cantArquitectos, int cantProgramadores,
			int cantTesters) {
		_personal = personal;
		_cantLideres = cantLideres;
		_cantArquitectos = cantArquitectos;
		_cantProgramadores = cantProgramadores;
		_cantTesters = cantTesters;
		initialize();
	}

	private void initialize() {
		frmIngresoDePersonal = new JFrame();
		frmIngresoDePersonal.setTitle("Ingreso de Personal");
		frmIngresoDePersonal.getContentPane().setBackground(new Color(224, 255, 255));
		frmIngresoDePersonal.setBounds(100, 100, 620, 600);
		frmIngresoDePersonal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngresoDePersonal.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Ingreso de Personas");
		lblTitulo.setForeground(new Color(0, 0, 139));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 36));
		lblTitulo.setBounds(55, 11, 500, 50);
		frmIngresoDePersonal.getContentPane().add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(0, 0, 139));
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNombre.setBounds(20, 70, 120, 35);
		frmIngresoDePersonal.getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNombre.setBounds(150, 70, 200, 35);
		frmIngresoDePersonal.getContentPane().add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(new Color(0, 0, 139));
		lblApellido.setFont(new Font("Calibri", Font.BOLD, 20));
		lblApellido.setBounds(20, 115, 120, 35);
		frmIngresoDePersonal.getContentPane().add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtApellido.setBounds(150, 115, 200, 35);
		frmIngresoDePersonal.getContentPane().add(txtApellido);

		JLabel lblRol = new JLabel("Rol:");
		lblRol.setForeground(new Color(0, 0, 139));
		lblRol.setFont(new Font("Calibri", Font.BOLD, 20));
		lblRol.setBounds(20, 160, 120, 35);
		frmIngresoDePersonal.getContentPane().add(lblRol);

		JComboBox<String> cmbxRoles = new JComboBox<>();
		cmbxRoles.setFont(new Font("Calibri", Font.PLAIN, 16));
		cmbxRoles.setModel(new DefaultComboBoxModel<>(
				new String[] { "Seleccione un rol", "LIDER", "ARQUITECTO", "PROGRAMADOR", "TESTER" }));
		cmbxRoles.setBounds(150, 160, 200, 32);
		frmIngresoDePersonal.getContentPane().add(cmbxRoles);

		JLabel lblCalificacion = new JLabel("Calificación:");
		lblCalificacion.setForeground(new Color(0, 0, 139));
		lblCalificacion.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCalificacion.setBounds(20, 205, 140, 35);
		frmIngresoDePersonal.getContentPane().add(lblCalificacion);

		JComboBox<String> cmbxCalificaciones = new JComboBox<>();
		cmbxCalificaciones.setFont(new Font("Calibri", Font.PLAIN, 16));
		cmbxCalificaciones.setModel(
				new DefaultComboBoxModel<>(new String[] { "Seleccione calificacion", "5", "4", "3", "2", "1" }));
		cmbxCalificaciones.setBounds(150, 205, 200, 32);
		frmIngresoDePersonal.getContentPane().add(cmbxCalificaciones);

		JButton btnIngresarPersona = new JButton("Ingresar Candidato");
		btnIngresarPersona.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnIngresarPersona.setBounds(370, 140, 210, 40);
		frmIngresoDePersonal.getContentPane().add(btnIngresarPersona);

		// Tabla de personas cargadas
		modeloTabla = new DefaultTableModel(new String[] { "Nombre", "Apellido", "Rol", "Calificación" }, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable tablaPersonas = new JTable(modeloTabla);
		tablaPersonas.setFont(new Font("Calibri", Font.PLAIN, 14));
		tablaPersonas.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane(tablaPersonas);
		scrollPane.setBounds(20, 255, 560, 150);
		frmIngresoDePersonal.getContentPane().add(scrollPane);

		JButton btnSiguiente = new JButton("Cargar Incompatibilidades");
		btnSiguiente.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSiguiente.setBounds(160, 458, 270, 44);
		frmIngresoDePersonal.getContentPane().add(btnSiguiente);

		// Accion ingresar persona
		btnIngresarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText().trim();
				String apellido = txtApellido.getText().trim();
				String rol = (String) cmbxRoles.getSelectedItem();
				String calificacionStr = (String) cmbxCalificaciones.getSelectedItem();

				if (nombre.isEmpty() || apellido.isEmpty()) {
					JOptionPane.showMessageDialog(frmIngresoDePersonal, "Nombre y apellido no pueden estar vacíos.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (rol.equals("Seleccione un rol")) {
					JOptionPane.showMessageDialog(frmIngresoDePersonal, "Seleccione un rol.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (calificacionStr.equals("Seleccione calificacion")) {
					JOptionPane.showMessageDialog(frmIngresoDePersonal, "Seleccione una calificación.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					int calificacion = Integer.parseInt(calificacionStr);
					Persona persona = new Persona(nombre, apellido, calificacion, rol);
					_personal.cargarPersona(persona);
					modeloTabla.addRow(new Object[] { nombre, apellido, rol, calificacion });
					txtNombre.setText("");
					txtApellido.setText("");
					cmbxRoles.setSelectedIndex(0);
					cmbxCalificaciones.setSelectedIndex(0);
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(frmIngresoDePersonal, ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Accion siguiente: ir a incompatibilidades
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (_personal.getPersonas().isEmpty()) {
					JOptionPane.showMessageDialog(frmIngresoDePersonal, "Debe ingresar al menos una persona.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				IngresoDeIncompatibilidades ventanaIncompat = new IngresoDeIncompatibilidades(_personal, _cantLideres,
						_cantArquitectos, _cantProgramadores, _cantTesters);
				ventanaIncompat.mostrarVentana();
				frmIngresoDePersonal.dispose();
			}
		});
	}

	public void mostrarVentana() {
		frmIngresoDePersonal.setVisible(true);
	}
}