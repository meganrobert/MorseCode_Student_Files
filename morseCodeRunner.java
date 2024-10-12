import java.util.*;
import java.io.File;
import java.io.IOException;
public class morseCodeRunner 
{

    public static void main(String[] args) 
    {
        morseCode m = new morseCode(); 

        System.out.println(m.encode("hello world")); 
        System.out.println(m.decode(".... . .-.. .-.. --- | .-- --- .-. .-.. -..")); 

    }

}
class morseCode
{

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890 ";
    private final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
            "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-",
            ".....", "-....", "--...", "---..", "----.", "-----", "|"};

    private HashMap<String, String> toText;
    private HashMap<String, String> toCode;

    public morseCode()
    {
        toText = new HashMap<>(); 
        toCode = new HashMap<>(); 


        for (int i = 0; i < alphabet.length(); i++) 
        {
            toCode.put(Character.toString(alphabet.charAt(i)), morse[i]); 
        }

        for (int i = 0; i < alphabet.length(); i++) 
        {
            toText.put(morse[i], Character.toString(alphabet.charAt(i))); 
        }

    }

    public String encode(String s)
    {
        String str = ""; 
        for(int i = 0; i < s.length(); i++) 
        {
            str += " " + toCode.get(String.valueOf(s.charAt(i)));

        }
        return str; 
    }

    public String decode(String s) 
    {
        String str = ""; 
        Scanner scan = new Scanner(s); 


        while(scan.hasNext())
        {
            str += toText.get(scan.next());


        }
        return str; 

    }
    
    
    
}