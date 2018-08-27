/*This project aims to provide solutions to the PART 1 AND Part 2 Questions
 *This project is a maven project , having all relevant dependencies in Pom.xml
 *Inside src/main/java, 
 *I have setup three packages namely-
 *DVLAPom- this package contains the class  DVLAPageObjModel.java, which represents the Page Object Model for DVLA page
 *excelUtil- this package contains the class  ReadExcel.java, basically this is a helper class which has helper a method 
 *         and reads the excel file for data and provides it .
 *part1filetesting- this package has the class FileCreation.java, which one method to scan folder and fetch file details
 ------------------------------------------------------------------------------------------------------------------------
 *Inside src/test/java   
 *Driver folder has - MAC supported drivers for chrome 
 *Features folder - has a feature file
 *Test Data - contains a set of files used for part 1 and part 2 testing
 *part2cucumbertest package contains two classes, CucumberTest which is the java glue code for the feature file  
 *                                                CucumberRunner class using junit to run the java glue code.
 *part1file package contains two classes , Filetesting.java - which has a main method and creates the object of the class 
                                           File creation and uses the service getfiledetails
                                         FileJunitTestCase.java - is the junit test case for FileCreation.java class.
 ------------------------------------------------------------------------------------------------------------------------
 Tips for people who clone this project
 My machine is a mac, and Drivers -chromedriver is mac supported. Please keep all your drivers in Drivers folder 
 PART-2-OUTPUT file is created as a result of testing - just for easy understanding I have created a file. 
 This file automatically gets created when you run cucumber runner.
 -------------------------------------------------------------------------------------------------------------------------
 
 
                                                                  