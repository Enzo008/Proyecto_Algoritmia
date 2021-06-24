package cibertec;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DialogoAcercaDeTienda extends JDialog implements ActionListener {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JButton btnCerrar;
	private JLabel lblTitulo;
	private JLabel lblSubTitulo;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoAcercaDeTienda dialog = new DialogoAcercaDeTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAcercaDeTienda() {
		setTitle("Acerca De");
		setAutoRequestFocus(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(170, 230, 89, 23);
		contentPanel.add(btnCerrar);
		
		lblTitulo = new JLabel("Tienda Cibertec");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(142, 11, 161, 39);
		contentPanel.add(lblTitulo);
		
		lblSubTitulo = new JLabel("Autores");
		lblSubTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubTitulo.setBounds(189, 61, 70, 20);
		contentPanel.add(lblSubTitulo);
		
		lblNewLabel_2 = new JLabel("Enzo Fabricio Gago Aguirre");
		lblNewLabel_2.setBounds(40, 106, 149, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Gianella Ram\u00EDrez Mart\u00EDnez");
		lblNewLabel_3.setBounds(40, 137, 149, 14);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Mariavictoria Gonzales Guti\u00E9rrez  ");
		lblNewLabel_4.setBounds(40, 168, 174, 14);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Juan Daniel Quesada \u00D1arques");
		lblNewLabel_5.setBounds(40, 199, 149, 14);
		contentPanel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Gianella Calvo Llangato");
		lblNewLabel_6.setBounds(248, 137, 149, 14);
		contentPanel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Karla Fabiana Vargas Camino");
		lblNewLabel_7.setBounds(248, 168, 149, 14);
		contentPanel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Juan Diego Maldonado Rojas");
		lblNewLabel_8.setBounds(248, 199, 149, 14);
		contentPanel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Britny Tamara Lopez Paz");
		lblNewLabel_9.setBounds(248, 106, 149, 14);
		contentPanel.add(lblNewLabel_9);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
		
	
}
