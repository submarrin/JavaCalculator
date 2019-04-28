package calculator;

public interface AbstractValue {
	AbstractValue add(AbstractValue operand)
			throws OperationNotSupportedException;

	AbstractValue sub(AbstractValue operand)
			throws OperationNotSupportedException;

	AbstractValue mul(AbstractValue operand)
			throws OperationNotSupportedException;

	AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException, OperationNotSupportedException;

	String toString();
}
