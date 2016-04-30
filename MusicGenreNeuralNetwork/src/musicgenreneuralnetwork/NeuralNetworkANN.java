/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
http://neuroph.sourceforge.net/tutorials/MultiLayerPerceptron.html

http://neuroph.sourceforge.net/javadoc/org/neuroph/core/NeuralNetwork.html

http://neuroph.sourceforge.net/javadoc/org/neuroph/nnet/MultiLayerPerceptron.html
*/

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
