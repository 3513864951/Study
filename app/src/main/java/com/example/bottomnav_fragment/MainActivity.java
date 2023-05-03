package com.example.bottomnav_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

/**
 * @author liukai
 */
public class MainActivity extends AppCompatActivity {
    MessageFragment messageFragment=new MessageFragment();
    DongtaiFragment dongtaiFragment=new DongtaiFragment();
    ContactFragment contactFragment=new ContactFragment();
    private BottomNavigationView mBottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigation();
        Log.d("6666","8888");
    }


    public void initBottomNavigation() {

        mBottomNavigationView = findViewById(R.id.navigation);
        // 添加监听
        mBottomNavigationView.removeBadge(R.id.menu_message);
        getSupportFragmentManager().beginTransaction().replace(R.id.display_fragment,messageFragment).commit();
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_message:
                        switchFragment(messageFragment);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.display_fragment,messageFragment).commit();
                        return  true;
                    /**
                     * 要是不返回true而是用break,那么最后返回的就是后面的那个false,这样就会出现点击底部导航栏按钮后，
                     * 虽然会监听到，但是屏幕中底部导航栏不会发生变化（变成深色的依然是点击前的那个按钮），
                     * 即点击事件执行完后，不会影响控件在屏幕中的变化
                     如果为 true，则将项目显示为选定项目;如果不应选择该项目，则为 false。
                     */
                    case R.id.menu_contacts:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.display_fragment,contactFragment).commit();
                        switchFragment(contactFragment);
                        return  true;
                    case R.id.menu_discover:
                    case R.id.menu_me:
                        getSupportFragmentManager().beginTransaction().replace(R.id.display_fragment,dongtaiFragment).commit();
                        return  true;
                    default:
                        break;
                }
                return false;
            }
        });

    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.display_fragment, fragment);
        transaction.commitAllowingStateLoss();
    }
    private void switchFragment1(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.display_fragment, fragment);
        transaction.commitAllowingStateLoss();
    }

}