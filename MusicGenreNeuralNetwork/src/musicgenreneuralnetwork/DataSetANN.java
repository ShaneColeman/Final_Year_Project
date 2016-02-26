/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import org.neuroph.core.data.DataSetRow;

/**
 *
 * @author Windows
 */
public abstract class DataSetANN 
{
    private int inputs;
    private int outputs;
    //private DataSet dataSet;
    
    public DataSetANN(int inputs, int outputs)
    {
        this.inputs = inputs;
        this.outputs = outputs;

        //setNumberOfInputs(inputs);
        //setNumberOfOutputs(outputs);
        
        //dataSet = new DataSet(getNumberOfInputs(), getNumberOfOutputs());
    }
    
    public void setNumberOfInputs(int inputs){this.inputs = inputs;}
    
    public void setNumberOfOutputs(int outputs){this.outputs = outputs;}
    
    public int getNumberOfInputs(){return inputs;}
    
    public int getNumberOfOutputs(){return outputs;}
    
    public void addTrainingDataSetRow(double[] inputs, double[] outputs){};
    
    public void addTestingDataSetRow(double[] inputs, double[] outputs){};
    
    public void addDataSetRow(DataSetRow dataSetRow){};
    
    //public DataSet getDataSet(){return dataSet;}
     
}
