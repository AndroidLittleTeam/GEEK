package com.alen.runoob.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.alen.runoob.R;
import com.alen.runoob.activity.base.BaseActivity;
import com.alen.runoob.js.Js;

import java.lang.ref.WeakReference;

public class DetailActivity extends BaseActivity {

    private WebView wvRunoob;
    private ProgressBar pbLoading;
    private Toolbar toolbar;

    private MyHandler handler = new MyHandler();

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_detail);
        wvRunoob = findView(R.id.wb_runoob);
        pbLoading = findView(R.id.pb_loading);
        toolbar = findView(R.id.toolbar);

        showContent(false);
        wvRunoob.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains("http://www.runoob.com/try/")) {
                    view.loadUrl(url);
                    showContent(false);
                }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl(Js.getClass);
                view.loadUrl(Js.hideDiv);
                view.loadUrl(Js.hide);
                view.loadUrl("javascript:hide();");
                handler.sendEmptyMessageDelayed(0, 300);
                super.onPageFinished(view, url);
            }

        });
        wvRunoob.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public void initData() {
        String title = getIntent().getStringExtra("title");
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String url = getIntent().getStringExtra("url");
        wvRunoob.loadUrl(url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 在有上一页的时候返回上一页
     */
    @Override
    public void onBackPressed() {

        if (wvRunoob.canGoBack()) {
            wvRunoob.goBack();
            showContent(false);
        } else {
            super.onBackPressed();
        }

    }

    /**
     * 处理可能发生OOM的情况
     */
    private class MyHandler extends Handler {

        WeakReference<DetailActivity> weakReference;

        public MyHandler() {
            weakReference = new WeakReference<>(DetailActivity.this);
        }

        @Override
        public void handleMessage(Message msg) {

            DetailActivity m = weakReference.get();

            if (msg.what == 0) {
                m.showContent(true);
            }
        }
    }

    /**
     * 是否显示内容
     *
     * @param isShow
     */
    public void showContent(boolean isShow) {
        pbLoading.setVisibility(isShow ? View.INVISIBLE : View.VISIBLE);
        wvRunoob.setVisibility(isShow ? View.VISIBLE : View.INVISIBLE);
    }
}