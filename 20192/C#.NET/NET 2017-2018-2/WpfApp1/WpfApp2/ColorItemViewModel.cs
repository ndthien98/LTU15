using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp2
{
    public class ColorItemViewModel : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        private String _color;
        public String Color
        {
            get { return _color; }
            set
            {
                if (value != _color)
                {
                    _color = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChangedEventArgs arg = new PropertyChangedEventArgs("Color");
                        PropertyChanged(this, arg);
                    }
                }
            }
        }
        private String _name;
        public String Name
        {
            get { return _name; }
            set
            {
                if (value != _name)
                {
                    _name = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChangedEventArgs arg = new PropertyChangedEventArgs("Name");
                        PropertyChanged(this, arg);
                    }
                }
            }
        }
        private String _desc;
        public String Desc
        {
            get { return _desc; }
            set
            {
                if (value != _desc)
                {
                    _desc = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChangedEventArgs arg = new PropertyChangedEventArgs("Desc");
                        PropertyChanged(this, arg);
                    }
                }
            }
        }
    }
}
