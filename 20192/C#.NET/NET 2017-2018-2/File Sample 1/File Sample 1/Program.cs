using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace File_Sample_1
{
    class Program
    {
        static byte[] data = null;
        //static void ReadCompleted(IAsyncResult arg)
        //{
        //    FileStream fs = arg.AsyncState as FileStream;
        //    if (fs != null)
        //    {
        //        int byteRead  = fs.EndRead(arg);
        //        String str = Encoding.UTF8.GetString(data);
        //        Console.WriteLine(str);
        //    }
        //}
        static void Main(string[] args)
        {
            using (FileStream fs = File.Open("c:\\temp\\input.txt", FileMode.Open, FileAccess.ReadWrite))
            {
                data = new byte[fs.Length];
                //fs.BeginRead(data, 0, data.Length, ReadCompleted, fs);
                Task readingTask = fs.ReadAsync(data, 0, data.Length);
                readingTask.ContinueWith((x) =>
                {
                    String str = Encoding.UTF8.GetString(data);
                    Console.WriteLine(str);
                });
                /*using (StreamReader sr = new StreamReader(fs))
                {
                    while (sr.EndOfStream == false)
                    {
                        String line = sr.ReadLine();
                        Console.WriteLine(line);
                    }
                }*/
                while (0 == 0) ;
            }
        }
    }
}
