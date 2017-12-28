using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Grafico.servicios;

namespace Grafico
{
    public partial class Perfil : System.Web.UI.Page
    {
        Servicicios ser;

        protected void Page_Load(object sender, EventArgs e)
        {
            ser = new Servicicios();
            actualizar();
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            ser.Agregar_estado(testado.Text);
            testado.Text = "";
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            actualizar();
        }

        protected void actualizar() {
            String contenido = ser.Publicar_Estado();
            char[] limite = { ';' };
            String[] palabras = contenido.Split(limite);

            tlistaEstado.Text = "";

            foreach (String s in palabras)
            {
                tlistaEstado.Text += "-  " + s + System.Environment.NewLine + System.Environment.NewLine;
            }
        }

        protected void Button5_Click(object sender, EventArgs e)
        {
            Response.Redirect("/Inicio.aspx");
        }
    }
}