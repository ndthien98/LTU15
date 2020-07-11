using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace String_Sample_4
{
    class Program
    {
        static String html = "<p>Please visit <a href=\"http://academy.telerik.com\">our site</a> to choose a training course. Also visit<a href=\"www.devbg.org\"> our forum</a> to discuss the courses.</p>";
        static void Main(string[] args)
        {
            String ahref = "<a href=\"";
            while (html.Contains(ahref))
            {
                int i = html.IndexOf(ahref) + ahref.Length;
                int j = html.IndexOf("\"", i);
                String link = html.Substring(i, j - i);
                int k = html.IndexOf(">", j);
                int p = html.IndexOf("</a>", k);
                String text = html.Substring(k + 1, p - k - 1);
                i = i - ahref.Length;
                String newString = html.Substring(0, i) +
                                    String.Format("[URL={0}]{1}[/URL]", link, text) +
                                    html.Substring(p + "</a>".Length);
                html = newString;
            }
            Console.WriteLine(html);
        }
    }
}
