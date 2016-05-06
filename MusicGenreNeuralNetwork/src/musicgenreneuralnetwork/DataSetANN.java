/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/******************************************************************
*Title: DataSetANN.java Abstract Class (User Created: Shane Coleman) utilising Neuroph Framework (DataSet, DataSetRow)
*Site Owner / Sponsor: DataSetANN.java Abstract Class (User Created: Shane Coleman) utilising Neuroph Framework (Neuroph)
*Date: 2016
*Author: Shane Coleman: DataSetANN.java Abstract Class
*Author: Neuroph Framework: Neuroph
*Availability: http://neuroph.sourceforge.net/download.html
*Availability: http://neuroph.sourceforge.net/javadoc/index.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/core/data/DataSet.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/core/data/DataSetRow.html
*Date Accessed: February 2016
*Modified: User created DataSetANN abstract class using the Neuroph frame for addTrainingDataSetRow, 
* addTestingDataSetRow and addDataSetRow methods
******************************************************************/

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
    
    public DataSetANN(int inputs, int outputs)
    {
        this.inputs = inputs;
        this.outputs = outputs;
    }
    
    public void setNumberOfInputs(int inputs){this.inputs = inputs;}
    
    public void setNumberOfOutputs(int outputs){this.outputs = outputs;}
    
    public int getNumberOfInputs(){return inputs;}
    
    public int getNumberOfOutputs(){return outputs;}
    
    public void addTrainingDataSetRow(double[] inputs, double[] outputs){};
    
    public void addTestingDataSetRow(double[] inputs, double[] outputs){};
    
    public void addDataSetRow(DataSetRow dataSetRow){};     
}
