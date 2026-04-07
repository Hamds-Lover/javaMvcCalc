public class CalculatorController{
	private CalculatorView view;
	private CalculatorModel model;

	public CalculatorController(CalculatorModel model, CalculatorView view){
		this.model = model;
		this.view = view;
	}

	public void run(){
		view.showMenu();
		double a = view.getNumber("Enter first number: ");
		double b = view.getNumber("Enter second number: ");
		String operator = view.getOperator();

		try {
			double result;
			switch (operator){
				case "+": result = model.add(a, b); break;
				case "-": result = model.subtract(a, b); break;
				case "*": result = model.multiply(a, b); break;
				case "/": result = model.divide(a, b); break;
				default: throw new IllegalArgumentException("Unknown operator: " + operator);
			}
			view.showResult(result);
		}catch(ArithmeticException | IllegalArgumentException e){
			view.showError(e.getMessage());
		}
	}
}