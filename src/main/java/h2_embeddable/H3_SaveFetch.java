package h2_embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_SaveFetch {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Ogrenci.class)
				.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		
		  H2_Dersler ders1 = new H2_Dersler("Müzik", "Matematik");
		  
		  H1_Ogrenci ogrenci1=new H1_Ogrenci(12, "Erdem Gocen", 76, ders1);
		  
		  session.save(ogrenci1);
		  
		  session.save(new H1_Ogrenci(13,"Mehmet Ozbay",83,new
		  H2_Dersler("Resim","Fizik")));// bu uzun yazım yukarıdaki 3 satırın aynısı
		 
		//Fetch İşlemi
		
		System.out.println(session.get(H1_Ogrenci.class, 12));
		
		System.out.println(session.get(H1_Ogrenci.class, 13).getOgrAd());
		
		tx.commit();
		
		sf.close();
		
		session.close();
		
		

	}

}
