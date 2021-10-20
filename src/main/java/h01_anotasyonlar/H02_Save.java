package h01_anotasyonlar;

import org.hibernate.cfg.Configuration;

public class H02_Save {
    public static void main(String[] args) {

        // BYRADAKİ IMPORTLAR HİBERNATE DEN YAPILIR
        Configuration con = new Configuration().configure("hibernate.cfg.xml");

        H01_Sehir sehir1 = new H01_Sehir(34, "İstanbul");
        H01_Sehir sehir2 = new H01_Sehir(01, "Adana");

    }

}
