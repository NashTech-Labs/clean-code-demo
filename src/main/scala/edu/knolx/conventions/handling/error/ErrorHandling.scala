package edu.knolx.conventions.handling.error

object CommonErrorHandling{
  val DEVICE_ID = 100

  trait DeviceHandle

  case object Invalid extends DeviceHandle

  case object Valid extends DeviceHandle{
    ???
  }

  case class DeviceShutDownError(label: String) extends Exception

  trait DeviceStatus

  case object DeviceRunning extends DeviceStatus

  case object DeviceSuspended extends DeviceStatus

  class Record{
    def getStatus: DeviceStatus = ???
  }

  def retrieveDeviceRecord(handle: DeviceHandle): Record = ???

  def pauseDevice(handle: DeviceHandle): Unit = ???
  def clearDeviceWorkQueue(handle: DeviceHandle): Unit = ???
  def closeDevice(handle: DeviceHandle): Unit = ???

}

class ErrorHandling {
  import CommonErrorHandling._

  class DeviceController{
    ???

    def sendShutDown(): Unit = {
      val handle = getHandle(DEVICE_ID)
      // Check the state of the device
      if(handle != Invalid){
        // Save the device status to the record field
        val record = retrieveDeviceRecord(handle)
        if(record.getStatus != DeviceSuspended) {
          pauseDevice(handle)
          clearDeviceWorkQueue(handle)
          closeDevice(handle)
        }else {
          println("Device suspended. Unable to shut down")
        }
      } else {
        println("Invalid handle for: " + DEVICE_ID.toString)
      }
    }

    def getHandle(deviceCode: Int): DeviceHandle = {
      if(???){
        Valid
      } else {
        Invalid
      }
    }

    ???
  }

}

class ErrorHandlingRefactored{
  import CommonErrorHandling._

  class DeviceController{

    def sendShutDown(): Unit = {
      try {
        tryToShutDown()
      } catch {
        case ex: DeviceShutDownError => println(ex)
      }
    }

    private def tryToShutDown(): Unit = {
      val handle = getHandle(DEVICE_ID)
      retrieveDeviceRecord(handle)
      pauseDevice(handle)
      clearDeviceWorkQueue(handle)
      closeDevice(handle)
    }

    def getHandle(deviceId: Int): DeviceHandle = {
      if(???) {
        Valid
      } else {
        throw DeviceShutDownError("Invalid handle for: " + deviceId.toString)
      }
    }

    ???
  }
}
