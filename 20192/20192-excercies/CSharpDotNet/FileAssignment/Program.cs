using System;
using System.Collections.Generic;
using System.IO;

namespace FileAssignment
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            /*
             Write a program that reads a list of words from a file words.txt
             and finds how many times each of the words is contained in another
             file test.txt. The result should be written in the file result.txt
             and the words should be sorted by the number of their occurrences
             in descending order. Handle all possible exceptions in your methods.
             */

            string InputFilePath = @"/Users/thiennd/Desktop/study-documents/20192/20192-excercies/CSharpDotNet/FileAssignment/test.txt";
            string OutputFilePath = @"/Users/thiennd/Desktop/study-documents/20192/20192-excercies/CSharpDotNet/FileAssignment/result.txt";

            try
            {
                StreamReader streamReader;
                Dictionary<string, int> hashtable = new Dictionary<string, int>();
                using (streamReader = new StreamReader(InputFilePath))
                {
                    string[] words;
                    string input = streamReader.ReadToEnd();
                    input = input.Replace(Environment.NewLine, " ");
                    input = input.Replace("\t", " ");
                    while (input.Contains("  "))
                    {
                        input = input.Replace("  ", " ");
                    }
                    words = input.Split(" ");
                    foreach (string word in words)
                    {
                        int value;
                        if (hashtable.TryGetValue(word, out value))
                        {
                            value = hashtable[word];
                            hashtable.Remove(word);
                            hashtable.Add(word, value + 1);
                        }
                        else
                        {
                            hashtable.Add(word, 1);
                        }
                    }
                }

                StreamWriter streamWriter;
                using (streamWriter = new StreamWriter(OutputFilePath))
                {
                    string[] keys = new string[hashtable.Count];
                    hashtable.Keys.CopyTo(keys, 0);
                    int[] values = new int[hashtable.Count];
                    hashtable.Values.CopyTo(values, 0);

                    Array.Sort(values, keys);
                    for (int i = keys.Length - 1; i >= 0; i--)
                    {
                        streamWriter.WriteLine("Word: {0,-30} \t-\tRepeat: {1}", keys[i], values[i]);
                    }
                }
            }
            catch (FileNotFoundException e)
            {
                Console.WriteLine("File not found: " +e.Message);
            }
        }
    }
}
