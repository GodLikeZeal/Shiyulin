package com.zeal.shiyulin.utils;

/**
 * AES加密算法工具类
 * Created by zeal on 2017/10/26.
 */

import org.apache.commons.codec.binary.Hex;
import org.apache.poi.ss.formula.functions.Hex2Dec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

    public class AESUtils {

        private static final String KEY_ALGORITHM = "AES";
        private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

        public static byte[] initSecretKey() {

            //返回生成指定算法密钥生成器的 KeyGenerator 对象
            KeyGenerator kg = null;
            try {
                kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return new byte[0];
            }
            //初始化此密钥生成器，使其具有确定的密钥大小
            //AES 要求密钥长度为 128
            kg.init(128);
            //生成一个密钥
            SecretKey  secretKey = kg.generateKey();
            return secretKey.getEncoded();
        }

        private static Key toKey(byte[] key){
            //生成密钥
            return new SecretKeySpec(key, KEY_ALGORITHM);
        }

        public static byte[] encrypt(byte[] data,Key key) throws Exception{
            return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
        }

        public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
            return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
        }

        public static byte[] encrypt(byte[] data,byte[] key,String cipherAlgorithm) throws Exception{
            //还原密钥
            Key k = toKey(key);
            return encrypt(data, k, cipherAlgorithm);
        }

        public static byte[] encrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
            //实例化
            Cipher cipher = Cipher.getInstance(cipherAlgorithm);
            //使用密钥初始化，设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //执行操作
            return cipher.doFinal(data);
        }

        public static byte[] decrypt(byte[] data,byte[] key) throws Exception{
            return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
        }

        public static byte[] decrypt(byte[] data,Key key) throws Exception{
            return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
        }

        public static byte[] decrypt(byte[] data,byte[] key,String cipherAlgorithm) throws Exception{
            //还原密钥
            Key k = toKey(key);
            return decrypt(data, k, cipherAlgorithm);
        }

        public static byte[] decrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
            //实例化
            Cipher cipher = Cipher.getInstance(cipherAlgorithm);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, key);
            //执行操作
            return cipher.doFinal(data);
        }

        private static String  showByteArray(byte[] data){
            if(null == data){
                return null;
            }
            StringBuilder sb = new StringBuilder("{");
            for(byte b:data){
                sb.append(b).append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("}");
            return sb.toString();
        }

        /**
         * 加密
         * @param content
         * @param strKey
         * @return
         * @throws Exception
         */
        public static byte[] encrypt(String content,String strKey ) throws Exception {
            SecretKeySpec skeySpec = getKey(strKey);
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
            //cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(content.getBytes());
            return  encrypted;
        }

        /**
         * 解密
         * @param strKey
         * @param content
         * @return
         * @throws Exception
         */
        public static String decrypt(byte[] content,String strKey ) throws Exception {
            SecretKeySpec skeySpec = getKey(strKey);
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] original = cipher.doFinal(content);
            String originalString = new String(original);
            return originalString;
        }

        private static SecretKeySpec getKey(String strKey) throws Exception {
            byte[] arrBTmp = strKey.getBytes();
            byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）

            for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
                arrB[i] = arrBTmp[i];
            }

            SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");

            return skeySpec;
        }
        /**
         * base 64 encode
         * @param bytes 待编码的byte[]
         * @return 编码后的base 64 code
         */
        public static String base64Encode(byte[] bytes){
            return new BASE64Encoder().encode(bytes);
        }

        /**
         * base 64 decode
         * @param base64Code 待解码的base 64 code
         * @return 解码后的byte[]
         * @throws Exception
         */
        public static byte[] base64Decode(String base64Code) throws Exception{
            return base64Code.isEmpty() ? null : new BASE64Decoder().decodeBuffer(base64Code);
        }

        /**
         * AES加密为base 64 code
         * @param content 待加密的内容
         * @param encryptKey 加密密钥
         * @return 加密后的base 64 code
         * @throws Exception
         */
        public static String aesEncrypt(String content, String encryptKey) throws Exception {
            return base64Encode(encrypt(content, encryptKey));
        }
        /**
         * 将base 64 code AES解密
         * @param encryptStr 待解密的base 64 code
         * @param decryptKey 解密密钥
         * @return 解密后的string
         * @throws Exception
         */
        public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
            return encryptStr.isEmpty() ? null : decrypt(base64Decode(encryptStr), decryptKey);
        }

        /**
         * AES加密为Hex编码 code
         * @param content 待加密的内容
         * @param encryptKey 加密密钥
         * @return 加密后的base 64 code
         * @throws Exception
         */
        public static String aesEncryptToHex(String content, String encryptKey) throws Exception {
            return Encodes.encodeHex(encrypt(content, encryptKey));
        }
        /**
         * 将base 64 code AES解密
         * @param encryptStr 待解密的base 64 code
         * @param decryptKey 解密密钥
         * @return 解密后的string
         * @throws Exception
         */
        public static String aesDecryptToHex(String encryptStr, String decryptKey) throws Exception {
            return encryptStr.isEmpty() ? null : decrypt(Encodes.decodeHex(encryptStr), decryptKey);
        }


        public static void main(String[] args) throws Exception {
//            byte[] key = initSecretKey();
//            System.out.println("key："+showByteArray(key));
//            Key k = toKey(key); //生成秘钥
//            String data ="AES数据";
//            System.out.println("加密前数据: string:"+data);
//            System.out.println("加密前数据: byte[]:"+showByteArray(data.getBytes()));
//            System.out.println();
//            byte[] encryptData = encrypt(data.getBytes(), k);//数据加密
//            System.out.println("加密后数据: byte[]:"+showByteArray(encryptData));
////       System.out.println("加密后数据: hexStr:"+Hex.encodeHexStr(encryptData));
//            System.out.println();
//            byte[] decryptData = decrypt(encryptData, k);//数据解密
//            System.out.println("解密后数据: byte[]:"+showByteArray(decryptData));
//            System.out.println("解密后数据: string:"+new String(decryptData));
            String test = "123456789";
            Long a = 9007199254740992L;
            String m = Hashids.getHashids().encode(a);
            System.out.println(m);
            Long k = Hashids.getHashids().decode(m)[0];
            System.out.println(k);
            String key = "123456";
//            System.out.println("加密前：" + test);
//            System.out.println(Encodes.encodeBase62(test.getBytes()));
//            System.out.println(Encodes.encodeBase64(test.getBytes()));
//            System.out.println(Encodes.encodeHex(test.getBytes()));
//            System.out.println(Encodes.encodeHex(a));
//
//            System.out.println("密钥：" + key);
//
//            String encrypt = aesEncrypt(test, key);
//            String encryptHex = aesEncryptToHex(test, key);
//            System.out.println("加密后：" + encrypt);
//            System.out.println("加密后：" + encryptHex);
//
//            String decrypt = aesDecrypt(encrypt, key);
//            String decryptHex = aesDecryptToHex(encryptHex, key);
//            System.out.println("解密后：" + decrypt);
//            System.out.println("解密后：" + decryptHex);
        }
    }

