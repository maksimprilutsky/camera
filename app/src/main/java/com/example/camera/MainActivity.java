package com.example.camera;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainActivity extends Activity{
        ImageView iv;
        TextView tv;
        String folderToSave;
        Button btn;
/** Called when the activity is first created. */
private static final int CAMERA_PIC_REQUEST=1112;
@Override
public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=(ImageView) findViewById(R.id.imageView);        iv.setImageResource(R.drawable.cat);
       // tv=(TextView) findViewById(R.id.TextView);

        folderToSave = Environment.getExternalStorageDirectory().toString();
        folderToSave+="/cats";
        File dir = new File(folderToSave);
        dir.mkdir();
      //  tv.setText(folderToSave);

        btn=(Button)findViewById(R.id.myB);
        btn.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                        //tv.setText("ok");
                        SavePicture(iv,folderToSave);
                }
        });
  //      iv.setImageResource(R.drawable.cat);

        final Button button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(button_click);
        }

public OnClickListener button_click=new OnClickListener(){

public void onClick(View v){

        Intent cameraIntent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
        iv.setImageResource(R.drawable.cat);



        }
// TODO Auto-generated method stub

        };
/*public void button_click( ){}*/
protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode== CAMERA_PIC_REQUEST){
                Bitmap thumbnail=(Bitmap) data.getExtras().get("data");

                //iv.setImageBitmap(thumbnail);
        }
}
        public String SavePicture(ImageView iv, String folderToSave)
        {
                OutputStream fOut = null;
//        Date currentTime = (Date) Calendar.getInstance().getTime();
/*        LocalTime now = LocalTime.now();
        LocalDate nowDate = LocalDate.now();*/

                try {
                        File file = new File(folderToSave,
/*                    Integer.toString(nowDate.getYear()) +
                            Integer.toString(nowDate.getMonthValue()) +
                            Integer.toString(nowDate.getDayOfMonth()) +
                            Integer.toString(now.getHour()) +
                            Integer.toString(now.getMinute()) +
                            Integer.toString(now.getSecond()) */
/*                    Integer.toString(nowDate.getYear()) +
                            Integer.toString(nowDate.getMonthValue()) +
                            Integer.toString(nowDate.getDayOfMonth()) +
                            Integer.toString(now.getHour()) +*/
//                            Integer.toString(currentTime.getMinutes()) +
//                            Integer.toString(now.getSecond())+
                                "1.jpg");
                        // ?????????????? ???????????????????? ?????? ?????? ?????????? ?????????????????????? ???? ???????? ????????????????????

                        fOut = new FileOutputStream(file);

                        Bitmap bitmap =((BitmapDrawable) iv.getDrawable()).getBitmap();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fOut); // ?????????????????? ???????????????? ?? jpeg-?????????????? ?? 85% ????????????.
                        fOut.flush();
                        fOut.close();
//            MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(),  file.getName()); // ?????????????????????? ?? ??????????????????????
                }
                catch (Exception e) // ?????????? ?????????????????? ???????? ???????????????????????? ???????????????? ???????????? ?? ????????????????????, ?????????? Exception ???????????????? ?? ???????????????? ??????????????
                {
                        tv.setText(e.getMessage().toString());
                        return e.getMessage();
                }
                return "";
        }

}
