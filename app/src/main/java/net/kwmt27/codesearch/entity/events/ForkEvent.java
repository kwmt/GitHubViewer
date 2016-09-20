package net.kwmt27.codesearch.entity.events;

import android.text.style.ClickableSpan;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import net.kwmt27.codesearch.entity.EventEntity;
import net.kwmt27.codesearch.entity.payloads.ForkEntity;
import net.kwmt27.codesearch.util.TextViewUtil;

public class ForkEvent extends EventEntity {

    @SerializedName("payload")
    private ForkEntity mForkEntity;


    @Override
    public void action(TextView view, ClickableSpan clickableSpan) {
        String repoName = getRepo().getName();
        String action = this.getClass().getSimpleName().replace("Event", "").toLowerCase() + "ed " + repoName;
        view.setText(action);
        TextViewUtil.addLink(view, repoName, clickableSpan);
    }
}
