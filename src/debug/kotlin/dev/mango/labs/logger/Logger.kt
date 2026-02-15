package dev.mango.labs.logger

import android.os.Build
import android.util.Log

/**
 * Created by krrishnaaaa on 23/11/14.
 */
object Logger {
  fun i(message: Any?) {
    if (message != null) {
      Log.i(tag, message.toString() + "")
    }
  }

  fun d(message: Any?) {
    if (message != null) {
      Log.d(tag, message.toString() + "")
    }
  }

  fun i(tag: String?, message: Any?) {
    if (message != null) {
      Log.i(tag, message.toString() + "")
    }
  }

  fun w(message: Any?) {
    if (message != null) {
      Log.w(tag, message.toString() + "")
    }
  }

  fun e(message: Any?) {
    if (message != null) {
      Log.e(tag, message.toString() + "")
    }
  }

  fun e(throwable: Throwable?) {
    if (throwable != null) {
      Log.e(tag, throwable.message, throwable)
    }
  }

  fun e(tag: String?, message: Any?) {
    if (message != null) {
      Log.e(tag, message.toString() + "")
    }
  }

  fun e(tag: String?, message: Any?, throwable: Throwable?) {
    if (message != null) {
      Log.e(tag, message.toString() + "", throwable)
    }
  }

  private val tag: String
    get() {
      val element = Thread.currentThread().stackTrace[4]
      val tag = getSimpleClassName(element.className) + ':' + element.methodName + "() "
      return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        tag
      } else {
        if (tag.length > 24) tag.substring(0, 23) else tag
      }
    }

  private fun getSimpleClassName(className: String): String {
    val last = className.lastIndexOf('.') + 1
    return className.substring(last)
  }
}
