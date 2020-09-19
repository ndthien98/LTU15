package view;

import controller.CalculatorController;
import java.awt.event.ActionListener;

public class CalculatorFrame extends javax.swing.JFrame {

	char operator;

	public CalculatorFrame() {
		initComponents();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initComponents() {

		labelOperator = new javax.swing.JLabel();
		labelFirstnumber = new javax.swing.JLabel();
		jtfInput1 = new javax.swing.JTextField();
		jtfInput2 = new javax.swing.JTextField();
		labelSecondNumber = new javax.swing.JLabel();
		labelResult = new javax.swing.JLabel();
		btnAdd = new javax.swing.JButton();
		btnMul = new javax.swing.JButton();
		btnSub = new javax.swing.JButton();
		btnDiv = new javax.swing.JButton();
		btnMod = new javax.swing.JButton();
		btnEqn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		labelOperator.setText("Result: ");

		labelFirstnumber.setText("First Number");

		jtfInput1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		jtfInput1.setText("0");

		jtfInput2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		jtfInput2.setText("0");

		labelSecondNumber.setText("Second Number");

		labelResult.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		labelResult.setText("0");

		btnAdd.setText("+");

		btnMul.setText("*");

		btnSub.setText("-");

		btnDiv.setText("/");

		btnMod.setText("%");

		btnEqn.setText("=");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(labelOperator)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(labelResult, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92,
												Short.MAX_VALUE)
										.addComponent(btnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnEqn, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
										.createSequentialGroup()
										.addComponent(btnMul, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(
												btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(labelSecondNumber, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(labelFirstnumber, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jtfInput1).addComponent(jtfInput2))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(labelFirstnumber).addComponent(jtfInput1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jtfInput2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(labelSecondNumber))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(labelOperator).addComponent(labelResult))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnSub)
						.addComponent(btnAdd))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnDiv)
						.addComponent(btnMul))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnMod)
						.addComponent(btnEqn))
				.addContainerGap(37, Short.MAX_VALUE)));

		pack();

	}

	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnDiv;
	private javax.swing.JButton btnEqn;
	private javax.swing.JButton btnMod;
	private javax.swing.JButton btnMul;
	private javax.swing.JButton btnSub;
	private javax.swing.JTextField jtfInput1;
	private javax.swing.JTextField jtfInput2;
	private javax.swing.JLabel labelFirstnumber;
	private javax.swing.JLabel labelOperator;
	private javax.swing.JLabel labelResult;
	private javax.swing.JLabel labelSecondNumber;

	public void setActionListenerBtnAdd(ActionListener aThis) {
		this.btnAdd.addActionListener(aThis);
	}

	public void setActionListenerBtnSub(ActionListener aThis) {
		this.btnSub.addActionListener(aThis);
	}

	public void setActionListenerBtnMul(ActionListener aThis) {
		this.btnMul.addActionListener(aThis);
	}

	public void setActionListenerBtnDiv(ActionListener aThis) {
		this.btnDiv.addActionListener(aThis);
	}

	public void setActionListenerBtnMod(ActionListener aThis) {
		this.btnMod.addActionListener(aThis);
	}

	public void setActionListenerBtnEqn(ActionListener aThis) {
		this.btnEqn.addActionListener(aThis);
	}

	public String getFirstText() {
		return jtfInput1.getText();
	}

	public String getSecondText() {
		return jtfInput2.getText();
	}

	public void setResult(Integer s) {
		this.labelResult.setText(s.toString());
	}

	public void setOperator(char c) {
		operator = c;
		this.labelOperator.setText("Result: " + c);
	}

	public char getOperator() {
		return operator;
	}
}