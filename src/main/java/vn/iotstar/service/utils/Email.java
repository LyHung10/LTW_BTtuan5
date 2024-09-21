package vn.iotstar.service.utils;

import java.util.Properties;
import java.util.Random;



public class Email {
	
	//Hàm mã code ngau nhien
	public String getRandom() {
	Random rnd = new Random();
	int number = rnd.nextInt(999999);
	return String.format("%06d", number);
	}
}
