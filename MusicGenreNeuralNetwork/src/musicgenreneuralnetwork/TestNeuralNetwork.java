/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import java.util.Arrays;
import java.util.Iterator;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

/**
 *
 * @author Windows
 */
public class TestNeuralNetwork 
{
    public void testNeuralNetwork(NeuralNetwork nnet, DataSet testDataSet)
    {
        Iterator<DataSetRow> it = testDataSet.getRows().iterator();
        double[] networkOutput;
        
        while(it.hasNext())
        {
            DataSetRow dataRow = it.next();
            nnet.setInput(dataRow.getInput());
            nnet.calculate();
            networkOutput = nnet.getOutput();
            System.out.println("\nInput: " + Arrays.toString(dataRow.getInput()));
            System.out.println("Output: " + Arrays.toString(networkOutput));
            System.out.println("Desired Output: " + Arrays.toString(dataRow.getDesiredOutput()));
        }
    }
}
