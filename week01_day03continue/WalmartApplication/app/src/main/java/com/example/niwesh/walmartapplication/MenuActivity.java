package com.example.niwesh.walmartapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabFood;
    TabItem tabClothing;
    TabItem tabBeauty;
    TabItem tabElectronics;
    TabItem tabLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tabLayout = (TabLayout) findViewById(R.id.menu_tabLayout);
        tabFood = (TabItem) findViewById(R.id.menu_food);
        tabClothing = (TabItem) findViewById(R.id.menu_clothing);
        tabBeauty = (TabItem) findViewById(R.id.menu_beauty);
        tabElectronics = (TabItem) findViewById(R.id.menu_electronics);
        tabLogout = (TabItem) findViewById(R.id.menu_logout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == 0){
                    Intent intent = new Intent(MenuActivity.this,CustomListActivity.class);
                    intent.putExtra("food1","Welcome to Food Category");
                    startActivity(intent);
                    Toast.makeText(MenuActivity.this, "Menu : Food", Toast.LENGTH_SHORT).show();
                }
                else if(tab.getPosition() == 1){
                    Intent intent = new Intent(MenuActivity.this,ListViewActivity.class);
                    intent.putExtra("clothing","Welcome to Clothing Category");
                    startActivity(intent);
                    Toast.makeText(MenuActivity.this, "Menu : Clothing", Toast.LENGTH_LONG).show();
                }
                else if(tab.getPosition() == 2){
                    Intent intent = new Intent(MenuActivity.this,SpinnerActivity.class);
                    intent.putExtra("beauty","Welcome to Beauty Category");
                    startActivity(intent);
                    Toast.makeText(MenuActivity.this, "Menu : Beauty", Toast.LENGTH_LONG).show();
                }
                else if(tab.getPosition() == 3){
                    Intent intent = new Intent(MenuActivity.this,ElectronicsActivity.class);
                    intent.putExtra("electronics","Welcome to Electronics Category");
                    startActivity(intent);
                    Toast.makeText(MenuActivity.this, "Menu : Electronics", Toast.LENGTH_LONG).show();
                }
                else if(tab.getPosition() == 4){
                    Intent intent = new Intent(MenuActivity.this,ShoppingActivity.class);
                    startActivity(intent);
                    Toast.makeText(MenuActivity.this, "Menu : Electronics", Toast.LENGTH_LONG).show();
                }
                else if(tab.getPosition() == 5){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                    builder.setTitle("Log Out");
                    builder.setMessage("Do you want to Logout?");

                    AlertDialog.OnClickListener listener = new AlertDialog.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(which==dialog.BUTTON_POSITIVE){
                                dialog.dismiss();
                                finish();
                            }
                            else if(which==dialog.BUTTON_NEGATIVE){
                                dialog.dismiss();
                            }
                        }
                    };

                    builder.setPositiveButton("Yes",listener);
                    builder.setNegativeButton("No",listener);
                    builder.show();
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
}
