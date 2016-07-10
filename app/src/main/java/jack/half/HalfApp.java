package jack.half;

import android.app.Application;

import org.xutils.x;

/**
 * Created by zjchai on 16/7/10.
 */
public class HalfApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
