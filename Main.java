
public class Main {

    public static void main(String[] args) {
        System.out.println("Starting Encryption tests...");
        testSDES();
    }

    private static void testSDES(){
        System.out.println("\n____ Testing S-DES ____");
        String principleKey = "1111011000"; //Can accept int[] for key also.
        long startTime = System.currentTimeMillis();
        String plainText = "decryptedtext";
        System.out.println("\n      Encryption     ");
        System.out.println("Input PlainText: " + plainText);
        SDESEncryption sDes = new SDESEncryption(principleKey);
        String cipherText = sDes.encrypt(plainText);
        System.out.println("Output CipherText: " + cipherText);
        System.out.println("\n      Decryption     ");
        System.out.println("Input CipherText: " + cipherText);
        String unencryptedText = sDes.decrypt(cipherText);
        System.out.println("Output PlainText: " + unencryptedText);
        long stopTime = System.currentTimeMillis();
        long runTime = stopTime - startTime;
        System.out.println("Run time: " + runTime);
    }

    private static void testRSA(){
        System.out.println("\n____ Testing RSA ____");
        String plainText = "decryptedtext";
        System.out.println("\n      Encryption     ");
        System.out.println("Input PlainText: " + plainText);
        RSASeed seed = new RSASeed(41,67,83);
        RSAEncryption rsa = new RSAEncryption(seed);
        RSAKey publicKey = rsa.getPublicKeyPair();
        String cipherText = rsa.encrypt(plainText, publicKey);
        System.out.println("Output CipherText: " + cipherText);
        System.out.println("\n      Decryption     ");
        System.out.println("Input CipherText: " + cipherText);
        RSAKey privateKey = rsa.getPrivateKeyPair();
        String unencryptedText = rsa.decrypt(cipherText,privateKey);
        System.out.println("Output PlainText: " + unencryptedText);
    }

}
