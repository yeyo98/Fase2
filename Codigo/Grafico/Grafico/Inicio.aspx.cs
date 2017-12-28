using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Grafico.servicios;

namespace Grafico
{
    public partial class Inicio : System.Web.UI.Page
    {
        Servicicios ingresar;

        protected void Page_Load(object sender, EventArgs e)
        {
            ingresar = new Servicicios();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            int num = Int32.Parse(tcodigo.Text);
            ingresar.Agregar_Usuario(num, tnombre.Text, tcorreo.Text, tnacimiento.Text, tcontra.Text, tnick.Text);
        }

        protected void Button2_Click(object sender, EventArgs e)
        {

            if (ingresar.Login(tcorreU.Text, tcontraU.Text) == true)
            {
               // tnombre.Text = "si salio";
                
                Response.Redirect("/Perfil.aspx");
            }else if(tcorreU.Text.Equals("admin") && tcontraU.Text.Equals("admin")){

            }

        }
    }
}