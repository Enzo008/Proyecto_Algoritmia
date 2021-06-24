package cibertec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DialogoCantidadOptima extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblCantidadOptima;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoCantidadOptima dialog = new DialogoCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogoCantidadOptima() {
		setTitle("Configurar Cantidad \u00D3ptima");
		setModal(true);
		setAutoRequestFocus(false);
		setBounds(100, 100, 405, 103);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCantidadOptima = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblCantidadOptima.setBounds(10, 13, 202, 14);
		contentPanel.add(lblCantidadOptima);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(222, 10, 47, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(290, 9, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(290, 35, 89, 23);
		contentPanel.add(btnCancelar);
		
		setCantidadOptima();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int canOp=getCantidadOptima();
			mostrarAlerta(canOp);
		}
		catch(Exception x){
			alerta("La cantidad debe ser un número entero.");
		}
		
	}
	//Metodos
	void mostrarAlerta(int c) {
		if(c<=0) {
			alerta("El número debe ser mayor a 0.");
		}else {
			Tienda.cantidadOptima=c;
			dispose();
		}
	}
	void alerta(String cad) {
		JOptionPane.showMessageDialog(this, cad);
		txtCantidad.requestFocus();
		txtCantidad.selectAll();
	}
	int getCantidadOptima() {
		return Integer.parseInt(txtCantidad.getText());
	}
	void setCantidadOptima() {
		txtCantidad.setText(""+Tienda.cantidadOptima);
	}

}
