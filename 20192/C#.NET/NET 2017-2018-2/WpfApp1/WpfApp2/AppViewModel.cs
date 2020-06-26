using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp2
{
    public class AppViewModel : INotifyPropertyChanged
    {
        public AppViewModel()
        {
            ColorItems = new ObservableCollection<ColorItemViewModel>();
        }
        public event PropertyChangedEventHandler PropertyChanged;
        public ObservableCollection<ColorItemViewModel> ColorItems { get; set; }
        private String _title;
        public String Title
        {
            get
            {
                return _title;
            }
            set
            {
                if (value != _title)
                {
                    _title = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChangedEventArgs arg = new PropertyChangedEventArgs("Title");
                        PropertyChanged(this, arg);
                    }
                }
            }
        }
    }
}
