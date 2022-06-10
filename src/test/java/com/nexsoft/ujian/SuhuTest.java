package com.nexsoft.ujian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.nexsoft.ujian.rumus.Suhu;

public class SuhuTest {

	Suhu suhu = new Suhu();
//1
	@ParameterizedTest
    @DisplayName("Konversi Suhu Sesuai Tabel")
    @CsvFileSource(resources = "data_suhu.csv", delimiter = ',', numLinesToSkip = 1)
    public void KonversiSuhu_SesuaiTabel(float no, float f, float expected) {
		
		float result = suhu.konversi(f);
		
		assertEquals(expected, result);	
}}
	

