package project01startingfiles;

/**
 *
 * @authors s537821 and s540200
 */
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.util.ArrayList;
import java.io.*;
public class Project01StartingFiles 
{
    //Method to print min data to screen
    public static void printMinToScreen(String[] minParts, long count)
    {
        //Minimum value is created and set to a high number.
        double minimum = 100000.0;
        double indexDouble;
        
        //String variables are created for each stock data category.
        String dateIndex = "";
        String tickerIndex = "";
        String openPriceIndex = "";
        String maximumIndex = "";
        String minimumIndex = "";
        String closingPriceIndex = "";
        String volumeIndex = "";
        
        //For loop that goes over each item in the data array.
        for (int index = 0; index < count; index++)
        {
            //Each item in the array is split by commas to create a new array.
            String[] splitLine = minParts[index].split(",");
            //This checks to make sure that a stock's low price is not left empty.
            //A problem occurs when the main file is loaded and this check is not
            //included.
            if (!splitLine[4].equals(""))
            {
                //A variable is created which converts the stock's low price data
                //from a string to a double.
                indexDouble = Double.parseDouble(splitLine[4]);
                //If the stock's low price is less than the minimum, it becomes the new minimum.
                if (indexDouble < minimum)
                {
                    minimum = indexDouble;
                    //The other data categories of the lowest price stock are updated.
                    dateIndex = splitLine[0];
                    tickerIndex = splitLine[1];
                    openPriceIndex = splitLine[2];
                    maximumIndex = splitLine[3];
                    minimumIndex = splitLine[4];
                    closingPriceIndex = splitLine[5];
                    volumeIndex = splitLine[6];
                }
            }
        }
        //After the lowest price stock is found, the data array is read through again
        //to find how many transactions the company that stock belongs to have made.
        int stockTransactions = 0;
        for (int index = 0; index < count; index++)
        {
            String[] splitLine = minParts[index].split(",");
            if (tickerIndex.equals(splitLine[1]))
            {
                stockTransactions++;
            }
        }
        //Information is printed to the user.
        System.out.println("Minimum Closing Stock Information");
        System.out.println("Date:           " + dateIndex);
        System.out.println("Ticker:         " + tickerIndex);
        System.out.println("Open price:     " + openPriceIndex);
        System.out.println("High price:     " + maximumIndex);
        System.out.println("Low price:      " + minimumIndex);
        System.out.println("Closing price:  " + closingPriceIndex);
        System.out.println("Volume:         " + volumeIndex);
        System.out.println(tickerIndex + " stock transactions: " + stockTransactions);
    }

    //Method to print max data to screen
    public static void printMaxToScreen(String[] maxParts, long count)
    {
        //This method functions the same as the printMinToScreen method, but it
        //finds the stock with the highest price and prints its data rather than
        //the stock with the lowest price.
        int lineCount = (int)count;
        
        double maximum = 0;
        double indexDouble;
        
        String dateIndex = "";
        String tickerIndex = "";
        String openPriceIndex = "";
        String maximumIndex = "";
        String minimumIndex = "";
        String closingPriceIndex = "";
        String volumeIndex = "";
        
        for (int index = 0; index < lineCount; index++)
        {
            String[] splitLine = maxParts[index].split(",");
            if (!splitLine[3].equals(""))
            {
                indexDouble = Double.parseDouble(splitLine[3]);
                if (indexDouble > maximum)
                {
                    maximum = indexDouble;
                    dateIndex = splitLine[0];
                    tickerIndex = splitLine[1];
                    openPriceIndex = splitLine[2];
                    maximumIndex = splitLine[3];
                    minimumIndex = splitLine[4];
                    closingPriceIndex = splitLine[5];
                    volumeIndex = splitLine[6];
                }
            }
        }
        int stockTransactions = 0;
        for (int index = 0; index < lineCount; index++)
        {
            String[] splitLine = maxParts[index].split(",");
            if (tickerIndex.equals(splitLine[1]))
            {
                stockTransactions++;
            }
        }
        System.out.println("Maximum Closing Stock Information");
        System.out.println("Date:           " + dateIndex);
        System.out.println("Ticker:         " + tickerIndex);
        System.out.println("Open price:     " + openPriceIndex);
        System.out.println("High price:     " + maximumIndex);
        System.out.println("Low price:      " + minimumIndex);
        System.out.println("Closing price:  " + closingPriceIndex);
        System.out.println("Volume:         " + volumeIndex);
        System.out.println(tickerIndex + " stock transactions: " + stockTransactions); 
    }

    //Method to find and print average volumes
    public static void findandPrintAverage(long count, long total)
    {
        //The total number of stocks, the total daily volumes, and the average
        //volumes per stock are printed to the user.
        System.out.println("Number of stock: " + count);
        System.out.println("Stock volume totals: " + total);
        System.out.println("Average volumes: " + (total / count));
    }

