package com.varun.demoapplication.utils

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.InputStreamReader
import java.lang.reflect.Type

class ConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        return StringResponseCopnverter()
    }
}

class StringResponseCopnverter : Converter<ResponseBody, String>
{
    override fun convert(value: ResponseBody): String {
        var reader = InputStreamReader(value.byteStream())
        val bufferSize = 1024
        val buffer = CharArray(bufferSize)
        val out = StringBuilder()
        val `in` = InputStreamReader(value.byteStream(), "UTF-8")
        while (true) {
            val rsz = `in`.read(buffer, 0, buffer.size)
            if (rsz < 0)
                break
            out.append(buffer, 0, rsz)
        }


        return out.toString()

    }

}