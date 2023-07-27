import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {

        // membuat scanner baru
        Scanner scanner = new Scanner(System.in);
        // membuat value untuk program dijalankan kembali atau tidak
        boolean lanjut = true;

        // looping program kembali bila false artinya program berjalan terus, bila true artinya program telah selesai
        while (lanjut) {
            // inisialisasi variabel
            int angkaPertama = 0;
            int angkaKedua = 0;
            int hasil = 0;

            // membuat value untuk angka pertama dijalankan kembali atau tidak
            boolean angkaPertamaValidasi = false;
            // melakukan looping bila ternyata salah memasukkan input angka pertama
            while (!angkaPertamaValidasi) {
                try {
                    // menerima input angka pertama
                    System.out.print("Masukkan angka pertama : ");
                    angkaPertama = scanner.nextInt();
                    angkaPertamaValidasi = true;
                } catch (InputMismatchException error) {
                    System.out.println("Maaf, input harus berupa format bilangan bulat. Silahkan coba kembali.");
                    angkaPertamaValidasi = false;
                    scanner.next(); // fungsinya agar tidak terjadi infinity loop
                }
            }

            // membuat value untuk angka kedua dijalankan kembali atau tidak
            boolean angkaKeduaValidasi = false;
            // melakukan looping bila ternyata salah memasukkan input angka kedua
            while (!angkaKeduaValidasi) {
                try {
                    // menerima input angka kedua
                    System.out.print("Masukkan angka kedua : ");
                    angkaKedua = scanner.nextInt();
                    angkaKeduaValidasi = true;
                } catch (InputMismatchException error) {
                    System.out.println("Maaf, input harus berupa format bilangan bulat. Silahkan coba kembali.");
                    angkaKeduaValidasi = false;
                    scanner.next();
                }
            }

            // membuat value untuk operator dijalankan kembali atau tidak
            boolean operatorValidasi = false;
            // melakukan looping bila ternyata salah memasukkan input operator
            while (!operatorValidasi) {
                try {
                    // menerima operator
                    System.out.print("Masukkan operator matematika (+, -, *, /) : ");
                    String operator = scanner.next();
                    // melakukan perhitungan kalkulasi sesuai dengan operator yg diinputkan
                    switch (operator) {
                        case "+":
                            hasil = angkaPertama + angkaKedua;
                            operatorValidasi = true;
                            break;
                        case "-":
                            hasil = angkaPertama - angkaKedua;
                            operatorValidasi = true;
                            break;
                        case "*":
                            hasil = angkaPertama * angkaKedua;
                            operatorValidasi = true;
                            break;
                        case "/":
                            if (angkaKedua == 0) {
                                System.out.println("Tidak dapat melakukan pembagian dengan 0");
                                operatorValidasi = false;
                            } else {
                                hasil = angkaPertama / angkaKedua;
                                operatorValidasi = true;
                            }
                            break;
                        default:
                            System.out.println("Maaf, operator yang Anda masukkan tidak valid! Silahkan coba kembali.");
                            operatorValidasi = false;
                            break;
                    }
                } catch (InputMismatchException error) {
                    System.out.println("Input operator harus berupa karakter. Silahkan coba kembali.");
                }
            }

            // memunculkan hasil
            System.out.println("Hasil : " + hasil);

            // menanyakan apakah ingin menjalankan program kembali?
            System.out.print("Apakah kalkulator ingin dijalankan kembali ? (ya/tidak) : ");
            String isRunning;
            isRunning = scanner.next();

            // mengatur program akan dijalankan kembali atau tidak sesuai inputan user
            if (isRunning.equalsIgnoreCase("ya")) {
                System.out.println("=================================================================================");
                System.out.println("Program Selanjutnya");
                lanjut = true;
            } else if (isRunning.equalsIgnoreCase("tidak")) {
                System.out.println("Terimakasih! Program Kalkulator Telah Selesai");
                System.out.println("=================================================================================");
                lanjut = false;
            } else {
                System.out.println("Input salah, format harus berupa ya/tidak. Silahkan refresh kembali.");
                System.out.println("=================================================================================");
                lanjut = false;
            }
        }

        // menutup scanner
        scanner.close();
        }

}
