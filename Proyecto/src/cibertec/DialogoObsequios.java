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

public class DialogoObsequios extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblObsequio1;
	private JLabel lblObsequio2;
	private JLabel lblObsequio3;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoObsequios dialog = new DialogoObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogoObsequios() {
		setTitle("Configurar Obsequios");
		setModal(true);
		setAutoRequestFocus(false);
		setBounds(100, 100, 500, 189);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			lblObsequio1 = new JLabel("1 unidad");
			lblObsequio1.setBounds(45, 37, 68, 14);
			contentPanel.add(lblObsequio1);		
		
			lblObsequio2 = new JLabel("2 a 5 unidades");
			lblObsequio2.setBounds(45, 62, 86, 14);
			contentPanel.add(lblObsequio2);		
		
			lblObsequio3 = new JLabel("6 a m\u00E1s unidades");
			lblObsequio3.setBounds(45, 87, 95, 14);
			contentPanel.add(lblObsequio3);		
		
			txtObsequio1 = new JTextField();
			txtObsequio1.setBounds(209, 31, 102, 20);
			contentPanel.add(txtObsequio1);
			txtObsequio1.setColumns(10);		
		
			txtObsequio2 = new JTextField();
			txtObsequio2.setColumns(10);
			txtObsequio2.setBounds(209, 56, 102, 20);
			contentPanel.add(txtObsequio2);
		
			txtObsequio3 = new JTextField();
			txtObsequio3.setColumns(10);
			txtObsequio3.setBounds(209, 81, 102, 20);
			contentPanel.add(txtObsequio3);
		
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(366, 28, 89, 23);
			contentPanel.add(btnAceptar);
		
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(366, 53, 89, 23);
			contentPanel.add(btnCancelar);
		
			MostrarDatos();
		
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
		String obs1,obs2,obs3;
		obs1=getObsequio(txtObsequio1);
		obs2=getObsequio(txtObsequio2);
		obs3=getObsequio(txtObsequio3);
		mostrarAlertas(obs1, obs2, obs3);
	}
	//Metodos
	void mostrarAlertas(String o1,String o2,String o3){
		if(o1.length()==0) {mensaje(txtObsequio1);}
		else if(o2.length()==0){mensaje(txtObsequio2);}
		else if(o3.length()==0){mensaje(txtObsequio3);}
		else {
			Tienda.obsequio1=o1;
			Tienda.obsequio2=o2;
			Tienda.obsequio3=o3;
			dispose();
		}
	}
	void mensaje(JTextField o) {
		JOptionPane.showMessageDialog(this, "No se puede dejar la caja en blanco.");
		o.requestFocus();
	}
	String getObsequio(JTextField o) {
		return o.getText();
	}

	void MostrarDatos() {
		txtObsequio1.setText(Tienda.obsequio1);
		txtObsequio2.setText(Tienda.obsequio2);
		txtObsequio3.setText(Tienda.obsequio3);
	}


}
