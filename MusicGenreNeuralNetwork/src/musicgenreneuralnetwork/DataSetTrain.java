/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.neuroph.core.data.BufferedDataSet;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

/**
 *
 * @author Windows
 */
public class DataSetTrain extends DataSetANN
{
    private DataSet train;
    //private int inputs;
    //private int outputs; 
    
    /*
    public DataSetTrain()
    {
        setNumberOfInputs(0);
        setNumberOfOutputs(0);
        
        train = new DataSet(getNumberOfInputs(),getNumberOfOutputs());
    }
    */
    
    public DataSetTrain(int inputs, int outputs)
    {
        super(inputs, outputs);
        
        //setNumberOfInputs(inputs);
        //setNumberOfOutputs(outputs);
        
        //train = new DataSet(getNumberOfInputs(),getNumberOfOutputs());
        
        train = new DataSet(inputs, outputs);
    }

    
    @Override
    public void addTrainingDataSetRows(double[] inputs, double[] outputs)
    {
        train.addRow(new DataSetRow(inputs,outputs));
    }
    
    
    @Override
    public void addDataSetRow(DataSetRow dataSetRow)
    {
        train.addRow(dataSetRow);
    }
    
    
    public static DataSet trainingSetFromFile(String fileName, int inputs, int outputs, String delimiter)
    {
        return DataSet.createFromFile(fileName, inputs, outputs, delimiter);
    }
    
    public void buffered(String fileName, int inputs, int outputs, String delimiter) throws FileNotFoundException
    {
        File file = new File(fileName);
            BufferedDataSet bDS = new BufferedDataSet(file,inputs,outputs,delimiter);

            for (DataSetRow dataRow : bDS.getRows()) 
            {
                train.addRow(dataRow);
                //bDS.addRow(dataRow);
            }
    }
    /*
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
    */

    public DataSet getTrainingDataSet()
    {
        return train;
    }
    
    public List<DataSetRow> getDataSetRows()
    {
        return train.getRows();
    }
}
