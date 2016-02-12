/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

/**
 *
 * @author Windows
 */
public class DataSetTest 
{
    private DataSet test;
    private int inputs;
    private int outputs;
    
    public void testingDataSet_8_4()
    {
        test = new DataSet(8,4);
        
        test.addRow(new DataSetRow(new double[]{0.301619433, 0.533333333, 0.1, 1, 0, 0.825, 0.272727273, 0}, 
                new double[]{0, 1, 0, 0}));
        
        test.addRow(new DataSetRow(new double[]{0.303643725, 0.7, 0.4, 0, 0, 0.125, 0.181818182, 0.714285714}, 
                new double[]{0, 0, 0, 1}));
        
        test.addRow(new DataSetRow(new double[]{0.214574899, 0.8, 0.7, 0, 0, 0.125, 0.727272727,0.571428571}, 
                new double[]{0, 0, 0, 1}));
        
        test.addRow(new DataSetRow(new double[]{0.237854251, 0.866666667, 0.9, 0, 0, 0.05, 0.818181818, 0.857142857}, 
                new double[]{1,	0, 0, 0}));
    }
    
    public void setInputs(int inputs)
    {
        this.inputs = inputs;
    }
    
    public void setOutputs(int outputs)
    {
        this.outputs = outputs;
    }
    
    public int getInputs()
    {
        return inputs;
    }
    
    public int getOutputs()
    {
        return outputs;
    }
    
    public DataSet getDataSet()
    {
        return test;
    }
}
