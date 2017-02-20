package fecha;

import java.time.LocalDate;

public class MainFecha {

	public static void main(String[] args) {
		
		Fecha then = new Fecha(31, 1, 1963);
		LocalDate now = LocalDate.now();
		
		while(then.getAnio() != now.getYear() || then.getMes() != now.getMonthValue() || then.getDia() != now.getDayOfMonth())
			System.out.println(then.siguienteDia());
		
	}

}
