/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

/**
 *
 * @author Windows
 */
public abstract class DataSetANN 
{
    public void addTrainingDataSetRows(double[] inputs, double[] outputs){};
    
    public void addTestingDataSetRows(double[] inputs, double[] outputs){};
    
    
}