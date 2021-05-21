import org.kohsuke.args4j.Option
import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.CmdLineException
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.lang.StringBuilder
import kotlin.experimental.xor
import kotlin.math.pow
import kotlin.streams.toList

public class XORCipher(){


    //метод шифрования/дешифровки
    fun cipher(imputFileName: String, Key: String, outputFileName: String){

        var currentPosition = 0L

            FileInputStream(imputFileName).use { input ->
                val inputFileBytes = input.readBytes()
                input.close()
                val outputFile = FileOutputStream(outputFileName)
                outputFile.use { out ->
                    val binaryKey = Key.toBigInteger(16).toString(2)
                    for (byte in inputFileBytes) {
                        val sb = StringBuilder()
                        sb.append(binaryKey.chars().skip(currentPosition).limit(8L).toList().map { it.toChar() }.joinToString(""))
                        currentPosition += 8L
                        currentPosition %= binaryKey.length
                        if (sb.length < 8) {
                            sb.append(binaryKey.chars().limit(currentPosition).toList().map { it.toChar() }.joinToString(""))
                        }
                        out.write((byte xor sb.toString().toInt(2).toByte()).toInt())
                    }
                    out.close()
                }
            }


    }
}




