package com.demo.ans.github.security;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

/**
 * Created by gokhan on 11/6/21.
 * @author gokhan
 * @since 2021/11/06
 */

public class GithubResponseAuthenticator {
    private final GithubResponseAuthenticatorModel authModel;

    private GithubResponseAuthenticator() {
        authModel = new GithubResponseAuthenticatorModel();
    }

    public static GithubResponseAuthenticator getInstance() {
        return InnerSingletonHolder.INSTANCE;
    }

    public void init() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(256);
        KeyPair pairs = keyPairGenerator.generateKeyPair();
        authModel.setPublicKey(pairs.getPublic());
        authModel.setPrivateKey(pairs.getPrivate());
    }

    public byte[] sign(byte[] data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature newSign = Signature.getInstance("SHA512withECDSA");
        newSign.initSign(authModel.getPrivateKey());
        newSign.update(data);
        return newSign.sign();
    }

    private static class InnerSingletonHolder {
        private static final GithubResponseAuthenticator INSTANCE = new GithubResponseAuthenticator();
    }
}
