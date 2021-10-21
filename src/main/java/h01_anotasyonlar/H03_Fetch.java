package h01_anotasyonlar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H03_Fetch {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H01_Sehir.class)
                .buildSessionFactory();
        // ! oluşturduk
        Session session = sf.openSession();// !Parent alandan kendime küçük alanlar açtım

        // Acilan session icerisinde islemlere baslayabilmek icin Transaction aciyoruz.
        /*
         * Transactionlar ile bir işlem yarıda kaldıysa veya tam olarak tamamlanadıysa
         * tüm adımlar başa alınır veri ve işlem güvenliği için önemlidir.Kısacası ya
         * hep ya hiç prensibine göre çalışır
         */

        Transaction tx = session.beginTransaction();

        System.out.println(session.get(H01_Sehir.class, 34));
        
       // System.out.println(session.get(H01_Sehir.class, 35).getSehirAd()); id ile çağırabiliyoruz
        
        tx.commit();

    }
}
