package model;

public class CalculatorDTO implements CalculatorImpl {

	private Integer firstNumber;
	private Integer secondNumber;
	private Integer result;
	private char operator;

	@Override
	public Integer getFirstNumber() {
		return firstNumber;
	}

	@Override
	public Integer getSecondNumber() {
		return secondNumber;
	}

	@Override
	public Integer getResult() {
		return result;
	}

	@Override
	public void setFirstNumber(Integer firstNumber) {
		this.firstNumber = firstNumber;
	}

	@Override
	public void setSecondNumber(Integer secondNumber) {
		this.secondNumber = secondNumber;
	}

	@Override
	public void setOperator(char operator) {
		this.operator = operator;
	}

}