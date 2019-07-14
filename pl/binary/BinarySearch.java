package pl.binary;

import java.io.*;
import java.util.*;

public class BinarySearch
{
    private final static String path = "file";
    private static List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args)
    {
        //System.out.println(System.getProperty("user.dir"));
        openFile();

        while (!integerList.isEmpty())
        {
            int key = getKey();
            int index  = rank(key);
            //int index = Collections.binarySearch(integerList, key);
            if (index >= 0)
                System.out.println("Element " + key + " ma index: " +index);
            else
                System.out.println("Podany element nie został odnaleziony. Prosze spróbować jeszcze raz.\n");
        }
    }

    public static void openFile()
    {
        try
        {
            BufferedReader In = new BufferedReader(new FileReader(path));

            String numberText = null;

            while ((numberText = In.readLine() ) != null)
            {
                integerList.add(Integer.parseInt(numberText.trim()));
                Collections.sort(integerList);
            }
            In.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static int rank(int key)
    {
        int left = 0;
        int right = integerList.size() - 1;

        while (left <= right)
        {
            int middle = (left + right) / 2;

            if (integerList.get(middle) > key)
                right = middle - 1;
            else if (integerList.get(middle) < key)
                left = middle + 1;
            else
                return middle;
        }
        return -1;
    }

    public static int getKey()
    {
        Scanner integerScanner = new Scanner(System.in);
        System.out.println("Podaj liczbę do wyszukania w pliku " + path + ".txt");
        int key = integerScanner.nextInt();
        return key;
    }
}