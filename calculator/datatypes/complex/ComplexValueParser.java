package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ComplexValueParser implements AbstractValueParser{

    public AbstractValue parse(String value) throws ParseValueException {
        try {
            System.out.println(value);
            ComplexValue compVal = new ComplexValue(getComplex(value));
            System.out.println("число = " + compVal.getReal() + compVal.getImag());
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
        double imag = 0;
        // ("(([-+]?\d+\.?\d*|[-+]?\d*\.?\d+)\s*\+\s*([-+]?\d+\.?\d*|[-+]?\d*\.?\d+)i)")
        // ("(((\\+|\\-)?)(\\d+(\\.\\d+)?))?((\\+|\\-)(\\d+(\\.\\d+)?)i)") было
        Pattern pattern = Pattern.compile("(((\\+|\\-)?)(\\d+(\\.\\d+)?))?((\\+|\\-)(\\d+(\\.\\d+)?)i)");
        Matcher matcher = pattern.matcher(value);
        real = Double.parseDouble(matcher.group(1));
        imag = Double.parseDouble(matcher.group(8));
        return new ComplexValue(real, imag);
    }

}
