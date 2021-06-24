package cibertec;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DialogoModificar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JLabel lblModelo;
	private JComboBox<String> cboCodigo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblCapacidad;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtFondo;
	private JTextField txtAlto;
	private JTextField txtCapacidad;
	private JButton btnGrabar;

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoModificar dialog = new DialogoModificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogoModificar() {
		setModal(true);
		setAutoRequestFocus(false);
		setTitle("Modificar Lavadora");
		setResizable(false);
		setBounds(100, 100, 541, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(10, 11, 56, 19);
		contentPanel.add(lblModelo);

		
		cboCodigo = new JComboBox<String>();
		cboCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel<String>(new String[] {"WHIRLPOOL WWI16BSBLA", "SAMSUNG WA17T6260BW", "MABE LMA72200WDBB1","WINIA WLA-195ECG","LG TS1604NW"}));
		cboCodigo.setBounds(142, 12, 242, 20);
		contentPanel.add(cboCodigo);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(429, 11, 89, 23);
		contentPanel.add(btnCerrar);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 41, 81, 19);
		contentPanel.add(lblPrecio);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAncho.setBounds(10, 71, 81, 19);
		contentPanel.add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlto.setBounds(10, 101, 81, 19);
		contentPanel.add(lblAlto);
		
		lblFondo = new JLabel("Fondo\r\n\r\n (cm)");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFondo.setBounds(10, 131, 81, 19);
		contentPanel.add(lblFondo);
		
		lblCapacidad = new JLabel("Capacidad (kg)");
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCapacidad.setBounds(10, 161, 103, 19);
		contentPanel.add(lblCapacidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(142, 42, 242, 20);
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAncho.setBounds(142, 72, 242, 20);
		contentPanel.add(txtAncho);
		
		txtFondo = new JTextField();
		txtFondo.setColumns(10);
		txtFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFondo.setBounds(142, 132, 242, 20);
		contentPanel.add(txtFondo);
		
		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAlto.setBounds(142, 102, 242, 20);
		contentPanel.add(txtAlto);
		
		txtCapacidad = new JTextField();
		txtCapacidad.setColumns(10);
		txtCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCapacidad.setBounds(142, 162, 242, 20);
		contentPanel.add(txtCapacidad);
		
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(429, 45, 89, 23);
		contentPanel.add(btnGrabar);
		
		setLavadora(Tienda.precio0, Tienda.ancho0, Tienda.alto0, Tienda.fondo0, Tienda.capacidad0);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == cboCodigo) {
			actionPerformedCboCodigo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedCboCodigo(ActionEvent e) {
		int cod=getCodigo();
		switch(cod) {
		// MODELO WHIRLPOOL WWI16BSBLA
		case 0:setLavadora(Tienda.precio0, Tienda.ancho0, Tienda.alto0, Tienda.fondo0, Tienda.capacidad0);
			break;
		//MODELO SAMSUNG WA17T6260BW
		case 1:setLavadora(Tienda.precio1, Tienda.ancho1, Tienda.alto1, Tienda.fondo1, Tienda.capacidad1);
			break;
		//MODELO MABE LMA72200WDBB1
		case 2:setLavadora(Tienda.precio2, Tienda.ancho2, Tienda.alto2, Tienda.fondo2, Tienda.capacidad2);
			break;
		//MODELO WINIA WLA-195ECG
		case 3:setLavadora(Tienda.precio3, Tienda.ancho3, Tienda.alto3, Tienda.fondo3, Tienda.capacidad3);
			break;
		//MODELO LG TS1604NW
		default:setLavadora(Tienda.precio4, Tienda.ancho4, Tienda.alto4, Tienda.fondo4, Tienda.capacidad4);
		}
	}
	//Metodos
	int getCodigo() {
		return cboCodigo.getSelectedIndex();
	}
	void setLavadora(double p,double an,double al,double f,double c){
		txtPrecio.setText(""+p);
		txtAncho.setText(""+an);
		txtAlto.setText(""+al);
		txtFondo.setText(""+f);
		txtCapacidad.setText(""+c);
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		try {
			int cod=getCodigo();
			double pre,anc,alt,fon,cap;
			pre= getPrecio();
			anc=getAncho();
			alt=getAlto();
			fon=getFondo();
			cap=getCapacidad();
			switch (cod) {
			case 0: mostrarAlerta(cod,pre, anc, alt, fon, cap);
				break;
			case 1: mostrarAlerta(cod,pre, anc, alt, fon, cap);
				break;
			case 2: mostrarAlerta(cod,pre, anc, alt, fon, cap);
				break;
			case 3: mostrarAlerta(cod,pre, anc, alt, fon, cap);
				break;
			default:mostrarAlerta(cod,pre, anc, alt, fon, cap);
			}
		}catch(Exception x){
			JOptionPane.showMessageDialog(this, "Revise que todas las cantidades sean números enteros");
		}
		
	}
	//Metodos
	double getPrecio(){return Double.parseDouble(txtPrecio.getText());}
	double getAncho(){return Double.parseDouble(txtAncho.getText());}
	double getAlto(){return Double.parseDouble(txtAlto.getText());}
	double getFondo(){return Double.parseDouble(txtFondo.getText());}
	double getCapacidad(){return Double.parseDouble(txtCapacidad.getText());}	
	
	void mostrarAlerta(int c,double p,double an,double al,double f,double ca) {
		if(p<=0) {mensaje(txtPrecio);}
		else if(an<=0) {mensaje(txtAncho);}
		else if(al<=0) {mensaje(txtAlto);}
		else if(f<=0) {mensaje(txtFondo);}
		else if(ca<=0) {mensaje(txtCapacidad);}
		else {nuevoDato(c, p, an, al, f, ca);
			dispose();}
	}
	void mensaje(JTextField x) {
		JOptionPane.showMessageDialog(this, "El numero no puede ser menor o igual 0.");
		x.requestFocus();
		x.selectAll();
	}
	void nuevoDato(int c,double p,double an,double al,double f,double ca) {
		switch(c) {
		case 0: Tienda.precio0=p;
				Tienda.ancho0=an;
				Tienda.alto0=al;
				Tienda.fondo0=f;
				Tienda.capacidad0=ca;
				break;
		case 1: Tienda.precio1=p;
				Tienda.ancho1=an;
				Tienda.alto1=al;
				Tienda.fondo1=f;
				Tienda.capacidad1=ca;
				break;
		case 2: Tienda.precio2=p;
				Tienda.ancho2=an;
				Tienda.alto2=al;
				Tienda.fondo2=f;
				Tienda.capacidad2=ca;
				break;
		case 3: Tienda.precio3=p;
				Tienda.ancho3=an;
				Tienda.alto3=al;
				Tienda.fondo3=f;
				Tienda.capacidad3=ca;
				break;
		default:Tienda.precio4=p;
				Tienda.ancho4=an;
				Tienda.alto4=al;
				Tienda.fondo4=f;
				Tienda.capacidad4=ca;
		}
	}
}