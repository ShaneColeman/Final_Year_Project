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
        ANNDataSetSetup nNC = new ANNDataSetSetup();
        
        //nNC.trainedMLPDataSetTrain();
        //nNC.savedMLPDataSetTest();
        
        //nNC.trainedMLPDSTrainFile();
        //nNC.savedMLPDSTestFile();
        
        nNC.trainedMLPBDSTrainFile();
        nNC.savedMLPBDSTestFile();
    }
}
