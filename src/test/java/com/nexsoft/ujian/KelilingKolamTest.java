package com.nexsoft.ujian;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.nexsoft.ujian.rumus.KelilingKolam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class KelilingKolamTest {

	KelilingKolam keliling = new KelilingKolam();
//1
	@ParameterizedTest
    @DisplayName("Keliling Sesuai Tabel")
    @CsvFileSource(resources = "data_keliling.csv", delimiter = ',', numLinesToSkip = 1)
    public void KelilingSesuaiTabel_Test(int no, double p, double l, double t, double expected) {
		
		double result = keliling.keliling(p,l,t);
		
		assertEquals(expected, result);

	}
//2
	@ParameterizedTest
	@DisplayName("Masukan bukan angka")
	@CsvSource("String")
			public void KelilingKolamBukanAngka_Test(String str) {
			assertThrows(IllegalArgumentException.class, ()-> {
			keliling.keliling(3, 5, Double.parseDouble(str));
		});
	}
	
//3
	@ParameterizedTest
	@DisplayName("Masukkan angka negatif")
	@CsvSource(value = {"-2;-3;-4;36",
			"-2;-3;-5;40",
			"-3;-4;-6;52"},
						delimiter = ';')
	public void KelilingAngkaNegatif_Test(double a, double b, double c, double expected) {
		
	double result = -1*(keliling.keliling(a, b, c));
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

	double result = keliling.keliling(arrResult[0], arrResult[1], arrResult[2]);
	assertEquals(arrResult[3], result);

}
}
