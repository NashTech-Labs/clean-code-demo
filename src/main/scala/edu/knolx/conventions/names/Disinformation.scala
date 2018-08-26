package edu.knolx.conventions.names

class Disinformation{

  case class Triangle(sides: List[Int], isRightAngle: Boolean){
    require(sides.size == 3, "A triangle must have 3 sides")

    val hp: Option[Int] = if(isRightAngle) Some(sides.max) else None //  What is hp??

    ???
  }

  def getPrintableAddress(title: String, firstName: String, lastName: String, street : String, houseNumber: String,
                          city: String, state: String, zipCode: Int): String = {
    s"$title $firstName $lastName\n$houseNumber, $street\n$city, $state(zip: $zipCode)"
  }
  //  Here some of the terms like title, state doesn't have separate clarity like if we do not group all these values we can not be sure about them

}


class DisinformationRefactored {

  case class Triangle(sides: List[Int], isRightAngle: Boolean){
    require(sides.size == 3, "A triangle must have 3 sides")

    val hypotenuse: Option[Int] = if(isRightAngle) Some(sides.max) else None

    ???
  }

  case class Address(title: String, firstName: String,
                     lastName: String, street : String, houseNumber: String,
                     city: String, state: String, zipCode: Int)

  def getPrintableAddress(address: Address): String = {
    s"${address.title} ${address.firstName} ${address.lastName}\n" +
      s"${address.houseNumber}, ${address.street}\n" +
      s"${address.city}, ${address.state}(zip: ${address.zipCode})"
  }

}
