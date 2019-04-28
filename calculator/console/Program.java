package calculator.console;

import java.util.Scanner;

import calculator.AbstractValueParser;
import calculator.Calculator;
import calculator.datatypes.complex.ComplexValueParser;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.real.RealValueParser;


public class Program {

	private final Scanner scanner;

	private final Calculator calc;

	private AbstractValueParser[] valueParsers;

	public Program() {
		scanner = new Scanner(System.in);
		valueParsers = new AbstractValueParser[] { new IntegerValueParser(),
				new RealValueParser(), new ComplexValueParser()};
		AbstractValueParser parser = inputValueParser();
		System.out.println("Работаем с типом '" + parser.getDataTypeName()
				+ "'");
		calc = new Calculator(parser);
	}

	private AbstractValueParser inputValueParser() {
		showChoices();
		int choice = scanner.nextInt();
		if (choice >= 1 && choice <= valueParsers.length)
			return valueParsers[choice - 1];
		else {
			System.out.println("Неверный выбор!");
			return inputValueParser();
		}
	}

	private void showChoices() {
		System.out.println("Вам нужно выбрать тип данных. Возможные варианты:");
		for (int i = 0; i < valueParsers.length; i++)
			System.out.println("  " + (i + 1) + ". "
					+ valueParsers[i].getDataTypeName());
	}

	public static void main(String args[]) {
		try {
			Program instance = new Program();
			instance.run(args);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void run(String[] args) {
		while (true) {
			String arg1 = scanner.next();
			if (arg1.equals("exit"))
				break;
			String op = scanner.next();
			String arg2 = scanner.next();
			try {
				System.out.println(" = " + calc.calculate(arg1, op, arg2));

			} catch (Exception exception) {
				System.out.println(exception.getLocalizedMessage());
			}
		}
	}

}
