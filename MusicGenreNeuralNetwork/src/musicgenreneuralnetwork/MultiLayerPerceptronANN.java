/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Windows
 */
public class MultiLayerPerceptronANN extends NeuralNetworkANN
{
    MultiLayerPerceptron multiLayer;
    
    @Override
    public void multiLayerPerceptron(TransferFunctionType type, int inputs, int hidden, int outputs)
    {
        multiLayer = new MultiLayerPerceptron(type,inputs,hidden,outputs);
    }
    
    @Override
    public void saveNeuralNetwork(String name)
    {
        multiLayer.save(name);
    }
    
    @Override
    public void learnDataSet(DataSet dataSet)
    {
        multiLayer.learn(dataSet);
    }
}
