package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class BMICalculatorController {

    @FXML
    private Button btnCalculate;

    @FXML
    private TextField weightInput;

    @FXML
    private TextField heightInput;

    @FXML
    private TextField bmiOutput;

    @FXML
    private TextField statusOutput;

    @FXML
    private Text close;

    @FXML
    void calculate(ActionEvent event) {
    	
    	try {
    		
    		Double weightValue = Double.parseDouble(weightInput.getText());
    		Double heightValue = Double.parseDouble(heightInput.getText());
    		Double bmiValue = weightValue/((heightValue/100) * (heightValue/100));
    		
    		heightInput.clear();
    		weightInput.clear();
    		
    		setResult(bmiValue);
    		
    	}catch(Exception e) {
    		
    	}

    }
    
    
    void setResult(Double bmiValue) {
    	
    	bmiOutput.setText(bmiValue.toString());
    	
    	if(bmiValue <= 18.5) {
    		    		
    		statusOutput.setText("Underweight");
    		
    	}else if(18.6 <= bmiValue && bmiValue <= 24.9) {
    		
    		statusOutput.setText("Normal weight");
    		
    	}else if(25 <= bmiValue && bmiValue <= 29.9) {
    		
    		statusOutput.setText("Overweight");
    		
    	}else {
    		
    		statusOutput.setText("Obesity");
    	}
    	
    	
    }

    @FXML
    void close(MouseEvent event) {
    	
    	System.exit(0);

    }

}
