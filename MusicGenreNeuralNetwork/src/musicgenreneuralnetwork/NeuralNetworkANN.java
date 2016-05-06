/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/******************************************************************
*Title: NeuralNetwork.java Abstract Class (User Created: Shane Coleman) utilising Neuroph Framework (NeuralNetork, MultiLayerPerceptron)
*Site Owner / Sponsor: NeuralNetwork.java Abstract Class (User Created: Shane Coleman) utilising Neuroph Framework (Neuroph)
*Date: 2016
*Author: Shane Coleman: NeuralNetwork.java Abstract Class
*Author: Neuroph Framework: Neuroph
*Availability: http://neuroph.sourceforge.net/download.html
*Availability: http://neuroph.sourceforge.net/javadoc/index.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/core/NeuralNetwork.html
*Availability: http://neuroph.sourceforge.net/javadoc/org/neuroph/nnet/MultiLayerPerceptron.html
*Availability: http://neuroph.sourceforge.net/tutorials/MultiLayerPerceptron.html
*Date Accessed: January, February 2016
*Modified: User created NeuralNetworkANN abstract class using the Neuroph frame for multiLayerPerceptron, saveNeuralNetwork,
* learnDataSet, learnDataSetWithBackP and learnDataSetWithMBackP abstract methods
******************************************************************/

package musicgenreneuralnetwork;

import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Windows
 */
public abstract class NeuralNetworkANN 
{
    public void multiLayerPerceptron(TransferFunctionType type, int inputs, int hidden, int outputs){};
    
    public void saveNeuralNetwork(String name){};
    
    
    public void learnDataSet(DataSet dataSet){};
    
    public void learnDataSetWithBackP(DataSet dataSet, BackPropagation learningRule){};
    
    public void learnDataSetWithMBackP(DataSet dataSet, MomentumBackpropagation learningRule){};
}
