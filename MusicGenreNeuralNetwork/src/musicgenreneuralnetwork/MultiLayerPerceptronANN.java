/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import org.neuroph.core.data.BufferedDataSet;
import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Windows
 */
public class MultiLayerPerceptronANN extends NeuralNetworkANN
{
    private MultiLayerPerceptron multiLayer;
    
    @Override
    public void multiLayerPerceptron(TransferFunctionType type, int inputs, int hidden, int outputs)
    {
        multiLayer = new MultiLayerPerceptron(type,inputs,hidden,outputs);
        
        System.out.println("\nMulti-Layer Perceptron ANN Created, Transfer Function Type: " + type + 
                " ,Inputs: " + inputs + ", Outputs: " + outputs);
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
    
    @Override
    public void learnDataSetWithBackP(DataSet dataSet, BackPropagation learningRule)
    {
        multiLayer.learn(dataSet, learningRule);
    }
    
    @Override
    public void learnDataSetWithMBackP(DataSet dataSet, MomentumBackpropagation learningRule)
    {
       multiLayer.learn(dataSet, learningRule); 
    }
    
    //Remove if unsuccessful
    public void learnDataSet(BufferedDataSet dataSet, MomentumBackpropagation learningRule)
    {
       multiLayer.learn(dataSet, learningRule); 
    }
    
    public MultiLayerPerceptron getMultiLayerPerceptron()
    {
        return multiLayer;
    }
}
