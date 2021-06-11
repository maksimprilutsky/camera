package com.example.camera;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import ru.mobilab.sample.R;

public class MainActivity extends Activity{
/** Called when the activity is first created. */
private static final int CAMERA_PIC_REQUEST=1112;
@Override
public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

final Button button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(button_click);
        }

public OnClickListener button_click=new OnClickListener(){

public void onClick(View v){

        Intent cameraIntent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
// TODO Auto-generated method stub
        }
        };
/*public void button_click( ){}*/
        }