package com.example.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//implement에서 design부분 해줘야함
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.e("main", "터치감지");
                switch (item.getItemId()) {
                    case R.id.action_bedtime:
                        Log.e("main", "1번");
                        setFrag(0);
                        break;
                    case R.id.action_attatch_file:
                        Log.e("main", "2번");
                        setFrag(1);
                        break;
                    case R.id.action_bluetooth:
                        Log.e("main", "3");
                        setFrag(2);
                        break;
                    case R.id.action_cloud:
                        Log.e("main", "4");
                        setFrag(3);
                        break;
                    case R.id.action_bus:
                        Log.e("main", "5");
                        setFrag(4);
                        break;
                }
                return true;
            }
        });

        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        setFrag(0);//첫화면을 지정하면된다.
    }

    //프래그먼트 교체가 일어날때
    private void setFrag(int n){
        Log.e("main","교체작업");
        fm = getSupportFragmentManager();
        ft= fm.beginTransaction();//실제 화면전환떄 ft를 사용함
        switch (n){
            case 0:
                Log.e("main","1");
                ft.replace(R.id.main_frame,frag1);
                ft.commit();//저장을 의미
                break;
            case 1:
                Log.e("main","1");
                ft.replace(R.id.main_frame,frag2);

                Log.e("main","1");
                ft.commit();

                Log.e("main","1");
                break;
            case 2:
                Log.e("main","1");
                ft.replace(R.id.main_frame,frag3);
                ft.commit();
                break;
            case 3:
                Log.e("main","1");
                ft.replace(R.id.main_frame,frag4);
                ft.commit();
                break;
            case 4:
                Log.e("main","1");
                ft.replace(R.id.main_frame,frag5);
                ft.commit();
                break;
        }
    }
}