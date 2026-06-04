package visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import logica.Persona;
import logica.PersonalLaboral;

public class IngresoDeIncompatibilidades {

	private JFrame frmIncompatibilidades;
	private PersonalLaboral _personal;
	private int _cantLideres, _cantArquitectos, _cantProgramadores, _cantTesters;
	private DefaultTableModel modeloTabla;
	private JComboBox<String> cmbxPersona1;
	private JComboBox<String> cmbxPersona2;
	private ArrayList<Persona> listaPersonas;

	public IngresoDeIncompatibilidades(PersonalLaboral personal, int cantLideres, int cantArquitectos,
			int cantProgramadores, int cantTesters) {
		_personal = personal;
		_cantLideres = cantLideres;
		_cantArquitectos = cantArquitectos;
		_cantProgramadores = cantProgramadores;
		_cantTesters = cantTesters;
		listaPersonas = new ArrayList<>(_personal.getPersonas());
		initialize();
	}

	private void initialize() {
		frmIncompatibilidades = new JFrame();
		frmIncompatibilidades.setTitle("Ingreso de Incompatibilidades");
		frmIncompatibilidades.getContentPane().setBackground(new Color(255, 240, 245));
		frmIncompatibilidades.setBounds(100, 100, 620, 520);
		frmIncompatibilidades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIncompatibilidades.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Incompatibilidades");
		lblTitulo.setForeground(new Color(139, 0, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 34));
		lblTitulo.setBounds(55, 11, 500, 50);
		frmIncompatibilidades.getContentPane().add(lblTitulo);

		JLabel lblPersona1 = new JLabel("Persona 1:");
		lblPersona1.setForeground(new Color(139, 0, 0));
		lblPersona1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPersona1.setBounds(20, 75, 130, 35);
		frmIncompatibilidades.getContentPane().add(lblPersona1);

		String[] nombresPersonas = getNombresPersonas();
		cmbxPersona1 = new JComboBox<>(nombresPersonas);
		cmbxPersona1.setFont(new Font("Calibri", Font.PLAIN, 16));
		cmbxPersona1.setBounds(160, 75, 420, 32);
		frmIncompatibilidades.getContentPane().add(cmbxPersona1);

		JLabel lblPersona2 = new JLabel("Persona 2:");
		lblPersona2.setForeground(new Color(139, 0, 0));
		lblPersona2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPersona2.setBounds(20, 120, 130, 35);
		frmIncompatibilidades.getContentPane().add(lblPersona2);

		cmbxPersona2 = new JComboBox<>(nombresPersonas);
		cmbxPersona2.setFont(new Font("Calibri", Font.PLAIN, 16));
		cmbxPersona2.setBounds(160, 120, 420, 32);
		frmIncompatibilidades.getContentPane().add(cmbxPersona2);

		JButton btnAgregarIncompat = new JButton("Agregar Incompatibilidad");
		btnAgregarIncompat.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnAgregarIncompat.setBounds(160, 165, 270, 40);
		frmIncompatibilidades.getContentPane().add(btnAgregarIncompat);

		modeloTabla = new DefaultTableModel(new String[] { "Persona 1", "Persona 2" }, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable tablaIncompat = new JTable(modeloTabla);
		tablaIncompat.setFont(new Font("Calibri", Font.PLAIN, 14));
		tablaIncompat.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane(tablaIncompat);
		scrollPane.setBounds(20, 220, 560, 150);
		frmIncompatibilidades.getContentPane().add(scrollPane);

		JButton btnFormarEquipo = new JButton("Formar Equipo");
		btnFormarEquipo.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnFormarEquipo.setBounds(185, 423, 220, 44);
		frmIncompatibilidades.getContentPane().add(btnFormarEquipo);

		btnAgregarIncompat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx1 = cmbxPersona1.getSelectedIndex();
				int idx2 = cmbxPersona2.getSelectedIndex();

				if (idx1 == idx2) {
					JOptionPane.showMessageDialog(frmIncompatibilidades, "Seleccione dos personas distintas.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Persona p1 = listaPersonas.get(idx1);
				Persona p2 = listaPersonas.get(idx2);

				try {
					_personal.cargarIncompatibles(p1, p2);
					modeloTabla.addRow(new Object[] { p1.toString(), p2.toString() });
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(frmIncompatibilidades, ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnFormarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipoFormado equipoFormado = new EquipoFormado(_personal, _cantLideres, _cantArquitectos,
						_cantProgramadores, _cantTesters);
				equipoFormado.mostrarVentana();
				frmIncompatibilidades.dispose();
			}
		});
	}

	private String[] getNombresPersonas() {
		String[] nombres = new String[listaPersonas.size()];
		for (int i = 0; i < listaPersonas.size(); i++) {
			nombres[i] = listaPersonas.get(i).toString();
		}
		return nombres;
	}

	public void mostrarVentana() {
		frmIncompatibilidades.setVisible(true);
	}
}