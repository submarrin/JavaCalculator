package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.datatypes.real.RealValue;

import java.awt.image.DataBufferUShort;

public class ComplexValue implements AbstractValue {
    private final double realVal;
    private final double imagVal;

    public ComplexValue(double realVal, double imagVal) {
        super();
        this.realVal = realVal;
        this.imagVal = imagVal;
    }

    public double getReal(){
        return realVal;
    }

    public double getImag() {
        return imagVal;
    }

    public ComplexValue(ComplexValue z) {
        super();
        this.realVal = z.realVal;
        this.imagVal = z.imagVal;
    }

    public double absVal() {
        return this.realVal * this.realVal + this.imagVal * this.imagVal;
    }

    public String toString() {
        return Double.toString(realVal) + " + " +  Double.toString(imagVal) + "i";
    }

    public AbstractValue add(AbstractValue operand) {
        return new ComplexValue(realVal + ((ComplexValue) operand).realVal,
                imagVal + ((ComplexValue) operand).imagVal);
    }

    public AbstractValue sub(AbstractValue operand) {
        return new ComplexValue(realVal - ((ComplexValue) operand).realVal,
                imagVal - ((ComplexValue) operand).imagVal);
    }

    public AbstractValue mul(AbstractValue operand) {
        return new ComplexValue(realVal * ((ComplexValue) operand).realVal - imagVal * ((ComplexValue) operand).imagVal,
                realVal * ((ComplexValue) operand).imagVal + imagVal * ((ComplexValue) operand).realVal);
    }

    public AbstractValue div(AbstractValue operand)
            throws DivisionByZeroException {
        double opReal = ((ComplexValue)operand).realVal;
        double opImag = ((ComplexValue)operand).imagVal;
        ComplexValue value = new ComplexValue(opReal, opImag);

        if (opReal == 0 && opImag == 0)
            throw new DivisionByZeroException();
        return new ComplexValue(((ComplexValue) this.mul(value)).getReal() / value.absVal(),
                ((ComplexValue) this.mul(value)).getImag() / value.absVal());
    }

}
