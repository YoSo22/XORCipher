import junit.framework.TestCase
import org.junit.Test
import java.io.File


class XORCipherTest : TestCase() {

    @Test
    fun testCipher() {

        val testSimbols1 = File("src/test/resources/TestSymbols.txt").readLines().joinToString("")
        XORCipher().cipher("src/test/resources/TestSymbols.txt","10d","src/test/resources/TestSymbols.txt")
        XORCipher().cipher("src/test/resources/TestSymbols.txt","10d","src/test/resources/TestSymbols.txt")
        val testSimbols2 = File("src/test/resources/TestSymbols.txt").readLines().joinToString("")
        assertEquals(testSimbols2,testSimbols1)
    }
}