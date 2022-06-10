package com.nexsoft.ujian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.nexsoft.ujian.rumus.VolumeKolam;

public class VolumeKolamTest {

	VolumeKolam volume = new VolumeKolam();
//1
	@ParameterizedTest
    @DisplayName("Volume Sesuai Tabel")
    @CsvFileSource(resources = "data_volume.csv", delimiter = ',', numLinesToSkip = 1)
    public void Keliling_SesuaiTabel(int no, double p, double l, double t, double expected) {
		
		double result = volume.volume(p,l,t);
		
		assertEquals(expected, result);
	}
//2
	@ParameterizedTest
	@DisplayName("Masukan bukan angka")
	@CsvSource("String")
			public void KelilingKolamBukanAngka_Test(String str) {
			assertThrows(IllegalArgumentException.class, ()-> {
			volume.volume(3, 5, Double.parseDouble(str));
		});
	}
	
//3
	@ParameterizedTest
	@DisplayName("Masukkan angka negatif")
	@CsvSource(value = {"-2;-3;-4;24",
			"-2;-3;-5;30",
			"-3;-4;-6;72"},
						delimiter = ';')
	public void VolumeAngkaNegatif_Test(double a, double b, double c, double expected) {
		
	double result = -1*(volume.volume(a, b, c));
	assertEquals(expected, result);
		
	}
//4
	@ParameterizedTest
	@DisplayName("Tidak dimasukkan angka")
	@CsvSource(value = {",,,0",
			",,,0",
			",,,0"},
			delimiter = ';')
	public void TidakDimasukkanAngka_Test(String c) {
		
	String arrIsi[] = c.split(",");
	int length = arrIsi.length;
	int arrResult[] = new int[length];


	for (int i = 0; i < length; i++) {
	if (arrIsi[i].isEmpty())
	{
		arrResult[i] = 0;
	}
	else {
		arrResult[i] = Integer.parseInt(arrIsi[i]);
	}
}

	double result = volume.volume(arrResult[0], arrResult[1], arrResult[2]);
	assertEquals(arrResult[3], result);
}}
