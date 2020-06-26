using System;
using System.Text;

namespace Assignment2
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = "Microsoft announced its next generation PHP compiler today. It is based on .NET Framework 4.0 and is implemented as a dynamic language in CLR.";
            Console.WriteLine("Original string: ");
            Console.WriteLine(str);
            string[] words = new string[3];
            words[0] = "Microsoft";
            words[1] = "PHP";
            words[2] = "CLR";

            Console.WriteLine("Replaced string");
            Console.WriteLine(replace(str,words));
            
        }
        static string replace(string input, string[] words)
        {
            StringBuilder dot = new StringBuilder("*");
            StringBuilder sb = new StringBuilder(input);
            foreach(string w in words)
            {
                while (dot.Length < w.Length)
                {
                    dot.Append("*");
                }
                sb.Replace(w, dot.ToString(0,w.Length));

            }
            return sb.ToString();
        }
    }
}
