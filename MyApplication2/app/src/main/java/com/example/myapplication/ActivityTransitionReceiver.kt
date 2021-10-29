package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.android.gms.location.ActivityTransitionResult
import io.karn.notify.Notify
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception
import java.lang.NumberFormatException
import java.text.SimpleDateFormat
import java.util.*


class ActivityTransitionReceiver : BroadcastReceiver() {

    private var filename = "log.txt"

    override fun onReceive(context: Context, intent: Intent) {

        val file: String = filename
        var fileOutputStream: FileOutputStream



        if (ActivityTransitionResult.hasResult(intent)) {
            val result = ActivityTransitionResult.extractResult(intent)
            result?.let {
                result.transitionEvents.forEach { event ->
                    //Info about activity
                    val info =
                        "Transition: " + ActivityTransitionsUtil.toActivityString(event.activityType) +
                                " (" + ActivityTransitionsUtil.toTransitionType(event.transitionType) + ")" + "   " +
                                SimpleDateFormat("HH:mm:ss", Locale.US).format(Date())
//notification details
                    Notify
                        .with(context)
                        .content {
                            title = "Activity Detected"
                            text = "I can see you are in ${
                                ActivityTransitionsUtil.toActivityString(
                                    event.activityType
                                )
                            } state"
                        }
                        .show(id = Constants.ACTIVITY_TRANSITION_NOTIFICATION_ID)
                    Toast.makeText(context, info, Toast.LENGTH_LONG).show()

                    try {
                        fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE)
                        fileOutputStream.write(info.toByteArray())
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    } catch (e: NumberFormatException) {
                        e.printStackTrace()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}