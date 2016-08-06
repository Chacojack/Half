package jack.half;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by zjchai on 16/7/10.
 */
public class HalfApp extends Application {



    @Override
    public void onCreate() {
        super.onCreate();

        AVOSCloud.initialize(this, Contants.AVOS_APP_ID, Contants.AVOS_APP_KEY);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);


    }
}
