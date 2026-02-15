package dev.mango.labs.logger


/**
 * Created by krrishnaaaa on 23/11/14.
 */
object Logger {
  fun i(message: Any?) {
  }

  fun d(message: Any?) {
  }

  fun i(tag: String?, message: Any?) {
  }

  fun w(message: Any?) {
  }

  fun e(message: Any?) {
  }

  fun e(throwable: Throwable?) {
  }

  fun e(tag: String?, message: Any?) {
  }

  fun e(tag: String?, message: Any?, throwable: Throwable?) {
  }

  private val tag: String
    get() = "Logger"

  private fun getSimpleClassName(className: String): String {
    return "Logger::class"
  }
}
