import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;

import javax.swing.UIManager;

import connexion.paramsconnexion;

import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GestionJeux extends JFrame {

	private JPanel contentPane;
	private JTextField console;
	private JTextField txtprix;
	public static ArrayList<Jeux> listjeux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionJeux frame = new GestionJeux();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionJeux() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblGestionDeVente = new JLabel("Boutique de  Jeux Videos");
		lblGestionDeVente.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGestionDeVente.setBackground(Color.WHITE);
		panel.add(lblGestionDeVente);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{41, 75, 0};
		gbl_panel_1.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblProduit = new JLabel("Jeux videos :");
		GridBagConstraints gbc_lblProduit = new GridBagConstraints();
		gbc_lblProduit.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduit.gridx = 0;
		gbc_lblProduit.gridy = 1;
		panel_1.add(lblProduit, gbc_lblProduit);
//---------------------------------------------------------------		
		   final JComboBox lstProduit = new JComboBox();
		   
		   listjeux=new ArrayList<Jeux>();
		   Connection dbConnect = null;
	        Statement dbStatement = null;
	        String SQL = "SELECT * FROM jeux";
	        try {
	            lstProduit.removeAllItems();
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            dbConnect = DriverManager.getConnection(paramsconnexion.URL,paramsconnexion.ADMIN,paramsconnexion.PASSWORD);
	            dbStatement = dbConnect.createStatement();
	            ResultSet res = dbStatement.executeQuery(SQL);
	            //lstProduit.addItem(new String(""));
	            Jeux jeux = new Jeux();
	            while (res.next()) {
	            	//jeux.setIdJeux(res.getInt("IdJeux"));
	            	jeux.setNom(res.getString("nom"));
	            	//jeux.setDescription(res.getString("description"));
	            	//jeux.setNumserie(res.getString("numserie"));
	            	jeux.setPrix(res.getInt("prix"));
	                lstProduit.addItem(res.getString("nom"));
	                listjeux.add(jeux);

	            }
	            res.close();
	            dbConnect.close();
	        } catch (InstantiationException ex) {
	            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        lstProduit.addItemListener(new ItemListener() {
			   	public void itemStateChanged(ItemEvent arg0) {
			   		int i = 0;
			   		if(lstProduit.getSelectedItem()!= null){
			   			
			   		do{	i++;}
			   		while(lstProduit.getSelectedItem().toString().equalsIgnoreCase((listjeux.get(i)).getNom()) && i<listjeux.size());
			   	
			   		txtprix.setVisible(false);
			   		txtprix.setText(String.valueOf((listjeux.get(i).getPrix())));
			   		txtprix.setVisible(true);
			   		}
			   	}
			   });
		//lstProduit.setModel(new DefaultComboBoxModel(new String[] {"","PS4", "PS3", "PSP", "PSP-Vita", "XBOX", "XBOX-One", "WII", "WII-U", "DS", "DS-3D", "DS-2D"}));
		
		GridBagConstraints gbc_lstProduit = new GridBagConstraints();
		gbc_lstProduit.fill = GridBagConstraints.HORIZONTAL;
		gbc_lstProduit.insets = new Insets(0, 0, 5, 0);
		gbc_lstProduit.anchor = GridBagConstraints.NORTH;
		gbc_lstProduit.gridx = 1;
		gbc_lstProduit.gridy = 1;
		lstProduit.setSelectedItem(null);
		panel_1.add(lstProduit, gbc_lstProduit);
		
		JLabel lblJeuxVideos = new JLabel("Console :");
		GridBagConstraints gbc_lblJeuxVideos = new GridBagConstraints();
		gbc_lblJeuxVideos.insets = new Insets(0, 0, 5, 5);
		gbc_lblJeuxVideos.gridx = 0;
		gbc_lblJeuxVideos.gridy = 2;
		panel_1.add(lblJeuxVideos, gbc_lblJeuxVideos);
//-----------------------------------------------------------------------------------------------
		
		final JComboBox produitj = new JComboBox();
		Connection dbConnect1 = null;
        Statement dbStatement1 = null;
        String SQL1 = "SELECT nom FROM console";
        try {
            produitj.removeAllItems();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnect1 = DriverManager.getConnection(paramsconnexion.URL,paramsconnexion.ADMIN,paramsconnexion.PASSWORD);
            dbStatement1 = dbConnect1.createStatement();
            ResultSet res = dbStatement1.executeQuery(SQL1);
            while (res.next()) {
                produitj.addItem(res.getString(1));
            }
            res.close();
            dbConnect1.close();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
		//produitj.setModel(new DefaultComboBoxModel(new String[] {"","GOD", "MGS", "HALO", "MARIO"}));
		GridBagConstraints gbc_produitj = new GridBagConstraints();
		gbc_produitj.insets = new Insets(0, 0, 5, 0);
		gbc_produitj.fill = GridBagConstraints.HORIZONTAL;
		gbc_produitj.gridx = 1;
		gbc_produitj.gridy = 2;
		panel_1.add(produitj, gbc_produitj);
		
		JLabel lblPrixDeLa = new JLabel("Prix de la Console :");
		GridBagConstraints gbc_lblPrixDeLa = new GridBagConstraints();
		gbc_lblPrixDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrixDeLa.gridx = 0;
		gbc_lblPrixDeLa.gridy = 3;
		panel_1.add(lblPrixDeLa, gbc_lblPrixDeLa);
		
		console = new JTextField();
		GridBagConstraints gbc_console = new GridBagConstraints();
		gbc_console.insets = new Insets(0, 0, 5, 0);
		gbc_console.fill = GridBagConstraints.HORIZONTAL;
		gbc_console.gridx = 1;
		gbc_console.gridy = 3;
		panel_1.add(console, gbc_console);
		console.setColumns(10);
		
		JLabel lblPrixDuJeux = new JLabel("Prix du jeux");
		GridBagConstraints gbc_lblPrixDuJeux = new GridBagConstraints();
		gbc_lblPrixDuJeux.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrixDuJeux.gridx = 0;
		gbc_lblPrixDuJeux.gridy = 4;
		panel_1.add(lblPrixDuJeux, gbc_lblPrixDuJeux);
		
		txtprix = new JTextField();
		/*Connection dbConnect11 = null;
        Statement dbStatement11 = null;
        String SQL11 = "SELECT prix FROM jeux";
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnect11 = DriverManager.getConnection(paramsconnexion.URL,paramsconnexion.ADMIN,paramsconnexion.PASSWORD);
            dbStatement11 = dbConnect11.createStatement();
            ResultSet res = dbStatement11.executeQuery(SQL11);
            while (res.next()) {
                txtprix.setText(String.valueOf(res.getInt(3)));
            }
            res.close();
            dbConnect11.close();
        } catch (InstantiationException ex) {
            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionJeux.class.getName()).log(Level.SEVERE, null, ex);
        }*/
		
		GridBagConstraints gbc_txtprix = new GridBagConstraints();
		gbc_txtprix.insets = new Insets(0, 0, 5, 0);
		gbc_txtprix.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtprix.gridx = 1;
		gbc_txtprix.gridy = 4;
		panel_1.add(txtprix, gbc_txtprix);
		txtprix.setColumns(10);
		
		final JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblListeDesJeux = new JLabel("Liste des jeux");
		lblListeDesJeux.setBounds(32, 11, 72, 19);
		panel_2.add(lblListeDesJeux);
		
		JLabel lblListesDesPrix = new JLabel("Listes des Prix");
		lblListesDesPrix.setBounds(186, 13, 81, 14);
		panel_2.add(lblListesDesPrix);
		
		final List listjeux = new List();
		listjeux.setBounds(10, 36, 123, 264);
		panel_2.add(listjeux);
		
		final List listprix = new List();
		listprix.setBounds(164, 36, 123, 264);
		panel_2.add(listprix);
		
		final TextField nbr = new TextField();
		nbr.setBounds(10, 310, 103, 22);
		panel_2.add(nbr);
		
		final TextField total = new TextField();
		total.setBounds(164, 310, 103, 22);
		panel_2.add(total);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(285, 349, 100, 30);
		panel_2.add(btnQuitter);
		
		JButton btnSupprimer = new JButton("Affichage");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSupprimer.setBounds(186, 349, 100, 30);
		panel_2.add(btnSupprimer);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setBounds(101, 349,100, 30);
		panel_2.add(btnEffacer);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String produit,produit2;
				Double prix,montant;
				int nombre,nombreproduit;
			
				produit = lstProduit.getSelectedItem().toString();
				
				prix = Double.parseDouble(txtprix.getText());
				//nombre = Integer.parseInt(nbr.getText());
				montant = prix ;
				listjeux.add(produit);
				listprix.add(String.valueOf(montant));
				//nombreproduit =listjeux.getItemCount();
				//nbr.setText(String.valueOf(nombreproduit));
			}
		});
		btnAjouter.setBounds(10, 349, 100, 30);
		panel_2.add(btnAjouter);
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtprix.setText("");
				listjeux.removeAll();
				listprix.removeAll();
				nbr.setText("");
				total.setText("");
				
			
				
				
				
			}
		});
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
}
