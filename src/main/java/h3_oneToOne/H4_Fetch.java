package h3_oneToOne;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H2_Gunluk.class)
				.addAnnotatedClass(H1_Kisi.class).buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// id=101 olan kisinin bilgilerini sorgula.

		System.out.println(session.get(H1_Kisi.class, 101));

		System.out.println();
		// id -12 olan gunlugun bilgilerini getiriniz

		System.out.println(session.get(H2_Gunluk.class, 12));

		System.out.println();

		// kişiler ve günlükler tablolarındaki ortak olan kayıtların kisi adı , yazılar
		// kısmı, kisi yasını sorgulayınız
		// Bunu hibernate ile tek satırda halledebiliriz ama şuan SQL ile yapacağız

		String sorgu = "SELECT k.kisiAd, g.yazilar, k.kisiYas"
				+ "FROM kisiler k INNER JOIN gunlukler g ON k.kisiId = g.kisi_id";
		List<Object[]> sonucList = session.createSQLQuery(sorgu).getResultList();

		for (Object[] w : sonucList) {
			System.out.println(Arrays.toString(w));
		}

		// günlük tablosundan öğrenci aını günlük adını kayıtların ogrenci yaşını getir

		String sorgu1 = "SELECT kisiAd,yazilar,kisiYas" + " FROM H1_Kisi k JOIN H2_Gunluk g ON k.kisiId=g.kisi";

		List<Object[]> sonucList1 = session.createQuery(sorgu1).getResultList();

		for (Object[] w1 : sonucList1) {
			System.out.println(Arrays.toString(w1));
		}
		session.close();
		sf.close();
		tx.commit();
	}

}
