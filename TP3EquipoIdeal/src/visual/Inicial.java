package visual;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logica.PersonalLaboral;
import logica.EquipoIdeal;

public class Inicial {

	private JFrame frmInicial;
	private JTextField txtCantLideres;
	private JTextField txtCantArquitectos;
	private JTextField txtCantProgramadores;
	private JTextField txtCantTesters;

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

	public Inicial() {
		initialize();
	}

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
		lblNewLabel.setBounds(143, 22, 250, 45);
		frmInicial.getContentPane().add(lblNewLabel);

		JLabel lblAquiPodraFormar = new JLabel("Aqui podrá formar su equipo ideal");
		lblAquiPodraFormar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAquiPodraFormar.setForeground(new Color(139, 69, 19));
		lblAquiPodraFormar.setFont(new Font("Calibri", Font.BOLD, 30));
		lblAquiPodraFormar.setBounds(47, 64, 430, 45);
		frmInicial.getContentPane().add(lblAquiPodraFormar);

		JLabel lblEstructuraDeEquipo = new JLabel("Estructura de equipo:");
		lblEstructuraDeEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstructuraDeEquipo.setForeground(new Color(139, 69, 19));
		lblEstructuraDeEquipo.setFont(new Font("Calibri", Font.BOLD, 28));
		lblEstructuraDeEquipo.setBounds(57, 120, 430, 45);
		frmInicial.getContentPane().add(lblEstructuraDeEquipo);

		JLabel lblCantidadDeLideres = new JLabel("Cantidad de lideres:");
		lblCantidadDeLideres.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeLideres.setForeground(new Color(139, 69, 19));
		lblCantidadDeLideres.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeLideres.setBounds(47, 170, 280, 45);
		frmInicial.getContentPane().add(lblCantidadDeLideres);

		txtCantLideres = new JTextField();
		txtCantLideres.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtCantLideres.setColumns(10);
		txtCantLideres.setBounds(420, 178, 114, 31);
		frmInicial.getContentPane().add(txtCantLideres);

		JLabel lblCantidadDeArquitectos = new JLabel("Cantidad de arquitectos:");
		lblCantidadDeArquitectos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeArquitectos.setForeground(new Color(139, 69, 19));
		lblCantidadDeArquitectos.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeArquitectos.setBounds(47, 213, 310, 45);
		frmInicial.getContentPane().add(lblCantidadDeArquitectos);

		txtCantArquitectos = new JTextField();
		txtCantArquitectos.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtCantArquitectos.setColumns(10);
		txtCantArquitectos.setBounds(420, 221, 114, 31);
		frmInicial.getContentPane().add(txtCantArquitectos);

		JLabel lblCantidadDeProgramadores = new JLabel("Cantidad de programadores:");
		lblCantidadDeProgramadores.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeProgramadores.setForeground(new Color(139, 69, 19));
		lblCantidadDeProgramadores.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeProgramadores.setBounds(47, 256, 340, 45);
		frmInicial.getContentPane().add(lblCantidadDeProgramadores);

		txtCantProgramadores = new JTextField();
		txtCantProgramadores.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtCantProgramadores.setColumns(10);
		txtCantProgramadores.setBounds(420, 264, 114, 31);
		frmInicial.getContentPane().add(txtCantProgramadores);

		JLabel lblCantidadDeTesters = new JLabel("Cantidad de testers:");
		lblCantidadDeTesters.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeTesters.setForeground(new Color(139, 69, 19));
		lblCantidadDeTesters.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCantidadDeTesters.setBounds(47, 299, 280, 45);
		frmInicial.getContentPane().add(lblCantidadDeTesters);

		txtCantTesters = new JTextField();
		txtCantTesters.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtCantTesters.setColumns(10);
		txtCantTesters.setBounds(420, 307, 114, 31);
		frmInicial.getContentPane().add(txtCantTesters);

		JButton btnContinuarProceso = new JButton("Continuar");
		btnContinuarProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cantLideres = Integer.parseInt(txtCantLideres.getText().trim());
					int cantArquitectos = Integer.parseInt(txtCantArquitectos.getText().trim());
					int cantProgramadores = Integer.parseInt(txtCantProgramadores.getText().trim());
					int cantTesters = Integer.parseInt(txtCantTesters.getText().trim());

					if (cantLideres < 0 || cantArquitectos < 0 || cantProgramadores < 0 || cantTesters < 0) {
						JOptionPane.showMessageDialog(frmInicial, "Los valores no pueden ser negativos.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					PersonalLaboral personal = new PersonalLaboral();

					IngresoDePersonal ingresoDePersonal = new IngresoDePersonal(personal, cantLideres, cantArquitectos,
							cantProgramadores, cantTesters);
					ingresoDePersonal.mostrarVentana();
					frmInicial.dispose();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frmInicial, "Ingrese solamente números.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnContinuarProceso.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnContinuarProceso.setBounds(154, 370, 239, 53);
		frmInicial.getContentPane().add(btnContinuarProceso);
	}

	public void mostrarVentana() {
		frmInicial.setVisible(true);
	}
}