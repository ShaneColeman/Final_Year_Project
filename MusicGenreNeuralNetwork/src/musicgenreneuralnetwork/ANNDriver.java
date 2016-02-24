/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import java.io.File;
import java.io.FileNotFoundException;
import org.neuroph.core.data.BufferedDataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Windows
 */
public class ANNDriver {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        try
        {
            
            NeuralNetworkCreation neuralNetwork = new NeuralNetworkCreation();
            
            /*
            neuralNetwork.dataSetTrainingCreation();
            
            neuralNetwork.createNeuralNetwork(TransferFunctionType.SIGMOID, 8, 6, 4);
            
            neuralNetwork.saveNeuralNetwork("test_mlp.nnet");
            */
            
            neuralNetwork.learnTestANNDataSetTrain();
            
            
            //neuralNetwork.learnTestANNDataSetFile();
            
            
            

            //neuralNetwork.multiLayerPerceptronCreation();
            
            //neuralNetwork.loadNeuralNetwork();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
}
