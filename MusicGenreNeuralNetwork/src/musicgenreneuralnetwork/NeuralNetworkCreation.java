/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.BufferedDataSet;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Windows
 */
public class NeuralNetworkCreation 
{
    private DataSetTrain dataTrain;
    private DataSetTest dataTest;
    private BackPropagation bP;
    private MomentumBackpropagation mBP;
    
    public void multiLayerPerceptronCreation() throws FileNotFoundException
    {
        try
        {
            //Training Data Set
            //dataSetTrainingCreation();

            //DataSet dS = DataSetTrain.trainingSetFromFile("C:\\Users\\Windows\\Desktop\\TrainingDataSet4.txt", 8, 4, "\t");

            //Place Line Of Code WIthin A New Method
            DataSetTrain train = new DataSetTrain(8,4);

            File file = new File("C:\\Users\\Windows\\Desktop\\TrainingDataSet11.txt");
            BufferedDataSet bDS = new BufferedDataSet(file,8,4,"\t");

            for (DataSetRow dataRow : bDS.getRows()) 
            {
                train.addDataSetRow(dataRow);
                //bDS.addRow(dataRow);
            }

            //Multi-Layer Perceptron Artificial Neural Network  - User Defined
            MultiLayerPerceptronANN mlp1 = new MultiLayerPerceptronANN();
            mlp1.multiLayerPerceptron(TransferFunctionType.SIGMOID, 8, 6, 4);
            System.out.println("\nMulti-Layer Perceptron A.N.N. created (Sigmoid, 8, 6, 4)");

            //BackPropagation
            //bP = new BackPropagation();
            //bP.setMaxError(0.04);
            //bP.setLearningRate(0.2);

            //Momentum Back Propagation
            mBP = new MomentumBackpropagation();
            mBP.setMaxError(0.04);
            mBP.setLearningRate(0.2);
            mBP.setMomentum(0.7);

            //Learning the Data Set - No Learning Rule
            //mlpANN1.learnDataSet(dataTrain.getTrainingDataSet());

            //Learning the Data Set using BackPropagation 
            //mlpANN1.learnDataSet(dataTrain.getTrainingDataSet(),bP);

            //Learning the Data Set using Momentum BackPropagation 
            //mlpANN1.learnDataSet(dataTrain.getTrainingDataSet(),mBP);
            //mlpANN1.learnDataSet(dS,mBP);
            //mlpANN1.learnDataSet(train.getTrainingDataSet(), bP);

            mlp1.learnDataSet(train.getTrainingDataSet(), mBP);

            //Input / Output (Desired) Values - Train Data Set
            //System.out.println("\nTraining - Input / Output Values (Desired): " + dataTrain.getTrainingDataSet().getRows());
            //System.out.println("\nTraining - Input / Output Values (Desired): " + dS.getRows());
            System.out.println("\nTraining - Input / Output Values (Desired): " + train.getTrainingDataSet().getRows());
            //System.out.println("\nTraining - Input / Output Values (Desired): " + bDS.getRows());

            //Max Error - BackPropagation
            //System.out.println("\nMax Error: " + bP.getTotalNetworkError());
            System.out.println("\nMax Error: " + mBP.getTotalNetworkError());

            //Test Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Trained Neural Network");
            //testNeuralNetwork(mlpANN1.getMultiLayerPerceptron(),dataTrain.getTrainingDataSet());
            //testNeuralNetwork(mlpANN1.getMultiLayerPerceptron(),dS);
            testNeuralNetwork(mlp1.getMultiLayerPerceptron(),train.getTrainingDataSet());
            //testNeuralNetwork(mlpANN1.getMultiLayerPerceptron(),bDS);
            
            //Save Neural Network
            //mlp1.saveNeuralNetwork("mlp1_sig_8_6_4.nnet");
            //System.out.println("\nMulti-Layer Perceptron A.N.N. (Sigmoid, 8, 6, 4) saved");

            //Test Data Set - Method Call
            //dataSetTestingCreation();

            //Load Neural Network
            //NeuralNetwork loadMLP = NeuralNetwork.createFromFile("mlp1_sig_8_6_4.nnet");

            //Input / Output (Desired) Values - Test Data Set
            //System.out.println("\nTesting - Input / Output Values (Desired): " + dataTest.getTestingDataSet().getRows());
            //System.out.println("\nTesting - Input / Output Values (Desired): " + dS.getRows());

            //Test Loaded Neural Network
            //System.out.println("\nTesting Loaded Neural Network");
            //testNeuralNetwork(loadMLP,dataTest.getTestingDataSet());
            //testNeuralNetwork(loadMLP,dS);

            //Date and Time
            Date date = new Date();
            System.out.println("\nDate and Time: " + date.toString()); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void loadNeuralNetwork() throws FileNotFoundException
    {
        DataSetTest test = new DataSetTest(8,4);

        File file = new File("C:\\Users\\Windows\\Desktop\\TrainingDataSet.txt");
        BufferedDataSet bDS = new BufferedDataSet(file,8,4,"\t");
        
        int COLUMN_SIZE = (test.getNumberOfInputs() + test.getNumberOfOutputs());
        
        String[] columnNames = new String[COLUMN_SIZE];
        columnNames[0] = "Test";
        
        bDS.setColumnNames(columnNames);
        
        System.out.println(Arrays.toString(bDS.getColumnNames()));
        
        Iterator<DataSetRow> it = bDS.getRows().iterator();
        while(it.hasNext())
        {
            DataSetRow dataRow = it.next();
            test.addDataSetRow(dataRow);
            //bDS.addRow(dataRow);
        }
        
        NeuralNetwork load = NeuralNetwork.createFromFile("mlp1_sig_8_6_4.nnet");
        
        testNeuralNetwork(load,test.getTestingDataSet());
    }
    
    private void dataSetTrainingCreation()
    {
        dataTrain = new DataSetTrain(8,4);
        
        dataTrain.addTrainingDataSetRows(new double[]{0.160931174, 0.486666667, 0.2, 0, 0, 0.35, 0.363636364, 0},
                new double[]{0, 0, 1, 0});
        dataTrain.addTrainingDataSetRows(new double[]{0.237854251, 0.733333333, 0.6, 0, 1, 0.025, 0.818181818, 0.428571429},
                new double[]{0, 0, 0, 1});
        dataTrain.addTrainingDataSetRows(new double[]{0.208502024, 0.466666667, 0.3, 0, 1, 0.3, 1, 0},
                new double[]{0, 0, 1, 0});
        dataTrain.addTrainingDataSetRows(new double[]{0.19534413, 0.6, 0.3, 0, 1, 0.3, 0.727272727, 0},
                new double[]{0, 0, 1, 0});
        dataTrain.addTrainingDataSetRows(new double[]{0.301619433, 0.533333333, 0.1, 1, 0, 0.825, 0.272727273, 0},
                new double[]{0, 1, 0, 0});
        dataTrain.addTrainingDataSetRows(new double[]{0.303643725, 0.7, 0.4, 0, 0, 0.125, 0.181818182, 0.714285714},
                new double[]{0, 0, 0, 1});
        dataTrain.addTrainingDataSetRows(new double[]{0.214574899, 0.8, 0.7, 0, 0, 0.125, 0.727272727,0.571428571}, 
                new double[]{0, 0, 0, 1});
        dataTrain.addTrainingDataSetRows(new double[]{0.237854251, 0.866666667, 0.9, 0, 0, 0.05, 0.818181818, 0.857142857}, 
                new double[]{1,	0, 0, 0});
        dataTrain.addTrainingDataSetRows(new double[]{0.259109312, 0.866666667, 0.8, 0, 0, 0.125, 1, 0.857142857}, 
                new double[]{1,	0, 0, 0});
        dataTrain.addTrainingDataSetRows(new double[]{0.197368421, 0.6, 0.2, 0, 1, 0.35, 0, 0}, 
                new double[]{0,	0, 1, 0}); 
        
    }
    
    private void dataSetTestingCreation()
    {
        dataTest = new DataSetTest(8,4);
        
        dataTest.addTestingDataSetRows(new double[]{0.301619433, 0.533333333, 0.1, 1, 0, 0.825, 0.272727273, 0},
                new double[]{0, 1, 0, 0});
        dataTest.addTestingDataSetRows(new double[]{0.303643725, 0.7, 0.4, 0, 0, 0.125, 0.181818182, 0.714285714}, 
                new double[]{0, 0, 0, 1});
        dataTest.addTestingDataSetRows(new double[]{0.214574899, 0.8, 0.7, 0, 0, 0.125, 0.727272727,0.571428571}, 
                new double[]{0, 0, 0, 1});
        dataTest.addTestingDataSetRows(new double[]{0.237854251, 0.866666667, 0.9, 0, 0, 0.05, 0.818181818, 0.857142857}, 
                new double[]{1,	0, 0, 0});
    }
    
    public void testNeuralNetwork(NeuralNetwork nnet, DataSet testDataSet)
    {
        Iterator<DataSetRow> it = testDataSet.getRows().iterator();
        double[] networkOutput;
        
        while(it.hasNext())
        {
            DataSetRow dataRow = it.next();
            nnet.setInput(dataRow.getInput());
            nnet.calculate();
            networkOutput = nnet.getOutput();
            System.out.println("Input: " + Arrays.toString(dataRow.getInput()));
            System.out.println("Output: " + Arrays.toString(networkOutput));
           
        }
    }
}
