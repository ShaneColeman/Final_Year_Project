/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicgenreneuralnetwork;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;

/**
 *
 * @author Windows
 */
public class ANNDataSetSetupTest {
    
    public ANNDataSetSetupTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of trainedMLPDataSetTrain method, of class ANNDataSetSetup.
     */
    @Test
    public void testTrainedMLPDataSetTrain() {
        System.out.println("trainedMLPDataSetTrain");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.trainedMLPDataSetTrain();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savedMLPDataSetTest method, of class ANNDataSetSetup.
     */
    @Test
    public void testSavedMLPDataSetTest() {
        System.out.println("savedMLPDataSetTest");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.savedMLPDataSetTest();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trainedMLPDSTrainFile method, of class ANNDataSetSetup.
     */
    @Test
    public void testTrainedMLPDSTrainFile() {
        System.out.println("trainedMLPDSTrainFile");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.trainedMLPDSTrainFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savedMLPDSTestFile method, of class ANNDataSetSetup.
     */
    @Test
    public void testSavedMLPDSTestFile() {
        System.out.println("savedMLPDSTestFile");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.savedMLPDSTestFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trainedMLPBDSTrainFile method, of class ANNDataSetSetup.
     */
    @Test
    public void testTrainedMLPBDSTrainFile() throws Exception {
        System.out.println("trainedMLPBDSTrainFile");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.trainedMLPBDSTrainFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savedMLPBDSTestFile method, of class ANNDataSetSetup.
     */
    @Test
    public void testSavedMLPBDSTestFile() throws Exception {
        System.out.println("savedMLPBDSTestFile");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.savedMLPBDSTestFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trainedMLPBDSTrainFile4Inputs method, of class ANNDataSetSetup.
     */
    @Test
    public void testTrainedMLPBDSTrainFile4Inputs() throws Exception {
        System.out.println("trainedMLPBDSTrainFile4Inputs");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.trainedMLPBDSTrainFile4Inputs();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savedMLPBDSTestFile4Inputs method, of class ANNDataSetSetup.
     */
    @Test
    public void testSavedMLPBDSTestFile4Inputs() throws Exception {
        System.out.println("savedMLPBDSTestFile4Inputs");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.savedMLPBDSTestFile4Inputs();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of currentDateAndTime method, of class ANNDataSetSetup.
     */
    @Test
    public void testCurrentDateAndTime() {
        System.out.println("currentDateAndTime");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.currentDateAndTime();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColumnNames method, of class ANNDataSetSetup.
     */
    @Test
    public void testSetColumnNames_DataSet() {
        System.out.println("setColumnNames");
        DataSet dataSet = null;
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.setColumnNames(dataSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColumnNames method, of class ANNDataSetSetup.
     */
    @Test
    public void testSetColumnNames_DataSet_DataSet() {
        System.out.println("setColumnNames");
        DataSet dataSetUserDefined = null;
        DataSet dS = null;
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.setColumnNames(dataSetUserDefined, dS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dataSetTrainingCreation method, of class ANNDataSetSetup.
     */
    @Test
    public void testDataSetTrainingCreation() {
        System.out.println("dataSetTrainingCreation");
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.dataSetTrainingCreation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testANN method, of class ANNDataSetSetup.
     */
    @Test
    public void testTestANN() {
        System.out.println("testANN");
        NeuralNetwork aNN = null;
        DataSet dataSet = null;
        ANNDataSetSetup instance = new ANNDataSetSetup();
        instance.testANN(aNN, dataSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
