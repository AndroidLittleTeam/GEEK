package com.alenbeyond.runoob.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.Toast;

import com.alenbeyond.runoob.App;
import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.base.BaseActivity;
import com.alenbeyond.runoob.adapter.VPCategoryAdapter;
import com.alenbeyond.runoob.greendao.bean.RunoobCategory;
import com.alenbeyond.runoob.greendao.gen.RunoobCategoryDao;
import com.alenbeyond.runoob.greendao.gen.DaoSession;

import java.util.List;

public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager vpCategory;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_main);
        toolbar = findView(R.id.toolbar);
        tabs = findView(R.id.tabs);
        vpCategory = findView(R.id.vp_category);

        toolbar.setTitle("IT教程");
        setSupportActionBar(toolbar);
    }

    @Override
    protected void loadServer() {
        DaoSession daoSession = App.daoMaster.newSession();
        RunoobCategoryDao categoryDao = daoSession.getRunoobCategoryDao();
        List<RunoobCategory> categories = categoryDao.queryBuilder().list();

        vpCategory.setAdapter(new VPCategoryAdapter(MainActivity.this, categories));
        tabs.setupWithViewPager(vpCategory);
//        ApiManager.getObCategory(new MyObserver<List<RunoobCategory>>() {
//            @Override
//            public void onNext(List<RunoobCategory> categories) {
//                vpCategory.setAdapter(new VPCategoryAdapter(MainActivity.this, categories));
//                tabs.setupWithViewPager(vpCategory);
//            }
//        });
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
