// @SOURCE:C:/Users/M/Documents/GitHub/metas/conf/routes
// @HASH:644f53abb0e4b2c17f63aa7693c51a4885872839
// @DATE:Wed Dec 10 20:06:47 GMT-03:00 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_metas1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("metas"))))
private[this] lazy val controllers_Application_metas1_invoker = createInvoker(
controllers.Application.metas(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "metas", Nil,"GET", """""", Routes.prefix + """metas"""))
        

// @LINE:8
private[this] lazy val controllers_Application_novaMeta2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("metas"))))
private[this] lazy val controllers_Application_novaMeta2_invoker = createInvoker(
controllers.Application.novaMeta(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "novaMeta", Nil,"POST", """""", Routes.prefix + """metas"""))
        

// @LINE:9
private[this] lazy val controllers_Application_deleteMetas3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("metas/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Application_deleteMetas3_invoker = createInvoker(
controllers.Application.deleteMetas(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteMetas", Seq(classOf[Long]),"POST", """""", Routes.prefix + """metas/$id<[^/]+>/delete"""))
        

// @LINE:10
private[this] lazy val controllers_Application_alcancarMeta4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("metas/"),DynamicPart("id", """[^/]+""",true),StaticPart("/concluir"))))
private[this] lazy val controllers_Application_alcancarMeta4_invoker = createInvoker(
controllers.Application.alcancarMeta(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "alcancarMeta", Seq(classOf[Long]),"POST", """""", Routes.prefix + """metas/$id<[^/]+>/concluir"""))
        

// @LINE:14
private[this] lazy val controllers_Assets_at5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at5_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """metas""","""controllers.Application.metas()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """metas""","""controllers.Application.novaMeta()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """metas/$id<[^/]+>/delete""","""controllers.Application.deleteMetas(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """metas/$id<[^/]+>/concluir""","""controllers.Application.alcancarMeta(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_Application_metas1_route(params) => {
   call { 
        controllers_Application_metas1_invoker.call(controllers.Application.metas())
   }
}
        

// @LINE:8
case controllers_Application_novaMeta2_route(params) => {
   call { 
        controllers_Application_novaMeta2_invoker.call(controllers.Application.novaMeta())
   }
}
        

// @LINE:9
case controllers_Application_deleteMetas3_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_deleteMetas3_invoker.call(controllers.Application.deleteMetas(id))
   }
}
        

// @LINE:10
case controllers_Application_alcancarMeta4_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_alcancarMeta4_invoker.call(controllers.Application.alcancarMeta(id))
   }
}
        

// @LINE:14
case controllers_Assets_at5_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at5_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     