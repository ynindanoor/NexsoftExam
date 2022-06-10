package com.nexsoft.ujian.rumus;
import javax.annotation.processing.FilerException;
public class KelilingKolam {

	public double keliling(double p, double l, double t) {
		return(4*(p+l+t));
	}
	
	public double kelilingKolam(double a, double b, double c) {
		return Math.abs(4 * (a + b + c));
	}
		
	
}
