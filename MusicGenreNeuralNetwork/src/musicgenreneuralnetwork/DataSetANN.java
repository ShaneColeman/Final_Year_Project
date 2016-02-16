/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import org.neuroph.core.data.DataSet;

/**
 *
 * @author Windows
 */
public abstract class DataSetANN 
{
    private int inputs;
    private int outputs;
    private DataSet dataSet;
    
    public void addTrainingDataSetRows(double[] inputs, double[] outputs){};
    
    public void addTestingDataSetRows(double[] inputs, double[] outputs){};
    
    public void setNumberOfInputs(int inputs){this.inputs = inputs;}
    
    public void setNumberOfOutputs(int outputs){this.outputs = outputs;}
    
    public int getNumberOfInputs(){return inputs;}
    
    public int getNumberOfOutputs(){return outputs;}
    
    public DataSet getDataSet(){return dataSet;}
     
}
