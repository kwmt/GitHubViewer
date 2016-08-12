package net.kwmt27.githubsearch.model;

import android.content.Context;

import net.kwmt27.githubsearch.BuildConfig;
import net.kwmt27.githubsearch.ModelLocator;
import net.kwmt27.githubsearch.entity.TokenEntity;
import net.kwmt27.githubsearch.model.rx.ReusableCompositeSubscription;
import net.kwmt27.githubsearch.util.PrefUtil;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginModel {

    private static final String OAUTH_URL = "https://github.com/login/oauth/authorize";
    private static final String SCOPE = "read:org";

    private ReusableCompositeSubscription mCompositeSubscription = new ReusableCompositeSubscription();
    private Context mContext;

    public LoginModel(Context context) {
        mContext = context.getApplicationContext();
    }

    public Subscription fetchAccessToken(String code, Subscriber<TokenEntity> subscriber) {
        Subscription subscription = ModelLocator.getApiClient().login.fetchAccessToken(code, BuildConfig.GITHUB_CLIENT_ID, BuildConfig.GITHUB_CLIENT_SECRET)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        mCompositeSubscription.add(subscription);
        return subscription;
    }

    public String getAccessToken() {
        String accessToken = PrefUtil.getAccessToken(mContext);
        if (accessToken == null) {
            return "";
        }
        return accessToken;
    }

    public String getAuthorizeUrl() {
        return OAUTH_URL  + "?client_id=" + BuildConfig.GITHUB_CLIENT_ID + "&scope=" + SCOPE;
    }
}