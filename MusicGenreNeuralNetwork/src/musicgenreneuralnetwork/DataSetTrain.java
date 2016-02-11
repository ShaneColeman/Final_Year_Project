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
    
    //Proper - Do Not Delete
    public void trainingDataSet_8_4()
    {
        train = new DataSet(8,4);
        
        train.addRow(new DataSetRow(new double[]{0.160931174, 0.486666667, 0.2, 0, 0, 0.35, 0.363636364, 0}, 
                new double[]{0, 0, 1, 0}));
        
        train.addRow(new DataSetRow(new double[]{0.237854251, 0.733333333, 0.6, 0, 1, 0.025, 0.818181818, 0.428571429}, 
                new double[]{0, 0, 0, 1}));
        
        train.addRow(new DataSetRow(new double[]{0.208502024, 0.466666667, 0.3, 0, 1, 0.3, 1, 0}, 
                new double[]{0, 0, 1, 0}));
        
        train.addRow(new DataSetRow(new double[]{0.19534413, 0.6, 0.3, 0, 1, 0.3, 0.727272727, 0}, 
                new double[]{0, 0, 1, 0}));
        
    }
    
    public DataSet getDataSet()
    {
        return train;
    }
}
