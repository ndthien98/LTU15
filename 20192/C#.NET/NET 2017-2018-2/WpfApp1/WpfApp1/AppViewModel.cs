using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp1
{
    public class AppViewModel : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        private String _value = "0";
        public String Value
        {
            get
            {
                return _value;
            }
            set
            {
                if (value != _value)
                {
                    _value = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChangedEventArgs arg = 
                            new PropertyChangedEventArgs("Value");
                        PropertyChanged(this, arg);
                    }
                }
            }
        }
    }
}
