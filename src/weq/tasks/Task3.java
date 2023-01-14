package weq.tasks;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Task3 {
	public static Scanner scanner = new Scanner(System.in);
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		System.out.println("Enter the date in format dd/MM/yyyy: ");
		Month currentMonth = LocalDate.now().getMonth();
		System.out.println(currentMonth);
		String stringDate = scanner.next();
		LocalDate localDate = LocalDate.parse(stringDate, formatter);
		int date = localDate.getDayOfMonth();
		String month = localDate.getMonth().toString();
		String year = String.valueOf(localDate.getYear());
		double finalAmt = 0;
		double penalty=0;
		double originalAmt = 1000;
		if(currentMonth.equals(localDate.getMonth()) || currentMonth.getValue()<localDate.getMonthValue()) {
			int lastDate = 10;
			 penalty = 1.0;
			// originalAmt = 1000;
			 long delayedDays = ChronoUnit.DAYS.between(LocalDate.now(), localDate);
			 System.out.println("del : "+delayedDays);
			if (delayedDays <= 0) {
				System.out.println(
						"Your electricity bill for the month of " + month + " year " + year + " is :" + originalAmt);
			} else {
				double penaltyPercent = (penalty / 100) * originalAmt;
				
				double finalPenaltyAmt = penaltyPercent * delayedDays;
				 finalAmt = originalAmt + finalPenaltyAmt;
				System.out
						.println("Your electricity bill for the Month of " + month + " Year " + year + " is :" + finalAmt);
			}
		}
		else {
			double penaltyPercent = (penalty / 100) * originalAmt;
			double finalPenaltyAmt = penaltyPercent ;
			 finalAmt = originalAmt + finalPenaltyAmt;
			System.out
					.println("Your electricity bill for the Month of " + month + " Year " + year + " is :" + finalAmt);
		}
		

	}
}
