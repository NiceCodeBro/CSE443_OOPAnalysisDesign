package Part1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

abstract  public class  TransformCalculator {
    protected boolean printExTime = false;
    private long startTime = 0;
    public TransformCalculator()
    {
        startTime = System.currentTimeMillis();
    }
    public List<Double> readNumbersFromFile(String filename)
    {
        BufferedReader reader = null;
        List<Double> numbers = new ArrayList<Double>();
        try {
            File file = new File(filename);
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(" ");
                for(String num:temp)
                    numbers.add(Double.parseDouble(num));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error occur when read number from file..");
        }
        return numbers;
    }
    public void writeNumbersToFile(String filename, List<Double> numbers)
    {

        try {
            BufferedWriter bw = null;
            FileWriter fw = null;
            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);
            StringBuilder sb = new StringBuilder();

            for(Double num:numbers)
                sb.append(num+" ");

            bw.write(sb.toString());


            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error occur when write number to file..");
        }
    }
    abstract public List<Double> transformNumbers(List<Double> numbers);


    final void doProcess(String fileNameForRead, String fileNameForWrite)
    {
        List<Double> readNumbersFromfile = readNumbersFromFile(fileNameForRead);
        List<Double> transformedNumbers = transformNumbers(readNumbersFromfile);
        writeNumbersToFile(fileNameForWrite,transformedNumbers);

        if(printExTime)
        {
            long endTime = System.currentTimeMillis();
            System.out.println("Execution time: " + ( endTime - startTime) + " ms.");
        }
    }

}
