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
import org.neuroph.core.learning.error.MeanSquaredError;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Windows
 */
public class ANNDataSetSetup 
{
    private DataSetTrain dataTrain;
    private DataSetTest dataTest;
    
    //private BackPropagation bP;
    private MomentumBackpropagation mBP;
    
    //1 - A
    public void trainedMLPDataSetTrain()
    {
        try
        {
            //Training Data Set
            dataSetTrainingCreation();
            
            //Set Data Set Attribute Column Names
            setColumnNames(dataTrain.getTrainingDataSet());
            System.out.println(Arrays.toString(dataTrain.getTrainingColumnNames()));

            //Multi-Layer Perceptron Artificial Neural Network  - User Defined
            MultiLayerPerceptronANN mlp1 = new MultiLayerPerceptronANN();
            mlp1.multiLayerPerceptron(TransferFunctionType.SIGMOID, 8, 6, 4);

            //BackPropagation
            //bP = new BackPropagation();
            //bP.setMaxError(0.04);
            //bP.setLearningRate(0.2);

            //Momentum BackPropagation
            mBP = new MomentumBackpropagation();
            mBP.setMaxError(0.04);
            mBP.setLearningRate(0.2);
            mBP.setMomentum(0.7);

            //Learning the Data Set using BackPropagation Learning Rule Algorithm
            //mlp1.learnDataSetWithBackP(dataTrain.getTrainingDataSet(),bP);
            
            //Learning the Data Set using Momentum BackPropagation Learning Rule Algorithm
            mlp1.learnDataSetWithMBackP(dataTrain.getTrainingDataSet(),mBP);
            
            //Total Network Error of Current Iteration - Momentum BackPropagation
            System.out.println("\nTotal Network Error of Current Iteration: " + mBP.getTotalNetworkError());
            
            //Input / Output (Desired) Values - Train Data Set
            //System.out.println("\nTraining - Input / Output Values (Desired): " + dataTrain.getTrainingDataSet().getRows());
            
            //Test Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Trained Neural Network");
            testANN(mlp1.getMultiLayerPerceptron(),dataTrain.getTrainingDataSet());
            
            //Current Iteration - BackPropagation
            //System.out.println("\nCurrent Iteration: " + bP.getCurrentIteration());
            
            //Current Iteration - Momentum BackPropagation
            System.out.println("\nCurrent Iteration: " + mBP.getCurrentIteration());
            
            //Max Error - BackPropagation 
            //System.out.println("\nMax Error: " + bP.getTotalNetworkError());
            
            //Save Neural Network
            mlp1.saveNeuralNetwork("mlp1_sig_8_6_4.nnet");
            System.out.println("\nMulti-Layer Perceptron A.N.N. (Sigmoid, 8, 6, 4) saved");
            
            currentDateAndTime();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //1 - B
    public void savedMLPDataSetTest()
    {
        try
        {
            //Testing Data Set
            dataSetTestingCreation();
            
            //Set Data Set Attribute Column Names
            setColumnNames(dataTest.getTestingDataSet());
            System.out.println(Arrays.toString(dataTest.getTestingColumnNames()));

            //Input / Output (Desired) Values - Test Data Set
            //System.out.println("\nTesting - Input / Output Values (Desired): " + dataTest.getTestingDataSet().getRows());

            //Load Saved Neural Network
            System.out.println("\nLoading Saved Neural Network");
            NeuralNetwork savedMLP = NeuralNetwork.createFromFile("mlp1_sig_8_6_4.nnet");
            
            //Test Code - Can Remove If Not Needed
            //Momentum BackPropagation
            mBP = new MomentumBackpropagation();
            mBP.setMaxIterations(2500);
            mBP.setMaxError(0.04);
            mBP.setLearningRate(0.2);
            mBP.setMomentum(0.7);
            //Learning the Data Set using Momentum BackPropagation 
            savedMLP.learn(dataTest.getTestingDataSet(), mBP);
            //Total Network Error of Current Iteration - Momentum BackPropagation
            System.out.println("\nTotal Network Error of Current Iteration: " + mBP.getTotalNetworkError());
            
            //Test Saved Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Saved Neural Network");
            testANN(savedMLP,dataTest.getTestingDataSet());
            
            //Test Code - Can Remove If Not Needed
            //Current Iteration - Momentum BackPropagation
            System.out.println("\nCurrent Iteration: " + mBP.getCurrentIteration());
            
            currentDateAndTime();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //2 - A
    public void trainedMLPDSTrainFile()
    {
        try
        {
            //Training Data Set Acquired From File
            DataSet dS = DataSetTrain.trainingSetFromFile("C:\\Users\\Windows\\Desktop\\TrainingDataSet50.txt", 8, 4, "\t");

            //Set Data Set Attribute Column Names
            setColumnNames(dS);
            System.out.println(Arrays.toString(dS.getColumnNames()));
            
            //Multi-Layer Perceptron Artificial Neural Network  - User Defined
            MultiLayerPerceptronANN mlp1 = new MultiLayerPerceptronANN();
            mlp1.multiLayerPerceptron(TransferFunctionType.SIGMOID, 8, 6, 4);

            //Momentum Back Propagation
            mBP = new MomentumBackpropagation();
            mBP.setMaxError(0.04);
            mBP.setLearningRate(0.2);
            mBP.setMomentum(0.7);

            //Learning the Data Set using Momentum BackPropagation 
            mlp1.learnDataSetWithMBackP(dS,mBP);
            
            //Total Network Error of Current Iteration - Momentum BackPropagation
            System.out.println("\nTotal Network Error of Current Iteration: " + mBP.getTotalNetworkError());

            //Input / Output (Desired) Values - Train Data Set
            //System.out.println("\nTraining - Input / Output Values (Desired): " + dS.getRows());

            //Test Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Trained Neural Network");
            testANN(mlp1.getMultiLayerPerceptron(),dS);
            
            //Current Iteration - Momentum BackPropagation
            System.out.println("\nCurrent Iteration: " + mBP.getCurrentIteration());

            //Save Neural Network
            mlp1.saveNeuralNetwork("mlp1_sig_8_6_4.nnet");
            System.out.println("\nMulti-Layer Perceptron A.N.N. (Sigmoid, 8, 6, 4) saved");

            currentDateAndTime();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //2 - B
    public void savedMLPDSTestFile()
    {
        try
        {
            //Testing Data Set
            DataSet dS = DataSetTest.testingSetFromFile("C:\\Users\\Windows\\Desktop\\TestingDataSet50.txt", 8, 4, "\t");

            //Set Data Set Attribute Column Names
            setColumnNames(dS);
            System.out.println(Arrays.toString(dS.getColumnNames()));
            
            //Input / Output (Desired) Values - Test Data Set
            //System.out.println("\nTesting - Input / Output Values (Desired): " + dS.getRows());

            //Load Saved Neural Network
            System.out.println("\nLoading Saved Neural Network");
            NeuralNetwork savedMLP = NeuralNetwork.createFromFile("mlp1_sig_8_6_4.nnet");
            
            //Test Code - Can Remove If Not Needed
            //Momentum BackPropagation
            mBP = new MomentumBackpropagation();
            mBP.setMaxIterations(2500);
            mBP.setMaxError(0.04);
            mBP.setLearningRate(0.2);
            mBP.setMomentum(0.7);
            //Learning the Data Set using Momentum BackPropagation 
            savedMLP.learn(dS, mBP);
            //Total Network Error of Current Iteration - Momentum BackPropagation
            System.out.println("\nTotal Network Error of Current Iteration: " + mBP.getTotalNetworkError());

            //Test Saved Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Saved Neural Network");
            testANN(savedMLP,dS);
            
            //Test Code - Can Remove If Not Needed
            //Current Iteration - Momentum BackPropagation
            System.out.println("\nCurrent Iteration: " + mBP.getCurrentIteration());
            
            currentDateAndTime();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //3 - A
    public void trainedMLPBDSTrainFile() throws FileNotFoundException
    {
        try
        {
            //User Defined Training Data Set Class Instantiation
            DataSetTrain train = new DataSetTrain(8,4);

            //Training Data Set File Location
            File file = new File("C:\\Users\\Windows\\Desktop\\TrainingDataSet50.txt");
            
            if(file.exists())
            {
                System.out.println("File " + file.getName() + " exists\n");
            }
            
            //Neuroph Framework BufferedDataSet Class
            BufferedDataSet bDS = new BufferedDataSet(file,8,4,"\t");
            
            /*
            Iterate through each row within the data set and add the row
            to the DataSetTrain class using the user defined addDataSetRow
            Method
            */
            Iterator<DataSetRow> it = bDS.getRows().iterator();
            while(it.hasNext())
            {
                DataSetRow dataRow = it.next();
                train.addDataSetRow(dataRow);
            }
            
            /*
            for (DataSetRow dataRow : bDS.getRows()) 
            {
                train.addDataSetRow(dataRow);
            }
            */
            
            //Set Data Set Attribute Column Names
            setColumnNames(train.getTrainingDataSet(),bDS);
            System.out.println(Arrays.toString(train.getTrainingColumnNames()));
            
            //Place within for-loop
            //bDS.addRow(dataRow);
            
            //Multi-Layer Perceptron Artificial Neural Network  - User Defined
            MultiLayerPerceptronANN mlp1 = new MultiLayerPerceptronANN();
            mlp1.multiLayerPerceptron(TransferFunctionType.SIGMOID, 8, 6, 4);
            
            //Momentum Back Propagation
            mBP = new MomentumBackpropagation();
            mBP.setMaxIterations(2500);
            mBP.setMaxError(0.04);
            mBP.setLearningRate(0.2);
            mBP.setMomentum(0.7);
            
            //Learning the Data Set using Momentum BackPropagation 
            mlp1.learnDataSetWithMBackP(train.getTrainingDataSet(), mBP);
            
            //Input / Output (Desired) Values - Train Data Set
            //System.out.println("\nTraining - Input / Output Values (Desired): " + train.getTrainingDataSet().getRows());
            
            //Total Network Error of Current Iteration - Momentum BackPropagation
            System.out.println("\nTotal Network Error of Current Iteration: " + mBP.getTotalNetworkError());
            
            //Test Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Trained Neural Network");
            testANN(mlp1.getMultiLayerPerceptron(),train.getTrainingDataSet());
            
            //Current Iteration - Momentum BackPropagation
            System.out.println("\nCurrent Iteration: " + mBP.getCurrentIteration());
            
            //Save Neural Network
            mlp1.saveNeuralNetwork("mlp1_sig_8_6_4.nnet");
            System.out.println("\nMulti-Layer Perceptron A.N.N. (Sigmoid, 8, 6, 4) saved");
            
            currentDateAndTime();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File does not exist: " + e.getMessage());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //3 - B
    public void savedMLPBDSTestFile() throws FileNotFoundException
    {
        try
        {
            //Test Data Set
            DataSetTest test = new DataSetTest(8,4);

            File file = new File("C:\\Users\\Windows\\Desktop\\TestingDataSet50.txt");
            
            if(file.exists())
            {
                System.out.println("File " + file.getName() + " exists\n");
            }
            
            BufferedDataSet bDS = new BufferedDataSet(file,8,4,"\t");

            Iterator<DataSetRow> it = bDS.getRows().iterator();
            while(it.hasNext())
            {
                DataSetRow dataRow = it.next();
                test.addDataSetRow(dataRow);
            }
            
            /*
            for (DataSetRow dataRow : bDS.getRows()) 
            {
                test.addDataSetRow(dataRow);
            }
            */
            
            //Set Data Set Attribute Column Names
            setColumnNames(test.getTestingDataSet(),bDS);
            System.out.println(Arrays.toString(test.getTestingColumnNames()));
            
            //Place within for-loop
            //bDS.addRow(dataRow);
            
            //Input / Output (Desired) Values - Train Data Set
            //System.out.println("\nTesting - Input / Output Values (Desired): " + test.getTestingDataSet().getRows());

            //Load Saved Neural Network
            System.out.println("\nLoading Saved Neural Network");
            NeuralNetwork savedMLP = NeuralNetwork.createFromFile("mlp1_sig_8_6_4.nnet");
            neuralNetworkProperties(savedMLP);
            
            //Test Code - Can Remove If Not Needed
            //Momentum BackPropagation
            mBP = new MomentumBackpropagation();
            mBP.setMaxIterations(2500);
            mBP.setMaxError(0.04);
            mBP.setLearningRate(0.2);
            mBP.setMomentum(0.7);
            //Learning the Data Set using Momentum BackPropagation 
            savedMLP.learn(test.getTestingDataSet(), mBP);
            //Total Network Error of Current Iteration - Momentum BackPropagation
            System.out.println("\nTotal Network Error of Current Iteration: " + mBP.getTotalNetworkError());
            
            //Test Saved Neural Network - Multi Layer Perceptron Sigmoid 8 6 4
            System.out.println("\nTesting Saved Neural Network");
            testANN(savedMLP,test.getTestingDataSet());
            
            //Test Code - Can Remove If Not Needed
            //Current Iteration - Momentum BackPropagation
            System.out.println("\nCurrent Iteration: " + mBP.getCurrentIteration());
            
            currentDateAndTime();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File does not exist: " + e.getMessage());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /*
    public void multiLayerPerceptronCreation() throws FileNotFoundException
    {
        try
        {
            //Learning the Data Set - No Learning Rule
            
            //Learning the Data Set using BackPropagation 
            //mlpANN1.learnDataSet(dataTrain.getTrainingDataSet(),bP);

            //Learning the Data Set using Momentum BackPropagation 
            //mlpANN1.learnDataSet(dataTrain.getTrainingDataSet(),mBP);
            //mlpANN1.learnDataSet(train.getTrainingDataSet(), bP);

            //System.out.println("\nTraining - Input / Output Values (Desired): " + bDS.getRows());

            //Max Error - BackPropagation
            //System.out.println("\nMax Error: " + bP.getTotalNetworkError());
            
            //testNeuralNetwork(mlpANN1.getMultiLayerPerceptron(),dS);
            
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

            //currentDateAndTime();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    */
    
    public void currentDateAndTime()
    {
        //Date and Time
        Date date = new Date();
        System.out.println("\nDate and Time: " + date.toString() + "\n");
    }
    
    public void setColumnNames(DataSet dataSet)
    {
        final int COLUMN_SIZE = (dataSet.getInputSize() + dataSet.getOutputSize());

        String[] columnNames = new String[COLUMN_SIZE];
            
        columnNames[0] = "Author and Song Duration";
        columnNames[1] = "Tempo (Beats per Minute)";
        columnNames[2] = "Root Mean Square (Amplitude)";
        columnNames[3] = "Sampling Frequency (kHz)";
        columnNames[4] = "Sampling Rate (b)";
        columnNames[5] = "Dynamic Range";
        columnNames[6] = "Tonality";
        columnNames[7] = "Number of Digital Errors";
        columnNames[8] = "1 0 0 0 - Rock";
        columnNames[9] = "0 1 0 0 - Classical";
        columnNames[10] = "0 0 1 0 - Jazz";
        columnNames[11] = "0 0 0 1 - Folk";
            
        dataSet.setColumnNames(columnNames);
    }
    
    public void setColumnNames(DataSet dataSetUserDefined, DataSet dS)
    {
        final int COLUMN_SIZE = (dataSetUserDefined.getInputSize() + dataSetUserDefined.getOutputSize());

        String[] columnNames = new String[COLUMN_SIZE];
            
        columnNames[0] = "Author and Song Duration";
        columnNames[1] = "Tempo (Beats per Minute)";
        columnNames[2] = "Root Mean Square (Amplitude)";
        columnNames[3] = "Sampling Frequency (kHz)";
        columnNames[4] = "Sampling Rate (b)";
        columnNames[5] = "Dynamic Range";
        columnNames[6] = "Tonality";
        columnNames[7] = "Number of Digital Errors";
        columnNames[8] = "1 0 0 0 - Rock";
        columnNames[9] = "0 1 0 0 - Classical";
        columnNames[10] = "0 0 1 0 - Jazz";
        columnNames[11] = "0 0 0 1 - Folk";
            
        dataSetUserDefined.setColumnNames(columnNames);
    }
    
    private void neuralNetworkProperties(NeuralNetwork neuralNetwork)
    {
        System.out.println("\nSaved Artificial Neural Network Properties " + 
                    "\nArtificial Neural Network: " + neuralNetwork.getNetworkType() +
                    "\nInputs: " + neuralNetwork.getInputsCount() + "\nOutputs: " + 
                    neuralNetwork.getOutputsCount());
    }
    
    public void dataSetTrainingCreation()
    {
        dataTrain = new DataSetTrain(8,4);
        
        dataTrain.addTrainingDataSetRow(new double[]{0.160931174, 0.486666667, 0.2, 0, 0, 0.35, 0.363636364, 0},
                new double[]{0, 0, 1, 0});
        dataTrain.addTrainingDataSetRow(new double[]{0.237854251, 0.733333333, 0.6, 0, 1, 0.025, 0.818181818, 0.428571429},
                new double[]{0, 0, 0, 1});
        dataTrain.addTrainingDataSetRow(new double[]{0.208502024, 0.466666667, 0.3, 0, 1, 0.3, 1, 0},
                new double[]{0, 0, 1, 0});
        dataTrain.addTrainingDataSetRow(new double[]{0.19534413, 0.6, 0.3, 0, 1, 0.3, 0.727272727, 0},
                new double[]{0, 0, 1, 0});
    }
    
    private void dataSetTestingCreation()
    {
        dataTest = new DataSetTest(8,4);
        
        dataTest.addTestingDataSetRow(new double[]{0.301619433, 0.533333333, 0.1, 1, 0, 0.825, 0.272727273, 0},
                new double[]{0, 1, 0, 0});
        dataTest.addTestingDataSetRow(new double[]{0.303643725, 0.7, 0.4, 0, 0, 0.125, 0.181818182, 0.714285714}, 
                new double[]{0, 0, 0, 1});
        dataTest.addTestingDataSetRow(new double[]{0.214574899, 0.8, 0.7, 0, 0, 0.125, 0.727272727,0.571428571}, 
                new double[]{0, 0, 0, 1});
        dataTest.addTestingDataSetRow(new double[]{0.237854251, 0.866666667, 0.9, 0, 0, 0.05, 0.818181818, 0.857142857}, 
                new double[]{1,	0, 0, 0});
    }
    
    public void testANN(NeuralNetwork aNN, DataSet dataSet)
    {
        Iterator<DataSetRow> it = dataSet.getRows().iterator();
        double[] aNNOutput;
        DataSetRow dataRow;
        MeanSquaredError mSE = new MeanSquaredError();
        
        while(it.hasNext())
        {
            dataRow = it.next();
            aNN.setInput(dataRow.getInput());
            aNN.calculate();
            aNNOutput = aNN.getOutput();
            System.out.println("\nInput: " + Arrays.toString(dataRow.getInput()));
            System.out.println("Output: " + Arrays.toString(aNNOutput));
            System.out.println("Desired Output: " + Arrays.toString(dataRow.getDesiredOutput()));
            
            mSE.calculatePatternError(aNNOutput, dataRow.getDesiredOutput());
        }
        
        System.out.println("\nTotal Network Error: " + mSE.getTotalError());
    }
}
