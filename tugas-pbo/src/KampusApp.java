import java.util.Scanner;

import model.Mahasiswa;
import repository.Database;
import model.Prodi;

public class KampusApp {
    public static void main(String[] args) {
        KampusApp kampusApp = new KampusApp();
        kampusApp.showMenu();
    }

    private Scanner scanner;
    private Database db;

    public KampusApp() {
        scanner = new Scanner(System.in);
        db = new Database();
    }

    public void showMenu() {
        System.out.println("---------------------------------");
        System.out.println("Selamat Datang di Aplikasi Kampus");
        System.out.println("Pilihan Menu Mahasiswa:");
        System.out.println("1 -> Tambah Data Mahasiswa");
        System.out.println("2 -> Ubah Data Mahasiswa");
        System.out.println("3 -> Hapus Data Mahasiswa");
        System.out.println("4 -> Cari Data Mahasiswa");
        System.out.println("\nPilihan Menu Prodi:");
        System.out.println("5 -> Tambah ID ");
        System.out.println("6 -> Ubah ID ");
        System.out.println("7 -> Hapus ID ");
        System.out.println("8 -> Cari ID ");
        System.out.println("\n0 -> Keluar Aplikasi");
        System.out.print("Silahkan masukan menu yang dipilih: ");
        int menuYangDipilih = scanner.nextInt();
        scanner.nextLine();
        switch(menuYangDipilih) {
            case 1:
            menuTambah();
            break;
            case 2:
            menuUbah();
            break;
            case 3:
            menuHapus();
            break;
            case 4:
            menuCari();
            break;
            case 5:
            menuTambahIDProdi();
            break;
            case 6:
            menuUbahIDProdi();
            break;
            case 7:
            menuHapusIDProdi();
            break;
            case 8:
            menuCariIDProdi();
            break;
            default: {
                System.out.print("* Terimakasih sudah menggunakan Aplikasi Kampus *");
                System.exit(0);
            }
            break;
        }
        scanner.close();
    }

    public void menuTambah() {
        System.out.println("----- Menu Tambah Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukan ID Prodi: ");
        String IDProdi = scanner.nextLine();
        Prodi prodi = db.prodiTbl.getProdiById(IDProdi);
        if (prodi == null) {
            System.out.println("Prodi dengan ID " + IDProdi + " tidak dapat ditemukan.");
        } else {
            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, IDProdi);
            db.mahasiswaTbl.create(mahasiswa);
            System.out.println(nama + " Bergabung di: " + prodi.getNamaProdi());
        }

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuUbah() {
        System.out.println("----- Menu Ubah Data Mahasiswa -----");
        System.out.print("Masukan NIM Sebelumnya: ");
        String nimLama = scanner.nextLine();
        System.out.print("Masukan NIM: ");
        String nimBaru = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String nama = scanner.nextLine();
        System.out.println("Masukan ID Prodi: ");
        String prodi = scanner.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(nimBaru, nama, prodi);
        db.mahasiswaTbl.update(nimLama, mahasiswa);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuCari() {
        System.out.println("----- Menu Cari Data Mahasiswa -----");
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        Mahasiswa mahasiswa = db.mahasiswaTbl.getMahasiswaByNim(nim);
    
        if (mahasiswa == null) {
            System.out.println("* NIM tidak ditemukan *");
        } else {
            System.out.println("* NIM: " + mahasiswa.getNim() + " *");
            System.out.println("* Nama: " + mahasiswa.getNama() + " *");
    
            String IDProdi = mahasiswa.getProdi(); // Mengambil ID Prodi dari Mahasiswa
            Prodi prodi = db.prodiTbl.getProdiById(IDProdi);
    
            if (prodi == null) {
                System.out.println("* ID Prodi tidak ditemukan *");
            } else {
                System.out.println("* Nama Prodi: " + prodi.getNamaProdi() + " *");
            }
        }
    
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuHapus() {
        System.out.println("----- Menu Hapus Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        db.mahasiswaTbl.delete(nim);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuTambahIDProdi() {
        System.out.println("----- Menu Tambah ID Prodi -----");
        System.out.print("Masukan ID: ");
        String id = scanner.nextLine();
        System.out.print("Masukan Nama Prodi: ");
        String nama = scanner.nextLine();
        Prodi prodi = new Prodi(id, nama);
        db.prodiTbl.create(prodi);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuUbahIDProdi() {
        System.out.println("----- Menu Ubah ID Prodi -----");
        System.out.print("Masukkan ID Sebelumnya: ");
        String idLama = scanner.nextLine();
    
        Prodi prodiLama = db.prodiTbl.getProdiById(idLama);
    
        if (prodiLama == null) {
            System.out.println("* ID Prodi tidak ditemukan *");
        } else {
            System.out.print("Masukkan ID Baru: ");
            String idBaru = scanner.nextLine();
            System.out.print("Masukkan Nama Prodi: ");
            String nama = scanner.nextLine();
    
            Prodi prodiBaru = new Prodi(idBaru, nama);
            db.prodiTbl.update(idLama, prodiBaru);
            System.out.println("Data ID Prodi berhasil diubah.");
        }
    
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }
    
    public void menuCariIDProdi() {
        System.out.println("----- Menu Cari Data Prodi -----");
        System.out.print("Masukan ID: ");
        String id = scanner.nextLine();
        Prodi prodi = db.prodiTbl.getProdiById(id);
        if (prodi == null) {
            System.out.println("* ID Prodi tidak ditemukan *");
        } else {
            System.out.println("* ID Prodi: " + prodi.getId() + " *");
            System.out.println("* Nama Prodi: " + prodi.getNamaProdi() + " *");
        }
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }
    
    public void menuHapusIDProdi() {
        System.out.println("----- Menu Hapus Data Prodi -----");
        System.out.print("Masukan ID: ");
        String id = scanner.nextLine();
        db.prodiTbl.delete(id);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }
    
}