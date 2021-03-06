package cibertec;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class DialogoVender extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JLabel lblModelo;
	private JComboBox<String> cboCodigo;
	private JLabel lblPrecio;

	private JButton btnVender;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JTextField txtCantidad;
	private JTextField txtPrecio;


	
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
			DialogoVender dialog = new DialogoVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @return 
	 */
	
	public DialogoVender() {
		setModal(true);
		setAutoRequestFocus(false);
		setTitle("Vender");
		setResizable(false);
		setBounds(100, 100, 509, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 56, 19);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(100, 38, 242, 20);
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(txtPrecio);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(100, 65, 242, 20);
		txtCantidad.setColumns(10);
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(txtCantidad);
		
		cboCodigo = new JComboBox<String>();
		cboCodigo.setBounds(100, 12, 242, 20);
		cboCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel<String>(new String[] {"WHIRLPOOL WWI16BSBLA", "SAMSUNG WA17T6260BW", "MABE LMA72200WDBB1","WINIA WLA-195ECG","LG TS1604NW"}));
		contentPanel.add(cboCodigo);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(398, 41, 89, 23);
		btnCerrar.addActionListener(this);
		contentPanel.add(btnCerrar);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 41, 81, 19);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 66, 81, 19);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblCantidad);
		
		btnVender = new JButton("Vender");
		btnVender.setBounds(398, 11, 89, 23);
		btnVender.addActionListener(this);
		contentPanel.add(btnVender);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 477, 213);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		txtPrecio.setText(""+Tienda.precio0);
	}

	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == cboCodigo) {
			actionPerformedCboCodigo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
	
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedCboCodigo(ActionEvent e) {
		txtCantidad.requestFocus();
		int cod=getCodigo();
		precio(cod);
	}
	//Metodos
	int getCodigo() {
		return cboCodigo.getSelectedIndex();
	}
	void precio(int c) {
		switch(c) {
		case 0: setPrecio(Tienda.precio0);
		break;
		case 1: setPrecio(Tienda.precio1);
		break;
		case 2: setPrecio(Tienda.precio2);
		break;
		case 3: setPrecio(Tienda.precio3);
		break;
		default:setPrecio(Tienda.precio4);
		}
	}
	void setPrecio(double p) {
			txtPrecio.setText(p+"");
	}
	//Variables Globales//
	//Acumulador de ventas
	public static int acumVentas0=0;
	public static int acumVentas1=0;
	public static int acumVentas2=0;
	public static int acumVentas3=0;
	public static int acumVentas4=0;
	//Acumulador de cantidades
	public static int acumCant0=0;
	public static int acumCant1=0;
	public static int acumCant2=0;
	public static int acumCant3=0;
	public static int acumCant4=0;
	//Acumulador de Importe
	public static double acumIpag0=0;
	public static double acumIpag1=0;
	public static double acumIpag2=0;
	public static double acumIpag3=0;
	public static double acumIpag4=0;
	
	//Acumuladores de Alerta
	public static double acumAlerta=0.0;
	public static int acumVentas=0;
	
	public void actionPerformedBtnVender(ActionEvent e) {
		try {
			txtCantidad.requestFocus();
			//Variables Locales
			String model,obs;
			int cod=getCodigo();
			int can=getCantidad();
			double prec,icom,ides,ipag;	
			if(can<=0) {
				alerta("La cantidad no puede ser menor o igual a 0.");
			}else {
				acumVentas++;
				prec=getPrecio(cod);
				model=getModelo(cod);
				acumuladores(cod, can);
				icom=calculoImporteCompra(prec, can);
				ides=calculoImporteDescuento(can, icom);
				ipag=calculoImportePaga(icom, ides);
				obs=getObsequio(can);
				mostrarDatos(model, prec, can, icom, ides, ipag, obs);
				acumuladorImporteModelo(prec, ipag);
				alertaVentas(ipag);
				txtCantidad.setText("");
				txtCantidad.requestFocus();
			}
		}
		catch(Exception x){
			alerta("La cantidad debe ser un n?mero entero.");
		}
	}
	
	//Metodos
	int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	void alerta(String cad){
			JOptionPane.showMessageDialog(this, cad);
			txtCantidad.requestFocus();
			txtCantidad.selectAll();		
	}
	double getPrecio(int c) {
		switch(c) {
		case 0:return Tienda.precio0;
		case 1:return Tienda.precio1;
		case 2:return Tienda.precio2;
		case 3:return Tienda.precio3;
		default:return Tienda.precio4;
		}
	}
	String getModelo(int c) {
		switch(c) {
		case 0:return Tienda.modelo0;
		case 1:return Tienda.modelo1;
		case 2:return Tienda.modelo2;
		case 3:return Tienda.modelo3;
		default:return Tienda.modelo4;
		}
	}
	void acumuladores(int c,int ca){
		switch(c) {
		case 0: acumVentas0++;acumCant0+=ca;break;
		case 1: acumVentas1++;acumCant1+=ca;break;
		case 2: acumVentas2++;acumCant2+=ca;break;
		case 3: acumVentas3++;acumCant3+=ca;break;
		default:acumVentas4++;acumCant4+=ca;
		}
	}
	double calculoImporteCompra(double p,int c) {
		return p*c;
	}	
	double calculoImporteDescuento(int c,double ic) {
		if(c>=15) {return ic*(Tienda.porcentaje4/100);}
		else if(c>=11) {return ic*(Tienda.porcentaje3/100);}
		else if(c>=6) {return ic*(Tienda.porcentaje2/100);}
		else {return ic*(Tienda.porcentaje1/100);}
	}
	double calculoImportePaga(double icom,double ides) {
		return icom-ides;
	}
	String getObsequio(int c) {
		if(c>=5) {return Tienda.obsequio3;}
		else if(c>=2){return Tienda.obsequio2;}
		else {return Tienda.obsequio1;}
	}
	void mostrarDatos(String m,double p,int c,double ic,double id,double ip,String o) {
		txtS.setText("");
		imprimir("BOLETA DE VENTA:\n");
		imprimir("Modelo            : "+m);
		imprimir("Precio            : S/. "+p);
		imprimir("Cantidad          : "+c);
		imprimir("Importe Compra    : S/. "+ic);
		imprimir("Importe Descuento : S/. "+id);
		imprimir("Importe Pagar     : S/. "+ip);
		imprimir("Obsequio          : "+o);
	}
	void acumuladorImporteModelo(double p,double ip) {
		if(p==Tienda.precio0) {acumIpag0+=ip;}
		else if(p==Tienda.precio1) {acumIpag1+=ip;}
		else if(p==Tienda.precio2) {acumIpag2+=ip;}
		else if(p==Tienda.precio3) {acumIpag3+=ip;}
		else {acumIpag4+=ip;}
	}
	void alertaVentas(double ip) {
		acumAlerta+=ip;
		if(acumVentas%5==0) {
			JOptionPane.showMessageDialog(this,"Venta Nro. "+acumVentas+"\n"+"Importe total general acumulado: "
					+ "S/."+acumAlerta+ "\nPorcentaje de la cuota diaria: "+((acumAlerta/Tienda.cuotaDiaria)*100)+"%");		
		}
	}
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}