import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class VBorrar extends JFrame {

	private JPanel contentPane;
	JTextField textCodigo;
	JTable table;
	JButton btnSalir;
	JButton btnBuscar;
	JButton btnBorrar;
	 JLabel lblError;


	public VBorrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo");
		label.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 17));
		label.setBounds(107, 53, 79, 31);
		contentPane.add(label);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(196, 61, 176, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		btnBuscar.setBounds(401, 60, 89, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 99, 523, 204);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Direcci\u00F3n", "Municipio", "Precio", "Metros"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(296);
		table.getColumnModel().getColumn(1).setPreferredWidth(175);
		scrollPane.setViewportView(table);
		
		btnSalir = new JButton("salir");
		btnSalir.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		btnSalir.setBounds(467, 316, 89, 23);
		contentPane.add(btnSalir);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		btnBorrar.setBounds(33, 319, 89, 23);
		contentPane.add(btnBorrar);
		btnBorrar.setVisible(false);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblError.setBounds(129, 323, 328, 16);
		contentPane.add(lblError);
		
	}
	
		public void setControlador(Controlador c){
			btnBorrar.addActionListener(c);
			btnBuscar.addActionListener(c);
			btnSalir.addActionListener(c);
			table.addMouseListener(c);
		}

}
