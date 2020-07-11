using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WpfApp1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {        
        public MainWindow()
        {
            InitializeComponent();
            this.DataContext = App.AppVM;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Button clickedButton = sender as Button;
            if (clickedButton.Content.ToString() == "+")
            {

            }else if (clickedButton.Content.ToString() == "-")
            {

            }else if (clickedButton.Content.ToString() == "x")
            {

            }else if (clickedButton.Content.ToString() == "/")
            {

            }else if (clickedButton.Content.ToString() == "=")
            {

            }else if (clickedButton.Content.ToString() == ".")
            {

            }else
            {
                int digit = int.Parse(clickedButton.Content.ToString());
                double value = double.Parse(App.AppVM.Value);
                value = value * 10 + digit;
                App.AppVM.Value = value.ToString();
            }
        }
    }
}
