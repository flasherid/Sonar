package it.cnvcrew.sonar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    public void onClick(View v){
        Intent i;
        int n = v.getId();
        switch (n){
            case R.id.b_log:
                i = new Intent(this, LoginActivity.class);
                break;
            case R.id.b_reg:
                i = new Intent(this, RegistraActivity.class);
                break;
            case R.id.b_nd:
                i = new Intent(this, MyNavigationDrawer.class);
                break;
            default:
                i = new Intent();
                break;
        }
        startActivity(i);
    }
}
