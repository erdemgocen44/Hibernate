package h7_crudIslemleri;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CrudMetodlar {

	private static SessionFactory sf;

	public void sessionFactoryOlustur() {

		try {

			Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Personel.class);
			sf = con.buildSessionFactory();

		} catch (Throwable e) {
			System.err.println("session fabrikası oluşurken hata oluştu" + e);

			throw new ExceptionInInitializerError(); // şart değil ama exception ın tam ismini yazmak istersek tercih
														// edilebilir

		}

	}

	// veritabanına bir personel ekleyen metod

	public void personelEkle(String ad, String soyad, int maas) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Personel personel = new Personel(ad, soyad, maas);
			session.save(personel);// yandakini syso içinde yazdırırsak verinin id sini döndürür
			tx.commit();
			System.out.println("personel başarıyla kaydoldu");
		} catch (HibernateException e) {
			if (tx != null) { // içi doluysa başarısız işlem
				tx.rollback(); // işlemi geri al
			}
			e.printStackTrace();// exception ın satırını göster

		} finally {
			session.close();
		}
	}

	// veritabanındaki tüm kayıtları listeleyyen method

	public void tumPersoneliListele() {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			List<Personel> personeller = session.createQuery("FROM Personel").getResultList();

			personeller.stream().forEach((x) -> System.out.println(x));

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) { // içi doluysa başarısız işlem
				tx.rollback(); // işlemi geri al
			}
			e.printStackTrace();// exception ın satırını göster

		} finally {
			session.close();
		}
	}

	// Veritabanından bir personeli silme

	public void personelSil(long id) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Personel personel = session.get(Personel.class, id);

			if (personel == null)
				System.out.println("Bulunamadı");
			else
				session.delete(personel);

			tx.commit();
			System.out.println(personel + " silindi");
		} catch (HibernateException e) {
			if (tx != null) { // içi doluysa başarısız işlem
				tx.rollback(); // işlemi geri al
			}
			e.printStackTrace();// exception ın satırını göster

		} finally {
			session.close();
		}
	}

	// id ile bir kaydın maas bilgisini guncelle

	public void maasGuncelle(long id, int maas) {
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			
			Personel personel=session.get(Personel.class, id);
			
			if(personel==null) {
				System.out.println(id+" id'li personel bulunamadı");
			}else personel.setMaas(maas);
			
			tx.commit();
			System.out.println(id+" id'li personelin yeni maaşı : "+maas);
			
			
		} catch (HibernateException e) {
			if (tx != null) { // içi doluysa başarısız işlem
				tx.rollback(); // işlemi geri al
			}
			e.printStackTrace();// exception ın satırını göster

		} finally {
			session.close();
		}
	}

}
