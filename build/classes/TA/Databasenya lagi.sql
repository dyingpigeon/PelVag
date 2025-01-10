CREATE TABLE `users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `nama_depan` VARCHAR(50) NOT NULL,
  `nama_belakang` VARCHAR(50) NOT NULL,
  `telepon` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`user_id`)
);
INSERT INTO `users` (`user_id`, `username`, `password`, `nama_depan`, `nama_belakang`, `telepon`) VALUES
  ('000001', 'ahmad', 'q', 'Ahmad', 'Santoso', '081234567890'),
  ('000002', 'budi', 'password123', 'Budi', 'Setiawan', '082134567891'),
  ('000003', 'citra', 'password123', 'Citra', 'Permata', '083134567892'),
  ('000004', 'dewi', 'password123', 'Dewi', 'Sari', '084134567893'),
  ('000005', 'eko', 'password123', 'Eko', 'Prasetyo', '085134567894');

CREATE TABLE `karyawan` (
  `karyawan_id` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `nama_belakang` varchar(255) NOT NULL,
  `telepon` varchar(20) NOT NULL,
  PRIMARY KEY (`karyawan_id`)
);

INSERT INTO `karyawan` (`karyawan_id`, `nama`, `nama_belakang`, `telepon`) VALUES
(100001, 'Ahmad', 'Santoso', '081234567890'),
(100002, 'Budi', 'Setiawan', '082134567891'),
(100003, 'Citra', 'Permata', '083134567892'),
(100004, 'Dewi', 'Sari', '084134567893'),
(100005, 'Eko', 'Prasetyo', '085134567894');

CREATE TABLE `songket` (
  `songket_id` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `harga` int NOT NULL,
  PRIMARY KEY (`songket_id`)
);

INSERT INTO `songket` (`songket_id`, `nama`, `harga`) VALUES
(200001, 'Songket Palembang', 500000),
(200002, 'Songket Minangkabau', 450000),
(200003, 'Songket Bali', 600000),
(200004, 'Songket Melayu', 550000),
(200005, 'Songket Aceh', 480000);


CREATE TABLE `bahan` (
  `bahan_id` int NOT NULL AUTO_INCREMENT,
  `nama` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`bahan_id`)
);

INSERT INTO `bahan` (`bahan_id`, `nama`) VALUES
(300001, 'Katun'),
(300002, 'Sutra'),
(300003, 'Brocade'),
(300004, 'Tenun'),
(300005, 'Polyester');


CREATE TABLE `warna` (
  `warna_id` int NOT NULL AUTO_INCREMENT,
  `nama` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`warna_id`)
);

INSERT INTO `warna` (`warna_id`, `nama`) VALUES
(400001, 'Merah'),
(400002, 'Biru'),
(400003, 'Hijau'),
(400004, 'Kuning'),
(400005, 'Ungu'),
(400006, 'Hitam'),
(400007, 'Putih'),
(400008, 'Emas'),
(400009, 'Perak'),
(4000010, 'Coklat');

CREATE TABLE `ekspedisi` (
  `ekspedisi_id` int NOT NULL AUTO_INCREMENT,
  `nama` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ekspedisi_id`)
);

INSERT INTO `ekspedisi` (`ekspedisi_id`, `nama`) VALUES
(500001, 'JNE'),
(500002, 'TIKI'),
(500003, 'POS Indonesia'),
(500004, 'SiCepat'),
(500005, 'J&T Express');



CREATE TABLE `pesanan` (
  `pesanan_id` int NOT NULL AUTO_INCREMENT,
  `karyawan_id` int NOT NULL,
  `ekspedisi_id` int NOT NULL,
  `penerima` varchar(255) NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `alamat` text NOT NULL,
  PRIMARY KEY (`pesanan_id`)
);

INSERT INTO `pesanan` (`pesanan_id`, `karyawan_id`, `ekspedisi_id`, `penerima`, `telepon`, `alamat`) VALUES
(600001, 100004, 500005, 'Lisa Rahmawati', '081345678901', 'Jl. Merdeka No. 10, Palembang'),
(600002, 100004, 500005, 'Andi Wijaya', '082345678902', 'Jl. Sudirman No. 15, Jakarta'),
(600003, 100004, 500005, 'Siti Nurhaliza', '083345678903', 'Jl. Ahmad Yani No. 20, Bandung'),
(600004, 100004, 500005, 'Rudi Santoso', '084345678904', 'Jl. Diponegoro No. 5, Surabaya'),
(600005, 100004, 500005, 'Fajar Pratama', '085345678905', 'Jl. Gatot Subroto No. 12, Medan');


CREATE TABLE `detail_pesanan` (
  `detail_pesanan_id` int NOT NULL AUTO_INCREMENT,
  `pesanan_id` int NOT NULL,
  `songket_id` int NOT NULL,
  `bahan_id` int NOT NULL,
  `warna_id` int NOT NULL,
  `jumlah` int NOT NULL,
  PRIMARY KEY (`detail_pesanan_id`),
  FOREIGN KEY (`pesanan_id`) REFERENCES `pesanan` (`pesanan_id`) ON DELETE CASCADE
);

INSERT INTO `detail_pesanan` (`detail_pesanan_id`, `pesanan_id`, `songket_id`, `bahan_id`, `warna_id`, `jumlah`) VALUES
(700001, 600001, 200001, 300001, 400001, 2),
(700002, 600001, 200002, 300002, 400002, 1),
(700003, 600002, 200003, 300003, 400003, 3),
(700004, 600002, 200004, 300004, 400004, 1),
(700005, 600003, 200005, 300005, 400005, 4),
(700006, 600004, 200001, 300001, 400006, 2),
(700007, 600005, 200002, 300002, 400007, 5);


CREATE TABLE `stok` (
  `songket_id` int NOT NULL,
  `jumlah` int NOT NULL
);