package Objet;
import java.io.Serializable;
public class Compte implements Serializable {

	int id;
	double montant;
	
	
	public Compte(int id, double d) {
		super();
		this.id = id;
		this.montant = d;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "Compte [id=" + id + ", montant=" + montant + "]";
	}
	
	
	
}
