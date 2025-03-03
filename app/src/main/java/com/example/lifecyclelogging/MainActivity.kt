package com.example.lifecyclelogging

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lifecyclelogging.ui.theme.LifecycleLoggingTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"  //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d(TAG, "onCreate: App Created")  //

        setContent {
            LifecycleLoggingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: App Started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: App Resumed")  // ✅ Log event
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: App Paused")  // ✅ Log event
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: App Stopped")  // ✅ Log event
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: App Destroyed")  // ✅ Log event
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LifecycleLoggingTheme {
        Greeting("Android")
    }
}