    //Method to print min data to file
    public static void printMinToFile(String[] minParts, PrintWriter file)
    {
        //This method functions the exact same as the printMinToScreen method,
        //but it writes the information to the output file rather than printing
        //it to the user's screen.
        
        //A line count variable is created that is equal to the array's length.
        int lineCount = minParts.length;
        
        double minimum = 100000.0;
        double indexDouble;
        
        String dateIndex = "";
        String tickerIndex = "";
        String openPriceIndex = "";
        String maximumIndex = "";
        String minimumIndex = "";
        String closingPriceIndex = "";
        String volumeIndex = "";
        
        for (int index = 0; index < lineCount; index++)
        {
            String[] splitLine = minParts[index].split(",");
            if (!splitLine[4].equals(""))
            {
                indexDouble = Double.parseDouble(splitLine[4]);
                if (indexDouble < minimum)
                {
                    minimum = indexDouble;
                    dateIndex = splitLine[0];
                    tickerIndex = splitLine[1];
                    openPriceIndex = splitLine[2];
                    maximumIndex = splitLine[3];
                    minimumIndex = splitLine[4];
                    closingPriceIndex = splitLine[5];
                    volumeIndex = splitLine[6];
                }
            }
        }
        int stockTransactions = 0;
        for (int index = 0; index < lineCount; index++)
        {
            String[] splitLine = minParts[index].split(",");
            if (tickerIndex.equals(splitLine[1]))
            {
                stockTransactions++;
            }
        }
        file.println("Minimum Closing Stock Information");
        file.println("Date:           " + dateIndex);
        file.println("Ticker:         " + tickerIndex);
        file.println("Open price:     " + openPriceIndex);
        file.println("High price:     " + maximumIndex);
        file.println("Low price:      " + minimumIndex);
        file.println("Closing price:  " + closingPriceIndex);
        file.println("Volume:         " + volumeIndex);
        file.println(tickerIndex + " stock transactions: " + stockTransactions);
        file.println("");
    }

    //Method to print max data to file
    public static void printMaxToFile(String[] maxParts, PrintWriter file)
    {
        //This method functions the exact same as the printMaxToScreen method,
        //but it writes the information to the output file rather than printing
        //it to the user's screen.
        
        //A line count variable is created that is equal to the array's length.
        int lineCount = maxParts.length;
        
        double maximum = 0;
        double indexDouble;
        
        String dateIndex = "";
        String tickerIndex = "";
        String openPriceIndex = "";
        String maximumIndex = "";
        String minimumIndex = "";
        String closingPriceIndex = "";
        String volumeIndex = "";
        
        for (int index = 0; index < lineCount; index++)
        {
            String[] splitLine = maxParts[index].split(",");
            if (!splitLine[3].equals(""))
            {
                indexDouble = Double.parseDouble(splitLine[3]);
                if (indexDouble > maximum)
                {
                    maximum = indexDouble;
                    dateIndex = splitLine[0];
                    tickerIndex = splitLine[1];
                    openPriceIndex = splitLine[2];
                    maximumIndex = splitLine[3];
                    minimumIndex = splitLine[4];
                    closingPriceIndex = splitLine[5];
                    volumeIndex = splitLine[6];
                }
            }
        }
        int stockTransactions = 0;
        for (int index = 0; index < lineCount; index++)
        {
            String[] splitLine = maxParts[index].split(",");
            if (tickerIndex.equals(splitLine[1]))
            {
                stockTransactions++;
            }
        }
        file.println("Maximum Closing Stock Information");
        file.println("Date:           " + dateIndex);
        file.println("Ticker:         " + tickerIndex);
        file.println("Open price:     " + openPriceIndex);
        file.println("High price:     " + maximumIndex);
        file.println("Low price:      " + minimumIndex);
        file.println("Closing price:  " + closingPriceIndex);
        file.println("Volume:         " + volumeIndex);
        file.println(tickerIndex + " stock transactions: " + stockTransactions);
        file.println("");
    }

    //method to print average data to file
    public static void findandPrintAverageToFile(long count, long total, PrintWriter file)
    {
        //This method functions the exact same as the findandPrintAverageToFile method,
        //but it writes the information to the output file rather than printing
        //it to the user's screen.
        file.println("Number of stock: " + count);
        file.println("Stock volume totals: " + total);
        file.println("Average volumes: " + (total / count));
    }
    
    public static void main(String[] args) throws Exception
    {
        //JFileChooser method allows the user to choose their input file.
        //Their file must be formatted correctly in order to work with this program.
        JButton open = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setDialogTitle("Please select a file");
        if (fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION)
        {
            //
        }
        
        //The chosen file becomes the input file and the output file is created.
        Scanner fileInput = new Scanner(fileChooser.getSelectedFile());
        PrintWriter fileWriter = new PrintWriter("SP500output.txt");
        
        //An array list is created which does not require its length to be specified before use.
        ArrayList<String> dataArrayList = new ArrayList<>();
        int lineCount = 0;
        long totalVolume = 0;
        
        //Each line in the input file is read and added to the array list.
        while (fileInput.hasNextLine())
        {
            String currentLine = fileInput.nextLine();
            dataArrayList.add(currentLine);
            //Each stock's volume for the day is split from the other data and
            //recorded for later use.
            String[] splitLine = currentLine.split(",");
            totalVolume = totalVolume + Integer.parseInt(splitLine[6]);    
            lineCount++;
        }
        
        //An array is created that has the same data as the array list, which will
        //not be used for anything else.
        String[] dataList = new String[lineCount];
        dataList = dataArrayList.toArray(dataList);

        //Using the gathered data, the user is informed of the stocks with the highest
        //and lowest prices, as well as the average daily volumes per stock.
        //This information is also written to the output file.
        System.out.println("Standard and Poor's Data");
        System.out.println("");
        printMinToScreen(dataList, lineCount);
        System.out.println("");
        printMaxToScreen(dataList, lineCount);
        System.out.println("");
        findandPrintAverage(lineCount, totalVolume);
        printMinToFile(dataList, fileWriter);
        printMaxToFile(dataList, fileWriter);
        findandPrintAverageToFile(lineCount, totalVolume, fileWriter);
        
        //Input and output files are closed.
        fileInput.close();
        fileWriter.close();
    }
}
