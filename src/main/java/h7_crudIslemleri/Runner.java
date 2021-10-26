package h7_crudIslemleri;
public class Runner {
    public static void main(String[] args) {
        
        //crud işlemleri için gerekli olan class tan object in türetilmesi
        CrudMetodlar metod=new CrudMetodlar();
        
        metod.sessionFactoryOlustur();
       
       
       metod.personelEkle("Akif Emre", "GÖÇEN", 7000);
        
       metod.personelEkle("Halide Dila", "GÖÇEN", 3000);
       
       metod.personelEkle("Ayşe Mine", "GÖÇEN", 7100);
       
       metod.tumPersoneliListele();
       
       metod.personelSil(23);
        
    }
}