package cibertec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class DialogoReportes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JComboBox<String> cboCodigo;
	private JLabel lblReporte;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoReportes dialog = new DialogoReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DialogoReportes() {
		setAutoRequestFocus(false);
		setModal(true);
		setTitle("Generar Reportes");
		setBounds(100, 100, 682, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblReporte = new JLabel("Tipos de Reporte");
		lblReporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReporte.setBounds(10, 13, 98, 14);
		contentPanel.add(lblReporte);
		
		cboCodigo = new JComboBox<String>();
		cboCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel<String>(new String[] {"Ventas por modelo", "Ventas en relaci\u00F3n \u00F3ptima de unidades vendidas", "Precios en relaci\u00F3n al precio promedio", "Promedios, menores y mayores"}));
		cboCodigo.setBounds(118, 10, 390, 22);
		contentPanel.add(cboCodigo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(567, 11, 89, 23);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 646, 221);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		ventasPorModelo(aporteCuota(DialogoVender.acumIpag0), aporteCuota(DialogoVender.acumIpag1), aporteCuota(DialogoVender.acumIpag2), aporteCuota(DialogoVender.acumIpag3), aporteCuota(DialogoVender.acumIpag4));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboCodigo) {
			actionPerformedCboCodigo(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
	int getCodigo() {
		return cboCodigo.getSelectedIndex();
	}
			
	protected void actionPerformedCboCodigo(ActionEvent e) {
		int cod=getCodigo();
		//CASE 0
		double aCuo0,aCuo1,aCuo2,aCuo3,aCuo4;	
		aCuo0=aporteCuota(DialogoVender.acumIpag0);
		aCuo1=aporteCuota(DialogoVender.acumIpag1);
		aCuo2=aporteCuota(DialogoVender.acumIpag2);
		aCuo3=aporteCuota(DialogoVender.acumIpag3);
		aCuo4=aporteCuota(DialogoVender.acumIpag4);
		//CASE 1
		int dif0=0,dif1=0,dif2=0,dif3=0,dif4=0;
		String imp0,imp1,imp2,imp3,imp4;
		imp0=cantidadOptima(DialogoVender.acumCant0,Tienda.cantidadOptima,dif0);
		imp1=cantidadOptima(DialogoVender.acumCant1,Tienda.cantidadOptima,dif1);
		imp2=cantidadOptima(DialogoVender.acumCant2,Tienda.cantidadOptima,dif2);
		imp3=cantidadOptima(DialogoVender.acumCant3,Tienda.cantidadOptima,dif3);
		imp4=cantidadOptima(DialogoVender.acumCant4,Tienda.cantidadOptima,dif4);
		//CASE 2
		double prom=(Tienda.precio0+Tienda.precio1+Tienda.precio2+Tienda.precio3+Tienda.precio4)/5;
		String pre0,pre1,pre2,pre3,pre4;
		pre0=promedioPrecio(prom,Tienda.precio0);
		pre1=promedioPrecio(prom,Tienda.precio1);
		pre2=promedioPrecio(prom,Tienda.precio2);
		pre3=promedioPrecio(prom,Tienda.precio3);
		pre4=promedioPrecio(prom,Tienda.precio4);
		//DEFAULT
		double preMen,preMay,anMen,anMay,fonMen,fonMay,alMen,alMay,capMen,capMay;
		preMen=menor(Tienda.precio0,Tienda.precio1,Tienda.precio2,Tienda.precio3,Tienda.precio4);
		preMay=mayor(Tienda.precio0,Tienda.precio1,Tienda.precio2,Tienda.precio3,Tienda.precio4);
		anMen=menor(Tienda.ancho0,Tienda.ancho1,Tienda.ancho2,Tienda.ancho3,Tienda.ancho4);
		anMay=mayor(Tienda.ancho0,Tienda.ancho1,Tienda.ancho2,Tienda.ancho3,Tienda.ancho4);
		fonMen=menor(Tienda.fondo0,Tienda.fondo1,Tienda.fondo2,Tienda.fondo3,Tienda.fondo4);
		fonMay=mayor(Tienda.fondo0,Tienda.fondo1,Tienda.fondo2,Tienda.fondo3,Tienda.fondo4);
		alMen=menor(Tienda.alto0,Tienda.alto1,Tienda.alto2,Tienda.alto3,Tienda.alto4);
		alMay=mayor(Tienda.alto0,Tienda.alto1,Tienda.alto2,Tienda.alto3,Tienda.alto4);
		capMen=menor(Tienda.capacidad0,Tienda.capacidad1,Tienda.capacidad2,Tienda.capacidad3,Tienda.capacidad4);
		capMay=mayor(Tienda.capacidad0,Tienda.capacidad1,Tienda.capacidad2,Tienda.capacidad3,Tienda.capacidad4);
		//CASOS
		switch(cod) {
		case 0:
			ventasPorModelo(aCuo0, aCuo1, aCuo2, aCuo3, aCuo4);
			break;
		case 1:
			ventasRelacionOptima(imp0, imp1, imp2, imp3, imp4);
			break;
		case 2:     
			preciosRelacionPromedio(pre0, pre1, pre2, pre3, pre4);
			break;
		default:
			promedioMenoresMayores(prom, preMen, preMay, anMen, anMay, fonMen, fonMay, alMen, alMay, capMen, capMay);
		}
	}
	//------------CASE-0-------------
	void ventasPorModelo(double a0,double a1,double a2,double a3,double a4) {
		txtS.setText("VENTAS POR MODELO:\n\n");
		imprimirVentas(Tienda.modelo0, DialogoVender.acumVentas0, DialogoVender.acumCant0, DialogoVender.acumIpag0, a0);
		imprimirVentas(Tienda.modelo1, DialogoVender.acumVentas1, DialogoVender.acumCant1, DialogoVender.acumIpag1, a1);
		imprimirVentas(Tienda.modelo2, DialogoVender.acumVentas2, DialogoVender.acumCant2, DialogoVender.acumIpag2, a2);
		imprimirVentas(Tienda.modelo3, DialogoVender.acumVentas3, DialogoVender.acumCant3, DialogoVender.acumIpag3, a3);
		imprimirVentas(Tienda.modelo4, DialogoVender.acumVentas4, DialogoVender.acumCant4, DialogoVender.acumIpag4, a4);
	}
	void imprimirVentas(String t,int av,int ac,double ai,double a){
		imprimir("Modelo                        : "+t);
		imprimir("Cantidad de ventas            : "+av);
		imprimir("Cantidad de unidades vendidas : "+ac);
		imprimir("Importe total vendido         : S/."+ai);
		imprimir("Aporte de la cuota diaria     : "+a+"%\n");
	}
	double aporteCuota(double ai) {
		return ai/Tienda.cuotaDiaria*100;
	}
	//------------CASE-1-------------
	//Calculo Ventas Relacion Optima
	String masCantidad(int d) {
		return "("+d+" m?s que la cantidad ?ptima)";
	}
	String menosCantidad(int d) {
		return "("+d+" menos que la cantidad ?ptima)";
	}
	String cantidadOptima(int ac,int co,int d) {
		if(ac>co) {
			d=ac-co;
			return masCantidad(d);
		}else {
			d=co-ac;
			return menosCantidad(d);
		}
	}
	void ventasRelacionOptima(String im0,String im1,String im2,String im3,String im4) {
		txtS.setText("VENTAS EN RELACI?N A LA CANTIDAD ?PTIMA DE UNIDADES VENDIDAS\n\n");
		imprimirRelacionOptima(Tienda.modelo0, DialogoVender.acumCant0, im0);
		imprimirRelacionOptima(Tienda.modelo1, DialogoVender.acumCant1, im1);
		imprimirRelacionOptima(Tienda.modelo2, DialogoVender.acumCant2, im2);
		imprimirRelacionOptima(Tienda.modelo3, DialogoVender.acumCant3, im3);
		imprimirRelacionOptima(Tienda.modelo4, DialogoVender.acumCant4, im4);
	}
	void imprimirRelacionOptima(String m,int ac,String imp) {
		imprimir("Modelo                        : "+m);
		imprimir("Cantidad de unidades vendidas : "+ac+imp+"\n");
	}
	//------------CASE-2-------------
	String promedioPrecio(double p,double t) {
		if(p>t) {return "(Menor al Promedio)";}
		else if(p<t) {return "(Mayor al Promedio)";}
		else{return "(Igual al Promedio)";}
	}
	void preciosRelacionPromedio(String p0,String p1,String p2,String p3,String p4) {
		txtS.setText("PRECIOS EN RELACI?N AL PRECIO PROMEDIO\n\n");
		imprimirRelacionPromedio(Tienda.modelo0,Tienda.precio0, p0);
		imprimirRelacionPromedio(Tienda.modelo1,Tienda.precio1, p1);
		imprimirRelacionPromedio(Tienda.modelo2,Tienda.precio2, p2);
		imprimirRelacionPromedio(Tienda.modelo3,Tienda.precio3, p3);
		imprimirRelacionPromedio(Tienda.modelo4,Tienda.precio4, p4);
	}	
	void imprimirRelacionPromedio(String m,double p,String ps) {
		imprimir("Modelo : "+m);
		imprimir("Precio : S/. "+p+ps+"\n");
	}
	//------------DEFAULT-------------
	void promedioMenoresMayores(double pProm, double pMe,double pMa, double anMe,double anMa, double fMe,double fMa, double alMe,double alMa, double cMe,double cMa) {
		txtS.setText("PROMEDIOS, MENORES Y MAYORES\n\n");
		imprimir("Precio promedio    : S/. "+pProm);
		imprimir("Precio menor       : S/. "+pMe);
		imprimir("Precio mayor       : S/. "+pMa+"\n");
		
		imprimir("Ancho promedio     : "+((Tienda.ancho0+Tienda.ancho1+Tienda.ancho2+Tienda.ancho3+Tienda.ancho4)/5)+" cm");
		imprimir("Ancho menor        : "+anMe+"cm");
		imprimir("Ancho mayor        : "+anMa+"cm\n");
		
		imprimir("Fondo promedio     : "+((Tienda.fondo0+Tienda.fondo1+Tienda.fondo2+Tienda.fondo3+Tienda.fondo4)/5)+" cm");
		imprimir("Fondo menor        : "+fMe+"cm");
		imprimir("Fondo mayor        : "+fMa+"cm\n");
		
		imprimir("Alto promedio      : "+((Tienda.alto0+Tienda.alto1+Tienda.alto2+Tienda.alto3+Tienda.alto4)/5)+" cm");
		imprimir("Alto menor         : "+alMe+"cm");
		imprimir("Alto mayor         : "+alMa+"cm\n");
		
		imprimir("Capacidad promedio : "+((Tienda.capacidad0+Tienda.capacidad1+Tienda.capacidad2+Tienda.capacidad3+Tienda.capacidad4)/5)+" cm");
		imprimir("Capacidad menor    : "+cMe+"cm");
		imprimir("Capacidad mayor    : "+cMa+"cm");
	}
	double menor(double x0,double x1,double x2,double x3,double x4) {
		if(x0<x1 && x0<x2 && x0<x3 && x0<x4) {return x0;}
		else if(x1<x0 && x1<x2 && x1<x3 && x1<x4) {return x1;}
		else if(x2<x0 && x2<x1 && x2<x3 && x2<x4) {return x2;}
		else if(x3<x0 && x3<x1 && x3<x2 && x3<x4) {return x3;}
		else {return x4;}
	}
	double mayor(double x0,double x1,double x2,double x3,double x4){
		if(x0>x1 && x0>x2 && x0>x3 && x0>x4) {return x0;}
		else if(x1>x0 && x1>x2 && x1>x3 && x1>x4) {return x1;}
		else if(x2>x0 && x2>x1 && x2>x3 && x2>x4) {return x2;}
		else if(x3>x0 && x3>x1 && x3>x2 && x3>x4) {return x3;}
		else {return x4;}
	}
}
