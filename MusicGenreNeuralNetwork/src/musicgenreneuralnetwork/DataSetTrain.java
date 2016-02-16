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
        setNumberOfInputs(0);
        setNumberOfOutputs(0);
        
        train = new DataSet(getNumberOfInputs(),getNumberOfOutputs());
    }
    
    public DataSetTrain(int inputs, int outputs)
    {
        setNumberOfInputs(inputs);
        setNumberOfOutputs(outputs);
        
        train = new DataSet(getNumberOfInputs(),getNumberOfOutputs());
    }

    
    public void addTrainingDataSetRows(double[] inputs, double[] outputs)
    {
        train.addRow(new DataSetRow(inputs,outputs));
    }
    
    public void setNumberOfInputs(int inputs)
    {
        this.inputs = inputs;
    }
    
    public void setNumberOfOutputs(int outputs)
    {
        this.outputs = outputs;
    }
    
    public int getNumberOfInputs()
    {
        return inputs;
    }
    
    public int getNumberOfOutputs()
    {
        return outputs;
    }
    
    public DataSet getDataSet()
    {
        return train;
    }
}
