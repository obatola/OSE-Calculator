package calc.view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import calc.util.ColorManager;
import calc.util.ColorType;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

/**
 * JPanel that shows the calculator screen (numbers).
 * @author Obatola Seward-Evans
 *
 */
public class CalculatorTextView extends JPanel {
	ColorManager colorManager = ColorManager.getInstance();
	private static CalculatorTextView instance = new CalculatorTextView();
	JLabel lblText;
	boolean newVal;
	
	/**
	 * Create the panel.
	 */
	private CalculatorTextView() {
		setBackground(colorManager.getColor(ColorType.textVIEW));
		setBorder(getBorder());
		// Currently Does nothing.
		Dimension maximumSize = new Dimension(218, 55);
		setMaximumSize(maximumSize);
		setBounds(0, 0, 218, 55);
		
		lblText = new JLabel("");
		lblText.setForeground(colorManager.getColor(ColorType.textVIEWtext));

		lblText.setHorizontalAlignment(SwingConstants.RIGHT);
		lblText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblText, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblText, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
	
	public static CalculatorTextView getInstance() {
		return instance;
	}
	
	public String getText() {
		return lblText.getText();
	}
	
	public double getDouble() {
//		if (lblText.getText() == null || lblText.getText() == "") { return -0; }
//		return Double.parseDouble(lblText.getText());
		
		double d;
		
		try {
		     d = Double.parseDouble(lblText.getText());
		}
		catch (NullPointerException | NumberFormatException  e) {
			System.out.println("could not parse double");
		     d = -0;
		}
		
		return d;
	}
	
	public void resetText() {
		lblText.setText("");
	}
	
	public void addText(String s){
		if (newVal == true) {
			this.resetText();
		}
		
		String tempString = lblText.getText();
		tempString = tempString.concat(s);
		lblText.setText(tempString);
		
		newVal = false;
	}

	public void newValue() {
		newVal = true;
	}
	
	public void refresh(){
		this.revalidate();
		setBackground(colorManager.getColor(ColorType.textVIEW));
		lblText.setForeground(colorManager.getColor(ColorType.textVIEWtext));
	}
}
