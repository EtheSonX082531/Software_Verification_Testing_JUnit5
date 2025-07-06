package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


class TesterTest {

        @BeforeAll
        static void setUpAll () {
            System.out.println("Setting up all equipments for testing.");
        }

        @AfterAll
        static void tearDownAll () {
            System.out.println("Cleaning up all equipments after testing.");
        }

        @BeforeEach
        void setUp () {
            System.out.println("Setting up before each test.");
        }

        @AfterEach
        void tearDown () {
            System.out.println("Cleaning up after each test.");
        }


        @Test
        void test1 () {
            Tester test = new Tester();
            assertEquals(5, test.add(2, 3));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Hello", "Anik", "Ben10"})
        void test2(String arg){
            assertFalse(arg.isEmpty());
        }

        @ParameterizedTest
        @MethodSource("intRange")
        void test3(int num){
            Tester test=new Tester();
            assertTrue(test.checkPositive(num));
        }

        static IntStream intRange(){
            return IntStream.range(10,20);
        }

        @ParameterizedTest
        @CsvSource({
                "1,2,3",
                "2,4,6"
        })
       void test4(int a,int b,int expected){
            Tester test=new Tester();
            assertEquals(expected,test.add(a,b));
        }

        @DisplayName("CsvFileSource testing....")
        @ParameterizedTest
        @CsvFileSource( resources = "/sampleData.csv",numLinesToSkip = 0)
        void test7(int a,int b,int expected){
            Tester test=new Tester();
            assertEquals(expected,test.add(a,b));
        }

        @Test
        void test5(){
            Tester test=new Tester();
            assertNull(test.getNull());
        }

        @Test
        void test6(){
            Tester test=new Tester();
            assertNotNull(test.getName());
        }

        @Test
        void test7(){
              Tester test=new Tester();
              assertThrows(ArithmeticException.class,()->test.divide(3,0));
        }

        @DisplayName("Testing AssertDoesNotThrow.....")
        @Test
        void test8(){
            Tester test=new Tester();
            assertDoesNotThrow(()->test.divide(6,3));
        }

        @DisplayName("Testing with assertTrue...")
        @Test
        void test9(){
            Tester test=new Tester();
            assertTrue(test.checkEven(40));
        }

        @DisplayName("Testing with assertSame and assertNotSame ...")
        @Test
        void test10(){
            Tester test=new Tester();
            Tester sameTest=test;
            Tester newTest= new Tester();
            assertSame(test,sameTest);
            assertNotSame(test,newTest);
        }

        @Test
        void test11(){
            int[] expectedArray={1,2,3};
            int[] actualArray={1,2,3};
            assertArrayEquals(expectedArray,actualArray);
        }

       /* @Test
        void test12(){
            List<String>expectedList=List.of("Anik","Ayon","Anirban");
            List<String>actualList=List.of("Anik","Ayon","Anirban");
            assertLinesMatch(expectedList,actualList);
        }*/

        @Test
        void test13(){
            assertTimeout(Duration.ofMillis(1),()->Tester.printAlphabet());
        }
}
