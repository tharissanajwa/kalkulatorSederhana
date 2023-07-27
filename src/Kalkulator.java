import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {

        // Membuat objek Scanner untuk menerima input dari pengguna
        Scanner scanner = new Scanner(System.in);
        // Variabel 'lanjut' untuk mengontrol apakah program akan berjalan kembali atau tidak
        boolean lanjut = true;

        while (lanjut) {
            double angkaPertama = 0;
            double angkaKedua = 0;
            double hasil = 0;

            // Validasi input angka pertama
            boolean angkaPertamaValidasi = false;
            while (!angkaPertamaValidasi) {
                try {
                    System.out.print("Masukkan angka pertama : ");
                    angkaPertama = scanner.nextDouble();
                    angkaPertamaValidasi = true;
                } catch (InputMismatchException error) {
                    // Menampilkan pesan kesalahan jika input bukan bilangan bulat
                    System.out.println("Maaf, input harus berupa format bilangan bulat. Silahkan coba kembali.");
                    angkaPertamaValidasi = false;
                    scanner.next(); // Membaca input berikutnya agar tidak terjadi infinite loop
                }
            }

            // Validasi input angka kedua
            boolean angkaKeduaValidasi = false;
            while (!angkaKeduaValidasi) {
                try {
                    System.out.print("Masukkan angka kedua : ");
                    angkaKedua = scanner.nextDouble();
                    angkaKeduaValidasi = true;
                } catch (InputMismatchException error) {
                    // Menampilkan pesan kesalahan jika input bukan bilangan bulat
                    System.out.println("Maaf, input harus berupa format bilangan bulat. Silahkan coba kembali.");
                    angkaKeduaValidasi = false;
                    scanner.next(); // Membaca input berikutnya agar tidak terjadi infinite loop
                }
            }

            // Validasi input operator matematika
            boolean operatorValidasi = false;
            while (!operatorValidasi) {
                System.out.print("Masukkan operator matematika (+, -, *, /) : ");
                char operator = scanner.next().charAt(0);
                switch (operator) {
                    case '+':
                        hasil = angkaPertama + angkaKedua;
                        operatorValidasi = true;
                        break;
                    case '-':
                        hasil = angkaPertama - angkaKedua;
                        operatorValidasi = true;
                        break;
                    case '*':
                        hasil = angkaPertama * angkaKedua;
                        operatorValidasi = true;
                        break;
                    case '/':
                        if (angkaKedua == 0) {
                            // Menampilkan pesan kesalahan jika terjadi pembagian dengan 0
                            System.out.println("Tidak dapat melakukan pembagian dengan 0");
                            operatorValidasi = false;
                        } else {
                            hasil = angkaPertama / angkaKedua;
                            operatorValidasi = true;
                        }
                        break;
                    default:
                        // Menampilkan pesan kesalahan jika operator yang dimasukkan tidak valid
                        System.out.println("Maaf, operator yang Anda masukkan tidak valid! Silahkan coba kembali.");
                        operatorValidasi = false;
                        break;
                }
            }

            // Menampilkan hasil perhitungan
            System.out.println("Hasil : " + hasil);

            // Meminta pengguna untuk menjalankan kalkulator kembali atau tidak
            System.out.print("Apakah kalkulator ingin dijalankan kembali ? (ya/tidak) : ");
            String isRunning;
            isRunning = scanner.next();

            if (isRunning.equalsIgnoreCase("ya")) {
                // Jika pengguna ingin menjalankan kalkulator kembali, program akan terus berjalan
                System.out.println("=================================================================================");
                System.out.println("Program Selanjutnya");
                lanjut = true;
            } else if (isRunning.equalsIgnoreCase("tidak")) {
                // Jika pengguna tidak ingin menjalankan kalkulator kembali, program akan selesai
                System.out.println("Terimakasih! Program Kalkulator Telah Selesai");
                System.out.println("=================================================================================");
                lanjut = false;
            } else {
                // Jika pengguna memasukkan input selain "ya" atau "tidak", program akan selesai
                System.out.println("Input salah, format harus berupa ya/tidak. Silahkan refresh kembali.");
                System.out.println("=================================================================================");
                lanjut = false;
            }
        }

        // Menutup scanner untuk mencegah resource leak
        scanner.close();
    }
}
