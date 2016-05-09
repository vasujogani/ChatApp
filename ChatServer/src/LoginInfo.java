import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class LoginInfo implements Comparable{
	private String username;
	private String password;
	
	public LoginInfo(String u, String p)
	{
		this.username = this.getMD5(u);
		this.password = this.getMD5(p);
	}
	
	public String getUsername(){return this.username;}
	public String getPassword(){return this.password;}
	@Override
	public int compareTo(Object b)
	{
		LoginInfo a = (LoginInfo)b;
		int n = -1;
		if(this.username.equals(a.getUsername()) && this.password.equals(a.getPassword()))
			n = 1;
		return n;
	}
	
	public String toString(){
		return "Login credentials are: username - "  + this.username + " \n password - "  + this.password;
	}
	
	public String save(){
		return this.username + " " + this.password;
	}
	
	public String getMD5(String data) {
        String result = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes(Charset.forName("UTF-8")));
            result = String.format(Locale.ROOT, "%032x", new BigInteger(1, md.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
        return result;
}
}
