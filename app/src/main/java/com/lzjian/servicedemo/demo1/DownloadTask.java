package com.lzjian.servicedemo.demo1;

import android.os.AsyncTask;

/**
 * @Description:
 */

public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {
    @Override
    protected Boolean doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
