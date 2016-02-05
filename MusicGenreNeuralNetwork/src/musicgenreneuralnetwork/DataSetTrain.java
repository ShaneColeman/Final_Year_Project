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
    DataSet train;
    
    public void trainingDataSet_8_4()
    {
        train = new DataSet(8,4);
        
        train.addRow(new DataSetRow(new double[]{0.160931174, 0.486666667, 0.2, 0, 0, 0.35, 0.363636364, 0}, 
                new double[]{0, 0, 1, 0}));
    }
    
    public DataSet getDataSet()
    {
        return train;
    }
}
