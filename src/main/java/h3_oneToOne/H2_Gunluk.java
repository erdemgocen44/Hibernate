package h3_oneToOne;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Gunluklerimiz")
public class H2_Gunluk {

	@Id
	private int id;
	
	private String yazilar;
	
	@OneToOne
	@JoinColumn(name="kisi_id")
	private H1_Kisi kisi;
	
	public H2_Gunluk() {
		// TODO Auto-generated constructor stub
	}

	public H2_Gunluk(int id, String yazilar) {
		super();
		this.id = id;
		this.yazilar = yazilar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYazilar() {
		return yazilar;
	}

	public void setYazilar(String yazilar) {
		this.yazilar = yazilar;
	}

	public H1_Kisi getKisi() {
		return kisi;
	}

	public void setKisi(H1_Kisi kisi) {
		this.kisi = kisi;
	}

	@Override
	public String toString() {
		return "H2_Gunluk [id=" + id + ", yazilar=" + yazilar + ", kisi=" + kisi + "]";
	}
	
	
}
