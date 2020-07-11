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

namespace WpfApp2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Random r = new Random();
        public MainWindow()
        {
            InitializeComponent();
            this.DataContext = App.AppVM;
            this.Loaded += MainWindow_Loaded;
        }

        private void MainWindow_Loaded(object sender, RoutedEventArgs e)
        {
            App.AppVM.Title = "COLOR LIST DEMONSTRATION";
            String[] colors = new String[]
            {
                "AliceBlue",
                "AntiqueWhite",
                "Aqua",
                "Aquamarine",
                "Azure",
                "Beige",
                "Bisque",
                "Black"
            };
            for (int j = 0; j < 40; j++)
            {
                int i = r.Next() % colors.Length;
                ColorItemViewModel item = new ColorItemViewModel();
                item.Color = colors[i];
                item.Name = colors[i].ToUpper();
                item.Desc = "This is " + colors[i].ToLower() + " color";
                App.AppVM.ColorItems.Add(item);
            }
        }        
    }
}
