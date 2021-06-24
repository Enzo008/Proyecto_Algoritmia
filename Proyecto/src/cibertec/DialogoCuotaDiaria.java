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

public class DialogoCuotaDiaria extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblCuota;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoCuotaDiaria dialog = new DialogoCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogoCuotaDiaria() {
		setModal(true);
		setAutoRequestFocus(false);
		setTitle("Configurar Cuota Diaria");
		setBounds(100, 100, 446, 103);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCuota = new JLabel("Cuota diaria esperada (S/.)");
		lblCuota.setBounds(10, 13, 147, 14);
		contentPanel.add(lblCuota);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(167, 10, 113, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(331, 10, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(331, 36, 89, 23);
		contentPanel.add(btnCancelar);
		
		setCuotaDiaria();
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
		try{
			double cuo=getCuotaDiaria();
			mostrarAlerta(cuo);
		}catch(Exception x){
			alerta("La cantidad debe ser un número entero.");
		}
		
	}
	//Metodos
	void mostrarAlerta(double c){
		if(c<=0) {
			alerta("La cuota diaria no puede ser menor a 0.");
			txtCantidad.requestFocus();
			txtCantidad.selectAll();
		}else {
			Tienda.cuotaDiaria=c;
			dispose();
		}
	}
	void alerta(String cad){
		JOptionPane.showMessageDialog(this,cad);
		txtCantidad.requestFocus();
		txtCantidad.selectAll();
	}
	double getCuotaDiaria() {
		return Double.parseDouble(txtCantidad.getText());
	}
	void setCuotaDiaria() {
		txtCantidad.setText(""+Tienda.cuotaDiaria);
	}

}
