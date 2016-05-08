package calc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calc.model.CalcManager;
import calc.model.OperationType;
import calc.view.CalculatorTextView;

public class ControllerButtonOperation implements ActionListener {
	CalcManager calcManager = CalcManager.getInstance();
	CalculatorTextView calculatorTextView = CalculatorTextView.getInstance();

	OperationType type;
	
	public ControllerButtonOperation(OperationType type) {
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (calcManager.getOperationCount() == 0 || calcManager.isPostCalculation()) {
			calcManager.setOperationType(type);
			calcManager.setFistValue();
			calcManager.incrementCount();
			calculatorTextView.resetText();
			calculatorTextView.newValue();
		} else if (calcManager.getOperationCount() == 1) {
			calcManager.calculate(calcManager.getOperationType());
			calcManager.setOperationType(type);
			calculatorTextView.newValue();
		}
	}
}
