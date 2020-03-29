package com.techelevator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WorkerDemo {
	
	
	public static void main(String [] args) {
		List <Worker> payroll = new ArrayList <Worker>();
		SalaryWorker mickeyMouse= new SalaryWorker("Mickey", "Mouse", 39000);
		SalaryWorker daisyDuck= new SalaryWorker("Daisy", "Duck", 39000);
		VolunteerWorker georgeGeef= new VolunteerWorker("George (Goofy)", "Geef");
		HourlyWorker minnieMouse= new HourlyWorker("Minnie", "Mouse", 105);
		payroll.add(minnieMouse);
		payroll.add(mickeyMouse);
		payroll.add(georgeGeef);
		payroll.add(daisyDuck);
		DecimalFormat df = new DecimalFormat("#,###.##");
		df.setMinimumFractionDigits(2);
		int totalHours = 0;
		double totalPay = 0;
		System.out.println("Employee\t\t\tHours Worked\t\t\tPay");
		System.out.println("==============================================================================");
		for (Worker w: payroll) {
			int random = (int)(Math.random()*80);
			totalHours += random;
			totalPay += w.getCalculateWeeklyPay(random);
			System.out.printf("%s, %-16s\t           %d\t\t\t       $%.2f\n", w.getLastName(), w.getFirstName(), random, w.getCalculateWeeklyPay(random));
		}
		System.out.println("");
		System.out.println("Total Hours: " + totalHours);
		System.out.println("Total Pay: $" + df.format(totalPay));
		System.out.println("==============================================================================");
}


}
