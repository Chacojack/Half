package jack.half.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;


/**
 * Created by zjchai on 16/7/13.
 */
public class BitmapUtils{

    public static Bitmap viewToBitmap(View view) {
        Bitmap bmp = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bmp));
        return bmp;
    }




}
