using System;
namespace HelloWorld
{
    public class Bai2ForLoop
    {
        public Bai2ForLoop()
        {
            Console.WriteLine("Bai tap 2 - Nguyen Duc Thien 20168806");
            Console.WriteLine(@"S = 1 + 1!/X + 2!/X2 + … + N!/XN ");
            Console.Write("Nhap N: ");
            int N = Int16.Parse(Console.ReadLine());
            Console.Write("Nhap x: ");
            int x = Int16.Parse(Console.ReadLine());

            double sum = 0;
            for (int i = 1; i <= N; i++)
            {
                sum += giaithua(i) / Math.Pow(x, i);
            }
            Console.WriteLine("Tong S : " + sum);
        }
        public double giaithua(int d)
        {
            double ans = 1;
            for (int i = 1; i <= d; i++)
            {
                ans *= i;
            }
            return ans;
        }
    }
}
