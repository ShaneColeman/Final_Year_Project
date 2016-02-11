/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import java.util.Arrays;
import java.util.Iterator;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Windows
 */
public class CreateNeuralNetwork 
{
    public CreateNeuralNetwork()
    {
        //Training Data Set
        DataSetTrain dataTrain = new DataSetTrain();
        dataTrain.trainingDataSet_8_4();
        
        //Multi-Layer Perceptron Artificial Neural Network 
        MultiLayerPerceptronANN mlpANN1 = new MultiLayerPerceptronANN();
        mlpANN1.multiLayerPerceptron(TransferFunctionType.SIGMOID, 8, 6, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Sigmoid, 8, 6, 4)");
        
        //Learning the Data Set
        mlpANN1.learnDataSet(dataTrain.getDataSet());
        
        //Test Neural Network
        System.out.println("\nTesting Trained Neural Network");
        testNeuralNetwork(mlpANN1.getMultiLayerPerceptron(),dataTrain.getDataSet());
        
        //Input / Output (Desired) Values - Train Data Set
        System.out.println("\nInput / Output Values (Desired): " + dataTrain.getDataSet().getRows());
        
        //Save Neural Network
        mlpANN1.saveNeuralNetwork("mlp1_sig_8_6_4.nnet");
        System.out.println("\nMulti-Layer Perceptron A.N.N. (Sigmoid, 8, 6, 4) saved");
        
        //Test Data Set
        DataSetTest dataTest = new DataSetTest();
        dataTest.testingDataSet_8_4();
        
        //Load Neural Network
        NeuralNetwork loadMLP = NeuralNetwork.createFromFile("mlp1_sig_8_6_4.nnet");
        
        //Test Loaded Neural Network
        System.out.println("\nTesting Loaded Neural Network");
         testNeuralNetwork(loadMLP,dataTest.getDataSet());
        
        //Input / Output (Desired) Values - Test Data Set
        System.out.println("\nInput / Output Values (Desired): " + dataTest.getDataSet().getRows());
        
        
        
        //Multiple Multi-Layer Perceptron Artificial Neural Networks
        /*
        MultiLayerPerceptronANN mlpANN2 = new MultiLayerPerceptronANN();
        mlpANN2.multiLayerPerceptron(TransferFunctionType.GAUSSIAN, 7, 6, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Gaussian, 7, 6, 4)");
        mlpANN1.saveNeuralNetwork("mlp2_gau_7_6_4.nnet");
        System.out.println("Multi-Layer Perceptron A.N.N. (Gaussian, 7, 6, 4) saved");
        
        MultiLayerPerceptronANN mlpANN3 = new MultiLayerPerceptronANN();
        mlpANN3.multiLayerPerceptron(TransferFunctionType.LINEAR, 6, 4, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Linear, 6, 4, 4)");
        mlpANN3.saveNeuralNetwork("mlp3_lin_6_4_4.nnet");
        System.out.println("Multi-Layer Perceptron A.N.N. (Linear, 6, 4, 4) saved");
        
        MultiLayerPerceptronANN mlpANN4 = new MultiLayerPerceptronANN();
        mlpANN4.multiLayerPerceptron(TransferFunctionType.LOG, 5, 4, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Log, 5, 4, 4)");
        mlpANN4.saveNeuralNetwork("mlp4_log_5_4_4.nnet");
        System.out.println("Multi-Layer Perceptron A.N.N. (Log, 5, 4, 4) saved");
        
        MultiLayerPerceptronANN mlpANN5 = new MultiLayerPerceptronANN();
        mlpANN5.multiLayerPerceptron(TransferFunctionType.RAMP, 8, 4, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Ramp, 8, 4, 4)");
        mlpANN5.saveNeuralNetwork("mlp5_ramp_8_4_4.nnet");
        System.out.println("Multi-Layer Perceptron A.N.N. (Ramp, 8, 4, 4) saved");
        
        MultiLayerPerceptronANN mlpANN6 = new MultiLayerPerceptronANN();
        mlpANN6.multiLayerPerceptron(TransferFunctionType.SGN, 7, 5, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Sgn, 7, 5, 4)");
        mlpANN6.saveNeuralNetwork("mlp6_sgn_7_5_4.nnet");
        System.out.println("Multi-Layer Perceptron A.N.N. (Sgn, 7, 5, 4) saved");
        
        MultiLayerPerceptronANN mlpANN7 = new MultiLayerPerceptronANN();
        mlpANN7.multiLayerPerceptron(TransferFunctionType.SIN, 6, 5, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Sin, 6, 5, 4)");
        mlpANN7.saveNeuralNetwork("mlp7_sin_6_5_4.nnet");
        System.out.println("Multi-Layer Perceptron A.N.N. (Sin, 6, 5, 4) saved");
        
        MultiLayerPerceptronANN mlpANN8 = new MultiLayerPerceptronANN();
        mlpANN8.multiLayerPerceptron(TransferFunctionType.STEP, 5, 3, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Step, 5, 3, 4)");
        mlpANN8.saveNeuralNetwork("mlp8_step_5_3_4.nnet");
        System.out.println("Multi-Layer Perceptron A.N.N. (Step, 5, 3, 4) saved");
        
        MultiLayerPerceptronANN mlpANN9 = new MultiLayerPerceptronANN();
        mlpANN9.multiLayerPerceptron(TransferFunctionType.TANH, 4, 2, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Tnah, 4, 2, 4)");
        mlpANN9.saveNeuralNetwork("mlp9_tnah_4_2_4.nnet");
        System.out.println("Multi-Layer Perceptron A.N.N. (Tnah, 4, 2, 4) saved");
        
        MultiLayerPerceptronANN mlpANN10 = new MultiLayerPerceptronANN();
        mlpANN10.multiLayerPerceptron(TransferFunctionType.TRAPEZOID, 7, 4, 4);
        System.out.println("\nMulti-Layer Perceptron A.N.N. created (Trapezoid, 7, 4, 4)");
        mlpANN10.saveNeuralNetwork("mlp10_trap_7_4_4.nnet");
        System.out.println("Multi-Layer Perceptron A.N.N. (Trapezoid, 7, 4, 4) saved");
        */
    }
    
    public void testNeuralNetwork(NeuralNetwork nnet, DataSet testDataSet)
    {
        for (Iterator<DataSetRow> it = testDataSet.getRows().iterator(); it.hasNext();) 
        {
            DataSetRow dataRow = it.next();
            nnet.setInput(dataRow.getInput());
            nnet.calculate();
            double[] networkOutput = nnet.getOutput();
            System.out.println("Input: " + Arrays.toString(dataRow.getInput()));
            System.out.println("Output: " + Arrays.toString(networkOutput));
        }
    }
}
