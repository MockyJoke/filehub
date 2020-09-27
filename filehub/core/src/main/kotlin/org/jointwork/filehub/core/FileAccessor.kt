package org.jointwork.filehub.core

import java.io.InputStream
import java.io.OutputStream

/***
 * FileAccessor is solely used for retrieving an inputstream or outputstream from a specifc file source
 */
interface FileAccessor {
    fun read(file : File) : InputStream
    fun write(file : File, outputStream : OutputStream) : Boolean
}