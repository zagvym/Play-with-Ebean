name := """ebean-models"""

libraryDependencies ++= Seq(
  "org.avaje.ebeanorm" % "avaje-ebeanorm" % "3.3.4",
  "org.avaje.ebeanorm" % "avaje-ebeanorm-agent" % "3.2.2")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test")

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

lazy val enhanceTarget = "com/example/models/**"

lazy val enhanceOpts = "debug=1"

//Refer to https://github.com/playframework/playframework/blob/2.3.x/framework/project/Build.scala
compile in (Compile) <<= (dependencyClasspath in Compile, compile in Compile, classDirectory in Compile) map {
  (deps, analysis, classes) =>
    val cp = deps.map(_.data.toURL).toArray :+ classes.toURL
    val cl = new java.net.URLClassLoader(cp)
    val t = cl.loadClass("com.avaje.ebean.enhance.agent.Transformer").
        getConstructor(classOf[Array[URL]], classOf[String]).
        newInstance(cp, enhanceOpts).
        asInstanceOf[AnyRef]
    val ft = cl.loadClass("com.avaje.ebean.enhance.ant.OfflineFileTransform").
        getConstructor(t.getClass, classOf[ClassLoader], classOf[String], classOf[String]).
        newInstance(t, ClassLoader.getSystemClassLoader, classes.getAbsolutePath, classes.getAbsolutePath).asInstanceOf[AnyRef]
    ft.getClass.getDeclaredMethod("process", classOf[String]).invoke(ft, enhanceTarget)
    analysis
}