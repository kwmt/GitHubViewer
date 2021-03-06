package net.kwmt27.codesearch.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * レポジトリ検索結果
 */
public class SearchRepositoryResultEntity {
    @SerializedName("total_count")
    private int mTotalCount;
    @SerializedName("incomplete_results")
    private boolean mIncompleteResults;
    @SerializedName("items")
    private List<GithubRepoEntity> mGithubRepoEntityList = new ArrayList<>();

    public int getTotalCount() {
        return mTotalCount;
    }

    public boolean isIncompleteResults() {
        return mIncompleteResults;
    }


    public List<GithubRepoEntity> getGithubRepoEntityList() {
        if(mGithubRepoEntityList == null) {
            return new ArrayList<>();
        }
        return mGithubRepoEntityList;
    }

    /** 結果がみつかったどうか */
    public boolean foundResult() {
        return getTotalCount() > 0;
    }
}
