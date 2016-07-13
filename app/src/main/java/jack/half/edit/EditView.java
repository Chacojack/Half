package jack.half.edit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jack.half.R;
import jack.half.utils.BitmapUtils;

/**
 * Created by zjchai on 16/7/10.
 */
public class EditView extends RelativeLayout implements IEditView{


    Context context ;

    public EditView(Context context) {
        super(context);
        this.context = context ;
        initViews();
    }

    public EditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context ;
        initViews();
    }

    public EditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context ;
        initViews();
    }

    private void initViews() {
        inflate(context,R.layout.view_edit,this) ;

    }






    public void savePhoto(View view) {
        final Bitmap bmp = BitmapUtils.viewToBitmap(view) ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(new Date());

        File dir = new File("/test");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        final String photoUrl = "/sdcard/" + time + ".png";//换成自己的图片保存路径
        final File file = new File(photoUrl);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Snackbar.make(this,"文件创建失败",Snackbar.LENGTH_LONG).show() ;
                return;
            }
        }

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Snackbar.make(EditView.this,"保存图片完成",Snackbar.LENGTH_LONG).show() ;
            }
        };

        new Thread() {
            @Override
            public void run() {
                try {
                    boolean flag = bmp.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
                    handler.sendEmptyMessage(flag?1:0) ;
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }



}
