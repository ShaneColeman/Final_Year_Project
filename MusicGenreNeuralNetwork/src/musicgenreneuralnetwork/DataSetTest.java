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
    
    public DataSetTest()
    {
        setInputs(0);
        setOutputs(0);
        
        test = new DataSet(getInputs(),getOutputs());
    }
    
    public DataSetTest(int inputs, int outputs)
    {
        setInputs(inputs);
        setOutputs(outputs);
        
        test = new DataSet(getInputs(),getOutputs());
    }
    
    public void addTestingDataSetRows(double[] inputs, double[] outputs)
    {
        test.addRow(new DataSetRow(inputs,outputs));
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
