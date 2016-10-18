public class Variable {
	ConstraintCondition blockConstrain, rowConstrain, colConstrain;
	boolean finishFlag = false;
	int blockId, rowId, colId;
	int x, y;
	int value;

	public Variable(ConstraintCondition blockConstrain, ConstraintCondition rowConstrain, ConstraintCondition colConstrain, int value, int x, int y) {
		this.blockConstrain = blockConstrain;
		this.rowConstrain = rowConstrain;
		this.colConstrain = colConstrain;
		this.value = value;
		this.x = x;
		this.y = y;
	}

	public void variableToMesssage() {
		if (!finishFlag && (int) (value & (value - 1)) == 0) {
			blockConstrain.updateValue(value);
			rowConstrain.updateValue(value);
			colConstrain.updateValue(value);
			finishFlag = true;
		}
	}

	public void updateValue(int message) {
		value = (int) (message & value);
	}
}
