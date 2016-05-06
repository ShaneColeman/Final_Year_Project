/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/******************************************************************
*Title: TestNeuralNetwork.java Concrete Class (User Created: Shane Coleman) utilising Neuroph Framework (MultiLayerPerceptron, testNeuralNetwork method) 
*Site Owner / Sponsor: TestNeuralNetwork.java Concrete Class (User Created: Shane Coleman) utilising Neuroph Framework (Neuroph)
*Date: 2016
*Author: Shane Coleman: TestNeuralNetwork.java Concrete Class
*Author: Neuroph Framework: Neuroph (testNeuralNetwork method, modified to testANN method)
*Availability: http://neuroph.sourceforge.net/download.html
*Availability: http://neuroph.sourceforge.net/javadoc/index.html
*Availability: http://neuroph.sourceforge.net/tutorials/MultiLayerPerceptron.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/core/learning/error/MeanSquaredError.html
*Date Accessed: February 2016
*Modified: User created TestNeuralNetwork concrete class using the Neuroph framework for testNeuralNetwork method (originally named), modified to testANN method. Code has been 
* modified through the use of variable names. For loop within testANN method alter to an Iterator.
* MeanSquaredError class added to testANN method from the Neuroph framework API.
******************************************************************/

package musicgenreneuralnetwork;

import java.util.Arrays;
import java.util.Iterator;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.learning.error.MeanSquaredError;

/**
 *
 * @author Windows
 */
public class TestNeuralNetwork 
{
    public void testANN(NeuralNetwork aNN, DataSet dataSet)
    {
        Iterator<DataSetRow> it = dataSet.getRows().iterator();
        double[] aNNOutput;
        DataSetRow dataRow;
        MeanSquaredError mSE = new MeanSquaredError();
        
        while(it.hasNext())
        {
            dataRow = it.next();
            aNN.setInput(dataRow.getInput());
            aNN.calculate();
            aNNOutput = aNN.getOutput();
            System.out.println("\nInput: " + Arrays.toString(dataRow.getInput()));
            System.out.println("Output: " + Arrays.toString(aNNOutput));
            System.out.println("Desired Output: " + Arrays.toString(dataRow.getDesiredOutput()));
            
            mSE.calculatePatternError(aNNOutput, dataRow.getDesiredOutput());
        }
        
        System.out.println("\nTotal Network Error: " + mSE.getTotalError());
    }
}
