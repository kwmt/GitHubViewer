package net.kwmt27.githubsearch.entity;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class TokenEntity extends RealmObject {

    @SerializedName("access_token")
    private String mAccessToken;
    @SerializedName("token_type")
    private String mTokenType;
    @SerializedName("scope")
    private String mScope;

    public TokenEntity setAccessToken(String accessToken) {
        mAccessToken = accessToken;
        return this;
    }

    public TokenEntity setTokenType(String tokenType) {
        mTokenType = tokenType;
        return this;
    }

    public TokenEntity setScope(String scope) {
        mScope = scope;
        return this;
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public String getTokenType() {
        return mTokenType;
    }

    public String getScope() {
        return mScope;
    }
}