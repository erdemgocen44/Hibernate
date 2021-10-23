package h6_caching;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hesaplar")
public class H2_Hesap {

	
	@Id
	private int iban;

	private String bankaAdi;
	
	@ManyToOne
	@JoinColumn(name="id")
	private H1_Developer developers;

	public H2_Hesap(int id, String bankaAdi) {
		super();
		this.iban = id;
		this.bankaAdi = bankaAdi;
	}
	public H2_Hesap() {
	}

	public int getId() {
		return iban;
	}

	public void setIban(int id) {
		this.iban = id;
	}

	public String getBankaAdi() {
		return bankaAdi;
	}

	public void setBankaAdi(String bankaAdi) {
		this.bankaAdi = bankaAdi;
	}

	public H1_Developer getDevelopers() {
		return developers;
	}

	public void setDevelopers(H1_Developer developers) {
		this.developers = developers;
	}
	@Override
	public String toString() {
		return "H2_Hesap [iban=" + iban + ", bankaAdi=" + bankaAdi +  "]";
	}
	
	
	
}
