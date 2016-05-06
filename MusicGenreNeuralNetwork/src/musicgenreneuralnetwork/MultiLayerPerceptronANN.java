/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/******************************************************************
*Title: MultiLayerPerceptonANN.java Concrete Class (User Created: Shane Coleman) utilising Neuroph Framework (NeuralNetork, MultiLayerPerceptron)
*Site Owner / Sponsor: MultiLayerPerceptonANN.java Concrete Class (User Created: Shane Coleman) utilising Neuroph Framework (Neuroph)
*Date: 2016
*Author: Shane Coleman: NeuralNetwork.java Concrete Class
*Author: Neuroph Framework: Neuroph
*Availability: http://neuroph.sourceforge.net/download.html
*Availability: http://neuroph.sourceforge.net/javadoc/index.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/core/NeuralNetwork.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/nnet/MultiLayerPerceptron.html
*Availability: http://neuroph.sourceforge.net/tutorials/MultiLayerPerceptron.html
*Date Accessed: January, February 2016
*Modified: User created MultiLayerPerceptonANN concrete class using the Neuroph frame for multiLayerPerceptron, saveNeuralNetwork,
* learnDataSet, learnDataSetWithBackP and learnDataSetWithMBackP concrete methods
******************************************************************/

package musicgenreneuralnetwork;

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
                " ,Inputs: " + inputs + " ,Hidden: " + hidden + ", Outputs: " + outputs);
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

    public MultiLayerPerceptron getMultiLayerPerceptron()
    {
        return multiLayer;
    }
}
