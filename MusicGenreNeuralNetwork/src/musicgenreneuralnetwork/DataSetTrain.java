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
public class DataSetTrain extends DataSetANN
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

    
    @Override
    public void addTrainingDataSetRows(double[] inputs, double[] outputs)
    {
        train.addRow(new DataSetRow(inputs,outputs));
    }
    
    @Override
    public void setNumberOfInputs(int inputs)
    {
        this.inputs = inputs;
    }
    
    @Override
    public void setNumberOfOutputs(int outputs)
    {
        this.outputs = outputs;
    }
    
    @Override
    public int getNumberOfInputs()
    {
        return inputs;
    }
    
    @Override
    public int getNumberOfOutputs()
    {
        return outputs;
    }
    
    @Override
    public DataSet getDataSet()
    {
        return train;
    }
}
