using System;

namespace HelloWorld
{
    internal class Bai3Array
    {
        public Bai3Array()
        {
            Console.WriteLine("Bai tap 2 - Nguyen Duc Thien 20168806");
            Console.WriteLine("Selection Sort");
            int n;
            int[] arr;

            Console.Write("Input N: ");
            n = Int16.Parse(Console.ReadLine());

            arr = new int[n];
            Random rd = new Random();
            for (int i = 0; i < n; i++)
            {
                arr[i] = rd.Next(1, 100);
            }
            Console.Write("\nArray before sort: ");
            foreach (var e in arr)
            {
                Console.Write(e + "; ");
            }
            for (int i = 0; i < n-1; i++)
            {
                int min = arr[i];
                int p = i;
                for (int j = i+1; j < n; j++)
                {
                    if (arr[j] < min)
                    {
                        min = arr[j];
                        p = j;
                    }
                }
                Console.Write("\n" + i + ":" + p);
                arr[p] = arr[i];
                arr[i] = min;
            }
            Console.Write("\nArray after sort: ");
            foreach (var e in arr)
            {
                Console.Write(e + "; ");
            }
        }
    }
}