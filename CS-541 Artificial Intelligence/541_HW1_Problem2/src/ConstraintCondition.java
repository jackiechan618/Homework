import java.util.*;

public class ConstraintCondition {
	private int position;
	private List<Variable> subConstraintList;

	ConstraintCondition() {
		position = 511;
		subConstraintList = new ArrayList<>(9);
	}

	public void initial(Variable s) {
		subConstraintList.add(s);
	}

	public void messageToVariable(int index) {
		for (int i = 0; i < subConstraintList.size(); i++) {
			if (!subConstraintList.get(i).finishFlag) {
				subConstraintList.get(i).updateValue(position);
				
				if (index >= 0 && index <= 2) {
					String result = parsePosition(position);
					System.out.println("message to factor [" + index + "]: " + result);
				}
			}
		}
	}

	public void updateValue(int value) {
		position = position - value;
	}
	
	public String parsePosition(int value) {
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < 9; i++) {
			int digit = (value & 1);
			builder.append(digit);
			value >>= 1;
		}
		
		return builder.toString();
	}
}
