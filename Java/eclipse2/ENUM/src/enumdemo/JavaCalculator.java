package enumdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class JavaCalculator extends JFrame {

    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    private JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
    private JButton buttonSquare, buttonSquareRoot;
    private JButton buttonSolve;
    private JButton buttonClear;
    private JButton buttonBackspace;
    private JButton buttonDecimalPoint;
    private JButton buttonNegative;
    
    private JTextField secondaryTextField;
    private JTextField primaryTextField;
    private JTextField primaryLabelTextField;
    private JPanel mainPanel, textPanel;
    
    private double firstValue;
    private double secondValue;
    private Operator currentOperator;
    
    private State state;

    enum Operator {
        None,
        Add,
        Subtract,
        Multiply,
        Divide
    }
    
    enum State {
    	FirstValue,
    	Operator,
    	SecondValue,
    	OperationDone
    }

    public JavaCalculator() {
    	     
    	currentOperator = Operator.None;
    	state = State.FirstValue;
    	
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 4));
        
        //row 1
        mainPanel.add(buttonSquare = new JButton("x²"));
        // if SquareRoot throws syntax error use unicode "\u221A" instead.
        mainPanel.add(buttonSquareRoot = new JButton("√"));
        mainPanel.add(buttonClear = new JButton("C"));
        mainPanel.add(buttonDivide = new JButton("÷"));
        
        //row 2
        mainPanel.add(button7 = new JButton("7"));
        mainPanel.add(button8 = new JButton("8"));
        mainPanel.add(button9 = new JButton("9"));
        mainPanel.add(buttonMultiply = new JButton("X"));
        
        //row 3    
        mainPanel.add(button4 = new JButton("4"));
        mainPanel.add(button5 = new JButton("5"));
        mainPanel.add(button6 = new JButton("6"));
        mainPanel.add(buttonSubtract = new JButton("-"));
        
        //row 4
        mainPanel.add(button1 = new JButton("1"));
        mainPanel.add(button2 = new JButton("2"));
        mainPanel.add(button3 = new JButton("3"));
        mainPanel.add(buttonAdd = new JButton("+"));
        
        //row 5
        mainPanel.add(button0 = new JButton("0"));
        mainPanel.add(buttonDecimalPoint = new JButton("."));
        mainPanel.add(buttonBackspace = new JButton("<-"));        
        mainPanel.add(buttonSolve = new JButton("="));   
        
        //row 6
        mainPanel.add(buttonNegative = new JButton("±"));
        
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.add(primaryTextField = new JTextField(20), BorderLayout.SOUTH);
        primaryTextField.setHorizontalAlignment(JTextField.RIGHT);
        primaryTextField.setEditable(false);
        primaryTextField.setText("0");
        
 
        textPanel.add(secondaryTextField = new JTextField(20), BorderLayout.CENTER);
        secondaryTextField.setHorizontalAlignment(JTextField.RIGHT);
        secondaryTextField.setEditable(false);
        
    
        textPanel.add(primaryLabelTextField = new JTextField(20), BorderLayout.NORTH);
		primaryLabelTextField.setText("By: Logan, James, Johnathon, and Coleton");
		primaryLabelTextField.setEditable(false);
        
        add(textPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.SOUTH);

		setDimensions(300, 282);
		setResizable(false);
		setTitle("Slip-Codex Calculator");
		
		primaryTextField.setFont(new Font("Times New Roman", Font.BOLD, 25));
		secondaryTextField.setFont(new Font("Times New Roman", Font.BOLD, 25));
		primaryLabelTextField.setFont(new Font("Comic Sans", Font.ITALIC, 14));
		
        button1.addActionListener(new ListenToNumber(1));
        button2.addActionListener(new ListenToNumber(2));
        button3.addActionListener(new ListenToNumber(3));
        button4.addActionListener(new ListenToNumber(4));
        button5.addActionListener(new ListenToNumber(5));
        button6.addActionListener(new ListenToNumber(6));
        button7.addActionListener(new ListenToNumber(7));
        button8.addActionListener(new ListenToNumber(8));
        button9.addActionListener(new ListenToNumber(9));
        button0.addActionListener(new ListenToNumber(0));

        buttonAdd.addActionListener(new ListenToOperator(Operator.Add));
        buttonSubtract.addActionListener(new ListenToOperator(Operator.Subtract));
        buttonMultiply.addActionListener(new ListenToOperator(Operator.Multiply));
        buttonDivide.addActionListener(new ListenToOperator(Operator.Divide));
        
        buttonSolve.addActionListener(new ListenToSolve());
        buttonClear.addActionListener(new ListenToClear());
        buttonNegative.addActionListener(new ListenToNegative());
        buttonDecimalPoint.addActionListener(new ListenToDecimal());
        buttonBackspace.addActionListener(new ListenToBackSpace());
        buttonSquare.addActionListener(new ListenToSquareAndRoot(true));
        buttonSquareRoot.addActionListener(new ListenToSquareAndRoot(false));
    } //JavaCaluclator()

    private void setDimensions(int x, int y) {
    	setPreferredSize(new Dimension(x, y));
	}
    
    private static String simplifyValue(double value) {
    	long rounded = Math.round(value);
    	if (value - rounded == 0)
    		return String.valueOf(rounded);
    	return String.valueOf(value);
    }
    
    private double solve() {
    	switch (currentOperator) {
			case Add:
				return firstValue + secondValue;
			case Divide:
				return firstValue / secondValue;
			case Multiply:
				return firstValue * secondValue;
			case Subtract:
				return firstValue - secondValue;       	
    	}
    	return 0;
    }
    
    private char operatorSymbol(Operator operator) {
    	switch (operator) {
			case Add:
				return '+';
			case Divide:
				return '÷';
			case Multiply:
				return 'x';			
			case Subtract:
				return '-';				
    	}
    	return '?';
    }
    
    private void clear() {
    	primaryTextField.setText("0");
        secondaryTextField.setText("");
        currentOperator = Operator.None;
        state = State.FirstValue;

        firstValue = 0;
        secondValue = 0;
    }

	class ListenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clear();
        }
    }

    class ListenToNumber implements ActionListener {
        private String number;

        public ListenToNumber(int number) {
            if (number < 0 || number > 9)
                throw new AssertionError();
            this.number = Integer.toString(number);
        }

        public void actionPerformed(ActionEvent e) {
        	
        	String value;
        	
        	switch (state) {
				case OperationDone:				
					clear();
				case FirstValue:
					value = primaryTextField.getText();
					value += number;
					firstValue = Double.valueOf(value);
					primaryTextField.setText(simplifyValue(firstValue));
					break;
				case Operator:
					state = State.SecondValue;
					primaryTextField.setText("");
					//no break. edit second value.
				case SecondValue:
					value = primaryTextField.getText();
					value += number;
					secondValue = Double.valueOf(value);
					primaryTextField.setText(simplifyValue(secondValue));
					break;
        	}
        }
    }

    class ListenToOperator implements ActionListener {
        private Operator operator;

        public ListenToOperator(Operator operator) {
            this.operator = operator;
        }

        public void actionPerformed(ActionEvent e) {

        	switch (state) {
        		case SecondValue:
        			firstValue = solve();
        			//no break. edit operator
        		case OperationDone:
				case FirstValue:
					state = State.Operator;
					//no break. edit operator
				case Operator:
					currentOperator = operator;
					String text = simplifyValue(firstValue) + " ";
					text += operatorSymbol(operator);
					secondaryTextField.setText(text);
					primaryTextField.setText("");
					break;				  	
        	}
        	
        }
    }
    //====================== add new code in this section start here=====================
    
    	// complete this segment of code to understand a little better how this calc was built.
    	//WHEN COMPLETE THE CALC SHOULD RUN WITHOUT ANY ERRORS. GOOD LUCK!
    
    class ListenToSolve implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        	//switch on the field state (type is the enum State)
            switch (state) {
                case FirstValue:
                    //does nothing
                    break;
                case Operator:
                    //does nothing                    
                    break;
                case SecondValue: //The state after the second value has been entered
                    // when = is hit after second value has been entered into primaryTextField solve using
                    // solve method solve() which accepts no parameters and set the answer equal to firstValue
                    //(solve() returns a double and firstValue is a double)
                      firstValue = solve();          
                    // set state to operationDone so that code will fall through to next case when                     
                            state = State.OperationDone;    
                    // set primaryTextField to firstValue using simplify value method.              
                                primaryTextField.setText(simplifyValue(firstValue));
                    //create a local variable String called text and give it a string ""
                                String text = "";
                    //add operatorSymbol(currentOperator) to text
                                text += " " + operatorSymbol(currentOperator);
                    //add " " (space) and a simplifyValue()'d' secondValue to text
                                text += " " + simplifyValue(secondValue); 
                    //set secondaryTextField to the String text 
                            secondaryTextField.setText(text);
                    //break after finished
                            break;
                case OperationDone: //The state after equals has been hit
                    //when equals is hit again after second value was entered and = had been pressed,
                    //the state is operationDone and the code starts here.
                    //solve using the solve method solve() and store it in firstValue

                    //set the primaryTextField text using simplifyValue() on firstValue

                    //break after done
                
            }
					    	
        }
    }      
    
   //======================= end new code stop here====================================
    
    class ListenToNegative implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		switch (state) {
	    		case OperationDone:
					secondValue = 0;
					state = State.FirstValue;
					secondaryTextField.setText("");
				case FirstValue:
					firstValue = -firstValue;
					primaryTextField.setText(simplifyValue(firstValue));
					break;
				case Operator:
					break;
				case SecondValue:
					secondValue = -secondValue;
					primaryTextField.setText(simplifyValue(secondValue));
					break;				
    		}
    	}
    }
    
    class ListenToDecimal implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
        	switch (state) {
	        	case OperationDone:					
					clear();
					applyDecimal();
					break;
				case Operator:
					state = State.SecondValue;
					primaryTextField.setText("");
					//no break. edit primary text
				case FirstValue:
				case SecondValue:
					applyDecimal();
					break;				
        	}
    	}
    	
    	void applyDecimal() {    		
    		String value = primaryTextField.getText();
			if (value.contains("."))
				return;
			value += ".";
			primaryTextField.setText(value);
    	}
    }
    
    class ListenToBackSpace implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		if (state == State.Operator || state == State.OperationDone)
    			return;
    		
    		String value = primaryTextField.getText();
    		
    		if (value.length() == 0)
    			return;
    		
    		value = value.substring(0, value.length() - 1);
    		primaryTextField.setText(value);
    		
    		if (value.length() == 0)
    			value = "0";
    		
    		if (state == State.FirstValue)
    			firstValue = Double.valueOf(value);
    		else
    			secondValue = Double.valueOf(value);    		
    	}
    }
    
    class ListenToSquareAndRoot implements ActionListener {
    	private boolean squareNotRoot;
    	
    	public ListenToSquareAndRoot(boolean squareNotRoot) {
    		this.squareNotRoot = squareNotRoot;
    	}
    	
    	public void actionPerformed(ActionEvent e) {
    		switch (state) {
	    		case SecondValue:
					firstValue = solve();
	    		case OperationDone:
    			case Operator:
    				currentOperator = Operator.None;
    				state = State.FirstValue;
    				secondaryTextField.setText("");
				case FirstValue:
					if (squareNotRoot)
						firstValue = firstValue * firstValue;
					else
						firstValue = Math.sqrt(firstValue);
					primaryTextField.setText(simplifyValue(firstValue));
					break;
    		}
    	}
    }
}