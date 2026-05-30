package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import logica.EquipoIdeal;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicial {

	private JFrame frmInicial;
	private JTextField txtCantIntegrantes;
	private JTextField txtCantLideres;
	private JTextField txtCantArquitectos;
	private JTextField txtCantProgramadores;
	private JTextField txtCantTesters;
	private EquipoIdeal estructuraEquipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial window = new Inicial();
					window.frmInicial.setVisible(true);
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
		frmInicial = new JFrame();
		frmInicial.setTitle("EquipoIdeal");
		frmInicial.getContentPane().setBackground(new Color(255, 248, 220));
		frmInicial.setBounds(100, 100, 596, 490);
		frmInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicial.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 45));
		lblNewLabel.setBackground(new Color(255, 245, 238));
		lblNewLabel.setBounds(143, 22, 250, 45);
		frmInicial.getContentPane().add(lblNewLabel);
		
		JLabel lblAquiPodraFormar = new JLabel("Aqui podrá formar su equipo ideal");
		lblAquiPodraFormar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAquiPodraFormar.setForeground(new Color(139, 69, 19));
		lblAquiPodraFormar.setFont(new Font("Calibri", Font.BOLD, 30));
		lblAquiPodraFormar.setBackground(new Color(255, 245, 238));
		lblAquiPodraFormar.setBounds(47, 64, 430, 45);
		frmInicial.getContentPane().add(lblAquiPodraFormar);
		
		JLabel lblEstructuraDeEquipo = new JLabel("Estructura de equipo:");
		lblEstructuraDeEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstructuraDeEquipo.setForeground(new Color(139, 69, 19));
		lblEstructuraDeEquipo.setFont(new Font("Calibri", Font.BOLD, 28));
		lblEstructuraDeEquipo.setBackground(new Color(255, 245, 238));
		lblEstructuraDeEquipo.setBounds(57, 120, 430, 45);
		frmInicial.getContentPane().add(lblEstructuraDeEquipo);
		
		JLabel lblCantidadDeIntegrantes = new JLabel("Cantidad de integrantes:");
		lblCantidadDeIntegrantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeIntegrantes.setForeground(new Color(139, 69, 19));
		lblCantidadDeIntegrantes.setFont(new Font("Calibri", Font.BOLD, 24));
		lblCantidadDeIntegrantes.setBackground(new Color(255, 245, 238));
		lblCantidadDeIntegrantes.setBounds(26, 160, 290, 45);
		frmInicial.getContentPane().add(lblCantidadDeIntegrantes);
		
		txtCantIntegrantes = new JTextField();
		txtCantIntegrantes.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtCantIntegrantes.setBounds(420, 167, 114, 31);
		frmInicial.getContentPane().add(txtCantIntegrantes);
		txtCantIntegrantes.setColumns(10);
		
		JLabel lblCantidadDeLideres = new JLabel("Cantidad de lideres:");
		lblCantidadDeLideres.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeLideres.setForeground(new Color(139, 69, 19));
		lblCantidadDeLideres.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeLideres.setBackground(new Color(255, 245, 238));
		lblCantidadDeLideres.setBounds(47, 202, 218, 45);
		frmInicial.getContentPane().add(lblCantidadDeLideres);
		
		txtCantLideres = new JTextField();
		txtCantLideres.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtCantLideres.setColumns(10);
		txtCantLideres.setBounds(420, 210, 114, 31);
		frmInicial.getContentPane().add(txtCantLideres);
		
		JLabel lblCantidadDeArquitectos = new JLabel("Cantidad de arquitectos:");
		lblCantidadDeArquitectos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeArquitectos.setForeground(new Color(139, 69, 19));
		lblCantidadDeArquitectos.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeArquitectos.setBackground(new Color(255, 245, 238));
		lblCantidadDeArquitectos.setBounds(47, 245, 268, 45);
		frmInicial.getContentPane().add(lblCantidadDeArquitectos);
		
		txtCantArquitectos = new JTextField();
		txtCantArquitectos.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtCantArquitectos.setColumns(10);
		txtCantArquitectos.setBounds(420, 253, 114, 31);
		frmInicial.getContentPane().add(txtCantArquitectos);
		
		JLabel lblCantidadDeProgramadores = new JLabel("Cantidad de programadores:");
		lblCantidadDeProgramadores.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeProgramadores.setForeground(new Color(139, 69, 19));
		lblCantidadDeProgramadores.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeProgramadores.setBackground(new Color(255, 245, 238));
		lblCantidadDeProgramadores.setBounds(47, 289, 294, 45);
		frmInicial.getContentPane().add(lblCantidadDeProgramadores);
		
		txtCantProgramadores = new JTextField();
		txtCantProgramadores.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtCantProgramadores.setColumns(10);
		txtCantProgramadores.setBounds(420, 297, 114, 31);
		frmInicial.getContentPane().add(txtCantProgramadores);
		
		JLabel lblCantidadDeTesters = new JLabel("Cantidad de testers:");
		lblCantidadDeTesters.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeTesters.setForeground(new Color(139, 69, 19));
		lblCantidadDeTesters.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeTesters.setBackground(new Color(255, 245, 238));
		lblCantidadDeTesters.setBounds(47, 333, 294, 45);
		frmInicial.getContentPane().add(lblCantidadDeTesters);
		
		txtCantTesters = new JTextField();
		txtCantTesters.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtCantTesters.setColumns(10);
		txtCantTesters.setBounds(420, 341, 114, 32);
		frmInicial.getContentPane().add(txtCantTesters);
		
		JButton btnContinuarProceso = new JButton("Continuar");
		btnContinuarProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strCantIntegrantes= txtCantIntegrantes.getText();
				String strCantLideres= txtCantLideres.getText();
				String strCantArquitectos= txtCantArquitectos.getText();
				String strCantProgramadores= txtCantProgramadores.getText();
				String strCantTesters= txtCantTesters.getText();
				
				try {
					Integer cantIntegrantes = Integer.parseInt(strCantIntegrantes);
					Integer cantLideres = Integer.parseInt(strCantLideres);
					Integer cantArquitectos= Integer.parseInt(strCantArquitectos);
					Integer cantProgramadores = Integer.parseInt(strCantProgramadores);
					Integer cantTesters = Integer.parseInt(strCantTesters);
					
					estructuraEquipo = new EquipoIdeal (cantIntegrantes,cantLideres,cantArquitectos,cantProgramadores,cantTesters);
					
					IngresoDePersonal ingresoDePersonal = new IngresoDePersonal(estructuraEquipo);
					ingresoDePersonal.mostrarVentana();
					frmInicial.dispose();
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(frmInicial, "Ingrese solamente números.", "Error",
							JOptionPane.ERROR_MESSAGE);
					mostrarVentana();
				}
			}
		});
		btnContinuarProceso.setFont(new Font("Arial", Font.PLAIN, 20));
		btnContinuarProceso.setBounds(154, 389, 239, 53);
		frmInicial.getContentPane().add(btnContinuarProceso);
	}
	
	public void mostrarVentana() {
		frmInicial.setVisible(true);
	}
}
