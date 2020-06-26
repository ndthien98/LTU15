using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace String_Sample_2
{
    class Program
    {
        static String text = "Microsoft announced its next generation PHP compiler today.It is based on .NET Framework 4.0 and is implemented as a dynamic language in CLR.";
        static String words = "PHP, CLR, Microsoft";
        static void Main(string[] args)
        {
            var splittedWords = words.Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries);
            String[] hiddenWords = new string[splittedWords.Length];
            for (int i = 0;i < splittedWords.Length;i++)
            {
                splittedWords[i] = splittedWords[i].Trim().ToLower();
                hiddenWords[i] = String.Empty;
                for (int j = 0;j < splittedWords[i].Length;j++)
                {
                    hiddenWords[i] += "*";
                }
            }
            for (int i = 0;i < splittedWords.Length;i++)
            {                
                var loweredText = text.ToLower();
                while (loweredText.IndexOf(splittedWords[i]) >= 0)
                {
                    int j = loweredText.IndexOf(splittedWords[i]);
                    var newText = text.Substring(0, j) + hiddenWords[i] + text.Substring(j + splittedWords[i].Length);
                    text = newText;
                    loweredText = text.ToLower();
                }
            }            
        }
    }
}
