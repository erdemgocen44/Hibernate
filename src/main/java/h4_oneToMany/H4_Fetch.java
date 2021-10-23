package h4_oneToMany;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Ogrenci.class)
				.addAnnotatedClass(H2_Kitap.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

//		for (H2_Kitap w : session.get(H1_Ogrenci.class, 222).getKitapListesi()) {
//			System.out.println("kitaplar " + w);
//		}
//
//		System.out.println("ilk Cevap" + session.get(H2_Kitap.class, 1002).getOgrenci());
//		System.out.println();

		// -------------SİLME İŞLEMİ-----------

		// tx.commit() olmadan hata verir. delete işlemlerimde unutmamalıyız

		// HQL ile tüm kitapları silelim

		// önce child table silinir

//		session.createQuery("DELETE FROM H2_Kitap").executeUpdate();
//
//		System.out.println("Kitaplar silindi");
//
//		// şimdi de parent ı silelim
//
//		session.delete(session.get(H1_Ogrenci.class, 222));
//
//		System.out.println("Parent silindi");

		// direk Parent tablodan Exception olmaksizin silebilmek için
		// A)ya Once Child sonra parent silinir.YA DA
		// B) SQL deki gibi Cascade ozelligi aktif hale getirilir.
		// (@OneToMany(mappedBy = "ogrenci", orphanRemoval = true, cascade =
		// CascadeType.ALL)
		// tekrar tabloları oluştur

//		session.delete(session.get(H1_Ogrenci.class, 222));
//
//		System.out.println("222 id li ogrenci bilgileri silindi");
		
		//--------------------------------------------------------------------------
//		// LAZY FETCH VS EAGER FETCH  
//		//------------------------------------------------------------------------
//		
//		/* 
//		 * Hibernate veritabanından verileri cekerken AC GOZLU(EAGER) veya TEMBEL(LAZY) olabilmektedir. 
//		 * EAGER Fetch isleminde bir tablodan veri cekilmesi istendiginde Hibernate o tablo ile iliskili
//		 * Tum tablolari da getirir. 
//		 *  
//		 * Eger LAZY fetch islemi kullanilirsa sadece istenilen tablonun verileri getirilir. 
//		 * 
//		 * 2 yontemin de avantajlari ve dezavatanjlari vardir. Tercih, uygulanin gereksinimlerine gore belirlenir.  
//		 * 
//		 * LAZY fetch gereksiz verilerin cekilmemesini saglamak icin ve daha dusuk bellek kullanimi icin daha elvereslidir. 
//		 * Ancak, zamana duyarlı uygulamalarda problem olusturuabilir. iliskili verilerin tek tek veritabnindan getirilmesi
//		 * zaman kayıolarina yol acabilir. 
//		 * 
//		 * EAGER fetch ise bazen kullanimayacak veriler bastan pesin pesin getirilmesine yol acabilir.
//		 *  
//		 *  */öğrenci class ına git( önce LAZY yap sonra )EAGER kısmını ekle, sonra alttaki satırları yaz
		
		
		session.get(H1_Ogrenci.class, 333);
System.out.println("333 nolu kitap silindi");
//fetch işleminde EAGER YAZILIYKEN konsolda alttaki sonuclar çıkar
//select
//h1_ogrenci0_.ogrId as ogrid1_1_0_,
//h1_ogrenci0_.ogrAd as ograd2_1_0_,
//h1_ogrenci0_.ogrNot as ogrnot3_1_0_,
//kitapliste1_.ogrId as ogrid3_0_1_,
//kitapliste1_.id as id1_0_1_,
//kitapliste1_.id as id1_0_2_,
//kitapliste1_.isim as isim2_0_2_,
//kitapliste1_.ogrId as ogrid3_0_2_ 


//fetch LAZY açıkken konsolda alttaki sonuçlar çıkar
//select
//h1_ogrenci0_.ogrId as ogrid1_1_0_,
//h1_ogrenci0_.ogrAd as ograd2_1_0_,
//h1_ogrenci0_.ogrNot as ogrnot3_1_0_ 






		tx.commit();
	}
}