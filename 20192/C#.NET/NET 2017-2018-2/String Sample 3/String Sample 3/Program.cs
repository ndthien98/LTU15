using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace String_Sample_3
{
    class Program
    {
        static String url = "http://www.devbg.org/forum/index.php";
        static void Main(string[] args)
        {
            int i = url.IndexOf("://");
            Console.WriteLine("Protocol: {0}", url.Substring(0, i));
            int j = url.IndexOf("/", i + 3);
            Console.WriteLine("Server: {0}", url.Substring(i + 3, j - i - 3));
            Console.WriteLine("Resource: {0}", url.Substring(j));
            String pattern = @"([\s\S]*?)://([\s\S]*?)/([\s\S]*)";
            var m = Regex.Match(url, pattern);
            Console.WriteLine(m.Groups[1].Value);
            Console.WriteLine(m.Groups[2].Value);
            Console.WriteLine(m.Groups[3].Value);
        }
    }
}
