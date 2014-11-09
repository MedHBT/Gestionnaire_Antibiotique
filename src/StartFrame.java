import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class StartFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTable table;
	public static final JLabel label = new JLabel("");
	public static final JLabel label_1 = new JLabel("");
	public static final JLabel label_2 = new JLabel("");
	private String circuit = "tous";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
					ImageIcon img = new ImageIcon(getClass().getResource("cow.png"));
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setTitle("Antibiotique Houda");
					frame.setIconImage(img.getImage());
					Connexion connexion = new Connexion();
					connexion.supprimer_formulaire_init();
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
	public StartFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1370, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmSortir = new JMenuItem("Sortir");
		mntmSortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment sortir?");
                if(option == 0)
                {
                    System.exit(0);
                }
			}
		});
		mnOptions.add(mntmSortir);
		
		JMenu mnAPropos = new JMenu("A Propos");
		menuBar.add(mnAPropos);
		
		JMenuItem mntmAide = new JMenuItem("Aide");
		mntmAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ce logiciel est developpé pour la gestion des formulaires des antibiotiques associé a chaque circuit.");
			}
		});
		
		JMenuItem mntmInformationEtContact = new JMenuItem("Information et Contact");
		mntmInformationEtContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Developpé par Ben Taieb Mohamed Hassine pour plus d'information contactez-moi sur l'addresse : medhassinebentaieb@gmail.com");
			}
		});
		mnAPropos.add(mntmInformationEtContact);
		mnAPropos.add(mntmAide);
		
		JMenuItem mntmVersion = new JMenuItem("Version");
		mntmVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antibiotique v 1.00 Septembre 2014");
			}
		});
		mnAPropos.add(mntmVersion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		final JPanel panel = new JPanel();
		contentPane.add(panel, "name_928603336183");
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel card_1 = new JPanel();
		panel.add(card_1, "name_1132723119086");
		
		JButton btnNewButton_1 = new JButton("Entrer");
		btnNewButton_1.setBounds(603, 174, 142, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "name_1348698020942");
			}
		});
		card_1.setLayout(null);
		card_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sortir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment sortir?");
                if(option == 0)
                {
                    
                    System.exit(0);
                }
			}
		});
		btnNewButton_2.setBounds(603, 270, 142, 23);
		card_1.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Configuration");
		btnNewButton.setBounds(603, 223, 142, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "name_2341856886225");
			}
		});
		card_1.add(btnNewButton);
		
		JPanel card_2 = new JPanel();
		panel.add(card_2, "name_1348698020942");
		card_2.setLayout(null);
		
		JLabel lblAjouterAuFormulaire = new JLabel("Ajouter au formulaire");
		lblAjouterAuFormulaire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAjouterAuFormulaire.setBounds(10, 11, 210, 24);
		card_2.add(lblAjouterAuFormulaire);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(10, 78, 125, 24);
		card_2.add(lblNom);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 113, 125, 25);
		card_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Region :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 183, 125, 24);
		card_2.add(lblNewLabel_3);
		
		JLabel lblDateDeclaration = new JLabel("Date declaration :");
		lblDateDeclaration.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDeclaration.setBounds(10, 218, 125, 24);
		card_2.add(lblDateDeclaration);
		
		
		JLabel lblDure = new JLabel("Dur\u00E9e :");
		lblDure.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDure.setBounds(10, 253, 125, 24);
		card_2.add(lblDure);
		
		JLabel lblDateDentre = new JLabel("Date d'entr\u00E9e :");
		lblDateDentre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDentre.setBounds(10, 288, 125, 26);
		card_2.add(lblDateDentre);
		
		JLabel lblDateDeSortie = new JLabel("Date de Sortie :");
		lblDateDeSortie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDeSortie.setBounds(10, 325, 125, 25);
		card_2.add(lblDateDeSortie);
		
		JLabel lblVeterinaire = new JLabel("Veterinaire :");
		lblVeterinaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVeterinaire.setBounds(10, 361, 125, 24);
		card_2.add(lblVeterinaire);
		
		JLabel lblRemarque = new JLabel("Remarque :");
		lblRemarque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRemarque.setBounds(10, 394, 125, 24);
		card_2.add(lblRemarque);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 78, 339, 25);
		card_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 113, 339, 25);
		card_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 183, 339, 25);
		card_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblJour = new JLabel("jour");
		lblJour.setBounds(269, 222, 29, 20);
		card_2.add(lblJour);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(297, 222, 50, 20);
		
		card_2.add(comboBox_1);
		
		JLabel lblMois = new JLabel("mois");
		lblMois.setBounds(145, 222, 37, 20);
		card_2.add(lblMois);
		
		
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(174, 222, 90, 20);
		comboBox_2.addItem(new ComboItem("Janvier", "01"));
		comboBox_2.addItem(new ComboItem("Février", "02"));
		comboBox_2.addItem(new ComboItem("Mars", "03"));
		comboBox_2.addItem(new ComboItem("Avril", "04"));
		comboBox_2.addItem(new ComboItem("Mai", "05"));
		comboBox_2.addItem(new ComboItem("Juin", "06"));
		comboBox_2.addItem(new ComboItem("Juillet", "07"));
		comboBox_2.addItem(new ComboItem("Aout", "08"));
		comboBox_2.addItem(new ComboItem("Septembre", "09"));
		comboBox_2.addItem(new ComboItem("Octobre", "10"));
		comboBox_2.addItem(new ComboItem("Novembre", "11"));
		comboBox_2.addItem(new ComboItem("Decembre", "12"));
		card_2.add(comboBox_2);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(394, 222, 90, 20);
		card_2.add(comboBox_3);
		
		comboBox_2.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	chargerJour(comboBox_1,comboBox_2,comboBox_3);
		    }
		});
		
		JLabel lblAnne = new JLabel("ann\u00E9e");
		lblAnne.setBounds(357, 222, 37, 20);
		card_2.add(lblAnne);
		
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(145, 253, 339, 25);
		card_2.add(textField_5);
		textField_5.setColumns(10);
		
		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(145, 361, 339, 25);
		Connexion connexion_selectionner_2 = new Connexion();
		Hashtable<Integer, String> ht_2 = connexion_selectionner_2.selectionner_veterinaire();
		Enumeration<Integer> enumKey_2 = ht_2.keys();
		while(enumKey_2.hasMoreElements()){
			Integer key = enumKey_2.nextElement();
			String val = ht_2.get(key);
			comboBox_4.addItem(new ComboItem(val, key.toString()));
		}
		card_2.add(comboBox_4);
		
		JLabel lblJour_1 = new JLabel("jour");
		lblJour_1.setBounds(269, 293, 29, 20);
		card_2.add(lblJour_1);
		
		final JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(297, 293, 51, 20);
		card_2.add(comboBox_5);
		
		final JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(394, 293, 90, 20);
		card_2.add(comboBox_7);
		
		JLabel lblMois_1 = new JLabel("mois");
		lblMois_1.setBounds(145, 293, 37, 20);
		card_2.add(lblMois_1);
		
		final JComboBox comboBox_6 = new JComboBox();
		
		comboBox_6.setBounds(174, 293, 90, 20);
		comboBox_6.addItem(new ComboItem("Janvier", "01"));
		comboBox_6.addItem(new ComboItem("Février", "02"));
		comboBox_6.addItem(new ComboItem("Mars", "03"));
		comboBox_6.addItem(new ComboItem("Avril", "04"));
		comboBox_6.addItem(new ComboItem("Mai", "05"));
		comboBox_6.addItem(new ComboItem("Juin", "06"));
		comboBox_6.addItem(new ComboItem("Juillet", "07"));
		comboBox_6.addItem(new ComboItem("Aout", "08"));
		comboBox_6.addItem(new ComboItem("Septembre", "09"));
		comboBox_6.addItem(new ComboItem("Octobre", "10"));
		comboBox_6.addItem(new ComboItem("Novembre", "11"));
		comboBox_6.addItem(new ComboItem("Decembre", "12"));
		card_2.add(comboBox_6);
		
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargerJour(comboBox_5,comboBox_6,comboBox_7);
			}
		});
		
		JLabel lblAnne_1 = new JLabel("ann\u00E9e");
		lblAnne_1.setBounds(357, 293, 37, 20);
		card_2.add(lblAnne_1);
		
		
		
		JLabel lblJour_2 = new JLabel("jour");
		lblJour_2.setBounds(269, 329, 29, 20);
		card_2.add(lblJour_2);
		
		final JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(297, 329, 51, 20);
		card_2.add(comboBox_8);
		
		final JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(394, 329, 90, 20);
		card_2.add(comboBox_10);
		
		JLabel lblMois_2 = new JLabel("mois");
		lblMois_2.setBounds(145, 329, 37, 20);
		card_2.add(lblMois_2);
		
		final JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(174, 329, 90, 20);
		comboBox_9.addItem(new ComboItem("Janvier", "01"));
		comboBox_9.addItem(new ComboItem("Février", "02"));
		comboBox_9.addItem(new ComboItem("Mars", "03"));
		comboBox_9.addItem(new ComboItem("Avril", "04"));
		comboBox_9.addItem(new ComboItem("Mai", "05"));
		comboBox_9.addItem(new ComboItem("Juin", "06"));
		comboBox_9.addItem(new ComboItem("Juillet", "07"));
		comboBox_9.addItem(new ComboItem("Aout", "08"));
		comboBox_9.addItem(new ComboItem("Septembre", "09"));
		comboBox_9.addItem(new ComboItem("Octobre", "10"));
		comboBox_9.addItem(new ComboItem("Novembre", "11"));
		comboBox_9.addItem(new ComboItem("Decembre", "12"));
		card_2.add(comboBox_9);
		
		comboBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargerJour(comboBox_8,comboBox_9,comboBox_10);
			}
		});
		
		JLabel lblAnne_2 = new JLabel("ann\u00E9e");
		lblAnne_2.setBounds(357, 329, 46, 20);
		card_2.add(lblAnne_2);
		
		
		final JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setBounds(145, 398, 339, 20);
		comboBox_11.addItem(new ComboItem("رجيش", "رجيش"));
		comboBox_11.addItem(new ComboItem("شيبة", "شيبة"));
		comboBox_11.addItem(new ComboItem("السعد", "السعد"));
		comboBox_11.addItem(new ComboItem("المنسورية", "المنسورية"));
		comboBox_11.addItem(new ComboItem("أولاد الذوادي", "أولاد الذوادي"));
		comboBox_11.addItem(new ComboItem("أولاد بالصيود", "أولاد بالصيود 1"));
		comboBox_11.addItem(new ComboItem("أولاد بالصيود 2", "أولاد بالصيود 2"));
		comboBox_11.addItem(new ComboItem("بريصا", "بريصا"));
		comboBox_11.addItem(new ComboItem("دخيلا", "دخيلا"));
		comboBox_11.addItem(new ComboItem("جواودة", "جواودة"));
		comboBox_11.addItem(new ComboItem("أولاد مجوب", "أولاد مجوب"));
		comboBox_11.addItem(new ComboItem("ليانة", "ليانة"));
		comboBox_11.addItem(new ComboItem("المهدية", "المهدية"));
		comboBox_11.addItem(new ComboItem("الحكايمة ", "الحكايمة"));
		comboBox_11.addItem(new ComboItem("الحكايمة الغربية", "الحكايمة الغربية"));
		comboBox_11.addItem(new ComboItem("Autre", "Autre"));
		card_2.add(comboBox_11);
		
		JButton btnAjouter_1 = new JButton("Ajouter");
		btnAjouter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item_1 = comboBox_1.getSelectedItem();
				Object item_2 = comboBox_2.getSelectedItem();
				Object item_3 = comboBox_3.getSelectedItem();
				String jour_1 = ((ComboItem)item_1).getValue();
				String mois_1 = ((ComboItem)item_2).getValue();
				String année_1 = ((ComboItem)item_3).getValue();
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
		        java.util.Date parsed_1 = null;
				try {
					parsed_1 = format.parse(année_1+"-"+mois_1+"-"+jour_1);
				} catch (ParseException e1) {
					label.setText("<html><font color='red'>ERREUR : <br>Date invalide</font></html>");
					e1.printStackTrace();
				}
		        Date date_1 = new Date(parsed_1.getTime());
				
				Object item_5 = comboBox_5.getSelectedItem();
				Object item_6 = comboBox_6.getSelectedItem();
				Object item_7 = comboBox_7.getSelectedItem();
				String jour_2 = ((ComboItem)item_5).getValue();
				String mois_2 = ((ComboItem)item_6).getValue();
				String année_2 = ((ComboItem)item_7).getValue();
				
				
		        java.util.Date parsed_2 = null;
				try {
					parsed_2 = format.parse(année_2+"-"+mois_2+"-"+jour_2);
				} catch (ParseException e1) {
					label.setText("<html><font color='red'>ERREUR : <br>Date invalide</font></html>");
					e1.printStackTrace();
				}
		        Date date_2 = new Date(parsed_2.getTime());
				
				Object item_8 = comboBox_8.getSelectedItem();
				Object item_9 = comboBox_9.getSelectedItem();
				Object item_10 = comboBox_10.getSelectedItem();
				String jour_3 = ((ComboItem)item_8).getValue();
				String mois_3 = ((ComboItem)item_9).getValue();
				String année_3 = ((ComboItem)item_10).getValue();
				
				
		        java.util.Date parsed_3 = null;
				try {
					parsed_3 = format.parse(année_3+"-"+mois_3+"-"+jour_3);
				} catch (ParseException e1) {
					label.setText("<html><font color='red'>ERREUR : <br>Date invalide</font></html>");
					e1.printStackTrace();
				}
		        Date date_3 = new Date(parsed_3.getTime());
				
				Object item_4 = comboBox_4.getSelectedItem();
				String numVet = ((ComboItem)item_4).getValue();
				
				Object item_11 = comboBox_11.getSelectedItem();
				String remarque = ((ComboItem)item_11).getValue();
				
				try {
				     int numero = Integer.parseInt(textField_7.getText());
				     int duree = Integer.parseInt(textField_5.getText());
				     
				    Formulaire formulaire = new Formulaire(textField_2.getText(), textField_3.getText(), duree, textField_4.getText(), date_1, numero, date_2, date_3, Integer.valueOf(numVet), remarque);
					Connexion connexion_ajouter = new Connexion();
					connexion_ajouter.ajouter_formulaire(formulaire);
					label.setText("<html><font color='green'>Ligne Ajouter</font></html>");
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					dm.getDataVector().removeAllElements();	
					
					Connexion connexion_data = new Connexion();
					Object[][] data = connexion_data.selectionner_formulaire("tous");
					for(int i = 0;i<data.length;i++){
						dm.addRow(data[i]);
					}
					table.repaint();
				}
				catch (NumberFormatException err) {
					label.setText("<html><font color='red'>ERREUR : <br>Numero/Duree champs non numerique</font></html>");
				}
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_7.setText("");
				cherger_date_selector(comboBox_1, comboBox_2, comboBox_3);
				cherger_date_selector(comboBox_5, comboBox_6, comboBox_7);
				cherger_date_selector(comboBox_8, comboBox_9, comboBox_10);
				label_2.setText("");
			}
		});
		btnAjouter_1.setBounds(395, 557, 89, 23);
		card_2.add(btnAjouter_1);
		
		JLabel lblNewLabel_4 = new JLabel("Numero :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 149, 125, 25);
		card_2.add(lblNewLabel_4);
		
		textField_7 = new JTextField();
		textField_7.setBounds(145, 149, 339, 25);
		card_2.add(textField_7);
		textField_7.setColumns(10);
		
		Connexion connexion_data = new Connexion();
		Object[][] data = connexion_data.selectionner_formulaire("tous");
		String[] columnNames = {"ID", "Nom", "Prenom", "Numero", "Region", "Date de declaration", "Durée", "Date d'entrée", "Date de Sortie", "Veterinaire", "Remarque" };
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		table = new JTable(model);

		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(494, 78, 840, 465);
		scrollPane.getViewport().setBackground(Color.WHITE);
		card_2.add(scrollPane);
		
		JButton btnGenererPdf = new JButton("Generer PDF");
		btnGenererPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar calendar = Calendar.getInstance();
				java.util.Date currentDate = calendar.getTime();
				java.sql.Date date = new java.sql.Date(currentDate.getTime());
				String targetDir = null;
				try {
					targetDir = RandomStringGenerator.generateRandomString(10,RandomStringGenerator.Mode.ALPHANUMERIC) + "_" + date + ".pdf";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new GenererPDF(table,targetDir);
				label_2.setText("<html><font color='green'>PDF Generer</font></html>");
				label.setText("");
			}
		});
		btnGenererPdf.setBounds(1215, 554, 119, 23);
		card_2.add(btnGenererPdf);
		
		
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(145, 596, 339, 59);
		card_2.add(label);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "name_1132723119086");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_7.setText("");
			}
		});
		btnAnnuler.setBounds(1215, 596, 119, 23);
		card_2.add(btnAnnuler);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		label_2.setBounds(494, 596, 711, 59);
		card_2.add(label_2);
		
		JLabel lblSelectionnerVotreCircuit = new JLabel("Selectionner votre circuit :");
		lblSelectionnerVotreCircuit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectionnerVotreCircuit.setBounds(494, 557, 181, 24);
		card_2.add(lblSelectionnerVotreCircuit);
		
		final JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setBounds(685, 557, 354, 21);
		comboBox_12.addItem(new ComboItem("Tous les circuit", "tous"));
		comboBox_12.addItem(new ComboItem("رجيش", "رجيش"));
		comboBox_12.addItem(new ComboItem("شيبة", "شيبة"));
		comboBox_12.addItem(new ComboItem("السعد", "السعد"));
		comboBox_12.addItem(new ComboItem("المنسورية", "المنسورية"));
		comboBox_12.addItem(new ComboItem("أولاد الذوادي", "أولاد الذوادي"));
		comboBox_12.addItem(new ComboItem("أولاد بالصيود", "أولاد بالصيود 1"));
		comboBox_12.addItem(new ComboItem("أولاد بالصيود 2", "أولاد بالصيود 2"));
		comboBox_12.addItem(new ComboItem("بريصا", "بريصا"));
		comboBox_12.addItem(new ComboItem("دخيلا", "دخيلا"));
		comboBox_12.addItem(new ComboItem("جواودة", "جواودة"));
		comboBox_12.addItem(new ComboItem("أولاد مجوب", "أولاد مجوب"));
		comboBox_12.addItem(new ComboItem("ليانة", "ليانة"));
		comboBox_12.addItem(new ComboItem("المهدية", "المهدية"));
		comboBox_12.addItem(new ComboItem("الحكايمة ", "الحكايمة"));
		comboBox_12.addItem(new ComboItem("الحكايمة الغربية", "الحكايمة الغربية"));
		comboBox_12.addItem(new ComboItem("Autre", "Autre"));
		comboBox_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBox_12.getSelectedItem();
		    	circuit = ((ComboItem)item).getValue();
				
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();	
				
				Connexion connexion_data = new Connexion();
				Object[][] data = connexion_data.selectionner_formulaire(circuit);
				for(int i = 0;i<data.length;i++){
					dm.addRow(data[i]);
				}
				table.repaint();
			}
		});
		card_2.add(comboBox_12);
		
		JButton btnSupprimerSelection = new JButton("Supprimer Selection");
		btnSupprimerSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] rows = table.getSelectedRows();
				for(int i = 0;i<rows.length;i++){
					int formulaire_id = (int) table.getModel().getValueAt(i, 0);
					Connexion connexion = new Connexion();
					connexion.supprimer_formulaire(formulaire_id);
				}
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();	
				
				Connexion connexion_data = new Connexion();
				Object[][] data = connexion_data.selectionner_formulaire(circuit);
				for(int i = 0;i<data.length;i++){
					dm.addRow(data[i]);
				}
				table.repaint();
				label_2.setText("<html><font color='green'>Selection Supprimée</font></html>");
				label.setText("");
			}
		});
		btnSupprimerSelection.setBounds(1049, 554, 156, 24);
		card_2.add(btnSupprimerSelection);
		
		JPanel card_3 = new JPanel();
		panel.add(card_3, "name_2341856886225");
		card_3.setLayout(null);
		
		JLabel lblAjouterUnNouveau = new JLabel("Ajouter un nouveau veterinaire");
		lblAjouterUnNouveau.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAjouterUnNouveau.setBounds(10, 11, 299, 20);
		card_3.add(lblAjouterUnNouveau);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(35, 42, 98, 20);
		card_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(35, 85, 98, 18);
		card_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(143, 42, 251, 20);
		card_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 85, 251, 20);
		card_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSupprimerUnVeterinaire = new JLabel("Supprimer un veterinaire");
		lblSupprimerUnVeterinaire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblSupprimerUnVeterinaire.setBounds(10, 157, 288, 20);
		card_3.add(lblSupprimerUnVeterinaire);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(35, 188, 243, 20);
		charger_veterinaire_pour_suppression(comboBox);
		card_3.add(comboBox);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textField.getText();
				String prenom = textField_1.getText();
				if(nom.equals("") || prenom.equals("")){
					label_1.setText("<html><font color='red'>ERREUR : <br>Nom/Prenom champs vide</font></html>");
				} else {
					Connexion connexion_ajouter = new Connexion();
					Veterinaire veterinaire = new Veterinaire(nom, prenom);
					connexion_ajouter.ajouter_veterinaire(veterinaire);
					textField.setText(null);
					textField_1.setText(null);
					charger_veterinaire(comboBox);
					charger_veterinaire(comboBox_4);
					label_1.setText("<html><font color='green'>Veterinaire Ajouté</font></html>");
				}
				
				
			}
		});
		btnAjouter.setBounds(288, 116, 106, 23);
		card_3.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object vet = comboBox.getSelectedItem();
				String vet_id = ((ComboItem)vet).getValue();
				int id = Integer.valueOf(vet_id);
				Connexion connexion_supprimer = new Connexion();
				if(connexion_supprimer.supprimer_veterinaire(id)){
					label_1.setText("<html><font color='green'>Veterinaire Supprimé</font></html>");
					charger_veterinaire(comboBox);		
					charger_veterinaire(comboBox_4);
				} else {
					label_1.setText("<html><font color='red'>Suppression échoué</font></html>");
				}
			}
		});
		btnSupprimer.setBounds(288, 187, 106, 23);
		card_3.add(btnSupprimer);
		
		JButton btnAnnuler_1 = new JButton("Annuler");
		btnAnnuler_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "name_1132723119086");
				textField.setText("");
				textField_1.setText("");
				label_1.setText("");
			}
		});
		btnAnnuler_1.setBounds(1215, 597, 119, 23);
		card_3.add(btnAnnuler_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
	
		label_1.setBounds(35, 327, 359, 67);
		card_3.add(label_1);
	}
	
	private void charger_veterinaire(JComboBox comboBox){
		comboBox.removeAllItems();
		Connexion connexion_selectionner = new Connexion();
		Hashtable<Integer, String> ht = connexion_selectionner.selectionner_veterinaire();
		Enumeration<Integer> enumKey = ht.keys();
		while(enumKey.hasMoreElements()){
			Integer key = enumKey.nextElement();
			String val = ht.get(key);
			comboBox.addItem(new ComboItem(val, key.toString()));
		}
	}
	
	private void charger_veterinaire_pour_suppression(JComboBox comboBox){
		comboBox.removeAllItems();
		Connexion connexion_selectionner = new Connexion();
		Hashtable<Integer, String> ht = connexion_selectionner.selectionner_veterinaire_pour_suppression();
		Enumeration<Integer> enumKey = ht.keys();
		while(enumKey.hasMoreElements()){
			Integer key = enumKey.nextElement();
			String val = ht.get(key);
			comboBox.addItem(new ComboItem(val, key.toString()));
		}
	}
	
	private void chargerJour(JComboBox comboBox_1,JComboBox comboBox_2,JComboBox comboBox_3){
		comboBox_1.removeAllItems();
		Object item = comboBox_2.getSelectedItem();
    	String mois = ((ComboItem)item).getValue();
    	comboBox_1.addItem(new ComboItem("1", "1"));
		comboBox_1.addItem(new ComboItem("2", "2"));
		comboBox_1.addItem(new ComboItem("3", "3"));
		comboBox_1.addItem(new ComboItem("4", "4"));
		comboBox_1.addItem(new ComboItem("5", "5"));
		comboBox_1.addItem(new ComboItem("6", "6"));
		comboBox_1.addItem(new ComboItem("7", "7"));
		comboBox_1.addItem(new ComboItem("8", "8"));
		comboBox_1.addItem(new ComboItem("9", "9"));
		comboBox_1.addItem(new ComboItem("10", "10"));
		comboBox_1.addItem(new ComboItem("11", "11"));
		comboBox_1.addItem(new ComboItem("12", "12"));
		comboBox_1.addItem(new ComboItem("13", "13"));
		comboBox_1.addItem(new ComboItem("14", "14"));
		comboBox_1.addItem(new ComboItem("15", "15"));
		comboBox_1.addItem(new ComboItem("16", "16"));
		comboBox_1.addItem(new ComboItem("17", "17"));
		comboBox_1.addItem(new ComboItem("18", "18"));
		comboBox_1.addItem(new ComboItem("19", "19"));
		comboBox_1.addItem(new ComboItem("20", "20"));
		comboBox_1.addItem(new ComboItem("21", "21"));
		comboBox_1.addItem(new ComboItem("22", "22"));
		comboBox_1.addItem(new ComboItem("23", "23"));
		comboBox_1.addItem(new ComboItem("24", "24"));
		comboBox_1.addItem(new ComboItem("25", "25"));
		comboBox_1.addItem(new ComboItem("26", "26"));
		comboBox_1.addItem(new ComboItem("27", "27"));
		comboBox_1.addItem(new ComboItem("28", "28"));
    	if(mois.equals("01") || mois.equals("03") || mois.equals("05") || mois.equals("07") || mois.equals("08") || mois.equals("10") || mois.equals("12")){
    		comboBox_1.addItem(new ComboItem("29", "29"));
    		comboBox_1.addItem(new ComboItem("30", "30"));
    		comboBox_1.addItem(new ComboItem("31", "31"));
    	} else if(mois.equals("04") || mois.equals("06") || mois.equals("09") || mois.equals("11")){
    		comboBox_1.addItem(new ComboItem("29", "29"));
    		comboBox_1.addItem(new ComboItem("30", "30"));
    	}
    	comboBox_3.removeAllItems();
    	comboBox_3.addItem(new ComboItem("2014", "2014"));
		comboBox_3.addItem(new ComboItem("2015", "2015"));
		comboBox_3.addItem(new ComboItem("2016", "2016"));
		comboBox_3.addItem(new ComboItem("2017", "2017"));
		comboBox_3.addItem(new ComboItem("2018", "2018"));
		comboBox_3.addItem(new ComboItem("2019", "2019"));
	}
	
	private void cherger_date_selector(JComboBox comboBox_1,JComboBox comboBox_2,JComboBox comboBox_3){
		
		comboBox_2.setSelectedIndex(0);
		comboBox_1.removeAllItems();
		comboBox_3.removeAllItems();
	}
}
