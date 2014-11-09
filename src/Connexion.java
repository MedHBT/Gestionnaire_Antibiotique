import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;


public class Connexion {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/antibiotique?useUnicode=true&characterEncoding=utf-8";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   private Connection conn;
	   private Statement stmt;
	   private ResultSet rs;
	   private int r;
	   private Object[][] datas;

	   
	   public Connexion() {
		   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		   try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }



	public void ajouter_veterinaire(Veterinaire vet) {
	    String sql = "INSERT INTO veterinaire (nom , prenom) VALUES ('" + vet.getNom()+ "','" + vet.getPrenom() +"')";
	    try {
			r = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	      try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ajouter_formulaire(Formulaire form) {
	    String sql = "INSERT INTO formulaire (nom , prenom, numero , region , date_declaration , duree , date_entre , date_sortie , numero_veterinaire , remarque) VALUES ('" + form.getNom() + "','" + form.getPrenom() +"',"+ form.getNumero() +",'"+ form.getRegion() +"','"+ form.getDateDeclaration()+"',"+ form.getDuree() +",'"+ form.getDateEntre() +"','"+ form.getDateSortie() +"',"+ form.getNumVeterinaire() +",'"+ form.getRemarque()+"')";
	    try {
			r = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	      try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean supprimer_veterinaire(int vet) {
	    String sql = "DELETE FROM veterinaire WHERE id = " + vet;
	    try {
			r = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	      try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return true;
	}
	
	public boolean supprimer_formulaire(int formulaire) {
	    String sql = "DELETE FROM formulaire WHERE id = " + formulaire;
	    try {
			r = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	      try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return true;
	}
	
	public boolean supprimer_formulaire_init() {
	    String sql = "DELETE FROM formulaire WHERE DATE_ADD(date_sortie, INTERVAL 1 DAY) <  CURDATE()";
	    try {
			r = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	      try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return true;
	}
	
	public Hashtable<Integer, String> selectionner_veterinaire() {
	    String sql = "SELECT * FROM veterinaire";
	    try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Hashtable<Integer,String> ht = new Hashtable<Integer, String>();
	    
	    try {
			while(rs.next()){
			     //Retrieve by column name
			     int id  = rs.getInt("id");
			     String nom = rs.getString("nom");
			     String prenom = rs.getString("prenom");

			     ht.put(id, nom + " " + prenom);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    
	    try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return ht;
	}
	
	public Hashtable<Integer, String> selectionner_veterinaire_pour_suppression() {
	    String sql = "SELECT * FROM veterinaire WHERE id NOT IN (SELECT numero_veterinaire FROM formulaire)";
	    try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Hashtable<Integer,String> ht = new Hashtable<Integer, String>();
	    
	    try {
			while(rs.next()){
			     //Retrieve by column name
			     int id  = rs.getInt("id");
			     String nom = rs.getString("nom");
			     String prenom = rs.getString("prenom");

			     ht.put(id, nom + " " + prenom);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    
	    try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return ht;
	}
	
	public Object[][] selectionner_formulaire(String circuit){
		int row = 0;
		String sql = null;
		if(circuit.equals("tous")){
			sql = "SELECT * FROM formulaire WHERE CURDATE() BETWEEN date_entre AND DATE_ADD(date_sortie, INTERVAL 1 DAY)";
		} else {
			sql = "SELECT * FROM formulaire WHERE remarque = '" + circuit +"' AND CURDATE() BETWEEN date_entre AND DATE_ADD(date_sortie, INTERVAL 1 DAY)";
		}
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()){  
			     row++; 
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Object[][] datas = new Object[row][11];
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 0;
		try {
			while(rs.next()){
			     //Retrieve by column name
				 int id = rs.getInt("id");
			     String nom = rs.getString("nom");
			     String prenom = rs.getString("prenom");
			     int numero = rs.getInt("numero");
			     String region = rs.getString("region");
			     Date dateDeclaration = rs.getDate("date_declaration");
			     int duree = rs.getInt("duree");
			     Date dateEntre = rs.getDate("date_entre");
			     Date dateSortie = rs.getDate("date_sortie");
			     int numero_veterinaire = rs.getInt("numero_veterinaire");
			     String veterinaire = trouver_veterinaire(numero_veterinaire);
			     String remarque = rs.getString("remarque");
			     datas[count][0] = id;
			     datas[count][1] = nom;
			     datas[count][2] = prenom;
			     datas[count][3] = numero;
			     datas[count][4] = region;
			     datas[count][5] = dateDeclaration;
			     datas[count][6] = duree;
			     datas[count][7] = dateEntre;
			     datas[count][8] = dateSortie;
			     datas[count][9] = veterinaire;
			     datas[count][10] = remarque;
			     count ++; 
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    
	    try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	
	public String trouver_veterinaire(int vet) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		   try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String sql = "SELECT * FROM veterinaire WHERE id = " + vet + " LIMIT 1";
	    String veterinaire = null;
	    try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    try {
			while(rs.next()){
			     //Retrieve by column name
			     String nom = rs.getString("nom");
			     String prenom = rs.getString("prenom");
			     veterinaire = nom +" "+prenom;
			     
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    
	    try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return veterinaire;
	}
}
