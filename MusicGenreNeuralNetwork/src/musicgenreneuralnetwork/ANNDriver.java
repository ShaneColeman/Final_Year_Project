/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import java.io.FileNotFoundException;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Windows
 */
public class ANNDriver {

    /**
     */

    public void mlp1()
    {
        try
        {
            DataSetTrain train = new DataSetTrain(8,4);
            train.getBufferedDataSet("C:\\Users\\Windows\\Desktop\\TrainingDataSet50.txt", 8, 4, "\t");
            
            MultiLayerPerceptronANN mlp1 = new MultiLayerPerceptronANN();
            
            mlp1.multiLayerPerceptron(TransferFunctionType.SIGMOID, 8, 6, 4);
            //mlp2.multiLayerPerceptron(TransferFunctionType.LOG, 8, 4, 4);
            
            MomentumBackpropagation mBP = new MomentumBackpropagation();
            
            int maxIterations = mBP.getMaxIterations();
            
            mBP.setMaxIterations(maxIterations);
            mBP.setMaxError(0.04);
            mBP.setLearningRate(0.2);
            mBP.setMomentum(0.7);
            
            mlp1.learnDataSetWithMBackP(train.getTrainingDataSet(),mBP);
            
            System.out.println("\nMax Error: " + mBP.getTotalNetworkError());
            
            System.out.println("\nCurrent Iteration: " + mBP.getCurrentIteration());
            
            //System.out.println("\nTraining - Input / Output Values (Desired): " + train.getTrainingDataSet().getRows());
            
            //Test Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Trained Neural Network");
            TestNeuralNetwork test = new TestNeuralNetwork();
            
            test.testNeuralNetwork(mlp1.getMultiLayerPerceptron(), train.getTrainingDataSet());
           
            //mlp1.saveNeuralNetwork("test_mlp1.nnet");
            
            
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
    
    public void mlp2()
    {
        try
        {
            DataSetTrain train = new DataSetTrain(8,4);
            train.getBufferedDataSet("C:\\Users\\Windows\\Desktop\\TrainingDataSet11.txt", 8, 4, "\t");
            
            MultiLayerPerceptronANN mlp2 = new MultiLayerPerceptronANN();
            
            
            mlp2.multiLayerPerceptron(TransferFunctionType.SIGMOID, 8, 6, 4);
            //mlp2.multiLayerPerceptron(TransferFunctionType.LOG, 8, 4, 4);
            
            MomentumBackpropagation mBP = new MomentumBackpropagation();
            mBP.setMaxIterations(2500);
            mBP.setMaxError(0.07);
            mBP.setLearningRate(0.1);
            mBP.setMomentum(0.6);
            
            mlp2.learnDataSetWithMBackP(train.getTrainingDataSet(),mBP);
            
            System.out.println("\nMax Error: " + mBP.getTotalNetworkError());
            
            System.out.println("\nTraining - Input / Output Values (Desired): " + train.getTrainingDataSet().getRows());
            
            //Test Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Trained Neural Network");
            TestNeuralNetwork test = new TestNeuralNetwork();
            
            test.testNeuralNetwork(mlp2.getMultiLayerPerceptron(), train.getTrainingDataSet());
           
            //mlp2.saveNeuralNetwork("test_mlp2.nnet");
            
       
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        ANNDriver ann = new ANNDriver();
        
        ann.mlp1();
        //ann.mlp2();
    }

    
}
