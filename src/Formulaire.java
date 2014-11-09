import java.sql.Date;


public class Formulaire {
	private int id;
	private String nom;
	private String prenom;
	private int numero;
	private String region;
	private Date dateDeclaration;
	private int duree;
	private Date dateEntre;
	private Date dateSortie;
	private int numVeterinaire;
	private String remarque;
	
	
	
	public Formulaire(String nom, String prenom, int numero, String region,
			Date dateDeclaration, int duree, Date dateEntre, Date dateSortie,
			int numVeterinaire, String remarque) {
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.region = region;
		this.dateDeclaration = dateDeclaration;
		this.duree = duree;
		this.dateEntre = dateEntre;
		this.dateSortie = dateSortie;
		this.numVeterinaire = numVeterinaire;
		this.remarque = remarque;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Date getDateDeclaration() {
		return dateDeclaration;
	}
	public void setDateDeclaration(Date dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Date getDateEntre() {
		return dateEntre;
	}
	public void setDateEntre(Date dateEntre) {
		this.dateEntre = dateEntre;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public int getNumVeterinaire() {
		return numVeterinaire;
	}
	public void setNumVeterinaire(int numVeterinaire) {
		this.numVeterinaire = numVeterinaire;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	
	
}
