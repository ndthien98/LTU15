using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace String___Example_1
{
    class Program
    {
        static void Main(string[] args)
        {
            String s = "We are living in a <upcase>yellow submarine</upcase>. We don't have <upcase>anything</upcase> else.";
            String start = "<upcase>";
            String end = "</upcase>";
            int curPos = 0;
            int startIndex = 0;
            int endIndex = 0;
            do
            {
                startIndex = s.IndexOf(start, curPos);
                endIndex = s.IndexOf(end, startIndex);
                if (startIndex >= 0 && endIndex >= 0)
                {
                    var str = s.Substring(startIndex + 8, endIndex - startIndex - 8);
                    s = s.Replace(str, str.ToUpper());
                }                
                curPos += endIndex;
            } while (startIndex >= 0 && curPos < s.Length);
            s = s.Replace(start, String.Empty);
            s = s.Replace(end, String.Empty);
            Console.WriteLine(s);
        }
    }
}
