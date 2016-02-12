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
public class DataSetTrain 
{
    private DataSet train;
    private int inputs;
    private int outputs; 
    
    public DataSetTrain()
    {
        setInputs(0);
        setOutputs(0);
        
        train = new DataSet(getInputs(),getOutputs());
    }
    
    public DataSetTrain(int inputs, int outputs)
    {
        setInputs(inputs);
        setOutputs(outputs);
        
        train = new DataSet(getInputs(),getOutputs());
    }

    
    public void addTrainingDataSetRows(double[] inputs, double[] outputs)
    {
        train.addRow(new DataSetRow(inputs,outputs));
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
        return train;
    }
}
