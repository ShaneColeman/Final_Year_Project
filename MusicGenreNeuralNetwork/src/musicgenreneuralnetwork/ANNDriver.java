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
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        //ANNDriver Class Runnable Driver
        ANNDataSetSetup aNN = new ANNDataSetSetup();
        
        //aNN.trainedMLPDataSetTrain();
        //aNN.savedMLPDataSetTest();
        
        //aNN.trainedMLPDSTrainFile();
        //aNN.savedMLPDSTestFile();
        
        //aNN.trainedMLPBDSTrainFile();
        //aNN.savedMLPBDSTestFile();
        
        //aNN.trainedMLPBDSTrainFile4Inputs();
        aNN.savedMLPBDSTestFile4Inputs();
    }
}
