/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/******************************************************************
*Title: Neuroph Framework, DataSet, DataSetRow
*Site Owner / Sponsor: Neuroph
*Date: 2016
*Author: Neuroph
*Availability: http://neuroph.sourceforge.net/download.html
*Availability: http://neuroph.sourceforge.net/javadoc/index.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/core/data/DataSet.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/core/data/DataSetRow.html
*Availability: http://neuroph.sourceforge.net/tutorials/MultiLayerPerceptron.html
*Date Accessed: February 2016
*Modified: User created DataSetTest class using the Neuroph frame for addTestingDataSetRow, addDataSetRow,
* testingSetFromFile and getTestingColumnNames methods
******************************************************************/

package musicgenreneuralnetwork;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

/**
 *
 * @author Windows
 */
public class DataSetTest extends DataSetANN
{
    private DataSet test;
    
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
    
    public String[] getTestingColumnNames()
    {
        return test.getColumnNames();
    }
    
    public DataSet getTestingDataSet()
    {
        return test;
    }
}
