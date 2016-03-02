/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import java.io.File;
import java.io.FileNotFoundException;
import org.neuroph.core.data.BufferedDataSet;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

/**
 *
 * @author Windows
 */
public class DataSetTest extends DataSetANN
{
    private DataSet test;
    //private int inputs;
    //private int outputs;
    
    public DataSetTest(int inputs, int outputs)
    {
        super(inputs, outputs);
        
        test = new DataSet(inputs,outputs);
    }
    
    @Override
    public void addTestingDataSetRow(double[] inputs, double[] outputs)
    {
        test.addRow(new DataSetRow(inputs,outputs));
    }
    
    @Override
    public void addDataSetRow(DataSetRow dataSetRow)
    {
        test.addRow(dataSetRow);
    }
    
    public static DataSet testingSetFromFile(String fileName, int inputs, int outputs, String delimiter)
    {
        return DataSet.createFromFile(fileName, inputs, outputs, delimiter);
    }
    
    public void getTestingBDS(String fileName, int inputs, int outputs, String delimiter) throws FileNotFoundException
    {
        File file = new File(fileName);
            
        BufferedDataSet bDS = new BufferedDataSet(file,inputs,outputs,delimiter);

        for (DataSetRow dataRow : bDS.getRows()) 
        {
            test.addRow(dataRow);
            //bDS.addRow(dataRow);
        }
    }
    
    public String[] getTestingColumnNames()
    {
        return test.getColumnNames();
    }
    
    public DataSet getTestingDataSet()
    {
        return test;
    }
    
    //Unused Code
    /*
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
    */
}
