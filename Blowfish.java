import javax.crypto.Cipher; 
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey; 
import javax.swing.JOptionPane; 
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class BlowFish 
{
 public static void main(String[] args) throws Exception {

  KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
  Cipher cipher = Cipher.getInstance("Blowfish");
  SecretKey skey = kgen.generateKey();
  byte[] raw = skey.getEncoded();
  SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");
  cipher.init(Cipher.ENCRYPT_MODE,skey);
  String inputText = JOptionPane.showInputDialog("Input your message: "); 
  byte[] encrypted = cipher.doFinal(inputText.getBytes());
  cipher.init(Cipher.DECRYPT_MODE,skey);
  byte[] decrypted = cipher.doFinal(encrypted);
  JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "\nEncrypted text: " + new String(encrypted) + "\n" + "\nDecrypted text: " + new String(decrypted));
  System.exit(0);
 } 
}
