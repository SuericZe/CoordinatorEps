package suericze.coordinatoreps.tablayout;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import suericze.coordinatoreps.R;

import static suericze.coordinatoreps.R.id.tablayout;

public class TablayoutActivity extends AppCompatActivity {
    private TabLayout mTablayout;
    private ViewPager mViewpager;
    private TextView tv_tabcontext;
    private Context mContext;
    private FragmentManager fm;
    /**
     * 是否使用viewpager进行效果展示
     */
    private boolean isUseViewpager = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        init();

        if (isUseViewpager){
            showWithViewpager();
        }else {
            showWithoutViewpager();
        }

    }

    private void showWithViewpager() {
        mViewpager.setVisibility(View.VISIBLE);
        tv_tabcontext.setVisibility(View.GONE);
        mViewpager.setAdapter(new MyCusAdapter(fm));
        mTablayout.setTabMode(TabLayout.MODE_FIXED);
        mTablayout.setupWithViewPager(mViewpager);
    }

    private void init() {
        mContext =this;
        fm = getSupportFragmentManager();
        mTablayout = (TabLayout) findViewById(tablayout);
        mViewpager = (ViewPager) findViewById(R.id.tab_viewpager);
        tv_tabcontext = (TextView) findViewById(R.id.tv_tabtext);
    }

    private class MyCusAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = new String[]{"tab1","tab2","tab3"};

        public MyCusAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }
    public void showWithoutViewpager(){
        tv_tabcontext.setVisibility(View.VISIBLE);
        mViewpager.setVisibility(View.GONE);
        mTablayout.addTab(mTablayout.newTab().setText("Tab1"),true);
        mTablayout.addTab(mTablayout.newTab().setText("Tab2").setIcon(R.mipmap.logo));
        mTablayout.addTab(mTablayout.newTab().setText("Tab3"));

        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tv_tabcontext.setText("Tab1");
                        Toast.makeText(mContext,"Tab1",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        tv_tabcontext.setText("Tab2");
                        Toast.makeText(mContext,"Tab2",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        tv_tabcontext.setText("Tab3");
                        Toast.makeText(mContext,"Tab3",Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public static void start(Context context) {
        context.startActivity(new Intent(context,TablayoutActivity.class));
    }
}
