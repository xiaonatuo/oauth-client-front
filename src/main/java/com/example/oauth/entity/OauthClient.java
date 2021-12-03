package com.example.oauth.entity;

import lombok.Data;

/**
 * OauthClient
 *
 * @author Administrator
 * @since 2021/12/3
 */
@Data
public class OauthClient {
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String code;
    private String redirect_uri;
    private String state;
}
