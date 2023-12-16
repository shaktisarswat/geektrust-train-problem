package com.geektrust.backend;

import com.geektrust.App;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

public class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor,true));
    }

    @Test
    @DisplayName("Integration Test #1")
    void runTest1(){
        //Arrange
        String argument= "sample_input/input1.txt";
        String expectedOutput = "ARRIVAL TRAIN_A ENGINE HYB NGP ITJ\n" +
                "ARRIVAL TRAIN_B ENGINE NJP PTA\n" +
                "DEPARTURE TRAIN_AB ENGINE ENGINE NJP PTA ITJ NGP";
        //Act
        App.run(Collections.singletonList(argument));
        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #2")
    void runTest2(){
        //Arrange
        String argument= "sample_input/input2.txt";
        String expectedOutput = "ARRIVAL TRAIN_A ENGINE NDL NDL GHY NJP NGP\n" +
                "ARRIVAL TRAIN_B ENGINE NJP GHY AGA BPL PTA\n" +
                "DEPARTURE TRAIN_AB ENGINE ENGINE GHY GHY NJP NJP PTA NDL NDL AGA BPL NGP";
        //Act
        App.run(Collections.singletonList(argument));
        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #3")
    void runTest3(){
        //Arrange
        String argument= "sample_input/input3.txt";
        String expectedOutput = "ARRIVAL TRAIN_A ENGINE NDL NDL GHY NJP NGP\n" +
                "ARRIVAL TRAIN_B ENGINE NJP GHY AGA BPL PTA\n" +
                "DEPARTURE TRAIN_AB ENGINE ENGINE GHY GHY NJP NJP PTA NDL NDL AGA BPL NGP";
        //Act
        App.run(Collections.singletonList(argument));
        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

}
