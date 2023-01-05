package Hashing;

public class Main {
    public static void main(String[] args) {
        String pass = "lehoai123";

        String securePass = HashingPass.getSecurePassword(pass);
        System.out.println(securePass);
    }
}
