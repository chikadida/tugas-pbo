package Penjualan_bunga;

public abstract class Penjualan_Bunga{
    public String nama_bunga ;
    public String harga_bunga ;

    public void caraBerkembangBiak (){
        System.out.println("Cara berkembang biak dengan setek");
    }

    public abstract void nama_pupuk();
}