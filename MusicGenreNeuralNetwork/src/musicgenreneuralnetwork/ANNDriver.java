/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import java.io.FileNotFoundException;

/**
 *
 * @author Windows
 */
public class ANNDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        NeuralNetworkCreation neuralNetwork = new NeuralNetworkCreation();
        
        neuralNetwork.multiLayerPerceptronCreation();
    }
    
}
