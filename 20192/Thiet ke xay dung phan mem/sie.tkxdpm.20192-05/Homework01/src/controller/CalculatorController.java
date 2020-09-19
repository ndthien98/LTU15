package controller;

import model.CalculatorDAO;
import view.CalculatorFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
	CalculatorFrame view;
	CalculatorDAO model;

	public static void main(String[] args) {
		CalculatorController controller = new CalculatorController();
	}

	public CalculatorController() {
		view = new CalculatorFrame();
		model = CalculatorDAO.getInstance();
		view.setActionListenerBtnAdd(btnAddAL);
		view.setActionListenerBtnSub(btnSubAL);
		view.setActionListenerBtnMul(btnMulAL);
		view.setActionListenerBtnDiv(btnDivAL);
		view.setActionListenerBtnMod(btnModAL);
		view.setActionListenerBtnEqn(btnEqnAL);
	}

	ActionListener btnAddAL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			view.setOperator('+');
		}
	};
	ActionListener btnSubAL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			view.setOperator('-');
		}
	};
	ActionListener btnMulAL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			view.setOperator('*');
		}
	};
	ActionListener btnDivAL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			view.setOperator('/');
		}
	};
	ActionListener btnModAL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			view.setOperator('%');
		}
	};
	ActionListener btnEqnAL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			view.setResult(model.calculate(view.getFirstText(), view.getSecondText(), view.getOperator()));
		}
	};
}
