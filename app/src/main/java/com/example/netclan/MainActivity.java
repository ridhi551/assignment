package com.example.netclan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.netclan.navigation_fragments.ChatFragment;
import com.example.netclan.navigation_fragments.ContactsFragment;
import com.example.netclan.navigation_fragments.ExploreFragment;
import com.example.netclan.navigation_fragments.GroupsFragment;
import com.example.netclan.navigation_fragments.NetworkFragment;
import com.example.netclan.refine.RefineActivity;
import com.example.netclan.tab_fragments.PersonalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id==R.id.navigation_explore){
                    // show explore
                    loadFragment(new ExploreFragment(),true);
                }else if(id==R.id.navigation_network){
                    loadFragment(new NetworkFragment(), false);
                    // show network
                }else if(id==R.id.navigation_chat){
                    loadFragment(new ChatFragment(), false);

                } else if (id== R.id.navigation_contacts) {
                    loadFragment(new ContactsFragment(), false);

                }else{
                    // show groups
                    loadFragment(new GroupsFragment(), false);
                }
                return true;
            }


            private void loadFragment(Fragment fragment, boolean flag){
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();

                if(flag){
                    ft.add(R.id.frame_container, fragment);
                }
                ft.replace(R.id.frame_container,fragment);
                ft.commit();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refine,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.refine) {
            // show up a page
            Intent in = new Intent(MainActivity.this, RefineActivity.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}