package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;


public class ComplexValueParser implements AbstractValueParser{

    public AbstractValue parse(String value) throws ParseValueException {
        try {
            ComplexValue compVal = new ComplexValue(getComplex(value));
            return compVal;
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }

    public String getDataTypeName() {
        return "Комплексные числа";
    }

    private ComplexValue getComplex(String value){
        double real = 0;
        double img = 0;
        // ("(([-+]?\d+\.?\d*|[-+]?\d*\.?\d+)\s*\+\s*([-+]?\d+\.?\d*|[-+]?\d*\.?\d+)i)")
        // ("(((\\+|\\-)?)(\\d+(\\.\\d+)?))?((\\+|\\-)(\\d+(\\.\\d+)?)i)") было
        String[] result = value.split("(?=[\\+|\\-|i])");
        real = Double.parseDouble(result[0]);
        img = Double.parseDouble(result[1]);
        return new ComplexValue(real, img);
    }

}
