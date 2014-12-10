// @SOURCE:C:/Users/M/Documents/GitHub/metas/conf/routes
// @HASH:644f53abb0e4b2c17f63aa7693c51a4885872839
// @DATE:Wed Dec 10 20:06:47 GMT-03:00 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:14
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:14
class ReverseAssets {


// @LINE:14
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def novaMeta(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "metas")
}
                        

// @LINE:10
def alcancarMeta(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "metas/" + implicitly[PathBindable[Long]].unbind("id", id) + "/concluir")
}
                        

// @LINE:7
def metas(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "metas")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:9
def deleteMetas(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "metas/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                        

}
                          
}
                  


// @LINE:14
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:14
class ReverseAssets {


// @LINE:14
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def novaMeta : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.novaMeta",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "metas"})
      }
   """
)
                        

// @LINE:10
def alcancarMeta : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.alcancarMeta",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "metas/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/concluir"})
      }
   """
)
                        

// @LINE:7
def metas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.metas",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "metas"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:9
def deleteMetas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteMetas",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "metas/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

}
              
}
        


// @LINE:14
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:14
class ReverseAssets {


// @LINE:14
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def novaMeta(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.novaMeta(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "novaMeta", Seq(), "POST", """""", _prefix + """metas""")
)
                      

// @LINE:10
def alcancarMeta(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.alcancarMeta(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "alcancarMeta", Seq(classOf[Long]), "POST", """""", _prefix + """metas/$id<[^/]+>/concluir""")
)
                      

// @LINE:7
def metas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.metas(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "metas", Seq(), "GET", """""", _prefix + """metas""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:9
def deleteMetas(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteMetas(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteMetas", Seq(classOf[Long]), "POST", """""", _prefix + """metas/$id<[^/]+>/delete""")
)
                      

}
                          
}
        
    