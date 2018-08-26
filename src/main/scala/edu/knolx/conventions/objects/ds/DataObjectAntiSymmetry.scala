package edu.knolx.conventions.objects.ds

case class Point(x: Int, y: Int)

class Data {

  trait Shape

  case class Square(topLeft: Point, side: Double) extends Shape

  case class Rectangle(topLeft: Point, height: Double, width: Double) extends Shape

  case class Circle(center: Point, radius: Double) extends Shape

  // case class Rhombus(center: Point, radius: Double) extends Shape

  class Geometry {
    final val PI = 3.141592653589793

    def area(shape: Shape): Double = {
      shape match {
        case square: Square => square.side * square.side
        case rectangle: Rectangle => rectangle.height * rectangle.width
        case circle: Circle => PI * circle.radius * circle.radius
        // case rhombus: Rhombus => PI * rh.radius * rh.radius
      }
    }

    //def volume(shape: Shape): Double = ???
  }

}

class Objects {

  trait Shape {
    def area: Double

    // def volume: Double
  }

  class Square(topLeft: Point, side: Double) extends Shape {
    override def area: Double = side * side
  }

  class Rectangle(topLeft: Point, height: Double, width: Double) extends Shape {
    override def area: Double = height * width
  }

  class Circle(center: Point, radius: Double) extends Shape {
    final val PI = 3.141592653589793

    override def area: Double = PI * radius * radius
  }

  // Need to add only a new class extending Shape trait for new shapes (extension not modification)

  class Geometry {
    def area(shape: Shape): Double = shape.area

    ???
  }
}
