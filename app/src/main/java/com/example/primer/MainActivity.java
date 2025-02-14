package com.example.primer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toast.makeText(this,"onCreate", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Instance", "onStart");
        Toast.makeText(this,"OnStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Instance", "onStart");
        Toast.makeText(this,"OnResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Instance", "onStart");
        Toast.makeText(this,"OnPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("Instance", "onStart");
        Toast.makeText(this,"OnStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Instance", "onStart");
        Toast.makeText(this,"OnDestroy", Toast.LENGTH_LONG).show();
    }
@Override
    protected void onSaveInstanceState(Bundle autState){
        super.onSaveInstanceState(autState);
        autState.putInt("Klic", count);
        Log.d("Instens","onSave");
        Toast.makeText(this, "onSave",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onRestoreInstanceState(Bundle SavedState){
        super.onRestoreInstanceState(SavedState);
        if(SavedState != null && SavedState.containsKey("Klic")){
            count = SavedState.getInt("Klic");
        }
        Log.d("Instens","get");
        Toast.makeText(this, "get",Toast.LENGTH_LONG).show();
    }
    public void onClickBatton(View view) {
        count++;
        TextView txt = findViewById(R.id.txtCounter);
        txt.setText(count.toString());
    }

    public void onClickButton(View view) {
        count--;
        TextView txt = findViewById(R.id.txtCounter);
        txt.setText(count.toString());
    }
}
