package Utility;

import java.lang.Object;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class HashSenha {

    public static String senhaHash(String senha){
	String salt = "a@123_!";
	String sha256hex = Hashing.sha256().hashString(senha + salt, StandardCharsets.UTF_8).toString();
	
	return sha256hex;
    }
    
}
