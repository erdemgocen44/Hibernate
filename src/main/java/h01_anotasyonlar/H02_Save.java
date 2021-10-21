package h01_anotasyonlar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H02_Save {
    public static void main(String[] args) {

        // ! BURADAKİ IMPORTLAR HİBERNATE DEN YAPILIR
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H01_Sehir.class);
        // ! SQL verilerinin olduğu cfg.xml classına bağlandık bu sayede sql e bağlandık
        // ! ve h01_sehir classında işlem yapacağımızı belirttik

        SessionFactory sf = con.buildSessionFactory();// ! işlem yapacağımız alanlar(Session) için parent alanlar
                                                      // ! oluşturduk
        Session s = sf.openSession();// !Parent alandan kendime küçük alanlar açtım

        // Acilan session icerisinde islemlere baslayabilmek icin Transaction aciyoruz.
        /*
         * Transactionlar ile bir işlem yarıda kaldıysa veya tam olarak tamamlanadıysa
         * tüm adımlar başa alınır veri ve işlem güvenliği için önemlidir.Kısacası ya
         * hep ya hiç prensibine göre çalışır
         */

        Transaction tx = s.beginTransaction();

        H01_Sehir sehir1 = new H01_Sehir(34, "İstanbul", 18000000);
        H01_Sehir sehir2 = new H01_Sehir(01, "Adana", 3200000);

        s.save(sehir1);
        s.save(sehir2);

        tx.commit();

        s.close();
        sf.close();
    }

}
