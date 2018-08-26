package edu.knolx.conventions.functions

object Constants {
  val COMMISSIONED = "commissioned"
  val HOURLY = "hourly"
  val SALARIED = "salaried"
  val TEMP = "temp"
}

case class InvalidEmployeeType(label: String) extends Exception

class PayRoll {

  import Constants._

  def calculatePayRoll(employee: Employee): Int = {
    employee.employeeType.toLowerCase match {
      case COMMISSIONED => employee.calculateCommissionedPay
      case HOURLY => employee.calculateHourlyPay
      case SALARIED => employee.calculateSalariedPay
      // New statements will be added for each type of employee
      case TEMP =>
        employee.calculateTempPay
      case other => throw InvalidEmployeeType(other)
    }
  }

  case class Employee(employeeType: String, name: String, designation: String) {

    def calculateCommissionedPay: Int = {
      0 //some calculation for commissioned employee
    }

    def calculateHourlyPay: Int = {
      0 //some calculation for hourly employee
    }

    def calculateSalariedPay: Int = {
      0 //some calculation for salaried employee
    }

    // Modifications in class for adding new type of employee
    def calculateTempPay: Int = {
      //some calculation for temp employee
      0
    }
  }

}

class RefactoredPayRoll {

  import Constants._

  def calculatePayRoll(employee: Employee): Int = {
    employee.calculatePay
  }

  trait Employee {
    def name: String

    def designation: String

    def calculatePay: Int
  }

  case class CommissionedEmployee(name: String, designation: String) extends Employee {
    override def calculatePay: Int = {
      0 //some calculation for commissioned employee
    }
  }

  case class HourlyEmployee(name: String, designation: String) extends Employee {
    override def calculatePay: Int = {
      0 //some calculation for hourly employee
    }
  }

  case class SalariedEmployee(name: String, designation: String) extends Employee {
    override def calculatePay: Int = {
      0 //some calculation for salaried employee
    }
  }

  // Extension for adding a new type
  /*case class TempEmployee(name: String, designation: String) extends Employee{
    override def calculatePay: Int = {
      0 //some calculation for temp employee
    }
  }*/

  object Employee {
    def apply(employeeType: String, name: String, designation: String): Employee =
      EmployeeFactory.makeEmployee(employeeType, name, designation)
  }

  // Bury the cases in abstraction
  private[functions] object EmployeeFactory {
    def makeEmployee(employeeType: String, name: String, designation: String): Employee = {
      employeeType.toLowerCase match {
        case COMMISSIONED => CommissionedEmployee(name, designation)
        case HOURLY => HourlyEmployee(name, designation)
        case SALARIED => SalariedEmployee(name, designation)
        // New statements will be added for each type of employee
        /*case TEMP =>
          TempEmployee(name, designation)*/
        case other => throw InvalidEmployeeType(other)
      }
    }
  }

}
