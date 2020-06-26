using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace WpfApp1
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        private static AppViewModel _appvm = null;
        public static AppViewModel AppVM
        {
            get
            {
                if (_appvm == null)
                {
                    _appvm = new AppViewModel();
                }
                return _appvm;
            }
        }
        protected override void OnExit(ExitEventArgs e)
        {
            //VIET THEM MA VAO DAY
            base.OnExit(e);
        }
    }
}
