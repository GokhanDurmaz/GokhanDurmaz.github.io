package com.demo.ans.github.security;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by gokhan on 11/6/21.
 * @author gokhan
 * @since 2021/11/06
 */

public class GithubResponseAuthenticatorModel {
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}
