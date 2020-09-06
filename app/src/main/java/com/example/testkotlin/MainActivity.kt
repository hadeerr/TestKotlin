package com.example.testkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.coroutines.*
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {

    object Resource {
        val name = "kkkkkkkkkkkkk"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        AppCenter.start(
            application, "1f7c8b38-74d3-4145-9436-397395e1c00d",
            Analytics::class.java, Crashes::class.java
        )


        var  array :  Array<Int> = arrayOf()
//        Log.e("TAG" , "ARRAY SIZE ".plus(array.size))
        var currentNumber : Int = array[1]

        for( it in array) {
            if (it == currentNumber) {
                Log.e( "TAG" , "".plus(it))
                Log.e( "TAG" , "".plus(it))
                Log.e( "TAG" , "".plus(it))
                Log.e( "TAG" , "".plus(it))
                Log.e( "TAG" , "".plus(it))
                Log.e( "TAG" , "".plus(it))
                Log.e( "TAG" , "".plus(it))
                Log.e( "TAG" , "".plus(it))

            }
        }










//        Log.e("TAG" , "ARRAY SIZE ".plus(array.size))


        /*     runBlocking<Unit> { // start main coroutine
                 GlobalScope.launch { // launch a new coroutine in background and continue
                     delay(1000L)
                     Log.e("onCreate","World!")
                 }
                 Log.e("onCreate","Hello,") // main coroutine continues here immediately
                 delay(2000L)      // delaying for 2 seconds to keep JVM alive
             }*/


        runBlocking {
            val startTime = System.currentTimeMillis()
            val job = launch(Dispatchers.Default) {
                var nextPrintTime = startTime
                var i = 0
                while (isActive) { // cancellable computation loop
                    // print a message twice a second
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        Log.e("onCreate" ,"job: I'm sleeping ${i++} ...")
                        nextPrintTime += 500L
                    }
                }
            }
            delay(1300L) // delay a bit
            Log.e("onCreate" ,"main: I'm tired of waiting!")
            job.cancelAndJoin() // cancels the job and waits for its completion
            Log.e("onCreate" ,"main: Now I can quit.")
        }
//////////////////////////////////////////////////////////////////////////////////
        //cancelable
     /*   runBlocking {
            val startTime = System.currentTimeMillis()
            val job = launch(Dispatchers.Default) {
                var nextPrintTime = startTime
                var i = 0
                while (i < 10) { // computation loop, just wastes CPU
                    // print a message twice a second
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        Log.e("onCreate" ,"job: I'm sleeping ${i++} ...")
                        nextPrintTime += 500L
                    }
                }
            }
            delay(1300L) // delay a bit
            Log.e("onCreate" ,"main: I'm tired of waiting!")
            job.cancelAndJoin() // cancels the job and waits for its completion
            Log.e("onCreate" ,"main: Now I can quit.")
        }*/
        /////////////////////////////////////////////////////////////////////////////

/*         runBlocking {
            val job = launch {
                repeat(1000) { i ->
                    Log.e("onCreate" ,"job: I'm sleeping $i ...")
                    delay(500L)
                }
            }
            delay(5000L) // delay a bit
             Log.e("onCreate" ,"main: I'm tired of waiting!")
            job.cancel() // cancels the job
            job.join() // waits for job's completion
             Log.e("onCreate" ,"main: Now I can quit.")
        }*/
        ////////////////////////////////////////////////////////////
/*        runBlocking {
            repeat(100_000) { // launch a lot of coroutines
                launch {
                    delay(1000L)
                    Log.e("onCreate" ,".")
                }
            }
        }*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        runBlocking { // this: CoroutineScope
            launch {
//                delay(200L)
                Log.e("onCreate" ,"Task from runBlocking")
            }

            coroutineScope { // Creates a coroutine scope
                launch {
//                    delay(500L)
                    Log.e("onCreate" ,"Task from nested launch")
                }

//                delay(100L)
                Log.e("onCreate" ,"Task from coroutine scope") // This line will be printed before the nested launch
            }

            Log.e("onCreate" ,"Coroutine scope is over") // This line is not printed until the nested launch completes
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
        GlobalScope.launch { // launch a new coroutine in background and continue
//            delay(1000L)
            Log.e("onCreate" ,"World!")
        }
        Log.e("onCreate" ,"Hello,")
        Log.e("onCreate" ,"after ,")
        Log.e("onCreate" ,"after ,")
        Log.e("onCreate" ,"jjjj ,")
        Log.e("onCreate" ,"hhhhh ,")
        Log.e("onCreate" ,"nnnn ,")
        Log.e("onCreate" ,"mmmm ,")
        Log.e("onCreate" ,"uyyyy ,")

*/


        /*       val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
               fruits
                   .filter { it.startsWith("a") }
                   .sortedBy { it }
                   .map { it.toUpperCase() }
                   .forEach { Log.e("TAG" , it) }*/


/*        val i = "AHMED"

        val isIndex =  i.length  == 5 ?: "Not"
        val a: Int = 100
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        val b: Int = 10
        val boxedB: Int? = b
        val anotherBoxedB: Int? = b
   // main thread continues here immediately
    */

       /* runBlocking {     // but this expression blocks the main thread
            delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
        }*/
//        Log.e("onCreate" , (boxedA === anotherBoxedA).toString()) // true
//        Log.e("onCreate" , (boxedB == anotherBoxedB).toString())

//        Log.e("onCreate" ,calcTaxes().toString())
    }

    fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")

    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }
}
