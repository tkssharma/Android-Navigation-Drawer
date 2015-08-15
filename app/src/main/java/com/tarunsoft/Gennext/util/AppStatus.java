package com.tarunsoft.Gennext.util;

/**
 * Created by tsharma3 on 8/15/2015.
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


public class AppStatus {

    private static AppStatus instance = new AppStatus();
    static Context context;
    ConnectivityManager connectivityManager;
    NetworkInfo wifiInfo, mobileInfo;
    boolean connected = false;

    public static AppStatus getInstance(Context ctx) {
        context = ctx.getApplicationContext();
        return instance;
    }

    public boolean isOnline() {
        try {
            connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() &&
                    networkInfo.isConnected();
            return connected;


        } catch (Exception e) {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
        }
        return connected;


		/*ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (connectivity != null)
		{
			NetworkInfo[] info = connectivity.getAllNetworkInfo();

			if (info != null)
			{
				for (int i = 0; i < info.length; i++)
				{
					Log.i("Class", info[i].getState().toString());
					if (info[i].getState() == NetworkInfo.State.CONNECTED)
					{
						return true;
					}
				}
			}
		}
		return false;*/
    }
}