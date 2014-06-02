

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

public class Fenetre2 extends JDialog {
	private ListeClient liste = null;
	private JTable table = null;
	private ModelTable model = null;
	private JFrame frame;
	public Fenetre2(JFrame frame, String string ,boolean b){
		super(frame,string,b);
		this.frame= frame;
		liste = new ListeClient();
		chargerClient();
		build();
	}

	private void build() {
		this.setTitle("Exercice JTable");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(300,600);
		this.addWindowListener(new WindowAdapter() {
			// red�finition de la m�thode
			public void windowClosing(WindowEvent e){
				// demander confirmation avec JOptionPane
				int v = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir quitter ?", "Confirmation", JOptionPane.YES_NO_OPTION, 2);
				// o pour oui et 1 pour non
				if( v == 0){
					// faire les differentes operations de maintenance
					// sauvegarde par exemple
					System.exit(0);
				}
			}
		});
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(1,1));
		table = new JTable();
		table.setPreferredSize(new Dimension(400, 300));
		model = new ModelTable(liste);
		table.setModel(model);
		// Selection simple au niveau des lignes au niveau de la JTable
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Permettre de trier l'affichage par colonne
		table.setAutoCreateRowSorter(true);
		
		//on va empecher de trier la colonne de date de naissance
		//TableRowSorter sorter = new TableRowSorter(model);
		//autre possibilit�
		TableRowSorter sorter = new TableRowSorter(table.getModel());
		table.setRowSorter(sorter);//Associer le gestionnaire de tri a la table
		sorter.setSortable(3, false);//bloque la colonne
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		
		table.getColumnModel().getColumn(1).setCellRenderer(new StringCellRenderer());
		table.getColumnModel().getColumn(2).setCellRenderer(new StringCellRenderer());
		table.getColumnModel().getColumn(3).setCellRenderer(new IntCellRenderer());
		table.getColumnModel().getColumn(4).setCellRenderer(new StringCellRenderer());
	
		
		// On va ajouter un listener lorsqu'on selectionne une ligne du tableau
		table.getSelectionModel().addListSelectionListener(new MaSelection());
		//table.getTableHeader().setDefaultRenderer(new changerEntete());
		//table.setDefaultRenderer(Object.class, new changerCellule());
		
		
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(scroll);
		// Il faut changer l'apparence des entetes de colonne, le type de retour au niveau des objets, modifier le retour du component, rendre editable
		this.getContentPane().add(pane, BorderLayout.CENTER);
		
		this.pack(); 
	}
	
	public void chargerClient(){
		String url = "jdbc:mysql://localhost/gestionjeux";
		String sql = "SELECT * FROM jeux";
		Jeux jeux = null;
		
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Calendar calendar = null;
		// Try avec ressource disponible a partir de java1.7
		try (Connection connection = DriverManager.getConnection(url, "root", "");
				Statement st = connection.createStatement()){
			rs = st.executeQuery(sql);
			while(rs.next()){
				jeux = new Jeux();
				jeux.setIdJeux(rs.getInt("idJeux"));
				jeux.setNom(rs.getString("nom"));
				jeux.setNumserie(rs.getString("numserie"));
				jeux.setDescription(rs.getString("description"));
				jeux.setPrix(rs.getInt("prix"));
				
				// On r�cupere une Date dans la DB et on en fait un Calendar
				
				liste.ajouterClient(jeux);
			}
			rsmd =(ResultSetMetaData) rs.getMetaData();
			int nbrChamp = rsmd.getColumnCount();
			String[] listChamps = new String[nbrChamp];
			for(int i =0;i<nbrChamp;i++){
				listChamps[i]= rsmd.getColumnClassName(i+1);
			}
			System.out.println(nbrChamp);
			System.out.println(Arrays.toString(listChamps));
			// System.out.println(Arrays.toString(liste.getClients().toArray()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Classe interne pour g�rer listes
	class MaSelection implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// System.out.println("Ok");
			DefaultListSelectionModel selection = (DefaultListSelectionModel) e.getSource();
			if (!selection.getValueIsAdjusting()){
				// Synchroniser le modele avec le tableau tri�
				int val = table.getRowSorter().convertRowIndexToModel(table.getSelectedRow());
				// Pour r�cuperer l'objet d'une ligne
				Jeux jeux = (Jeux) ((ModelTable)table.getModel()).getValue(val);
				System.out.println(jeux.toString());
			}
		}		
	}
	
	// Pour changer l'apparence des components par d�faut pour une JTable
	/*class changeEntete extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			this.setOpaque(true);
			this.setBackground(Color.DARK_GRAY);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("Verdana", Font.BOLD, 16));
			this.setHorizontalAlignment(CENTER);
			return this;
		}
	}*/
	
	class StringCellRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			this.setOpaque(true);
			this.setBackground(Color.DARK_GRAY);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("Verdana", Font.PLAIN, 12));
			this.setHorizontalAlignment(CENTER);
			return this;
		}
	}
	
	
	class StringCellRenderere extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			this.setHorizontalAlignment(LEFT);
			return this;
		}
	}
	class IntCellRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			this.setHorizontalAlignment(CENTER);
			return this;
		}
	}
	
	class StringCellRenderere1 extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			this.setHorizontalAlignment(RIGHT);
			return this;
		}
	}
}


