package cibertec;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class DialogoListar extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JButton btnListar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
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
			DialogoListar dialog = new DialogoListar();
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
	public DialogoListar() {
		setModal(true);
		setAutoRequestFocus(false);
		setTitle("Listado de Lavadoras");
		setBounds(100, 100, 530, 352);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 494, 251);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(162, 278, 89, 23);
		btnCerrar.addActionListener(this);
		contentPanel.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(265, 278, 89, 23);
		btnListar.addActionListener(this);
		contentPanel.add(btnListar);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("LISTADO DE LAVADORAS\n\n");
		mostrarDatos(Tienda.modelo0,Tienda.precio0,Tienda.fondo0,Tienda.ancho0,Tienda.alto0,Tienda.capacidad0);
		mostrarDatos(Tienda.modelo1,Tienda.precio1,Tienda.fondo1,Tienda.ancho1,Tienda.alto1,Tienda.capacidad1);
		mostrarDatos(Tienda.modelo2,Tienda.precio2,Tienda.fondo2,Tienda.ancho2,Tienda.alto2,Tienda.capacidad2);
		mostrarDatos(Tienda.modelo3,Tienda.precio3,Tienda.fondo3,Tienda.ancho3,Tienda.alto3,Tienda.capacidad3);
		mostrarDatos(Tienda.modelo4,Tienda.precio4,Tienda.fondo4,Tienda.ancho4,Tienda.alto4,Tienda.capacidad4);
	}
	//Metodos
	void mostrarDatos(String mod,double pre,double fon,double anc,double alt,double cap) {
		imprimir("Modelo      : "+mod);
		imprimir("Precio      : S/. "+pre);
		imprimir("Profundidad : "+fon+" cm");
		imprimir("Ancho       : "+anc+" cm");
		imprimir("Alto        : "+alt+" cm");
		imprimir("Capacidad   : "+cap+" km\n");
	}
	void imprimir(String cad) {
		txtS.append(cad+"\n");
	}

	
}
