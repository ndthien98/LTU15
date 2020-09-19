package model;

public class CalculatorDAO {
	private static CalculatorDAO instance;
	private String regex;

	public static CalculatorDAO getInstance() {
		if (instance == null) {
			instance = new CalculatorDAO();
		}
		return instance;
	}

	private CalculatorDAO() {
		this.regex = "\\D";
	}

	public Integer calculate(String firstText, String secondText, char operator) {
		try {
			int a1 = Integer.valueOf(firstText.replaceAll(regex, ""));
			int a2 = Integer.valueOf(secondText.replaceAll(regex, ""));
			System.out.println(a1 + " " + operator + " " + a2);
			switch (operator) {
			case '+':
				return a1 + a2;
			case '-':
				return a1 - a2;
			case '*':
				return a1 * a2;
			case '/':
				return a1 / a2;
			case '%':
				return a1 % a2;
			default:
				return 0;
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			return 0;
		}
	}
}
