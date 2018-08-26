package edu.knolx.conventions.handling.error

case class DeviceResponseException(label: String) extends Exception

case class PortUnlockedException(label: String) extends Exception

case class AnyOtherError(label: String) extends Exception

class Port(portNumber: Int) {
  def open(): Unit = {
    if (???) {

    } else if (???) {
      throw DeviceResponseException("")
    } else if (???) {
      throw PortUnlockedException("")
    } else {
      throw AnyOtherError("")
    }
  }
}

class CallersNeeds {

  val port: Port = ???

  try {
    port.open()
  } catch {
    case ex: DeviceResponseException =>
      reportPortError(ex)
      println(s"Device response exception with: $ex")
    case ex: PortUnlockedException =>
      reportPortError(ex)
      println(s"Unlock exception: $ex")
    case ex: AnyOtherError =>
      reportPortError(ex)
      println(s"Got this one error: $ex")
  } finally {
    ???
  }
  // Poor example of code duplication

  def reportPortError(e: Exception): Unit = ???

}

class CallerNeedsRefactored {

  val localPort = new LocalPort(12)

  try {
    localPort.open()
  } catch {
    case ex: PortDeviceFailure =>
      reportPortError(ex.exception)
      println(s"${ex.exception.getMessage}: ${ex.exception}")
  } finally {
    ???
  }

  class LocalPort(portNumber: Int) {
    val port: Port = new Port(portNumber)

    def open(): Unit = {
      try {
        port.open()
      } catch {
        case ex: Exception => throw PortDeviceFailure(ex)
      }
    }
  }

  case class PortDeviceFailure(exception: Exception) extends Exception

  def reportPortError(e: Exception): Unit = ???
}
