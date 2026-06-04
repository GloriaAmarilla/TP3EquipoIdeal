package visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import logica.EquipoIdeal;
import logica.Persona;
import logica.PersonalLaboral;

public class EquipoFormado {

	private JFrame frmEquipoFormado;
	private PersonalLaboral _personal;
	private int _cantLideres, _cantArquitectos, _cantProgramadores, _cantTesters;
	private DefaultTableModel modeloTabla;
	private JLabel lblEstado;
	private JLabel lblCalificacion;
	private JLabel lblEvaluaciones;
	private JLabel lblTiempo;

	public EquipoFormado(PersonalLaboral personal, int cantLideres, int cantArquitectos, int cantProgramadores,
			int cantTesters) {
		_personal = personal;
		_cantLideres = cantLideres;
		_cantArquitectos = cantArquitectos;
		_cantProgramadores = cantProgramadores;
		_cantTesters = cantTesters;
		initialize();
	}

	private void initialize() {
		frmEquipoFormado = new JFrame();
		frmEquipoFormado.setTitle("Equipo Formado");
		frmEquipoFormado.getContentPane().setBackground(new Color(240, 255, 240));
		frmEquipoFormado.setBounds(100, 100, 620, 560);
		frmEquipoFormado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEquipoFormado.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Equipo Ideal");
		lblTitulo.setForeground(new Color(0, 100, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 36));
		lblTitulo.setBounds(55, 11, 500, 50);
		frmEquipoFormado.getContentPane().add(lblTitulo);

		lblEstado = new JLabel("Buscando el equipo ideal...");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setForeground(new Color(0, 100, 0));
		lblEstado.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEstado.setBounds(20, 65, 560, 30);
		frmEquipoFormado.getContentPane().add(lblEstado);

		modeloTabla = new DefaultTableModel(new String[] { "Nombre", "Apellido", "Rol", "Calificación" }, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable tablaEquipo = new JTable(modeloTabla);
		tablaEquipo.setFont(new Font("Calibri", Font.PLAIN, 15));
		tablaEquipo.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 15));
		JScrollPane scrollPane = new JScrollPane(tablaEquipo);
		scrollPane.setBounds(20, 105, 560, 200);
		frmEquipoFormado.getContentPane().add(scrollPane);

		lblCalificacion = new JLabel("");
		lblCalificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalificacion.setForeground(new Color(0, 100, 0));
		lblCalificacion.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCalificacion.setBounds(20, 315, 560, 30);
		frmEquipoFormado.getContentPane().add(lblCalificacion);

		lblEvaluaciones = new JLabel("");
		lblEvaluaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvaluaciones.setForeground(new Color(0, 100, 0));
		lblEvaluaciones.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEvaluaciones.setBounds(20, 350, 560, 28);
		frmEquipoFormado.getContentPane().add(lblEvaluaciones);

		lblTiempo = new JLabel("");
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempo.setForeground(new Color(0, 100, 0));
		lblTiempo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTiempo.setBounds(20, 383, 560, 28);
		frmEquipoFormado.getContentPane().add(lblTiempo);

		JButton btnNuevaBusqueda = new JButton("Nueva Búsqueda");
		btnNuevaBusqueda.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnNuevaBusqueda.setBounds(185, 430, 220, 44);
		frmEquipoFormado.getContentPane().add(btnNuevaBusqueda);

		btnNuevaBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicial inicial = new Inicial();
				inicial.mostrarVentana();
				frmEquipoFormado.dispose();
			}
		});
	}

	public void mostrarVentana() {
		frmEquipoFormado.setVisible(true);
		iniciarBusqueda();
	}

	private void iniciarBusqueda() {
		EquipoIdeal.ResultadoListener listener = new EquipoIdeal.ResultadoListener() {
			public void onResultado(HashSet<Persona> equipo, int evaluaciones, long tiempoMs) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						if (equipo.isEmpty()) {
							lblEstado.setText("No se encontró un equipo válido.");
						} else {
							lblEstado.setText("¡Equipo encontrado!");
							for (Persona p : equipo) {
								modeloTabla.addRow(new Object[] { p.getNombre(), p.getApellido(), p.getRol(),
										p.getCalificacion() });
							}
							int total = equipo.stream().mapToInt(Persona::getCalificacion).sum();
							lblCalificacion.setText("Calificación total del equipo: " + total);
						}
						lblEvaluaciones.setText("Equipos evaluados: " + evaluaciones);
						lblTiempo.setText("Tiempo de búsqueda: " + tiempoMs + " ms");
					}
				});
			}
		};

		EquipoIdeal equipo = new EquipoIdeal(_cantLideres, _cantArquitectos, _cantProgramadores, _cantTesters,
				_personal, listener);

		Thread thread = new Thread(equipo);
		thread.start();
	}
}