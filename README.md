# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah : Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu : <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama : Gilang Ramadhan Herdian</li>
  <li>NIM : 23552011436</li>
  <li>Studi Kasus : Kasir toko online dengan pengelolaan diskon </li>
</ul>

## Judul Studi Kasus
<p>Kasir E-Commerce</p>

## Penjelasan Studi Kasus
<p>Sistem ini merupakan simulasi kasir berbasis console untuk e-commerce. Pengguna dapat melihat daftar produk, memilih produk yang ingin dibeli, menentukan jumlah, serta memilih metode pembayaran (Credit Card, Bank Transfer, atau E-Wallet). Setelah semua item dimasukkan dan metode pembayaran dipilih, sistem menghitung total harga setelah diskon, melakukan proses pembayaran, dan menyimpan transaksi ke dalam database.</p>
</ul>Fitur Utama :</ul>
</ul>
<li>Menampilkan daftar produk</li>
<li>Menambahkan produk ke keranjang</li>
<li>Mendukung tiga metode pembayaran</li>
<li>Menghitung total transaksi dengan diskon</li>
<li>Menyimpan transaksi ke database</li>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Memungkinkan kelas baru mewarisi properti dan metode dari kelas lain.</p>
</ul>Contoh :</ul>
<li>Class CreditCardPayment, BankTransferPayment, dan EWalletPayment merupakan turunan dari PaymentMethod.</li>

### 2. Encapsulation
<p>Menyembunyikan detail implementasi dari pengguna dan hanya mengekspos apa yang dibutuhkan.</p>
</ul>Contoh :</ul>
<li>Class Product, Transaction, dan PaymentMethod kemungkinan besar memiliki atribut private dan diakses melalui getter/setter.</li>

### 3. Polymorphism
<p>Objek bisa memiliki banyak bentuk melalui pewarisan dan interface.</p>
</ul>Contoh :</ul>
<li>PaymentMethod method bisa merujuk ke objek CreditCardPayment, BankTransferPayment, atau EWalletPayment.</li>

### 4. Abstract
<p>Menyederhanakan kompleksitas sistem dengan hanya menampilkan fitur penting.</p>
</ul>Contoh :</ul>
<li>Interface/abstract class PaymentMethod mewakili berbagai metode pembayaran tanpa perlu tahu implementasi detailnya.</li>

## Demo Proyek
<ul>
  <li>Github : <a href="">https://github.com/Gilangrmdhn05/UTS_PBO2_23CNSA_23553011436</a></li>
  <li>Youtube : <a href="">https://youtu.be/ZKLJ5Zm7G10?si=t_WSDyInQNdQd8O3</a></li>
</ul>
