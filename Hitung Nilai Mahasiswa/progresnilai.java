import java.util.Scanner;


public class progresnilai {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Nama: ");
        String Nama = input.nextLine();
        System.out.print("Nim: ");
        String NIM = input.nextLine();

        
        System.out.print("Nilai Tubes: ");
        double skortubes = input.nextDouble();
        System.out.print("Nilai Quiz: ");
        double skorQuiz = input.nextDouble();
        System.out.print("Nilai Tugas: ");
        double SkorTugas = input.nextDouble();
        System.out.print("Nilai UTS: ");
        double skorUTS = input.nextDouble();
        System.out.print("Nilai UAS: ");
        double SkorUAS = input.nextDouble();

        caramenghitung rumus = new caramenghitung();
        Double Totalnilai = rumus.Totalnilai(skortubes, skorQuiz, SkorTugas, skorUTS, SkorUAS);

        System.out.println("Nama  : " + Nama);
        System.out.println("NIM   : " + NIM);
        System.out.println("Nilai Matakuliah Pemrograman Berorientasi Objek:"+ Totalnilai);
                
        input.close();
    }
}
