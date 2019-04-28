package calculator.datatypes.complex;

import calculator.AbstractValueParser;
import calculator.ParseValueException;
import org.junit.Assert;

import static org.junit.Assert.*;

public class ComplexValueParserTest {

    @org.junit.Test
    public void parse() throws ParseValueException {
        AbstractValueParser complex_parser = new ComplexValueParser();
        Assert.assertEquals(
                new ComplexValue(1, 1),
                complex_parser.parse("1+1i")
        );
        Assert.assertEquals(
                new ComplexValue(-1.5345, 7.999565),
                complex_parser.parse("-1.5345+7.999565i")
        );
        Assert.assertEquals(
                new ComplexValue(-0.989030000, +235.8324798),
                complex_parser.parse("-.989030000+235.8324798i")
        );
        Assert.assertEquals(
                new ComplexValue(0, 5),
                complex_parser.parse("0+5i")
        );
    }

    @org.junit.Test
    public void getDataTypeName() {
    }
}