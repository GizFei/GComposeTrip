package coder.giz.android.compose.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlin.reflect.KClass

/**
 * Created by GizFei on 2024/2/3
 */


infix fun Context.launch(clz: KClass<out ComponentActivity>) {
    this.startActivity(Intent(this, clz.java))
}

fun Context.launch(clz: KClass<out ComponentActivity>, args: Bundle) {
    this.startActivity(Intent(this, clz.java).apply {
        putExtras(args)
    })
}