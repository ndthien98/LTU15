using System;
namespace HelloWorld
{
    public class Bai1IfElseStatement
    {
        public Bai1IfElseStatement()
        {
            Console.WriteLine("Bai tap 1 - Nguyen Duc Thien 20168806");
            Console.Write("Giai phuong trinh bac 2: ax^2 + bx + c = 0 \nNhap vao a: ");
            double a = Double.Parse(Console.ReadLine());
            Console.Write("Nhap vao b: ");
            double b = Double.Parse(Console.ReadLine());
            Console.Write("Nhap vao c: ");
            double c = Double.Parse(Console.ReadLine());
            //Console.WriteLine(a + "; " + b + "; " + c);
            if (a == 0)
            {
                if (b == 0)
                {
                    if (c == 0)
                    {
                        Console.WriteLine("Phuong trinh vo so nghiem!");
                    }
                    else
                    {
                        Console.WriteLine("Phuong trinh vo nghiem!");
                    }
                }
                else
                {
                    Console.WriteLine("Phuong trinh 1 co nghiem la: " + (-c / b));
                }
            }
            else
            {
                double delta = b * b - 4 * a * c;
                if (delta < 0)
                {
                    Console.WriteLine("Phuong trinh vo nghiem!");
                }
                else if (delta == 0)
                {
                    Console.WriteLine("Phuong trinh co nghiem kep la: " + (-b / (2 * a)));
                }
                else
                {
                    Console.WriteLine("Phuong trinh co 2 nghiem: ");
                    Console.WriteLine("x1 = " + ((-b + Math.Sqrt(delta)) / (2 * a)));
                    Console.WriteLine("x2 = " + ((-b - Math.Sqrt(delta)) / (2 * a)));
                }
            }
        }
    }
}
