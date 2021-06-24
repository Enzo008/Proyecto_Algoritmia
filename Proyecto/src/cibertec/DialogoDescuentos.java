package cibertec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DialogoDescuentos extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescuento4;
	private JTextField txtDescuento3;
	private JTextField txtDescuento2;
	private JTextField txtDescuento1;
	private JLabel lblDescuento1;
	private JLabel lblDescuento2;
	private JLabel lblDescuento3;
	private JLabel lblDescuento4;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblporcent;
	private JLabel lblporcent_1;
	private JLabel lblporcent_2;
	private JLabel lblporcent_3;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoDescuentos dialog = new DialogoDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogoDescuentos() {
		setTitle("Configurar Descuentos");
		setModal(true);
		setAutoRequestFocus(false);
		setBounds(100, 100, 467, 159);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblDescuento1 = new JLabel("1 a 5 unidades ");
		lblDescuento1.setBounds(10, 21, 90, 14);
		contentPanel.add(lblDescuento1);
		
		lblDescuento2 = new JLabel("6 a 10 unidades");
		lblDescuento2.setBounds(10, 46, 90, 14);
		contentPanel.add(lblDescuento2);
		
		lblDescuento3 = new JLabel("11 a 15 unidades");
		lblDescuento3.setBounds(10, 71, 90, 14);
		contentPanel.add(lblDescuento3);
		
		lblDescuento4 = new JLabel("M\u00E1s de 15 unidades");
		lblDescuento4.setBounds(10, 96, 106, 14);
		contentPanel.add(lblDescuento4);
		
		txtDescuento4 = new JTextField();
		txtDescuento4.setBounds(126, 93, 116, 20);
		contentPanel.add(txtDescuento4);
		txtDescuento4.setColumns(10);
		
		txtDescuento3 = new JTextField();
		txtDescuento3.setColumns(10);
		txtDescuento3.setBounds(126, 68, 116, 20);
		contentPanel.add(txtDescuento3);
		
		txtDescuento2 = new JTextField();
		txtDescuento2.setColumns(10);
		txtDescuento2.setBounds(126, 43, 116, 20);
		contentPanel.add(txtDescuento2);
		
		txtDescuento1 = new JTextField();
		txtDescuento1.setColumns(10);
		txtDescuento1.setBounds(126, 18, 116, 20);
		contentPanel.add(txtDescuento1);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(352, 16, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(352, 42, 89, 23);
		contentPanel.add(btnCancelar);
		
		lblporcent = new JLabel("%");
		lblporcent.setBounds(254, 21, 46, 14);
		contentPanel.add(lblporcent);
		
		lblporcent_1 = new JLabel("%");
		lblporcent_1.setBounds(252, 46, 46, 14);
		contentPanel.add(lblporcent_1);
		
		lblporcent_2 = new JLabel("%");
		lblporcent_2.setBounds(252, 71, 46, 14);
		contentPanel.add(lblporcent_2);
		
		lblporcent_3 = new JLabel("%");
		lblporcent_3.setBounds(252, 96, 46, 14);
		contentPanel.add(lblporcent_3);
		
		mostrarDatos();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			double des1,des2,des3,des4;
			des1=getDescuento(txtDescuento1);
			des2=getDescuento(txtDescuento2);
			des3=getDescuento(txtDescuento3);
			des4=getDescuento(txtDescuento4);
			mostrarAlerta(des1, des2, des3, des4);
		}
		catch(Exception x) {
			JOptionPane.showMessageDialog(this, "Revise que todas las cantidades sean números enteros");
		}
		
	}
	//Metodos
	void mostrarAlerta(double d1,double d2,double d3, double d4) {
		if(d1<0 || d1>100) {
			alerta(txtDescuento1);
		}else if(d2<0 || d2>100) {
			alerta(txtDescuento2);
		}else if(d3<0 || d3>100) {
			alerta(txtDescuento3);
		}else if(d4<0 || d4>100) {
			alerta(txtDescuento4);
			
		}else {
			Tienda.porcentaje1=d1;
			Tienda.porcentaje2=d2;
			Tienda.porcentaje3=d3;
			Tienda.porcentaje4=d4;
			dispose();
		}
	}
	void alerta(JTextField d) {
		JOptionPane.showMessageDialog(this, "El numero no puede ser menor a 0 ni mayor a 100");
		d.requestFocus();
		d.selectAll();
	}
	double getDescuento(JTextField d) {
		return Double.parseDouble(d.getText());
	}
	void mostrarDatos() {
		txtDescuento1.setText(Tienda.porcentaje1+"");
		txtDescuento2.setText(Tienda.porcentaje2+"");
		txtDescuento3.setText(Tienda.porcentaje3+"");
		txtDescuento4.setText(Tienda.porcentaje4+"");
	}
}
