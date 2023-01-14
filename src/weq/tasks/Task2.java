package weq.tasks;

public class Task2 {
	public static Double annualROI = 4.5;
	public static Double iniitialAmt = 100.0;// say amount is 100 initilally

	public static void main(String[] args) {
		Double quaterROI = annualROI / 4;
		System.out.println("Interest rate for each quarter Q1,Q2,Q3 and Q4 is " + quaterROI);
		Double quarterAmt = (iniitialAmt / 4) + quaterROI;
		System.out.println("Quater Amount with interest : " + quarterAmt);
		Double finalAmt = iniitialAmt + (quaterROI * 4);
		System.out.println("Final Amount with interest : " + finalAmt + " for the amount " + iniitialAmt);
	}
}
