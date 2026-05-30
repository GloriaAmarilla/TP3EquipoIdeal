package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Inicial {

	private JFrame frmEquipoideal;
	private JTextField cantIntegrantes;
	private JTextField cantLideres;
	private JTextField cantAquitectos;
	private JTextField cantProgramadores;
	private JTextField cantTesters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial window = new Inicial();
					window.frmEquipoideal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEquipoideal = new JFrame();
		frmEquipoideal.setTitle("EquipoIdeal");
		frmEquipoideal.getContentPane().setBackground(new Color(255, 248, 220));
		frmEquipoideal.setBounds(100, 100, 596, 741);
		frmEquipoideal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEquipoideal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 45));
		lblNewLabel.setBackground(new Color(255, 245, 238));
		lblNewLabel.setBounds(140, 38, 250, 45);
		frmEquipoideal.getContentPane().add(lblNewLabel);
		
		JLabel lblAquiPodraFormar = new JLabel("Aqui podrá formar su equipo ideal");
		lblAquiPodraFormar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAquiPodraFormar.setForeground(new Color(139, 69, 19));
		lblAquiPodraFormar.setFont(new Font("Calibri", Font.BOLD, 30));
		lblAquiPodraFormar.setBackground(new Color(255, 245, 238));
		lblAquiPodraFormar.setBounds(47, 89, 430, 45);
		frmEquipoideal.getContentPane().add(lblAquiPodraFormar);
		
		JLabel lblEstructuraDeEquipo = new JLabel("Estructura de equipo:");
		lblEstructuraDeEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstructuraDeEquipo.setForeground(new Color(139, 69, 19));
		lblEstructuraDeEquipo.setFont(new Font("Calibri", Font.BOLD, 30));
		lblEstructuraDeEquipo.setBackground(new Color(255, 245, 238));
		lblEstructuraDeEquipo.setBounds(47, 169, 430, 45);
		frmEquipoideal.getContentPane().add(lblEstructuraDeEquipo);
		
		JLabel lblCantidadDeIntegrantes = new JLabel("Cantidad de integrantes:");
		lblCantidadDeIntegrantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeIntegrantes.setForeground(new Color(139, 69, 19));
		lblCantidadDeIntegrantes.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeIntegrantes.setBackground(new Color(255, 245, 238));
		lblCantidadDeIntegrantes.setBounds(0, 253, 290, 45);
		frmEquipoideal.getContentPane().add(lblCantidadDeIntegrantes);
		
		cantIntegrantes = new JTextField();
		cantIntegrantes.setFont(new Font("Calibri", Font.PLAIN, 20));
		cantIntegrantes.setBounds(335, 259, 165, 32);
		frmEquipoideal.getContentPane().add(cantIntegrantes);
		cantIntegrantes.setColumns(10);
		
		JLabel lblCantidadDeLideres = new JLabel("Cantidad de lideres:");
		lblCantidadDeLideres.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeLideres.setForeground(new Color(139, 69, 19));
		lblCantidadDeLideres.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeLideres.setBackground(new Color(255, 245, 238));
		lblCantidadDeLideres.setBounds(22, 309, 218, 45);
		frmEquipoideal.getContentPane().add(lblCantidadDeLideres);
		
		cantLideres = new JTextField();
		cantLideres.setFont(new Font("Calibri", Font.PLAIN, 20));
		cantLideres.setColumns(10);
		cantLideres.setBounds(335, 315, 165, 32);
		frmEquipoideal.getContentPane().add(cantLideres);
		
		JLabel lblCantidadDeArquitectos = new JLabel("Cantidad de arquitectos:");
		lblCantidadDeArquitectos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeArquitectos.setForeground(new Color(139, 69, 19));
		lblCantidadDeArquitectos.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeArquitectos.setBackground(new Color(255, 245, 238));
		lblCantidadDeArquitectos.setBounds(22, 365, 268, 45);
		frmEquipoideal.getContentPane().add(lblCantidadDeArquitectos);
		
		cantAquitectos = new JTextField();
		cantAquitectos.setFont(new Font("Calibri", Font.PLAIN, 20));
		cantAquitectos.setColumns(10);
		cantAquitectos.setBounds(335, 371, 165, 32);
		frmEquipoideal.getContentPane().add(cantAquitectos);
		
		JLabel lblCantidadDeProgramadores = new JLabel("Cantidad de programadores:");
		lblCantidadDeProgramadores.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeProgramadores.setForeground(new Color(139, 69, 19));
		lblCantidadDeProgramadores.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeProgramadores.setBackground(new Color(255, 245, 238));
		lblCantidadDeProgramadores.setBounds(22, 421, 294, 45);
		frmEquipoideal.getContentPane().add(lblCantidadDeProgramadores);
		
		cantProgramadores = new JTextField();
		cantProgramadores.setFont(new Font("Calibri", Font.PLAIN, 20));
		cantProgramadores.setColumns(10);
		cantProgramadores.setBounds(335, 427, 165, 32);
		frmEquipoideal.getContentPane().add(cantProgramadores);
		
		JLabel lblCantidadDeTesters = new JLabel("Cantidad de testers:");
		lblCantidadDeTesters.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeTesters.setForeground(new Color(139, 69, 19));
		lblCantidadDeTesters.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeTesters.setBackground(new Color(255, 245, 238));
		lblCantidadDeTesters.setBounds(22, 483, 294, 45);
		frmEquipoideal.getContentPane().add(lblCantidadDeTesters);
		
		cantTesters = new JTextField();
		cantTesters.setFont(new Font("Calibri", Font.PLAIN, 20));
		cantTesters.setColumns(10);
		cantTesters.setBounds(335, 489, 165, 32);
		frmEquipoideal.getContentPane().add(cantTesters);
		
		JButton btnContinuarProceso = new JButton("Continuar");
		btnContinuarProceso.setFont(new Font("Arial", Font.PLAIN, 20));
		btnContinuarProceso.setBounds(134, 564, 239, 53);
		frmEquipoideal.getContentPane().add(btnContinuarProceso);
	}
}
