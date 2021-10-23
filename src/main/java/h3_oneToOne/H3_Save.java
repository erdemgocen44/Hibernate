package h3_oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_Save {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Kisi.class)
				.addAnnotatedClass(H2_Gunluk.class).buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// Günlüklerin tanımlanması

		H2_Gunluk gunluk1 = new H2_Gunluk(11, "Salihin günlüğü");

		H2_Gunluk gunluk2 = new H2_Gunluk(12, "Minenin günlüğü");

		H2_Gunluk gunluk3 = new H2_Gunluk(13, "Dilanın günlüğü");

		// Kişilerin tanımlanması

		H1_Kisi kisi1 = new H1_Kisi(101, "Erdem", 38);

		H1_Kisi kisi2 = new H1_Kisi(102, "Merve", 36);

		H1_Kisi kisi3 = new H1_Kisi(103, "Akif", 10);

		gunluk1.setKisi(kisi1);
		gunluk2.setKisi(kisi2);
		gunluk3.setKisi(kisi3);

		session.save(kisi1);
		session.save(kisi2);
		session.save(kisi3);

		session.save(gunluk1);
		session.save(gunluk2);
		session.save(gunluk3);

		System.out.println(
				gunluk1.getKisi() + " " + gunluk1.getYazilar() + " " + kisi2.getKisiYas() + " " + kisi2.getKisiAd());

		tx.commit();

		session.close();

	}
}
