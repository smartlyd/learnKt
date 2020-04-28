package com.example.mylibrary.ktinterface.data

import android.location.Address
import android.os.Parcel
import android.os.Parcelable
import android.support.v4.app.INotificationSideChannel

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.data
 * @description:  TODO
 * @date:         2019/3/22
 * @time:         2:23 PM
 */
data class DataClass(var name: String, var age: Int) :Const(number = 30.00) {


    var nn: Int = 20

    init {
        println("init")
    }

}
