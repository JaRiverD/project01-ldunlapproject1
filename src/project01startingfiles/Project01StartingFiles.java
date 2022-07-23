package project01startingfiles;

/**
 *
 * @author s540200
 */

import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.util.ArrayList;
import java.io.*;
public class Project01StartingFiles 
{
    //Method to print min data to screen
    public static void printMintoScreen(String[] minParts, long count)
    {
        int lineCount = (int)count;
        String[] date = new String[lineCount];
        String[] ticker = new String[lineCount];
        String[] openPrice = new String[lineCount];
        String[] highPrice = new String[lineCount];
        String[] lowPrice = new String[lineCount];
        String[] closingPrice = new String[lineCount];
        String[] volume = new String[lineCount];
        
        double minimum = 100000.0;
        double indexDouble;
        int minimumIndex = 0;
        int stockTransactions = 0;
        
        for (int index = 0; index < lineCount; index++)
        {
            String[] splitLine = minParts[index].split(",");
            date[index] = splitLine[0];
            ticker[index] = splitLine[1];
            openPrice[index] = splitLine[2];
            highPrice[index] = splitLine[3];
            lowPrice[index] = splitLine[4];
            closingPrice[index] = splitLine[5];
            volume[index] = splitLine[6];
            
            indexDouble = Double.parseDouble(lowPrice[index]);
            if (indexDouble < minimum)
            {
                minimum = indexDouble;
                minimumIndex = index;
            }
        }
        
        for (int index = 0; index < lineCount; index++)
        {
            if (ticker[index].equals(ticker[minimumIndex]))
            {
                stockTransactions++;
            }
        }
        System.out.println("Minimum Closing Stock Information");
        System.out.println("Date: " + date[minimumIndex]);
        System.out.println("Ticker: " + ticker[minimumIndex]);
        System.out.println("Open price: " + openPrice[minimumIndex]);
        System.out.println("High price: " + highPrice[minimumIndex]);
        System.out.println("Low price: " + lowPrice[minimumIndex]);
        System.out.println("Closing price: " + closingPrice[minimumIndex]);
        System.out.println("Volume: " + volume[minimumIndex]);
        System.out.println(ticker[minimumIndex] + " stock transactions: " + stockTransactions);
    }

    //Method to print max data to screen
    public static void printMaxToScreen(String[] maxParts, long count)
    {
        
    }

    //Method to find and print average volumes
    public static void findandPrintAverage(long count, long total)
    {
        
    }

    //Method to print min data to file
    public static void printMinToFile(String[] minParts, PrintWriter file)
    {
        
    }

    //Method to print max data to file
    public static void printMaxToFile(String[] maxParts, PrintWriter file)
    {
        
    }

    //method to print average data to file
    public static void findandPrintAverageToFile(long count, long total, PrintWriter file)
    {
        
    }
    
    public static void main(String[] args) throws Exception
    {
        JButton open = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setDialogTitle("Please select a file");
        if (fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION)
        {
            //
        }
        
        Scanner fileInput = new Scanner(fileChooser.getSelectedFile());
        PrintWriter fileWriter = new PrintWriter("SP500output.txt");
        
        ArrayList<String> dataArrayList = new ArrayList<>();
        int lineCount = 0;
        
        while (fileInput.hasNextLine())
        {
            dataArrayList.add(fileInput.nextLine());
            lineCount++;
        }
        
        String[] dataList = new String[lineCount];
        dataList = dataArrayList.toArray(dataList);

        System.out.println("Standard and Poor's Data");
        System.out.println("");
        
        printMintoScreen(dataList, lineCount);
        
        fileInput.close();
        fileWriter.close();
    }
}
