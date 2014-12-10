
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Meta],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(metas: List[Meta]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.21*/("""

"""),_display_(/*3.2*/main("Metas Semanais")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""
    """),format.raw/*4.5*/("""<html xmlns="http://www.w3.org/1999/html">
        <head>
            <title>Minhas Metas</title>
            <meta charset="UTF-8">
            <link href=""""),_display_(/*8.26*/routes/*8.32*/.Assets.at("stylesheets/bootstrap.css")),format.raw/*8.71*/("""" rel="stylesheet" media="screen">
            <script src=""""),_display_(/*9.27*/routes/*9.33*/.Assets.at("javascripts/jquery-2.1.1.min.js")),format.raw/*9.78*/(""""></script>
            <script src=""""),_display_(/*10.27*/routes/*10.33*/.Assets.at("javascripts/myjs.js")),format.raw/*10.66*/(""""></script>
            <script src=""""),_display_(/*11.27*/routes/*11.33*/.Assets.at("javascripts/bootstrap.min.js")),format.raw/*11.75*/(""""></script>
            <script src=""""),_display_(/*12.27*/routes/*12.33*/.Assets.at("javascripts/inputvalidator.js")),format.raw/*12.76*/(""""></script>

        </head>
        <body>
            <div class="container">
                <div class="page-header">
                    <h1>WeekList
                        <small>O jeito mais fácil de organizar suas metas semanais. </small>
                    </h1>
                </div>
                <br>


                <div class="col-md-6" id="criaMeta">
                    <section class="panel panel-info">
                        <header class="panel-heading">
                            <h2 class="panel-title">Criar nova meta da Semana</h2>
                        </header>
                    <div class="panel-body">
                        <form role="form" action=""""),_display_(/*31.52*/routes/*31.58*/.Application.novaMeta()),format.raw/*31.81*/("""" method="post">
                            <div class="form-group">
                                <label for="meta">Nome</label>
                                <input type="text" class="form-control" name="nome" placeholder="Digite o nome da Meta"  required data-validation-required-message="Por favor digite um nome para a sua meta.">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Prazo <small>1º, 2º, 3º ou 4º semana do mês (coloque só o número).</small></label>
                                <input type="number" class="form-control" name="prazo" placeholder="Digite um prazo de 1 a 4"  required data-validation-required-message="Por favor digite um prazo de 1 a 4." min="1" max="4">
                            </div>
                            <div class="form-group">
                                <label for="prioridade">Prioridade</label>
                                <select class="form-control" name="prioridade">
                                    <option>Alta</option>
                                    <option>Média</option>
                                    <option>Baixa</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Descrição</label>
                                <input type="text" class="form-control" name="descricao" placeholder="Digite uma descricao"  required data-validation-required-message="Por favor digite uma descrição para a sua meta.">
                            </div>
                            <input type="submit" class="btn btn-info" value="Criar Meta">
                        </form><br><br>
                    </div>
                        </section>
                </div>


                <div class="col-md-6">
                    <section class="panel panel-info">
                    <header class="panel-heading">
                        <h2 class="panel-title">Minhas Metas</h2>
                    </header>
                    <div class="panel-body" id ="divMeta">
                    <p>Crie metas e as organize. Suas metas estão ordenadas por semana e logo em seguida
                        por prioridade. No total, você possui """),_display_(/*66.64*/metas/*66.69*/.size),format.raw/*66.74*/(""" """),format.raw/*66.75*/("""metas. </p>
                    <hr>
                    """),_display_(/*68.22*/if(metas.isEmpty)/*68.39*/ {_display_(Seq[Any](format.raw/*68.41*/("""
                        """),format.raw/*69.25*/("""Nenhuma meta cadastrada.
                    """)))}/*70.23*/else/*70.28*/{_display_(Seq[Any](format.raw/*70.29*/("""
                        """),format.raw/*71.25*/("""<ol class="list-group" id="metas">
                        """),_display_(/*72.26*/for(meta <- metas) yield /*72.44*/ {_display_(Seq[Any](format.raw/*72.46*/("""
                            """),_display_(/*73.30*/if(!meta.isAlcancada)/*73.51*/{_display_(Seq[Any](format.raw/*73.52*/("""
                                """),format.raw/*74.33*/("""<ul><b>"""),_display_(/*74.41*/meta/*74.45*/.getNome()),format.raw/*74.55*/("""</b><br>
                                    <u>Descrição:</u> """),_display_(/*75.56*/meta/*75.60*/.getDescricao()),format.raw/*75.75*/("""<br>
                                    <u>Semana:</u> """),_display_(/*76.53*/meta/*76.57*/.getSemana()),format.raw/*76.69*/("""<br>
                                    <u>Prioridade:</u> """),_display_(/*77.57*/meta/*77.61*/.getPrioridade()),format.raw/*77.77*/("""<br><br>

                                    <form action=""""),_display_(/*79.52*/routes/*79.58*/.Application.deleteMetas(meta.getId())),format.raw/*79.96*/("""" method="post">
                                        <input type="submit" class="btn btn-danger" value="Desistir">
                                    </form>
                                    <form action=""""),_display_(/*82.52*/routes/*82.58*/.Application.alcancarMeta(meta.getId())),format.raw/*82.97*/("""" method="post">
                                        <input type="submit" class="btn btn-success" value="Cumprir Meta">
                                    </form>
                                </ul>
                                <br>
                                """)))}),format.raw/*87.34*/("""
                        """)))}),format.raw/*88.26*/("""
                        """),format.raw/*89.25*/("""</ol>
                    """)))}),format.raw/*90.22*/("""


                """),format.raw/*93.17*/("""</div> </section> </div>
            </div>
            <br>
            <div class="container">
                    <div class="col-md-12">
                        <section class="panel panel-success">
                            <header class="panel-heading">
                                <h2 class="panel-title">Metas Concluídas</h2>
                            </header>
                        <div class="panel-body">
                            As metas que você marcou como concluídas aparecerão aqui, também ordenadas por prazo e logo em seguida por prioridade.
                            <hr>
                                        """),_display_(/*105.42*/if(metas.isEmpty)/*105.59*/ {_display_(Seq[Any](format.raw/*105.61*/("""
                        """),format.raw/*106.25*/("""Nenhuma meta cadastrada.
                    """)))}/*107.23*/else/*107.28*/{_display_(Seq[Any](format.raw/*107.29*/("""
                        """),format.raw/*108.25*/("""<ol class="list-group">
                        """),_display_(/*109.26*/for(meta <- metas) yield /*109.44*/ {_display_(Seq[Any](format.raw/*109.46*/("""
                            """),_display_(/*110.30*/if(meta.isAlcancada)/*110.50*/{_display_(Seq[Any](format.raw/*110.51*/("""
                                """),format.raw/*111.33*/("""<ul><b>"""),_display_(/*111.41*/meta/*111.45*/.getNome()),format.raw/*111.55*/("""</b><br>
                                    <u>Descrição:</u> """),_display_(/*112.56*/meta/*112.60*/.getDescricao()),format.raw/*112.75*/("""<br>
                                    <u>Semana:</u> """),_display_(/*113.53*/meta/*113.57*/.getSemana()),format.raw/*113.69*/("""<br>
                                    <u>Prioridade:</u> """),_display_(/*114.57*/meta/*114.61*/.getPrioridade()),format.raw/*114.77*/("""<br>
                                </ul>
                            </ol>

                    """)))}),format.raw/*118.22*/("""
                    """)))}),format.raw/*119.22*/("""
                    """)))}),format.raw/*120.22*/("""
                """),format.raw/*121.17*/("""</div></section></div></div>
            <br><br><br>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
            <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        </body>
    </html>
""")))}),format.raw/*128.2*/("""



"""))}
  }

  def render(metas:List[Meta]): play.twirl.api.HtmlFormat.Appendable = apply(metas)

  def f:((List[Meta]) => play.twirl.api.HtmlFormat.Appendable) = (metas) => apply(metas)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Dec 10 17:54:29 GMT-03:00 2014
                  SOURCE: C:/Users/M/Desktop/si1-lab2/app/views/index.scala.html
                  HASH: af7bbc126f85198966355ed4f60e5f0490fb5ac0
                  MATRIX: 727->1|834->20|864->25|894->47|933->49|965->55|1153->217|1167->223|1226->262|1314->324|1328->330|1393->375|1459->414|1474->420|1528->453|1594->492|1609->498|1672->540|1738->579|1753->585|1817->628|2559->1343|2574->1349|2618->1372|5019->3746|5033->3751|5059->3756|5088->3757|5175->3817|5201->3834|5241->3836|5295->3862|5361->3910|5374->3915|5413->3916|5467->3942|5555->4003|5589->4021|5629->4023|5687->4054|5717->4075|5756->4076|5818->4110|5853->4118|5866->4122|5897->4132|5989->4197|6002->4201|6038->4216|6123->4274|6136->4278|6169->4290|6258->4352|6271->4356|6308->4372|6398->4435|6413->4441|6472->4479|6716->4696|6731->4702|6791->4741|7103->5022|7161->5049|7215->5075|7274->5103|7324->5125|8012->5785|8039->5802|8080->5804|8135->5830|8202->5878|8216->5883|8256->5884|8311->5910|8389->5960|8424->5978|8465->5980|8524->6011|8554->6031|8594->6032|8657->6066|8693->6074|8707->6078|8739->6088|8832->6153|8846->6157|8883->6172|8969->6230|8983->6234|9017->6246|9107->6308|9121->6312|9159->6328|9294->6431|9349->6454|9404->6477|9451->6495|9778->6791
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|59->31|59->31|59->31|94->66|94->66|94->66|94->66|96->68|96->68|96->68|97->69|98->70|98->70|98->70|99->71|100->72|100->72|100->72|101->73|101->73|101->73|102->74|102->74|102->74|102->74|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|107->79|107->79|107->79|110->82|110->82|110->82|115->87|116->88|117->89|118->90|121->93|133->105|133->105|133->105|134->106|135->107|135->107|135->107|136->108|137->109|137->109|137->109|138->110|138->110|138->110|139->111|139->111|139->111|139->111|140->112|140->112|140->112|141->113|141->113|141->113|142->114|142->114|142->114|146->118|147->119|148->120|149->121|156->128
                  -- GENERATED --
              */
          