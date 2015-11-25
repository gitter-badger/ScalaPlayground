package org.panik

import org.organic.meal.Config

import scala.io.Source
import java.io.File
import java.nio.file._

/**
 * Created by anthonygaro on 9/11/15.
 */
object HelloPanik {
  def main(args: Array[String]) {
    println("Hello, Panik!")
//    val t = new Config() //line is supposed to fail

    print("Enter Number: ")
    //val i = scala.io.StdIn.readInt()
    println("Exiting")

    val source1 = Source.fromURL("http://horstmann.com", "UTF-8")
    println(source1.mkString)

//    for (d <- subdirs(new File("/Users/anthonygaro/Apps")))  println(d)
    val dir = new File("/Users/anthonygaro/Apps")
//    Files.walkFileTree( dir.toPath, (f: Path) => println(f) )

    Files.walkFileTree( dir.toPath, new SimpleFileVisitor[Path] {
      override def visitFile(p: Path, attrs: attribute.BasicFileAttributes) = {
       // println(p)
        FileVisitResult.CONTINUE
      }
    })

    implicit def makeFileVisitor(f: (Path) => Unit) = new SimpleFileVisitor[Path] {
      override def visitFile(p: Path, attrs: attribute.BasicFileAttributes) = {
        f(p)
        FileVisitResult.CONTINUE
      }
    }

    import sys.process._
    val cmd = "ls -al"
    val p = Process(cmd, dir)
    println(p.run) //will run command

    val cmd2 = "ls -al .." ! //will run command


  }


  def subdirs(dir: File): Iterator[File] = {
    val children = dir.listFiles.filter(_.isDirectory)
    children.toIterator ++ children.toIterator.flatMap(subdirs _)
  }



}
