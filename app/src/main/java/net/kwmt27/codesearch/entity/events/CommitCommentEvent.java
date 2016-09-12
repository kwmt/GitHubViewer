package net.kwmt27.codesearch.entity.events;


import android.text.style.ClickableSpan;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import net.kwmt27.codesearch.entity.EventEntity;
import net.kwmt27.codesearch.entity.payloads.CommitCommentEntity;
import net.kwmt27.codesearch.util.TextViewUtil;

// https://developer.github.com/v3/activity/events/types/#commitcommentevent
public class CommitCommentEvent extends EventEntity {

    @SerializedName("payload")
    private CommitCommentEntity mCommitCommentEntity;

    @Override
    public void action(TextView view, ClickableSpan clickableSpan) {
        String repoName = getRepo().getName();
        String action = mCommitCommentEntity.getAction() + " " + repoName; // TODO
        view.setText(action);
        TextViewUtil.addLink(view, repoName, clickableSpan);
    }
}