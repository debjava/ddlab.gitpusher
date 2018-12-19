/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.util;

import static com.ddlab.gitpusher.util.CommonConstants.NO_CONNECTION_MSG;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.ddlab.gitpusher.core.GitResponse;
import com.ddlab.gitpusher.core.UserAccount;
import com.ddlab.gitpusher.exception.GenericGitPushException;

/**
 * The Class HTTPUtil.
 *
 * @author Debadatta Mishra
 */
public class HTTPUtil {

  /**
   * Gets the trusted http client.
   *
   * @return the trusted http client
   */
  public static HttpClient getTrustedHttpClient() {
    HttpClient httpClient = null;
    try {
      httpClient =
          HttpClients.custom()
              .setSSLContext(
                  new SSLContextBuilder()
                      .loadTrustMaterial(null, TrustAllStrategy.INSTANCE)
                      .build())
              .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
              .build();
    } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
      e.printStackTrace();
    }
    return httpClient;
  }

  /**
   * Gets the http get.
   *
   * @param uri the uri
   * @param userAccount the user account
   * @return the http get
   */
  public static HttpGet getHttpGet(String uri, UserAccount userAccount) {
    HttpGet httpGet = new HttpGet(uri);
    String encodedUser =
        HTTPUtil.getEncodedUser(userAccount.getUserName(), userAccount.getPassword());
    httpGet.setHeader("Authorization", "Basic " + encodedUser);
    return httpGet;
  }

  /**
   * Gets the http post.
   *
   * @param uri the uri
   * @param userAccount the user account
   * @return the http post
   */
  public static HttpPost getHttpPost(String uri, UserAccount userAccount) {
    HttpPost httpPost = new HttpPost(uri);
    String encodedUser =
        HTTPUtil.getEncodedUser(userAccount.getUserName(), userAccount.getPassword());
    httpPost.setHeader("Authorization", "Basic " + encodedUser);
    return httpPost;
  }

  /**
   * Gets the encoded user.
   *
   * @param userName the user name
   * @param password the password
   * @return the encoded user
   */
  public static String getEncodedUser(String userName, String password) {
    String endodedString = null;
    String userNamePassword = userName + ":" + password;
    endodedString = Base64.getEncoder().encodeToString(userNamePassword.getBytes());
    return endodedString;
  }

  /**
   * Gets the http get or post response.
   *
   * @param httpGetOrPost the http get or post
   * @return the http get or post response
   * @throws GenericGitPushException the generic git push exception
   */
  public static GitResponse getHttpGetOrPostResponse(HttpRequestBase httpGetOrPost)
      throws GenericGitPushException {
    GitResponse reponse = null;
    HttpClient httpClient = getTrustedHttpClient();
    HttpResponse response = null;
    try {
      response = httpClient.execute(httpGetOrPost);
      int statusCode = response.getStatusLine().getStatusCode();
      HttpEntity entity = response.getEntity();
      String responseText = EntityUtils.toString(entity);
      reponse = new GitResponse(String.valueOf(statusCode), responseText);
    } catch (IOException e) {
      throw new GenericGitPushException(NO_CONNECTION_MSG);
    }
    return reponse;
  }
}
