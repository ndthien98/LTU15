using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace String_Sample_1
{
    class Program
    {
        static String text = "We are living in a yellow submarine. We don't  anything else. Inside the submarine is very tight So we are drinking all the day. We will move out of it in 5 days.";
        static String word = "in";
        static void Main(string[] args)
        {
            String pattern = @"([^\.]*) in ([^\.]*).";
            var matches = Regex.Matches(text, pattern);
            foreach (Match m in matches)
            {
                Console.WriteLine(m.Value);
                Console.WriteLine("Left: {0}", m.Groups[1].Value);
                Console.WriteLine("Right: {0}", m.Groups[2].Value);
            }

            char[] seperator = new char[] { '.' };
            var sentences = text.Split(seperator, 
                                        StringSplitOptions.RemoveEmptyEntries);
            for (int i = 0; i < sentences.Length;i++)
            {
                sentences[i] = sentences[i].Trim();
                if (sentences[i].ToLower().Contains(" " + word.ToLower()))
                {
                    Console.WriteLine(sentences[i]);
                }else if (sentences[i].ToLower().Contains(word.ToLower() + " "))
                {
                    Console.WriteLine(sentences[i]);
                }
            }

            foreach (var s in sentences)
            {
                var s_trimmed = s.Trim();
                if (s_trimmed.ToLower().IndexOf(" " + word.ToLower()) >= 0)
                {
                    Console.WriteLine("{0}", s_trimmed);
                }else if (s_trimmed.ToLower().IndexOf(word.ToLower() + " ") >= 0)
                {
                    Console.WriteLine("{0}", s_trimmed);
                }
            }
        }
    }
}
