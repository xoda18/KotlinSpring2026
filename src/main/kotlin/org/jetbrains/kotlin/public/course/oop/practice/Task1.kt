package org.jetbrains.kotlin.public.course.oop.practice

import java.io.Reader
import java.nio.file.Path
import kotlin.io.path.readText
import java.nio.file.Files

/*
Implement a file reader for two file types: markdown and plain text
Requirements:
 - When reading a file through the FileReader, I should clearly differentiate between file types (plain/markdown/failure).
 In case of success, path and content should be saved. In case of failure - the message why content couldn't be loaded
 - The first line of file content should contain the string "<Presentable name of class>: <file-path>"
 */

open class ReadResult {
    data class PlainText(val path: Path, val content: String) : ReadResult()
    data class Markdown(val path: Path, val content: String) : ReadResult()
    data class Failure(val message: String) : ReadResult()
}

private fun ReadResult.contentOrThrow(): String = when (this) {
    is ReadResult.PlainText -> content
    is ReadResult.Markdown  -> content
    is ReadResult.Failure   -> error(message)
    else                    -> error("Wrong result type: $this")
}

fun ReadResult.countChar(ch: Char): Int = contentOrThrow().count { it == ch }

operator fun ReadResult.get(begin: Int, end: Int): String {
    val s = contentOrThrow()
    return s.substring(begin, end)
}

interface FileReader {
    fun read(path: Path): ReadResult
}

class PlainTextReader : FileReader {
    override fun read(path: Path): ReadResult {
        val content = Files.readString(path)
        return ReadResult.PlainText(path, content)
    }
}

class MarkdownReader: FileReader {
    override fun read(path: Path): ReadResult {
        val content = Files.readString(path)
        return ReadResult.Markdown(path, content)
    }
}

class UniversalReader: FileReader {
    override fun read(path: Path): ReadResult {
        val format = path.fileName.toString().substringAfterLast('.', "").lowercase()

        return when (format) {
            "txt" -> PlainTextReader().read(path)
            "md"  -> MarkdownReader().read(path)
            else  -> ReadResult.Failure("Unsupported file type: $format")
        }
    }
}

fun main() {
    val path = Path.of("abc.txt")
    val res = UniversalReader().read(path)
    println(res)
}