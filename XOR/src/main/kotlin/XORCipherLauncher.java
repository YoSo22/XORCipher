
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.IOException;

public class XORCipherLauncher {

    @Option(name = "-c", metaVar = "XOREncryption", usage = "Input file for Encryption", forbids = {"-d"})
    private String inputKeyC;

    @Option(name = "-d", metaVar = "XORDecryption", usage = "Input file for Decryption", forbids = {"-c"})
    private String inputKeyD;

    @Option(name = "-o", metaVar = "OutputName", required = true, usage = "Output file Name")
    private String outputName;

    @Argument(required = true, metaVar = "InputName", usage = "Input file name")
    private String inputFileName;

    @Argument(required = true, metaVar = "Key", usage = "Key for Encryption and Decryption")
    private String Key;


    private List<String> arguments = new ArrayList<String>(Collections.singleton(inputFileName));

    public XORCipherLauncher() {
    }

    public static void main(String[] args) {
        new XORCipherLauncher().launch(args);
    }public class XORCipherLauncher {

    @Option(name = "-c", metaVar = "XOREncryption", usage = "Input file for Encryption", forbids = {"-d"})
    private String inputKeyC;

    @Option(name = "-d", metaVar = "XORDecryption", usage = "Input file for Decryption", forbids = {"-c"})
    private String inputKeyD;

    @Option(name = "-o", metaVar = "OutputName", required = true, usage = "Output file Name")
    private String outputName;

    @Argument(required = true, metaVar = "InputName", usage = "Input file name")
    private String inputFileName;

    @Argument(required = true, metaVar = "Key", usage = "Key for Encryption and Decryption")
    private String Key;


    private List<String> arguments = new ArrayList<String>(Collections.singleton(inputFileName));

    public XORCipherLauncher() {
    }

    public static void main(String[] args) {
        new XORCipherLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
            if ((arguments.isEmpty()) || (!arguments.get(0).equals("ciphxor"))) {
                System.err.println("Error entering arguments (for correct input, see the example)");
                System.err.println("ciphxor [options...] arguments...");
                parser.printUsage(System.err);
                System.err.println("Example: ciphxor [-c Key| -d Key] InputName.txt [-o OutputName.txt]");
                throw new IllegalArgumentException("");
            }
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Example: ciphxor [-c Key| -d Key] InputName.txt [-o OutputName.txt]");
            parser.printUsage(System.err);
            return;
        }

        XORCipher Cipher = new XORCipher();
        Cipher.cipher(inputFileName, Key, outputName);

    }
}
