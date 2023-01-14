package weq.tasks;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Task1 {
	public static Scanner scanner = new Scanner(System.in);
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		System.out.println("Enter the Start Date in the format dd/MM/yyyy");
		String startDate = scanner.next();
		System.out.println("Enter the End Date in the format dd/MM/yyyy");
		String endDate = scanner.next();
		Task1 task1 = new Task1();
		List<String> dates = task1.getDates(startDate, endDate);
		task1.displayDates(dates);
	}

	private void displayDates(List<String> dates) {
		if (dates.size() == 0) {
			System.out.println("No dates have Monday,Thursday or Friday in the given range");
			return;
		}
		ListIterator<String> listIterator = dates.listIterator();
		System.out.println("There are " + dates.size() + " dates in the given range, printing the dates: ");
		while (listIterator.hasNext()) {
			String date = listIterator.next();
			System.out.println(date);
		}

	}

	public List<String> getDates(String startDate, String endDate) {
		List<String> dates = new ArrayList<>();
		LocalDate sDate = LocalDate.parse(startDate, formatter);
		LocalDate eDate = LocalDate.parse(endDate, formatter);
		if (sDate.isAfter(eDate))
			throw new DateTimeException("Start Date cannot be greater then End Date");

		for (LocalDate date = sDate; date.isBefore(eDate) || date.equals(eDate); date = date.plusDays(1)) {
			DayOfWeek day = date.getDayOfWeek();
			if (day.equals(DayOfWeek.MONDAY) || day.equals(DayOfWeek.THURSDAY) || day.equals(DayOfWeek.FRIDAY)) {
				String formattedDate = date.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy"));
				dates.add(formattedDate);
			}

		}

		return dates;
	}

}
