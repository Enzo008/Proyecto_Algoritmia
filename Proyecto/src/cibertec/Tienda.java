package cibertec;

import java.awt.EventQueue;
/* 01100111 01110010 01110101 01110000 01101111 00100000 00110100 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnuArchivo;
	private JMenuItem mnuSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultar;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;
	private JMenuItem mntmListar;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenuItem mntmModificar;
	private JMenuItem mntmVender;
	private JMenuItem mntmReportes;
	private JMenuItem mntmDescuentos;
	private JMenuItem mntmObsequios;
	private JMenuItem mntmCantidadOptima;
	private JMenuItem mntmCuotaDiaria;
	

	// Datos m?nimos de la primera lavadora
	public static String modelo0 = "WHIRLPOOL WWI16BSBLA";
	public static double precio0 = 999.0;
	public static double fondo0 = 67.0;
	public static double ancho0 = 64.0;
	public static double alto0 = 105.0;
	public static double capacidad0 = 16;
	// Datos m?nimos de la segunda lavadora
	public static String modelo1 = "SAMSUNG WA17T6260BW";
	public static double precio1 = 1199.0;
	public static double ancho1 = 63.0;
	public static double alto1 = 108.0;
	public static double fondo1 = 69.0;
	public static double capacidad1 = 17;
	// Datos m?nimos de la tercera lavadora
	public static String modelo2 = "MABE LMA72200WDBB1";
	public static double precio2 = 1599.0;
	public static double ancho2 = 68.0;
	public static double alto2 = 109.0;
	public static double fondo2 = 68.0;
	public static double capacidad2 = 22;
	// Datos m?nimos de la cuarta lavadora
	public static String modelo3 = "WINIA WLA-195ECG";
	public static double precio3 = 899.0;
	public static double ancho3 = 52.5;
	public static double alto3 = 85.5;
	public static double fondo3 = 53.5;
	public static double capacidad3 = 6.5;
	// Datos m?nimos de la quinta lavadora
	public static String modelo4 = "LG TS1604NW";
	public static double precio4 = 1099.0;
	public static double ancho4 = 63.2;
	public static double alto4 = 102.0;
	public static double fondo4 = 67;
	public static double capacidad4 = 17;
	// Porcentajes de descuento
	public static double porcentaje1 = 7;
	public static double porcentaje2 = 10;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15;
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	// Cantidad ?ptima de unidades vendidas
	public static int cantidadOptima = 10;
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tienda() {
		setTitle("Tienda");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 465);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnuArchivo = new JMenu("Archivo");
		menuBar.add(mnuArchivo);

		mnuSalir = new JMenuItem("Salir  ");
		mnuSalir.addActionListener(this);
		mnuArchivo.add(mnuSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(this);
		mnMantenimiento.add(mntmConsultar);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(this);
		
		mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(this);//PASO IMPORTANTE
		mnMantenimiento.add(mntmModificar);
		mnMantenimiento.add(mntmListar);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmReportes = new JMenuItem("Reportes");
		mntmReportes.addActionListener(this);
		mnVentas.add(mntmReportes);
		
		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracion);
		
		mntmDescuentos = new JMenuItem("Descuentos");
		mntmDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmDescuentos);
		
		mntmObsequios = new JMenuItem("Obsequios");
		mntmObsequios.addActionListener(this);
		mnConfiguracion.add(mntmObsequios);
		
		mntmCantidadOptima = new JMenuItem("Cantidad \u00D3ptima");
		mntmCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmCantidadOptima);
		
		mntmCuotaDiaria = new JMenuItem("Cuota Diaria");
		mntmCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmCuotaDiaria);

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);

		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Cibertec_Coding\\Java\\ProyectoFinal\\cibertec.jpg"));
		lbLogo.setBounds(217, 128, 283, 115);
		contentPane.add(lbLogo);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mnuSalir) {
			actionPerformedMnuSalir(arg0);
		}
		if (arg0.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(arg0);
		}
		if (arg0.getSource() == mntmModificar) {
			actionPerformedMntmModificar(arg0);
		}
		if (arg0.getSource() == mntmListar) {
			actionPerformedMntmListar(arg0);
		}
		if (arg0.getSource() == mntmVender) {
			actionPerformedMntmVender(arg0);
		}
		if (arg0.getSource() == mntmReportes) {
			actionPerformedMntmReportes(arg0);
		}
		if (arg0.getSource() == mntmDescuentos) {
			actionPerformedMntmDescuentos(arg0);
		}
		if (arg0.getSource() == mntmObsequios) {
			actionPerformedMntmObsequios(arg0);
		}
		if (arg0.getSource() == mntmCantidadOptima) {
			actionPerformedMntmCantidadOptima(arg0);
		}
		if (arg0.getSource() == mntmCuotaDiaria) {
			actionPerformedMntmCuotaDiaria(arg0);
		}
		if (arg0.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(arg0);
		}		
	}
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent arg0) {
		DialogoAcercaDeTienda d = new DialogoAcercaDeTienda();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	private void actionPerformedMntmCuotaDiaria(ActionEvent arg0) {
		DialogoCuotaDiaria d = new DialogoCuotaDiaria();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	private void actionPerformedMntmCantidadOptima(ActionEvent arg0) {
		DialogoCantidadOptima d = new DialogoCantidadOptima();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	private void actionPerformedMntmObsequios(ActionEvent arg0) {
		DialogoObsequios d = new DialogoObsequios();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	private void actionPerformedMntmDescuentos(ActionEvent arg0) {
		DialogoDescuentos d = new DialogoDescuentos();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmReportes(ActionEvent arg0) {
		DialogoReportes d = new DialogoReportes();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmVender(ActionEvent arg0) {
		DialogoVender d = new DialogoVender();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}

	protected void actionPerformedMntmListar(ActionEvent arg0) {
		DialogoListar d = new DialogoListar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmModificar(ActionEvent arg0) {
		DialogoModificar d = new DialogoModificar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmConsultar(ActionEvent arg0) {
		DialogoConsultar d = new DialogoConsultar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMnuSalir(ActionEvent arg0) {
		System.exit(0);
	}
}