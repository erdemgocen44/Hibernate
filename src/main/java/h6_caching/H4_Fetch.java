package h6_caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Developer.class)
				.addAnnotatedClass(H2_Hesap.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session1 = sf.openSession();

		Transaction tx1 = session1.beginTransaction();

		// id=1 olan dev in bilgilerini çekelim

		System.out.println(session1.get(H1_Developer.class, 1));
		// id=2 olan dev in bilgilerini çekelim
		System.out.println(session1.get(H1_Developer.class, 2));

		// id=1 olan dev in bilgilerini çekelim

		System.out.println(session1.get(H1_Developer.class, 1));
		// id=2 olan dev in bilgilerini çekelim
		System.out.println(session1.get(H1_Developer.class, 2));

		
		tx1.commit();
		
		//session1 i kapatıp deneyelim...
		session1.close();
		
		System.out.println("SESSİON1 KAPATILDI");
		System.out.println();
		
		session1=sf.openSession();
		tx1=session1.beginTransaction();
		
		tx1.commit();
		
		
		//tekrar a.ılan session1 çalıştırıyoruz...
		System.out.println(session1.get(H1_Developer.class, 1));
		
// Ayrı bir sessionda aynı veriye (111) erişmek istersek ne olur?
// Cevap: Bu veri, diğer session’a ait oldugu icin bu session’nın cache’inde bulunmaz.
// Bu sebeple ile yeniden veritabanına gitmek gerekecektir.
		
// Ayrı session’ların aynı veriyi cache’den alabilmesi için L2 cache sisteminin acilmasi gerekir.
// Bunun için 
// 1) Aşağıda anotasyonların ilgili nesnelere eklenemsi gerekir.
//   @Cacheable
//   @Cache(region=“H2_Kitap”, usage=CacheConcurrencyStrategy.READ_WRITE)

// 2) POM dosyasına Cache ile ilgili dependency’leri eklemek gerekir.
//   https://mvnrepository.com/artifact/org.hibernate/hibernate-ehcache
		
// 3) cfg dosyasına asagidaki konfigürasyonları eklemek gerekir. 
//		<!-- Following 2 lines are for Second Level Cache -->
//  	<property name=“hibernate.cache.use_second_level_cache”>true</property>     
//		<property name=“hibernate.cache.region.factory_class”>org.hibernate.cache.ehcache.internal.EhcacheRegionFactory</property>
//		<property name=“hibernate.cache.provider_class”>org.hibernate.cache.internal.EhcacheProvider</property>

	Session session2=sf.openSession();
	
	Transaction tx2=session2.beginTransaction();
	
	tx2.commit();
	
	System.out.println(session2.get(H1_Developer.class, 1));
		
	}
}
