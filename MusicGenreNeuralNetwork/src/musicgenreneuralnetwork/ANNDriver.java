/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import java.io.FileNotFoundException;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Windows
 */
public class ANNDriver {

    public void trainedNeuralNetwork()
    {
        try
        {
            DataSetTrain trainDS = new DataSetTrain(8,4);
            trainDS.getTrainingBDS("C:\\Users\\Windows\\Desktop\\TrainingDataSet50.txt", 8, 4, "\t");
            
            MultiLayerPerceptronANN mlp1 = new MultiLayerPerceptronANN();
            
            mlp1.multiLayerPerceptron(TransferFunctionType.SIGMOID, 8, 6, 4);
            //mlp2.multiLayerPerceptron(TransferFunctionType.LOG, 8, 4, 4);
            
            MomentumBackpropagation mBP = new MomentumBackpropagation();
            
            int maxIterations = mBP.getMaxIterations();
            
            mBP.setMaxIterations(maxIterations);
            mBP.setMaxError(0.04);
            mBP.setLearningRate(0.2);
            mBP.setMomentum(0.7);
            
            mlp1.learnDataSetWithMBackP(trainDS.getTrainingDataSet(),mBP);
            
            System.out.println("\nMax Error: " + mBP.getTotalNetworkError());
            
            System.out.println("\nCurrent Iteration: " + mBP.getCurrentIteration());
            
            //System.out.println("\nTraining - Input / Output Values (Desired): " + train.getTrainingDataSet().getRows());
            
            //Test Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Trained Neural Network");
            TestNeuralNetwork test = new TestNeuralNetwork();
            
            test.testNeuralNetwork(mlp1.getMultiLayerPerceptron(), trainDS.getTrainingDataSet());
           
            mlp1.saveNeuralNetwork("test_mlp1.nnet");
            
            /////////////////////////////////////////
            //NeuralNetworkCreation neuralNetwork = new NeuralNetworkCreation();
            
            /*
            neuralNetwork.dataSetTrainingCreation();
            
            neuralNetwork.createNeuralNetwork(TransferFunctionType.SIGMOID, 8, 6, 4);
            
            neuralNetwork.saveNeuralNetwork("test_mlp.nnet");
            */
            
            //neuralNetwork.learnTestANNDataSetTrain();
            
            //neuralNetwork.learnTestANNDataSetFile();
            
            //neuralNetwork.multiLayerPerceptronCreation();
            
            //neuralNetwork.loadNeuralNetwork();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void savedNeuralNetwork()
    {
        try
        {
            DataSetTest testDS = new DataSetTest(8,4);
            testDS.getTestingBDS("C:\\Users\\Windows\\Desktop\\TestingDataSet50.txt", 8, 4, "\t");
            
            //Load Saved Neural Network
            System.out.println("\nLoading Saved Neural Network");
            NeuralNetwork load = NeuralNetwork.createFromFile("test_mlp1.nnet");
            
            //System.out.println("\nTraining - Input / Output Values (Desired): " + testDS.getTestingDataSet().getRows());
            
            //Test Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Trained Neural Network");
            TestNeuralNetwork test = new TestNeuralNetwork();
            
            test.testNeuralNetwork(load, testDS.getTestingDataSet());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        NeuralNetworkCreation nNC = new NeuralNetworkCreation();
        //nNC.trainedMLPDataSetTrain();
        //nNC.savedMLPDataSetTest();
        
        //nNC.trainedMLPDSTrainFile();
        //nNC.savedMLPDSTestFile();
        
        nNC.trainedMLPBDSTrainFile();
        //nNC.savedMLPBDSTestFile();
        
        //ANNDriver ann = new ANNDriver();
        //ann.trainedNeuralNetwork();
        //ann.savedNeuralNetwork();
        
    }

    
}
