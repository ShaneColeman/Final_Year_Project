/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/******************************************************************
*Title: DataSetTrain.java Concrete Class (User Created: Shane Coleman) utilising Neuroph Framework (DataSet, DataSetRow)
*Site Owner / Sponsor: DataSetTrain.java Concrete Class (User Created: Shane Coleman) utilising Neuroph Framework (Neuroph)
*Date: 2016
*Author: Shane Coleman: DataSetTest.java Concrete Class
*Author: Neuroph Framework: Neuroph
*Availability: http://neuroph.sourceforge.net/download.html
*Availability: http://neuroph.sourceforge.net/javadoc/index.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/core/data/DataSet.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/core/data/DataSetRow.html
*Availability: http://neuroph.sourceforge.net/tutorials/MultiLayerPerceptron.html
*Date Accessed: February 2016
*Modified: User created DataSetTrain concrete class using the Neuroph Framework API for user created methods for addTrainingDataSetRow, addDataSetRow,
* trainingSetFromFile and getTrainingColumnNames methods
******************************************************************/

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
    
    public DataSetTrain(int inputs, int outputs)
    {
        super(inputs, outputs);
        
        train = new DataSet(inputs, outputs);
    }

    @Override
    public void addTrainingDataSetRow(double[] inputs, double[] outputs)
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
    
    public String[] getTrainingColumnNames()
    {
        return train.getColumnNames();
    }
    
    public DataSet getTrainingDataSet()
    {
        return train;
    }
}
