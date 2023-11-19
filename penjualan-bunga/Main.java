import Penjualan_bunga.Bunga_Anggrek;

public class Main {
    public static void main(String[] args) {
        Bunga_Anggrek pembeli_01 = new Bunga_Anggrek();
        pembeli_01.nama_bunga = "anggrek";
        pembeli_01.harga_bunga = "500000";
        pembeli_01.JenisAnggrek ="anggrek bulan";
        pembeli_01.Ukuran ="ukuran besar";
        
        Bunga_mawar pembeli_02 = new Bunga_mawar();
        pembeli_02.nama_bunga = "Bunga mawar"; 
        pembeli_02.Jumblahkelopak = "10"; 
        pembeli_02.Warna = "Merah";
        pembeli_02.aroma = "Harum"; 

        System.out.println("****************Toko Bunga**********************");
        System.out.println("Nama bunga :"+ pembeli_01.nama_bunga);
        System.out.println("Jenis bunga :"+ pembeli_01.JenisAnggrek);
        System.out.println("Harga bunga :"+ pembeli_01.harga_bunga);
        System.out.println("Ukuran :"+ pembeli_01.Ukuran);
        pembeli_01.caraBerkembangBiak();
        pembeli_01.nama_pupuk();

        System.out.println("****************Toko Bunga**********************");

        System.out.println("Nama Bunga:"+ pembeli_02.nama_bunga);
        System.out.println("Jumlah kelopak Bunga:"+ pembeli_02.Jumblahkelopak);
        System.out.println("Warna Bunga:"+ pembeli_02.Warna);
        System.out.println("Aroma Bunga:"+ pembeli_02.aroma);
        pembeli_02.caraBerkembangBiak();
        pembeli_02.nama_pupuk();

        
    }

}
